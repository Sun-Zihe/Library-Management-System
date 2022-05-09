package com.fc.service;

import com.fc.entity.BookInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface BookInfoService {
    /**
     * 查询所有记录
     */
    PageInfo<BookInfo> queryBookInfoAll(BookInfo bookInfo, Integer page, Integer limit);

    /**
     * 添加图书记录
     */
    void addBookSubmit(BookInfo bookInfo);

    /**
     * 修改 根据id查询记录信息
     */
    BookInfo queryBookInfoById(Integer id);

    /**''
     * 修改提交
     */
    void updateBookSubmit(BookInfo bookInfo);

    /**
     * 根据ids删除记录信息
     */
    void deleteBookByIds(List<String> list);

    /**
     * 根据类型获取图书数量
     */
    List<BookInfo> getBookCountByType();
}
