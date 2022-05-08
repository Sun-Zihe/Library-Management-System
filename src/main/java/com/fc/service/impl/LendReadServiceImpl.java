package com.fc.service.impl;

import com.fc.dao.BookInfoMapper;
import com.fc.dao.LendListMapper;
import com.fc.entity.BookInfo;
import com.fc.entity.LendList;
import com.fc.service.LendReadService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LendReadServiceImpl implements LendReadService {

    @Autowired
    private LendListMapper lendListMapper;

    @Autowired
    private BookInfoMapper bookInfoMapper;

    //查询所有，以及模糊查询，
    @Override
    public PageInfo queryLendListAll(LendList info, Integer page, Integer limit) {

        //开分页
        PageHelper.startPage(page,limit);

        List<LendList> list=lendListMapper.queryLendListAll(info);

        for (LendList ls:list
             ) {
            System.out.println(ls.getBacktype());
        }

        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }


    //还书
    @Override
    public void backBook(LendList lendList) {
        LendList list = lendListMapper.selectByPrimaryKey(lendList.getId());
        LendList lend=new LendList();
        lend.setId(list.getId());
        lend.setBacktype(list.getBacktype());
        lend.setBackdate(new Date());
        lend.setExceptremarks(list.getExceptremarks());
        lend.setBookid(list.getBookid());
        lendListMapper.updateLendListSubmit(lend);
        //判断异常还书 如果是延期或者正常还书，需要更改书的状态
        if(lend.getBacktype()==0 || lend.getBacktype()==1){
            BookInfo bookInfo=bookInfoMapper.selectByPrimaryKey(lend.getBookid());
            bookInfo.setStatus(0);//该为未借出
            bookInfoMapper.updateByPrimaryKey(bookInfo);
        }

    }

    @Override
    public void addLendListSubmit(LendList lendList) {
        lendListMapper.insert(lendList);
    }

    @Override
    public Integer updateLendListSubmit(List<String> ids, List<String> bookIds) throws NumberFormatException{

        int affRow=0;

        for(String id:ids){
            //根据id查询借阅记录信息
            LendList lendList=new LendList();
            lendList.setId(Integer.parseInt(id));
            lendList.setBackdate(new Date());
            lendList.setBacktype(0);//正常还书
            //如果用updatePrimarykey会默认很多赋值为空
            lendListMapper.updateLendListSubmit(lendList);
        }
        for(String bid:bookIds){
            //根据id查询图书记录信息
            BookInfo bookInfo=bookInfoMapper.selectByPrimaryKey(Integer.parseInt(bid));
            bookInfo.setStatus(0);//该为未借出
            affRow = bookInfoMapper.updateByPrimaryKey(bookInfo);
        }

        return affRow;
    }

}
