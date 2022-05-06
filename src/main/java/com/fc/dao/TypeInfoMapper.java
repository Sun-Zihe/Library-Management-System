package com.fc.dao;

import com.fc.entity.TypeInfo;
import com.fc.entity.TypeInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TypeInfoMapper {
    long countByExample(TypeInfoExample example);

    int deleteByExample(TypeInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TypeInfo record);

    int insertSelective(TypeInfo record);

    List<TypeInfo> selectByExample(TypeInfoExample example);

    TypeInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TypeInfo record, @Param("example") TypeInfoExample example);

    int updateByExample(@Param("record") TypeInfo record, @Param("example") TypeInfoExample example);

    int updateByPrimaryKeySelective(TypeInfo record);

    int updateByPrimaryKey(TypeInfo record);
}