package com.fc.controller;

import com.fc.entity.BookInfo;
import com.fc.entity.ReaderInfo;
import com.fc.service.ReaderInfoService;
import com.fc.vo.DataInfoVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReaderInfoController {
    @Autowired
    private ReaderInfoService readerInfoService;

    //读者管理页面跳转
    @GetMapping("/readerIndex")
    public String readerIndex () {
        return "reader/readerIndex";
    }

    //添加页面跳转
    @RequestMapping("/readerAdd")
    public String readerAdd(){
        return "reader/readerAdd";
    }

    //查询所有数据
    @RequestMapping("/readerAll")
    @ResponseBody
    public DataInfoVO readerAll(ReaderInfo readerInfo, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit){
        PageInfo<ReaderInfo> pageInfo = readerInfoService.queryAllReaderInfo(readerInfo,pageNum,limit);

        System.out.println("-----------------");
        for (ReaderInfo S:
                pageInfo.getList()
        ) {
            System.out.println(S);
        }

        return new DataInfoVO(0,"成功",pageInfo.getList(),pageInfo.getTotal());//总条数getTotal，数据封装成list,以便加载分页显示,由于加了ResponseBody,就会返回一个字符串
    }

    //添加数据
    @RequestMapping("/addReaderSubmit")
    public DataInfoVO addReaderSubmit(@RequestBody ReaderInfo readerInfo) {
        readerInfo.setPassword("123456");//设置默认密码
        readerInfoService.addReaderInfoSubmit(readerInfo);
        return new DataInfoVO();
    }

    //根据查询读者信息
    @GetMapping("queryReaderInfoById")
    public String queryReaderInfoById(Integer id, Model model){
        ReaderInfo readerInfo = readerInfoService.queryReaderInfoById(id);
        model.addAttribute("info",readerInfo);
        return "reader/updateReader";
    }

    //修改提交
    @RequestMapping("updateReaderSubmit")
    @ResponseBody
    public DataInfoVO updateReaderSubmit(@RequestBody ReaderInfo readerInfo) {
        readerInfoService.updateReaderInfoSubmit(readerInfo);
        return new DataInfoVO();
    }

}
