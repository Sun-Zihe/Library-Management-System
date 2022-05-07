package com.fc.service.impl;

import com.fc.dao.ReaderInfoMapper;
import com.fc.entity.Admin;
import com.fc.entity.ReaderInfo;
import com.fc.service.ReaderInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReaderInfoServiceImpl implements ReaderInfoService {

    @Autowired
    private ReaderInfoMapper readerInfoMapper;

    @Override
    public ReaderInfo queryUserInfoByNameAndPassword(String username, String password) {
        return readerInfoMapper.queryUserInfoByNameAndPassword(username, password);
    }

    @Override
    public PageInfo<ReaderInfo> queryAllReaderInfo(ReaderInfo readerInfo, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<ReaderInfo> readerInfoList =  readerInfoMapper.queryAllReaderInfo(readerInfo);
        return new PageInfo<>(readerInfoList);
    }

    @Override
    public void addReaderInfoSubmit(ReaderInfo readerInfo) {

    }

    @Override
    public PageInfo<Admin> page(Integer pageNum, Integer limit, String name, String password, Integer id, String realname, String gender, Date birthday, String address, String tel, Date registerDate, String readerNumber) {
        if (readerNumber != null && !readerNumber.equals("")) {
            readerNumber = "%" + readerNumber + "%";
        }

        PageHelper.startPage(pageNum, limit);

//        List<ReaderInfo> notes = noteMapper.findNoteByUserId(userId, typeId, title, date);

        List<ReaderInfoMapper> readerInfoMappers = ReaderInfoMapper.findNoteByUserId(name, password, id, realname);

        return new PageInfo<>(readerInfoMappers);
    }
}
