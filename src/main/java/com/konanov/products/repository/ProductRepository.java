package com.konanov.products.repository;

import com.konanov.products.entity.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by user01 on 3/6/17.
 */

public interface ProductRepository extends MongoRepository<Product, String> {

    @Override
    <S extends Product> List<S> save(Iterable<S> iterable);

    @Override
    List<Product> findAll();

    @Override
    List<Product> findAll(Sort sort);

    @Override
    <S extends Product> S insert(S s);

    @Override
    <S extends Product> List<S> insert(Iterable<S> iterable);

    Product findByName(String name);
}
