package com.codegym.service;


import com.codegym.model.Product;
import com.codegym.model.ProductForm;
import com.codegym.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
@PropertySource("classpath:global_config_app.properties")
public class ProductServiceImpl implements ProductService{
    @Autowired
    Environment env;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findOne(id);
    }

    @Override
    public void save(ProductForm productForm) {
        //1. store img to hask disk;

        //2. store url, info of product to database

        Product product = exchangeObject(productForm); //

       productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
       productRepository.delete(id);
    }

    @Override
    public Product exchangeObject(ProductForm productForm) {
        String fileName;
        if (productForm.getImg().equals("")) {
            fileName = productRepository.findOne(productForm.getId()).getImg();
        } else {
            MultipartFile multipartFile = productForm.getImg();
            fileName = multipartFile.getOriginalFilename();
        }
        String folderContaintFileStore = env.getProperty("file_upload");
        // /home/huyen/IdeaProjects/ListMVC/MVC_Product_managerment/src/main/webapp/WEB-INF/views/images/
        try {
            // write file to hard disk;
            FileCopyUtils.copy(productForm.getImg().getBytes(), new File(folderContaintFileStore + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // colect info for store to database;
        Product product = new Product(productForm.getId(), productForm.getName(),
                productForm.getPrice(), fileName,productForm.getDescription(), productForm.getAuthor());
        return product;
    }

    @Override
    public Page<Product> findAllByNameContaining(String name, Pageable pageable) {
        return productRepository.findAllByNameContaining(name, pageable);
    }
}