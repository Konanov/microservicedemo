package com.konanov.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by user01 on 3/6/17.
 */

@Service
public class WebProductService {

    @Autowired        // NO LONGER auto-created by Spring Cloud (see below)
    @LoadBalanced
    protected RestTemplate restTemplate;

    protected String serviceUrl;

    public WebProductService() {
        this.serviceUrl = "http://PRODUCTS-SERVICE";
    }

    public ResponseEntity<Product> createProduct(String name) {
        Product product = new Product();
        product.setName(name);
        return restTemplate.postForEntity(serviceUrl + "/products/put/{name}", product, Product.class, name);
    }

    public ResponseEntity<Product> getProduct(String name) {
        return restTemplate.getForEntity(serviceUrl + "/products/{name}", Product.class, name);
    }
}
