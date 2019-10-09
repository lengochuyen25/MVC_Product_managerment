package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.model.ProductForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);

    Product findById(Long id);

    void save(ProductForm productForm);

    void remove(Long id);

//    ArrayList<Product> findByName(String name);

    Product exchangeObject(ProductForm productForm);

    Page<Product> findAllByNameContaining(String name, Pageable pageable);
}
