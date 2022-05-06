package com.fc.entity;

import java.util.Date;

public class LendList {
    private Integer id;

    private Integer bookid;

    private Integer readerid;

    private Date lenddate;

    private Date backdate;

    private Integer backtype;

    private String exceptremarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}