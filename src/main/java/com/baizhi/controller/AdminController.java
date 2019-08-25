package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("login")
    public String login(Admin admin) {
        Admin admin1 = adminService.query(admin.getName());

        if (admin1 == null) {
            return "login";
        } else if (admin1.getPassword().equals(admin.getPassword())) {

            return "redirect:/emp/showAll";
        } else {
            return "login";
        }
    }
}




