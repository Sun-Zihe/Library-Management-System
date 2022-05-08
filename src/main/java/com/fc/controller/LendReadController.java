package com.fc.controller;

import com.fc.entity.BookInfo;
import com.fc.entity.LendList;
import com.fc.entity.ReaderInfo;
import com.fc.service.BookInfoService;
import com.fc.service.LendReadService;
import com.fc.service.ReaderInfoService;
import com.fc.vo.DataInfoVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class LendReadController {

    @Autowired
    private LendReadService lendReadService;
    @Autowired
    private ReaderInfoService readerService;
    @Autowired
    private BookInfoService bookInfoService;

//    @Autowired
//    private BookInfoService bookInfoService;

    //页面跳转
    @GetMapping("/lendListIndex")
    public String lendListIndex(){
        return "lend/lendListIndex";
    }

    @ResponseBody
    @RequestMapping("/lendListAll")
    public DataInfoVO lendListAll(Integer backType, String readerNumber, String name, Integer status,
                                  @RequestParam(defaultValue = "1")Integer page, @RequestParam(defaultValue = "15")Integer limit){

        DataInfoVO vo ;

        LendList info=new LendList();
        System.out.println("backType:"+backType);

        info.setBacktype(backType);

        //创建读者对象
        ReaderInfo reader=new ReaderInfo();
        reader.setReadernumber(readerNumber);

        info.setReaderInfo(reader);

        //图书对象
        BookInfo book=new BookInfo();
        book.setName(name);
        book.setStatus(status);
        info.setBookInfo(book);

        //分页查询所有的记录信息
        PageInfo pageInfo=lendReadService.queryLendListAll(info,page,limit);

        vo = new DataInfoVO(0,"成功",pageInfo.getList(),pageInfo.getTotal());
        return vo;
    }


    //借书跳转
    @GetMapping("/addLendList")
    public String addLendList(){
        return "lend/addLendList";
    }

    //借书
    @ResponseBody
    @RequestMapping("/addLend")
    public DataInfoVO addLend(String readerNumber,String ids){
        //获取图书id的集合
        List<String> list= Arrays.asList(ids.split(","));
        //判断卡号是否存在
        ReaderInfo reader=new ReaderInfo();
        reader.setReadernumber(readerNumber);
        PageInfo<ReaderInfo> pageInfo=readerService.queryAllReaderInfo(reader,1,1);
        if(pageInfo.getList().size()==0){
            return new DataInfoVO(null,"卡号信息不存在",null,null);
        }else{
            ReaderInfo readerCard2=pageInfo.getList().get(0);
            //可借书
            for(String bid:list) {
                LendList lendList = new LendList();
                lendList.setReaderid(readerCard2.getId());//读者id
                lendList.setBookid(Integer.valueOf(bid));//书的id
                lendList.setLenddate(new Date());
                lendReadService.addLendListSubmit(lendList);
                //更变书的状态
                BookInfo info = bookInfoService.queryBookInfoById(Integer.valueOf(bid));
                //设置书的状态
                info.setStatus(1);
                bookInfoService.updateBookSubmit(info);
            }

        }

        return new DataInfoVO(200,"借书成功",null,null);
    }


     // 页面跳转 异常还书
    @GetMapping("/excBackBook")
    public String excBackBook(HttpServletRequest request, Model model){
        //获取借阅记录id
        String id=request.getParameter("id");
        String bId=request.getParameter("bookId");
        model.addAttribute("id",id);
        model.addAttribute("bid",bId);
        return "lend/excBackBook";
    }

    //异常还书操作
    @ResponseBody
    @RequestMapping("/updateLendInfoSubmit")
    public DataInfoVO updateLendInfoSubmit(LendList lendList){
        lendReadService.backBook(lendList);
        return new DataInfoVO(0,"成功",null,null);
    }

//还书
    @ResponseBody
    @RequestMapping("/backLendListByIds")
    public DataInfoVO backLendListByIds(String ids,String bookIds){

        List list=Arrays.asList(ids.split(","));//借阅记录的id
        List bookList=Arrays.asList(bookIds.split(","));//图书信息的id
        Integer affRow = lendReadService.updateLendListSubmit(list, bookList);

        if (affRow>0){
            return new DataInfoVO(0,"成功",null,null);
        }else {
            return new DataInfoVO(400,"失败",null,null);
        }
    }
}
