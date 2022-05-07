package com.fc.service.impl;

import com.fc.dao.NoticeMapper;
import com.fc.entity.Notice;
import com.fc.service.NoticeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public PageInfo<Notice> queryAllNotice(Notice notice, Integer pageNum, Integer limit) {
        //开启分页
        PageHelper.startPage(pageNum,limit);//业务层实现分页
        List<Notice> noticeList = noticeMapper.queryNoticeAll(notice);

        System.out.println(noticeList);
        return new PageInfo<>(noticeList);
    }
}