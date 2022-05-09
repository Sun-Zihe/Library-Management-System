package com.fc.service.impl;

import com.fc.dao.TypeInfoMapper;
import com.fc.entity.TypeInfo;
import com.fc.service.TypeInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeInfoServiceImpl implements TypeInfoService {
    @Autowired
    private TypeInfoMapper typeInfoMapper;

    @Override
    public PageInfo<TypeInfo> queryTypeInfoAll(String name, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<TypeInfo> typeInfoList =  typeInfoMapper.queryTypeInfoAll(name);
        return new PageInfo<>(typeInfoList);
    }

    @Override
    public void addTypeSubmit(TypeInfo typeInfo) {
        typeInfoMapper.addTypeSubmit(typeInfo);
    }

    @Override
    public TypeInfo queryTypeInfoById(Integer id) {
        return typeInfoMapper.queryTypeInfoById(id);
    }

    @Override
    public void updateTypeSubmit(TypeInfo TypeInfo) {
        typeInfoMapper.updateTypeSubmit(TypeInfo);
    }

    @Override
    public void deleteTypeByIds(List<String> id) {
        List<Integer> list=new ArrayList<>();
        for(String cid:id){
            int id2= Integer.valueOf(cid);
            list.add(id2);
        }
        typeInfoMapper.deleteTypeByIds(list);
    }
}
