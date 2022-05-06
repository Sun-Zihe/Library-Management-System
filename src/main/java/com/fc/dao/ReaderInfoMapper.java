package com.fc.dao;

import com.fc.entity.ReaderInfo;
import com.fc.entity.ReaderInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ReaderInfoMapper {
    long countByExample(ReaderInfoExample example);

    int deleteByExample(ReaderInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ReaderInfo record);

    int insertSelective(ReaderInfo record);

    List<ReaderInfo> selectByExample(ReaderInfoExample example);

    ReaderInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ReaderInfo record, @Param("example") ReaderInfoExample example);

    int updateByExample(@Param("record") ReaderInfo record, @Param("example") ReaderInfoExample example);

    int updateByPrimaryKeySelective(ReaderInfo record);

    int updateByPrimaryKey(ReaderInfo record);

    ReaderInfo queryUserInfoByNameAndPassword(String username, String password);
}