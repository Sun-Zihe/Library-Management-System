package com.fc.service;

import com.fc.entity.BookInfo;
import com.fc.entity.ReaderInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface ReaderInfoService {

    ReaderInfo queryUserInfoByNameAndPassword(String username, String password);

    //查询所有读者信息
    PageInfo<ReaderInfo> queryAllReaderInfo(ReaderInfo readerInfo, Integer pageNum, Integer limit);

    //添加
    void addReaderInfoSubmit(ReaderInfo readerInfo);

    //Id查询读者信息
    ReaderInfo queryReaderInfoById(Integer id);

    //修改
    void updateReaderInfoSubmit(ReaderInfo readerInfo);

    //删除
    void deleteReaderInfoByIds(List<String> list);

}
