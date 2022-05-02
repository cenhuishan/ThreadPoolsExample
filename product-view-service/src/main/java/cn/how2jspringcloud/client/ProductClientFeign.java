package cn.how2jspringcloud.client;


import cn.how2jspringcloud.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "PRODUCT-DATA-SERVICE")
public interface ProductClientFeign {
    @RequestMapping("/products")
    public List<Product> listProducts();
}
