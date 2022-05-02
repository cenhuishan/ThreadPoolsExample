package cn.how2jspringcloud.controller;


import cn.how2jspringcloud.pojo.Product;
import cn.how2jspringcloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("/products")
    public Object product(){
        List<Product> ps = productService.listProducts();
        return ps;
    }
}
