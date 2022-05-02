package cn.how2jspringcloud.controller;


import cn.how2jspringcloud.pojo.Product;
import cn.how2jspringcloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @RequestMapping("/products")
    public String productList(Model model){
        List<Product> ps= productService.productList();
        model.addAttribute("ps",ps);
        return "products";
    }

}
