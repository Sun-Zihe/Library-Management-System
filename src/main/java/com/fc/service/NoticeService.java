package com.fc.service;

import com.fc.entity.Notice;
import com.github.pagehelper.PageInfo;

public interface NoticeService {
    PageInfo<Notice> queryAllNotice(Notice notice,Integer pageNum,Integer limit);

    void addNotice(Notice notice);
}
