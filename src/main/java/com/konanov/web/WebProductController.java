package com.konanov.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

/**
 * Created by user01 on 3/6/17.
 */

@Controller
public class WebProductController {

    protected WebProductService productService;

    protected Logger logger = Logger.getLogger(WebProductController.class.getName());

    @Autowired
    public WebProductController(WebProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/products/{name}", method = RequestMethod.GET)
    public ResponseEntity<Product> obtainProduct(@PathVariable("name") String name) {

        logger.info("web-service byNumber() invoked: " + name);

        ResponseEntity<Product> product = productService.getProduct(name);
        logger.info("web-service byNumber() found: " + product);
        return product;
    }

    @RequestMapping(value = "/products/put/{name}", method = RequestMethod.GET)
    public ResponseEntity<Product> persistProduct(@PathVariable("name") String name) {
        return productService.createProduct(name);
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        return "Hello products";
    }
}
