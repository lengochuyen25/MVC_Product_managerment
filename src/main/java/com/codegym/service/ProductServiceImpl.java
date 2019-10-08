package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Cuoc doi cua Pi", "45000", "", "Hanh trinh lenh denh tren bien cua cau be Pi", "Canada Yann Martel"));
        products.put(2, new Product(2, "Rung Nauy", "60000", "", "Mot cuon tieu thuyet ky dieu co am huong dao va tu nguyen", "Murakami Haruki"));
        products.put(3, new Product(3, "Cuoc doi cua Pi", "45000", "", "Hanh trinh lenh denh tren bien cua cau be Pi", "Canada Yann Martel"));
        products.put(4, new Product(4, "Rung Nauy", "60000", "", "Mot cuon tieu thuyet ky dieu co am huong dao va tu nguyen", "Murakami Haruki"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);

    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);

    }

    @Override
    public void remove(int id) {
        products.remove(id);

    }

    @Override
    public ArrayList<Product> findByName(String name) {
        List<Product> searchList=new ArrayList<>();

        for (Product product: findAll()){
            if (product.getName().equals(name)){
                searchList.add(product);
            }


        }
        return (ArrayList<Product>) searchList;


    }
}
