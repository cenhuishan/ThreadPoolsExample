package cn.how2jspringcloud.service;


import cn.how2jspringcloud.client.ProductClientFeign;
import cn.how2jspringcloud.client.ProductClientRibbon;
import cn.how2jspringcloud.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductClientFeign productClientFeign;

    public List<Product> productList(){
        return productClientFeign.listProducts();
    }
}
