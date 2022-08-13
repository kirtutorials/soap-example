package com.example.demo.services;

import com.example.demo.soap.Product;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {

    private static final Map<String, Product> products = new HashMap<>();

    @PostConstruct
    public void initialize() {
        Product mobile = new Product();
        mobile.setCategory("Electronics");
        mobile.setName("iphone");
        mobile.setPrice(2000.00);

        Product shoes = new Product();
        mobile.setCategory("wearables");
        mobile.setName("reebobk");
        mobile.setPrice(200);

        Product tv = new Product();
        mobile.setCategory("Electronics");
        mobile.setName("iTV");
        mobile.setPrice(2000.00);

        products.put(mobile.getName(), mobile);
        products.put(shoes.getName(), shoes);
        products.put(tv.getName(), tv);
    }

    public Product getSingleProduct(String name) {
            return products.get(name);
    }
}
