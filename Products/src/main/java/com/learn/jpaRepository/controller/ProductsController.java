package com.learn.jpaRepository.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.jpaRepository.entity.Products;
import com.learn.jpaRepository.exception.ProductException;
import com.learn.jpaRepository.service.ProductsService;

@RestController
@RequestMapping("api")
public class ProductsController {
	
    @Autowired
    ProductsService productsService;
    
    //Fetching all the Products from the database
    @GetMapping("/products")
    private List<Products> getAllProducts() {
        return productsService.getAllProducts();
    }

    //fetch product by Id
    @GetMapping("products/product/{productid}")
    private Products getProducts(@PathVariable("productid") int productid) {
        return productsService.getProductsById(productid);
    }

    //Deleting product
    @DeleteMapping("/book/{bookid}")
    private void deleteBook(@PathVariable("bookid") int bookid) {
        productsService.delete(bookid);
    }

    //Posting product details in the database
    @PostMapping("/Product")
    private int saveBook(@RequestBody Products Products) {
        productsService.save(Products);
        return Products.getProductid();
    }

    //Updating record
    @PutMapping("/Products")
    private Products update(@RequestBody Products Product, @PathVariable Integer productid) {
    	productsService.update(Product, productid);
        return Product;
    }
    
    // Fetch product if product price is less than given price
    @GetMapping("products/getPriceLessThan")
    private List<Products> getPriceLessThan(@RequestParam("Price") int price) throws ProductException {
        return productsService.getPriceLessThan(price);
    }
    // Fetch product if product price is less than or equal to given price
    @GetMapping("products/getPriceLessThanEqual")
    private List<Products> getPriceLessThanEqual(@RequestParam("Price") int price) throws ProductException {
        return productsService.getPriceLessThanEqual(price);
    }
    
    // Fetch product based on price and name
    @GetMapping("products/getPriceAndProduct")
    private List<Products> getPriceAndProductName(@RequestParam("Price") int price,@RequestParam("productName") String productName) throws ProductException {
        return productsService.getPriceAndProductName(price,productName);
    }


}
