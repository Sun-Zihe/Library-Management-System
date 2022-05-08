package com.fc.service;

import com.fc.entity.BookInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface BookInfoService {
    BookInfo queryBookInfoById(Integer id);

    void updateBookSubmit(BookInfo info);

    PageInfo<BookInfo> queryBookInfoAll(BookInfo bookInfo, Integer pageNum, Integer limit);
}
