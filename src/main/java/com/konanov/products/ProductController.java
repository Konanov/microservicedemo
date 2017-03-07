package com.konanov.products;

import com.konanov.products.entity.Product;
import com.konanov.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by user01 on 3/6/17.
 */

@RestController
public class ProductController {

    private ProductRepository repository;

    @Autowired
    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/products/put/{name}", method = RequestMethod.POST)
    public Product putProduct(@PathVariable(value = "name") String name) {
        return repository.save(new Product(name));
    }

    @RequestMapping(value = "/products/{name}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable(value = "name") String name) {
        return repository.findByName(name);
    }
}
