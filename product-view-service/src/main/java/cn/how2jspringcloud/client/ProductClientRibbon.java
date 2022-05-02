package cn.how2jspringcloud.client;


import cn.how2jspringcloud.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ProductClientRibbon {

//    @Autowired
//    RestTemplate restTemplate;

//    public List<Product> listProduct(){
//    return restTemplate.getForObject("http://PRODUCT-DATA-SERVICE/products",List.class);
//    }
}
