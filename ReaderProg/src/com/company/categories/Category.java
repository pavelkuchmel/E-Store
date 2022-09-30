package com.company.categories;

import java.util.ArrayList;

public class Category {
    private String categoryName;
    ArrayList<String> categoryArray;

    public Category(){}

    public Category(String categoryName){
        this.categoryName = categoryName;
        categoryArray = new ArrayList<>();
    }
}

