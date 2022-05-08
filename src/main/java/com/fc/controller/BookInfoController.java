package com.fc.controller;

import com.fc.entity.BookInfo;
import com.fc.service.BookInfoService;
import com.fc.vo.DataInfoVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookInfoController {
    @Autowired
    private BookInfoService bookInfoService;

    @RequestMapping("/bookAll")
    @ResponseBody
    public DataInfoVO bookAll(BookInfo bookInfo, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit){
        PageInfo<BookInfo> pageInfo = bookInfoService.queryBookInfoAll(bookInfo,pageNum,limit);
        return new DataInfoVO(0,"成功",pageInfo.getList(),pageInfo.getTotal());//总条数getTotal，数据封装成list,以便加载分页显示,由于加了ResponseBody,就会返回一个字符串
    }
}
