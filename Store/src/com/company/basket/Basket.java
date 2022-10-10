package com.company.basket;

import com.company.product.Product;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Product> basket;

    public void addProduct(Product product){
        basket.add(product);
    }
    public void basketClear(){
        basket.clear();
    }
}
