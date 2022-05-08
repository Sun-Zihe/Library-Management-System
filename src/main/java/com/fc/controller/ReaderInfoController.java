package com.fc.controller;

import com.fc.entity.BookInfo;
import com.fc.entity.ReaderInfo;
import com.fc.service.ReaderInfoService;
import com.fc.vo.DataInfoVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/readerAll")
    @ResponseBody
    public DataInfoVO readerAll(ReaderInfo readerInfo, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit){
        PageInfo<ReaderInfo> pageInfo = readerInfoService.queryAllReaderInfo(readerInfo,pageNum,limit);
        return new DataInfoVO(0,"成功",pageInfo.getList(),pageInfo.getTotal());//总条数getTotal，数据封装成list,以便加载分页显示,由于加了ResponseBody,就会返回一个字符串
    }

}
