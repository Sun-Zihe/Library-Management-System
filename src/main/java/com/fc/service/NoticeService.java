package com.fc.service;

import com.fc.entity.Notice;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface NoticeService {
    PageInfo<Notice> queryAllNotice(Notice notice,Integer pageNum,Integer limit);

    void addNotice(Notice notice);

    Notice queryNoticeById(Integer id);

    void deleteNoticeByIds(List<String> ids);

}
