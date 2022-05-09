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
    public PageInfo<BookInfo> queryBookInfoAll(BookInfo bookInfo, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<BookInfo> bookInfoList = bookInfoMapper.queryBookInfoAll(bookInfo);
        return new PageInfo<>(bookInfoList);
    }

    @Override
    public void addBookSubmit(BookInfo bookInfo) {
        bookInfoMapper.insert(bookInfo);
    }

    @Override
    public BookInfo queryBookInfoById(Integer id) {
        return bookInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateBookSubmit(BookInfo bookInfo) {
        bookInfoMapper.updateByPrimaryKeySelective(bookInfo);
    }

    @Override
    public void deleteBookByIds(List<String> list) {
        for (String id : list){
            bookInfoMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
    }

    @Override
    public List<BookInfo> getBookCountByType() {
        return bookInfoMapper.getBookCountByType();
    }
}
