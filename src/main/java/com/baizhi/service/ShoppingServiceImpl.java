package com.baizhi.service;

import com.baizhi.dao.ProductionDAO;
import com.baizhi.entity.Production;
import com.baizhi.vo.Cart;
import com.baizhi.vo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class ShoppingServiceImpl implements ShoppingService {
    @Autowired
    private ProductionDAO productionDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Production queryById(String id, HttpServletRequest request) {
        Production production = productionDAO.select(id);
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {//没有购物车
            cart = new Cart();
            Item item = new Item(production, 1, production.getPrice());
            HashMap<String, Item> cartMap = new HashMap<>();
            cartMap.put(production.getId(), item);
            cart.setMap(cartMap);
            cart.setTotal(production.getPrice());
            request.getSession().setAttribute("cart", cart);
        } else {//有购物车，有购物项
            if (cart.getMap().containsKey(production.getId())) {
                Item item = cart.getMap().get(production.getId());
                item.setCount(item.getCount() + 1);
                item.setSubTotal(item.getSubTotal() + production.getPrice());
                cart.getMap().put(production.getId(), item);
                cart.setTotal(cart.getTotal() + production.getPrice());
                request.getSession().setAttribute("cart", cart);

            } else {//有购物车，没有购物项
                Item item = new Item(production, 1, production.getPrice());
                Map<String, Item> map = cart.getMap();
                map.put(production.getId(), item);
                cart.setMap(map);
                cart.setTotal(production.getPrice() + cart.getTotal());
                request.getSession().setAttribute("cart", cart);
            }
        }

        return production;
    }

    @Override
    //修改数量并更新价格
    public void modify(String id, Integer count, HttpServletRequest request) {
        Production production = productionDAO.select(id);
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        Item item = cart.getMap().get(id);
        //原数量
        Integer count1 = item.getCount();
        item.setCount(count);
        item.setSubTotal(production.getPrice() * count);
        Map<String, Item> map = cart.getMap();
        map.put(production.getId(), item);
        cart.setMap(map);
        cart.setTotal(cart.getTotal() + (count - count1) * production.getPrice());
        request.getSession().setAttribute("cart", cart);


    }

    @Override
    //删除购物项
    public Production removeById(String id, HttpServletRequest request) {
        Production production = productionDAO.select(id);
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.setTotal(cart.getTotal() - cart.getMap().get(id).getCount() * production.getPrice());
        cart.getMap().remove(id);
        request.getSession().setAttribute("cart", cart);

        return production;
    }
}
