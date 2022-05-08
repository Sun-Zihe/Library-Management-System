package com.fc.service.impl;

import com.fc.dao.BookInfoMapper;
import com.fc.entity.BookInfo;
import com.fc.service.BookInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookInfoServiceImpl implements BookInfoService {

    @Autowired
    private BookInfoMapper bookInfoMapper;

    @Override
    public BookInfo queryBookInfoById(Integer id) {
        return bookInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateBookSubmit(BookInfo info) {
        bookInfoMapper.updateByPrimaryKeySelective(info);
    }

    @Override
    public PageInfo<BookInfo> queryBookInfoAll(BookInfo bookInfo, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<BookInfo> bookInfoList = bookInfoMapper.queryBookInfoAll(bookInfo);
        return new PageInfo<>(bookInfoList);
    }
}
