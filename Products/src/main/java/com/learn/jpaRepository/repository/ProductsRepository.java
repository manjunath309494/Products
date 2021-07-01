package com.learn.jpaRepository.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.jpaRepository.entity.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

	public List<Products> findByPriceGreaterThanEqual(int Price);
	
	public Optional<List<Products>>findByPriceLessThan(int price);

    public Optional<List<Products>> findByPriceLessThanEqual(int price);

    public Optional<Products> findByPriceOrProductName(int price, String productName);

    public Optional<List<Products>> findByPriceAndProductName(int price,String productName);

    public List<Products> findByproductNameBetween(String start, String end);   

    public List<Products> findByproductNameIsNull();

    public List<Products> findByproductNameOrProductNameIsNull(String name);

    public List<Products> findByproductNameLike(String name);

    public List<Products> findByproductNameContaining(String name);

    public List<Products> findByproductNameStartingWith(String name);
    

	
}
