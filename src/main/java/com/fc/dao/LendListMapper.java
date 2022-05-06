package com.fc.dao;

import com.fc.entity.LendList;
import com.fc.entity.LendListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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
}