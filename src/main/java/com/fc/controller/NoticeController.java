package com.fc.controller;

import com.fc.entity.Notice;
import com.fc.service.NoticeService;
import com.fc.vo.DataInfoVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    //后台公告
    @GetMapping("/noticeIndexOfBack")
    public String noticeIndexOfBack(){
        return "notice/noticeIndexOfBack";
    }

//    @GetMapping("/noticeIndexOfReader")
//    public String noticeIndexOfReader(){
//        return "notice/noticeIndexOfReader";
//    }

    //查询所有公告信息
    @RequestMapping("/noticeAll")
    @ResponseBody
    public DataInfoVO noticeAll(Notice notice, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15")Integer limit){
        PageInfo<Notice> pageInfo = noticeService.queryAllNotice(notice, pageNum, limit);
        return new DataInfoVO(0,"成功",pageInfo.getList(),pageInfo.getTotal());
    }

    //添加页面跳转
    @GetMapping("/noticeAdd")
    public String noticeAdd(){
        return "notice/noticeAdd";
    }

    //添加页面提交
    @PostMapping("addNoticeSubmit")
    public DataInfoVO addNoticeSubmit(Notice notice) {
        //主题和内容可以页面获取，作者和时间在后台自动获取
        notice.setAuthor("admin");//这里先暂且写admin
        notice.setCreatedate(new Date());
        noticeService.addNotice(notice);
        return new DataInfoVO(0,"添加成功", null, null);
    }

}
