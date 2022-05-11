package com.fc.service;

import com.fc.entity.Admin;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AdminService {

    Admin queryUserByNameAndPassword(String username, String password);

    //查询所有管理员
    PageInfo<Admin> queryAdminAll(Admin admin, Integer pageNum, Integer limit);

    //提交
    void addAdminSubmit(Admin admin);

    //查询
    Admin queryAdminById(Integer id);

    //修改
    void updateAdminSubmit(Admin admin);

    //删除
    void deleteAdminByIds(List<String> ids);


}
