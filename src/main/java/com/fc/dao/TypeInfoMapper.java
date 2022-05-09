package com.fc.dao;

import com.fc.entity.TypeInfo;
import com.fc.entity.TypeInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RestController;

@RestController
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

    /**
     * 查询所有的记录信息
     */
    List<TypeInfo> queryTypeInfoAll(String name);

    /**
     * 添加图书类型
     */
    void addTypeSubmit(TypeInfo typeInfo);

    /**
     * 修改 根据id查询记录信息，查询弹出修改界，然后修改进行确认提交
     */
    TypeInfo queryTypeInfoById(Integer id);

    /**
     * 修改提交
     */
    void updateTypeSubmit(TypeInfo TypeInfo);

    /**
     * 根据ids删除记录信息
     */
    void deleteTypeByIds(List<Integer> id);

    List<TypeInfo> queryTypeName();
}