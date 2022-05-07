package com.fc.controller;

import com.fc.service.ReaderInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReaderInfoController {
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
}
