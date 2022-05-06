package com.fc.service;

import com.fc.entity.ReaderInfo;

public interface ReaderInfoService {
    ReaderInfo queryUserInfoByNameAndPassword(String username, String password);
}
