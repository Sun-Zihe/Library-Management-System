package com.fc.controller;

import com.fc.entity.Admin;
import com.fc.service.AdminService;
import com.fc.vo.DataInfoVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/adminIndex")
    public String adminIndex() {

        return "admin/adminIndex";
    }

    @RequestMapping("/adminAll")
    @ResponseBody
    public DataInfoVO queryAdminAll(Admin admin, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit) {
        PageInfo<Admin> pageInfo = adminService.queryAdminAll(admin, pageNum, limit);
        return new DataInfoVO(0, "成功", pageInfo.getList(), pageInfo.getTotal());
    }

    //添加的页面跳转
    @GetMapping("/adminAdd")
    public String adminAdd() {
        return "admin/adminAdd";
    }

    //添加
    @RequestMapping("/addAdminSubmit")
    @ResponseBody
    public DataInfoVO addBookSubmit(Admin admin) {
        adminService.addAdminSubmit(admin);
        return new DataInfoVO(0, "成功", null, null);
    }

    //根据id查询,修改密码
    @GetMapping("/queryAdminById")
    public String queryAdminById(Integer id, Model model) {
        model.addAttribute("id", id);
        return "admin/updateAdmin";
    }

    //修改提交
    @RequestMapping("/updatePwdSubmit")
    @ResponseBody
    public DataInfoVO updatePwdSubmit(Integer id, String oldPwd, String newPwd) {
        //根据id查询对象
        Admin admin = adminService.queryAdminById(id);

        if (!oldPwd.equals(admin.getPassword())) {
            return new DataInfoVO(400, "失败", null, null);

        } else {
            admin.setPassword(newPwd);

            adminService.updateAdminSubmit(admin);

            return new DataInfoVO(0, "成功", null, null);
        }
    }

    //删除
    @RequestMapping("/deleteAdminByIds")
    @ResponseBody
    public DataInfoVO deleteAdminByIds(String ids){
        List<String> list = Arrays.asList(ids.split(","));

        adminService.deleteAdminByIds(list);

        return new DataInfoVO(0,"成功",null,null);
    }


}
