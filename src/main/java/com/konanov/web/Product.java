package com.konanov.web;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Created by user01 on 3/7/17.
 */

@JsonRootName("Product")
public class Product {
    private String id;
    private String name;

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
