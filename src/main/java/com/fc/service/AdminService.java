package com.fc.service;

import com.fc.entity.Admin;
import org.springframework.web.servlet.ModelAndView;

public interface AdminService {

    Admin queryUserByNameAndPassword(String username, String password);
}
