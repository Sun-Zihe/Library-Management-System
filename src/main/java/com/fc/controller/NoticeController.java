package com.fc.controller;

import com.fc.entity.Notice;
import com.fc.service.NoticeService;
import com.fc.vo.DataInfoVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
    public DataInfoVO noticeAll(Notice notice, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15")Integer limit){
        PageInfo<Notice> pageInfo = noticeService.queryAllNotice(notice, page, limit);
        return new DataInfoVO(0,"成功",pageInfo.getList(),pageInfo.getTotal());
    }

    //添加页面跳转
    @GetMapping("/noticeAdd")
    public String noticeAdd(){
        return "notice/noticeAdd";
    }

    //添加页面提交
    @RequestMapping("addNoticeSubmit")
    @ResponseBody
    public DataInfoVO addNoticeSubmit(Notice notice) {
        //主题和内容可以页面获取，作者和时间在后台自动获取
        notice.setAuthor("admin");//这里先暂且写admin
        notice.setCreatedate(new Date());
        noticeService.addNotice(notice);

        System.out.println(11111111);

        return new DataInfoVO(0,"添加成功", null, null);
    }

    //查看详情
    @GetMapping("/queryNoticeById")
    public String queryNoticeById(Integer id, Model model){
        Notice notice = noticeService.queryNoticeById(id);
        model.addAttribute("info",notice);
        return "notice/updateNotice";
    }

    //删除公告
    @RequestMapping("/deleteNoticeByIds")
    @ResponseBody
    public DataInfoVO deleteNoticeByIds(String ids){
        List<String> list = Arrays.asList(ids.split(","));
        noticeService.deleteNoticeByIds(list);
        return new DataInfoVO(0,"删除成功", null, null);
    }

}
