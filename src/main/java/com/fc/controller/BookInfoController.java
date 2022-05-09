package com.fc.controller;

import com.fc.entity.BookInfo;
import com.fc.entity.TypeInfo;
import com.fc.service.BookInfoService;
import com.fc.service.TypeInfoService;
import com.fc.vo.DataInfoVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class BookInfoController {
    @Autowired
    private BookInfoService bookInfoService;

    @Autowired
    private TypeInfoService typeInfoService;


    /**
     * 图书管理首页
     * @return
     */
    @GetMapping("/bookIndex")
    public String bookIndex(){
        return "book/bookIndex";
    }

    /**
     * 获取book信息，封装成json
     * @param bookInfo
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/bookAll")
    @ResponseBody
    public DataInfoVO bookAll(BookInfo bookInfo, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15") Integer limit){
        PageInfo<BookInfo> pageInfo = bookInfoService.queryBookInfoAll(bookInfo,page,limit);
        return new DataInfoVO(0,"成功",pageInfo.getList(),pageInfo.getTotal());//总条数getTotal，数据封装成list,以便加载分页显示,由于加了ResponseBody,就会返回一个字符串
    }

    /**
     * 添加页面的跳转
     */
    @GetMapping("/bookAdd")
    public String bookAdd(){
        return "book/bookAdd";
    }

    /**
     * 类型添加提交
     */
    @RequestMapping("/addBookSubmit")
    @ResponseBody
    public DataInfoVO addBookSubmit(BookInfo bookInfo){//info?bookInfo?
        bookInfoService.addBookSubmit(bookInfo);//info?bookInfo?
        return new DataInfoVO(0,"成功",null,null);
    }

    /**
     * 类型根据id查询(修改)
     */
    @GetMapping("/queryBookInfoById")
    public String queryTypeInfoById(Integer id, Model model){
        BookInfo bookInfo= bookInfoService.queryBookInfoById(id);
        model.addAttribute("info",bookInfo);
        return "book/updateBook";
    }

    /**
     * 修改提交功能
     */

    @RequestMapping("/updateBookSubmit")
    @ResponseBody
    public DataInfoVO updateBookSubmit(@RequestBody BookInfo bookInfo){
        bookInfoService.updateBookSubmit(bookInfo);
        return new DataInfoVO(0,"成功",null,null);
    }

    /**
     * 类型删除
     */

    @RequestMapping("/deleteBook")
    @ResponseBody
    public DataInfoVO deleteBook(String ids){
        List<String> list= Arrays.asList(ids.split(","));
        bookInfoService.deleteBookByIds(list);
        return new DataInfoVO(0,"成功",null,null);
    }

    @RequestMapping("/findAllList")
    @ResponseBody
    public List<TypeInfo> findAll(){
        PageInfo<TypeInfo> pageInfo = typeInfoService.queryTypeInfoAll(null,1,100);
        List<TypeInfo> lists = pageInfo.getList();
        return lists;
    }
}
