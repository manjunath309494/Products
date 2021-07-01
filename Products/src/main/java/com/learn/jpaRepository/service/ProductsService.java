package com.learn.jpaRepository.service;

import com.learn.jpaRepository.exception.ProductException;
import com.learn.jpaRepository.entity.Products;
import com.learn.jpaRepository.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {
	
        @Autowired
        ProductsRepository ProductsRepository;

        // Getting all Products 
        public List<Products> getAllProducts() {
                List<Products> Products = new ArrayList<Products>();
                ProductsRepository.findAll().forEach(Products1 -> Products.add(Products1));
                return Products;
        }

        //Getting Product by specific Id
        public Products getProductsById(int id) {
                return ProductsRepository.findById(id).get();
        }

        //Posting a record  
        public void save(Products Products) {
                ProductsRepository.save(Products);
        }
        
        // Updating the resource
        public void update(Products Products, int productid) {
                ProductsRepository.save(Products);
        }

        //deleting a specific record by using the method deleteById() of CrudRepository
        public void delete(int id) {
                ProductsRepository.deleteById(id);
        }        

	    public List<Products> getPriceAndProductName(int price, String productName) throws ProductException{
	
	            Optional<List<Products>> byPriceOrProductName = ProductsRepository.findByPriceAndProductName(price, productName);
	
	            if(byPriceOrProductName.isPresent() && byPriceOrProductName.get().size() > 0 ) {
	                  return (List<Products>) byPriceOrProductName.get();
	            }
	            else {
	                    throw new ProductException("Product with mentioned price or name is  NOT FOUND");
	            }	
	    }
	    
        public List<Products> getPriceLessThan(int price) throws ProductException{

                Optional<List<Products>> byPriceLessThan = ProductsRepository.findByPriceLessThan(price);

                if(byPriceLessThan.isPresent() && byPriceLessThan.get().size() > 0 ) {
                        return (List<Products>) byPriceLessThan.get();
                } else {
                        throw new ProductException("Products with lesser than given price NOT FOUND");
                }
        }
        
        public List<Products> getPriceLessThanEqual(int price) throws ProductException{

                Optional<List<Products>> byPriceLessThanEqual = ProductsRepository.findByPriceLessThanEqual(price);

                if(byPriceLessThanEqual.isPresent() && byPriceLessThanEqual.get().size() > 0 ) {
                        return (List<Products>) byPriceLessThanEqual.get();
                } else {
                        throw new ProductException("Product with given price NOT FOUND");
                }
        }
}
