package com.company.basket;

import com.company.product.Product;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Product> basket;

    public Basket(){
        basket = new ArrayList<>();
    }

    public void addProduct(Product product){
        basket.add(product);
    }
    public void addProduct(String name, double price, int rating){
        addProduct(new Product(name, price, rating));
    }
    public void basketClear(){
        basket.clear();
    }

    public int basketSize(){
        return basket.size();
    }

    public Product getProduct(int index){
        return basket.get(index);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "basket=" + basket +
                '}';
    }
}
