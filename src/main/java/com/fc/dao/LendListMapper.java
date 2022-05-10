package com.fc.dao;

import com.fc.entity.LendList;
import com.fc.entity.LendListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface LendListMapper {
    long countByExample(LendListExample example);

    int deleteByExample(LendListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LendList record);

    int insertSelective(LendList record);

    List<LendList> selectByExample(LendListExample example);

    LendList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LendList record, @Param("example") LendListExample example);

    int updateByExample(@Param("record") LendList record, @Param("example") LendListExample example);

    int updateByPrimaryKeySelective(LendList record);

    int updateByPrimaryKey(LendList record);


     // 查询所有借阅记录
    List<LendList> queryLendListAll(LendList lendList);

    //正常还书
    void updateLendListSubmit(LendList lend);

    List<LendList> queryLookBookList(@Param("rid") Integer readerId, @Param("bid") Integer bookId);
}