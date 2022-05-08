package com.fc.service;

import com.fc.entity.BookInfo;
import com.fc.entity.ReaderInfo;
import com.github.pagehelper.PageInfo;

public interface ReaderInfoService {
    ReaderInfo queryUserInfoByNameAndPassword(String username, String password);

    PageInfo<ReaderInfo> queryAllReaderInfo(ReaderInfo readerInfo,Integer pageNum,Integer limit);

}
