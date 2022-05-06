package com.fc.service.impl;

import com.fc.dao.ReaderInfoMapper;
import com.fc.entity.ReaderInfo;
import com.fc.service.ReaderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReaderInfoServiceImpl implements ReaderInfoService {

    @Autowired
    private ReaderInfoMapper readerInfoMapper;

    @Override
    public ReaderInfo queryUserInfoByNameAndPassword(String username, String password) {
        return readerInfoMapper.queryUserInfoByNameAndPassword(username, password);
    }
}
