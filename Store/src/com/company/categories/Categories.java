package com.company.categories;

import com.company.product.Product;

import java.util.ArrayList;
import java.util.PrimitiveIterator;

public class Categories {
    private String categoryName;
    private ArrayList<Product> categories;
    public Categories(String categoryName){
        this.categoryName = categoryName;
        categories = new ArrayList<>();
    }
    public void addProduct(Product product){
        this.categories.add(product);
    }
    public void addProduct(String name, double price, int rating){
        addProduct(new Product(name, price, rating));
    }

    public Product getProduct(int index){
        return categories.get(index);
    }
    public int getSize(){
        return categories.size();
    }
    @Override
    public String toString() {
        return '@' + categoryName;
    }
}
