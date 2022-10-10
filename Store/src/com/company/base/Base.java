package com.company.base;
import com.company.basket.Basket;
import com.company.categories.Categories;
import com.company.user.User;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Base {
    private ArrayList<User> users;
    private ArrayList<Basket> baskets;
    private ArrayList<Categories> categories;

    public void readerFileCategories(){
        //ArrayList<Character> buffer = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        StringBuilder categoryName = new StringBuilder();
        StringBuilder name = new StringBuilder();
        StringBuilder price = new StringBuilder();
        StringBuilder rating = new StringBuilder();

        try(FileReader reader = new FileReader("E:\\JavaFXCode\\Store\\src\\com\\company\\base\\categories.txt"))
        {
            int c;
            while((c=reader.read())!=-1){

                //System.out.print((char)c);
                buffer.append((char)c);

            }
            System.out.println(buffer);

        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        char sw = ' ';
        for(int i = 0, j = 0; i < buffer.length(); i++){
            if (buffer.charAt(i) == '@') {
                sw = buffer.charAt(i);
                continue;
            }
            if (buffer.charAt(i) == '$') {
                sw = buffer.charAt(i);
                continue;
            }
            if (buffer.charAt(i) == '%') {
                sw = buffer.charAt(i);
                continue;
            }
            if (buffer.charAt(i) == '&') {
                sw = buffer.charAt(i);
                continue;
            }
            if (buffer.charAt(i) == '>'){
                addCategories(categoryName.toString());
                System.out.println("categoryName: " + categoryName.toString());
                System.out.println("name: " + name.toString());//categories.get(i).getProduct(i).setName(name.toString());
                System.out.println("price: " + price.toString());//categories.get(i).getProduct(i).setPrice(Double.parseDouble(price.toString()));
                System.out.println("rating: " + rating.toString());//categories.get(i).getProduct(i).setRating(Integer.parseInt(rating.toString()));
                System.out.println(categories);
                categories.get(j).addProduct(name.toString(), Double.parseDouble(price.toString()), Integer.parseInt(rating.toString()));
                categoryName.delete(0, categoryName.length());
                name.delete(0, name.length());
                price.delete(0, price.length());
                rating.delete(0, rating.length());
                j++;
                continue;
            }
            switch (sw){
                case '@':
                    categoryName.append(buffer.charAt(i));
                    break;
                case '$':
                    name.append(buffer.charAt(i));
                    break;
                case '%':
                    price.append(buffer.charAt(i));
                    break;
                case '&':
                    rating.append(buffer.charAt(i));
                    break;
            }
        }
    }
    public void writeFileCategories(){
        try(FileWriter writer = new FileWriter("E:\\JavaFXCode\\Store\\src\\com\\company\\base\\categories.txt", false))
        {
            for (int i = 0; i < categories.size(); i++){
                writer.write(categories.get(i).toString());
                for (int j = 0; j < categories.get(i).getSize(); j++){
                    writer.write(categories.get(i).getProduct(j).toString());
                }
            }
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
    public Base() {
        this.users = new ArrayList<>();
        this.baskets = new ArrayList<>();
        this.categories = new ArrayList<>();
    }
    public void addCategories(Categories categories){
        this.categories.add(categories);
    }
    public void addCategories(String categoryName){
        categories.add(new Categories(categoryName));
    }
    public void addUser(User user){
        users.add(user);
    }
    public void addUser(String login, String password){
        /*User name = new User(login, password);*/
        users.add(new User(login, password));
    }
    public User getUser(int indexUser){
        return users.get(indexUser);
    }
    public boolean checkUserLogin(String login){
        for(User u : users){
            if(u.getLogin().equals(login)) return false;
        }
        return true;
    }
    public boolean checkUserPassword(String login, String password){
        for (User u : users){
            if(u.getLogin().equals(login)){
                if (u.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }
    public int indexLogin(String login){
        int index = 0;
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getLogin().equals(login)) index = i;
        }
        return index;
    }

    public void writeFileUsers(){
        try(FileWriter writer = new FileWriter("E:\\JavaFXCode\\Store\\src\\com\\company\\base\\users.txt", false))
        {
            for (int i = 0; i < users.size(); i++){
                writer.write(users.get(i).toString());
            }
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    public void readerFileUsers(){
        ArrayList<Character> buffer = new ArrayList<>();
        StringBuilder login = new StringBuilder();
        StringBuilder password = new StringBuilder();
        try(FileReader reader = new FileReader("E:\\JavaFXCode\\Store\\src\\com\\company\\base\\users.txt"))
        {
            int c;
            while((c=reader.read())!=-1){

                //System.out.print((char)c);
                buffer.add((char)c);

            }
            //System.out.println(buffer);

        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        char sw = ' ';
        for(Character ch : buffer){
            if (ch == '$') {
                sw = ch;
                continue;
            }
            if (ch == '@') {
                sw = ch;
                continue;
            }
            if (ch == '>'){
                addUser(login.toString(), password.toString());
                login.delete(0, login.length());
                password.delete(0, password.length());
                continue;
            }
            switch (sw){
                case '$':
                    login.append(ch);
                    break;
                case '@':
                    password.append(ch);
                    break;
            }
        }
    }
}
