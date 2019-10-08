package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;
import com.codegym.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

//    private static Map<Integer, Product> products;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }


    @Override
    public void remove(Long id) {
        productRepository.remove(id);
    }

//    @Override
//    public ArrayList<Product> findByName(String name) {
//        List<Product> searchList = new ArrayList<>();
//
//        for (Product product : findAll()) {
//            if (product.getName().equals(name)) {
//                searchList.add(product);
//            }
//
//
//        }
//        return (ArrayList<Product>) searchList;
//    }
}


//    static {
//        products = new HashMap<>();
//        products.put(1, new Product(1, "Cuoc doi cua Pi", "45000", "", "Hanh trinh lenh denh tren bien cua cau be Pi", "Canada Yann Martel"));
//        products.put(2, new Product(2, "Rung Nauy", "60000", "", "Mot cuon tieu thuyet ky dieu co am huong dao va tu nguyen", "Murakami Haruki"));
//        products.put(3, new Product(3, "Cuoc doi cua Pi", "45000", "", "Hanh trinh lenh denh tren bien cua cau be Pi", "Canada Yann Martel"));
//        products.put(4, new Product(4, "Rung Nauy", "60000", "", "Mot cuon tieu thuyet ky dieu co am huong dao va tu nguyen", "Murakami Haruki"));
//    }