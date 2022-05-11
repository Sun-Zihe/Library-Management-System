package com.fc.service.impl;

import com.fc.dao.AdminMapper;
import com.fc.entity.Admin;
import com.fc.service.AdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin queryUserByNameAndPassword(String username, String password) {
        return adminMapper.queryUserByNameAndPassword(username,password);
    }

    @Override
    public PageInfo<Admin> queryAdminAll(Admin admin, Integer pageNum, Integer limit) {
        //开启分页
        PageHelper.startPage(pageNum,limit);

        List<Admin> adminList = adminMapper.queryAdminInfoAll(admin);

        return new PageInfo<>(adminList);
    }

    //添加
    @Override
    public void addAdminSubmit(Admin admin){
        adminMapper.insert(admin);
    }

    //查询
    @Override
    public Admin queryAdminById(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    //修改
    @Override
    public void updateAdminSubmit(Admin admin) {
        adminMapper.updateByPrimaryKey(admin);
    }

    //删除
    @Override
    public void deleteAdminByIds(List<String> ids) {
        for (String id : ids) {
            adminMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
    }
}
