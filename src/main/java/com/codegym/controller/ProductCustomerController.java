package com.codegym.controller;

import com.codegym.model.Author;
import com.codegym.model.Product;
import com.codegym.model.ProductForm;
import com.codegym.service.AuthorService;
import com.codegym.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@Controller
@PropertySource("classpath:global_config_app.properties")
public class ProductCustomerController {

    @Autowired
    private ProductService productService;

    @Autowired
    private AuthorService authorService;

    @ModelAttribute("authors")
    public Iterable<Author> authors() {
        return authorService.findAll();
    }
    @GetMapping("/products_customer")
    public ModelAndView listProductsCustomer(@RequestParam("s") Optional<String> s, Pageable pageable) {
        Page<Product> products;
        if(s.isPresent()){
            products=productService.findAllByNameContaining(s.get(),pageable);
        }else {
            products = productService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/product_customer/list");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/view-product-customer/{id}")
    public ModelAndView viewProductCustomer(@PathVariable Long id) {
        Product product = productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/product_customer/view");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

}
