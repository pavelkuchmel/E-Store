package com.company.product;

public class Product {
    public Product(){}
    public Product(String name, double price, int rating){
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}
    public int getRating() {return rating;}
    public void setRating(int rating) {this.rating = rating;}

    @Override
    public String toString() {
        return '$' + name + '%' + price + '&' + rating + '>';
    }

    private String name;
    private double price;
    private int rating;
}
