package com.baizhi.controller;

import com.baizhi.entity.Production;
import com.baizhi.service.ShoppingService;
import com.baizhi.vo.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("shopping")
public class ShoppingController {
    @Autowired
    private ShoppingService shoppingService;

    @RequestMapping("add")
    public String addItem(String id, HttpServletRequest request, Model model) {
        Production production = shoppingService.queryById(id, request);
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        model.addAttribute("production", production);
        return "addItemSuccess";
    }

    public String modify(String id, Integer count, HttpServletRequest request) {
        return "xx";
    }

    //删除购物项
    @RequestMapping("delete")
    public String delete(String id, HttpServletRequest request, Model model) {
        shoppingService.removeById(id, request);
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        model.addAttribute("cart", cart);
        return "cart";
    }
}
