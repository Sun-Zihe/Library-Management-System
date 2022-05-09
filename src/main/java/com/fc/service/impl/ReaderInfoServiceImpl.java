package com.fc.service.impl;

import com.fc.dao.ReaderInfoMapper;
import com.fc.entity.Admin;
import com.fc.entity.BookInfo;
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
        List<ReaderInfo> readerInfoList = readerInfoMapper.queryAllReaderInfo(readerInfo);
        for (ReaderInfo S:
                readerInfoList
             ) {
            System.out.println(S);
        }
        return new PageInfo<>(readerInfoList);
    }

    @Override
    public void addReaderInfoSubmit(ReaderInfo readerInfo) {
        readerInfoMapper.insert(readerInfo);
    }

    @Override
    public ReaderInfo queryReaderInfoById(Integer id) {
        return readerInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateReaderInfoSubmit(ReaderInfo readerInfo) {
        readerInfoMapper.updateByPrimaryKeySelective(readerInfo);
    }

    @Override
    public void deleteReaderInfoByIds(List<String> ids) {
        for (String id : ids){
            readerInfoMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
    }
}
