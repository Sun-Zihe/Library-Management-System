package com.fc.service;

import com.fc.entity.BookInfo;
import com.fc.entity.ReaderInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ReaderInfoService {

    ReaderInfo queryUserInfoByNameAndPassword(String username, String password);

    PageInfo<ReaderInfo> queryAllReaderInfo(ReaderInfo readerInfo, Integer pageNum, Integer limit);

    void addReaderInfoSubmit(ReaderInfo readerInfo);

    ReaderInfo queryReaderInfoById(Integer id);

    void updateReaderInfoSubmit(ReaderInfo readerInfo);

}
