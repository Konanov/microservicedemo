package com.konanov.products;

import com.konanov.products.entity.Product;
import com.konanov.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by user01 on 3/6/17.
 */


@EnableDiscoveryClient
@SpringBootApplication
@EnableMongoRepositories
/*@Import(AccountsConfiguration.class)*/
public class ProductsServer implements CommandLineRunner {

    public static void main(String[] args) {
        // Will configure using products-server.yml
        System.setProperty("spring.config.name", "products-server");

        SpringApplication.run(ProductsServer.class, args);
    }

    @Autowired
    ProductRepository repository;

    @Override
    public void run(String... strings) throws Exception {
        repository.save(new Product("milk"));
        repository.save(new Product("bread"));
        repository.save(new Product("butter"));
        repository.save(new Product("beer"));
        repository.save(new Product("soda"));
    }
}
