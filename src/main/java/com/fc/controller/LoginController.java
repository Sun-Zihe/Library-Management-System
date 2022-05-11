package com.fc.controller;

import com.fc.codeutil.IVerifyCodeGen;
import com.fc.codeutil.SimpleCharVerifyCodeGenImpl;
import com.fc.codeutil.VerifyCode;
import com.fc.entity.Admin;
import com.fc.entity.ReaderInfo;
import com.fc.service.AdminService;
import com.fc.service.ReaderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RequestMapping
@Controller
public class LoginController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private ReaderInfoService readerService;

    //验证码、拦截器
    @RequestMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) {
        //不会写，这次就当学习一下了，第一次见 (´-﹏-`；)
        IVerifyCodeGen iVerifyCodeGen = new SimpleCharVerifyCodeGenImpl();
        try {
            //设置长宽
            VerifyCode verifyCode = iVerifyCodeGen.generate(80, 28);
            String code = verifyCode.getCode();
            //将VerifyCode绑定session
            request.getSession().setAttribute("VerifyCode", code);
            //设置响应头
            response.setHeader("Pragma", "no-cache");
            //设置响应头
            response.setHeader("Cache-Control", "no-cache");
            //在代理服务器端防止缓冲
            response.setDateHeader("Expires", 0);
            //设置响应内容类型
            response.setContentType("image/jpeg");
            response.getOutputStream().write(verifyCode.getImgBytes());
            response.getOutputStream().flush();
        } catch (IOException e) {
            System.out.println("异常处理");
        }
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    /**
     * 登录验证
     */
    @RequestMapping("/loginIn")
    public String loginIn(HttpServletRequest request, Model model){
        //获取用户名与密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //验证码
        String code=request.getParameter("captcha");
        //用户类型
        String type=request.getParameter("type");

        //判断验证码是否正确（验证码已经放入session）
        HttpSession session = request.getSession();

        //从session中获取验证码
        String realCode = (String)session.getAttribute("VerifyCode");

        //这一步验证码
        if (!realCode.toLowerCase().equals(code.toLowerCase())){
            //如果验证码不正确
            model.addAttribute("msg","验证码不正确");
            return "login";
        }else{
            //验证码正确则判断用户名和密码
            if(type.equals("1")){//管理员信息
                //用户名和密码是否正确
                Admin admin=adminService.queryUserByNameAndPassword(username,password);
                if(admin==null){//该用户不存在
                    model.addAttribute("msg","用户名或密码错误");
                    return "login";
                }
                //将用户和用户类型写入到域对象中
                session.setAttribute("user",admin);
                session.setAttribute("type","admin");
            }else{//来自读者信息表
                ReaderInfo readerInfo=readerService.queryUserInfoByNameAndPassword(username,password);
                if(readerInfo==null){
                    model.addAttribute("msg","用户名或密码错误");
                    return "login";
                }
                session.setAttribute("user",readerInfo);
                session.setAttribute("type","reader");
            }
            //返回字符串，让前端lay去跳转
            return "/index";
        }
    }

    /**
     * 退出功能
     */
    @GetMapping("loginOut")
    public String loginOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();//注销
        return "/login";
    }


}
