package com.fc.service;

import com.fc.entity.Admin;
import com.fc.entity.ReaderInfo;
import com.github.pagehelper.PageInfo;

import java.util.Date;

public interface ReaderInfoService {
    ReaderInfo queryUserInfoByNameAndPassword(String username, String password);

    PageInfo<ReaderInfo> queryAllReaderInfo(ReaderInfo readerInfo, Integer pageNum, Integer limit);

    void addReaderInfoSubmit(ReaderInfo readerInfo);

    PageInfo<Admin> page(Integer pageNum, Integer limit, String name, String password, Integer id, String realname, String gender, Date birthday, String address, String tel, Date registerDate, String readerNumber);


}
