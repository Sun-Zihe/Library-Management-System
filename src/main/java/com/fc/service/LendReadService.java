package com.fc.service;

import com.fc.entity.LendList;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface LendReadService {

    //查询
    PageInfo queryLendListAll(LendList info, Integer page, Integer limit);

    //还书
    void backBook(LendList lendList);

    //借书
    void addLendListSubmit(LendList lendList);

    Integer updateLendListSubmit(List<String> ids, List<String> bookIds);
}
