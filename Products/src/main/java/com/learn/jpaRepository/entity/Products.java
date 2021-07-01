package com.learn.jpaRepository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Products {
	
    @Id
    @Column
    private Integer productid;
    
    @Column
    private String productName;
    
    @Column
    private int quantity;
    
    @Column
    private int price;
    
    public int getProductid()
    {
        return productid;
    }
    public void setProductid(int productid)
    {
        this.productid = productid;
    }
    
    public String getProductName()
    {
        return productName;
    }
    public void setproductName(String productName)
    {
        this.productName = productName;
    }
    
    public int getQuantity()
    {
        return quantity;
    }
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    
    public int getPrice()
    {
        return price;
    }
    public void setPrice(int price)
    {
        this.price = price;
    }

}

