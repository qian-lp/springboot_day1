package com.baizhi.controller;

import com.baizhi.entity.Production;
import com.baizhi.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("product")
public class ProductionController {
    @Autowired
    private ProductionService productionService;

    //展示商品
    @RequestMapping("showAll")
    public Map<String, Object> findAll(Integer page, Integer rows) {
        //总数据量
        Integer counts = productionService.count();
        //总页数
        Integer total = (counts % rows == 0) ? (counts / rows) : counts / rows + 1;
        List<Production> productions = productionService.queryAll(page, rows);
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows", productions);
        map.put("page", page);
        map.put("total", total);
        map.put("records", counts);
        return map;
    }

    @RequestMapping("findOne")
    public String addCart(String id, HttpServletRequest request) {
        Production production = productionService.queryOne(id);
        //request.getSession().setAttribute();
        return "cart";
    }
}
