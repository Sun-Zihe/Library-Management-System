package com.fc.service;

import com.fc.entity.TypeInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TypeInfoService {
    /**
     * 查询所有记录
     */
    PageInfo<TypeInfo> queryTypeInfoAll(String name, Integer pageNum, Integer limit);

    /**
     * 添加图书类型
     */
    void addTypeSubmit(TypeInfo typeInfo);

    /**
     * 修改 根据id查询记录信息
     */
    TypeInfo queryTypeInfoById(Integer id);

    /**
     * 修改提交
     */
    void updateTypeSubmit(TypeInfo TypeInfo);

    /**
     * 根据ids删除记录信息
     */
    void deleteTypeByIds(List<String> id);
}
