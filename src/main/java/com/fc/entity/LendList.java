package com.fc.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class LendList {
    private Integer id;

    private Integer bookid;

    private Integer readerid;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//接收页面输入的时间，将其格式化
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date lenddate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")//后端传的日期格式化
    private Date backdate;

    private Integer backtype;

    private String exceptremarks;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Integer getReaderid() {
        return readerid;
    }

    public void setReaderid(Integer readerid) {
        this.readerid = readerid;
    }

    public Date getLenddate() {
        return lenddate;
    }

    public void setLenddate(Date lenddate) {
        this.lenddate = lenddate;
    }

    public Date getBackdate() {
        return backdate;
    }

    public void setBackdate(Date backdate) {
        this.backdate = backdate;
    }

    public Integer getBacktype() {
        return backtype;
    }

    public void setBacktype(Integer backtype) {
        this.backtype = backtype;
    }

    public String getExceptremarks() {
        return exceptremarks;
    }

    public void setExceptremarks(String exceptremarks) {
        this.exceptremarks = exceptremarks == null ? null : exceptremarks.trim();
    }

    /**
     * 自己添加的属性
     */

    private BookInfo bookInfo;

    private ReaderInfo readerInfo;

    public BookInfo getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }

    public ReaderInfo getReaderInfo() {
        return readerInfo;
    }

    public void setReaderInfo(ReaderInfo readerInfo) {
        this.readerInfo = readerInfo;
    }

    @Override
    public String toString() {
        return "LendList{" +
                "id=" + id +
                ", bookid=" + bookid +
                ", readerid=" + readerid +
                ", lenddate=" + lenddate +
                ", backdate=" + backdate +
                ", backtype=" + backtype +
                ", exceptremarks='" + exceptremarks + '\'' +
                ", bookInfo=" + bookInfo +
                ", readerInfo=" + readerInfo +
                '}';
    }
}