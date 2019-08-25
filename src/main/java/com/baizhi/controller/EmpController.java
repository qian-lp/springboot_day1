package com.baizhi.controller;

import com.baizhi.entity.Emp;
import com.baizhi.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    @RequestMapping("showAll")
    //展示
    public String showALL(Model model) {
        List<Emp> emps = empService.queryAll();
        model.addAttribute("emps", emps);
        return "emplist";
    }

    //删除
    @RequestMapping("delete")
    public String delete(String id) {
        empService.remove(id);
        return "redirect:/emp/showAll";
    }

    //修改
    @RequestMapping("updateFirst")
    public String updateFirst(String id, Model model) {
        Emp emp = empService.queryById(id);
        System.out.println(emp);
        model.addAttribute("emp", emp);
        return "update";
    }

    @RequestMapping("updateLast")
    public String updateLast(Emp emp) {
        System.out.println(emp + "传回来的");
        empService.change(emp);
        return "redirect:/emp/showAll";
    }

    //添加
    @RequestMapping("add")
    public String add(Emp emp) {
        emp.setId(UUID.randomUUID().toString());
        empService.add(emp);
        return "redirect:/emp/showAll";
    }
}
