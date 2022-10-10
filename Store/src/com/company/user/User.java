package com.company.user;

import com.company.basket.Basket;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class User {
    public User(String login, String password) {
        this.login = login;
        this.password = password;

    }

    @Override
    public String toString() {
        return '$' + login + '@'+ password +'>';
    }

    public void userWindow(Stage stage){
        Text text = new Text("You are login as "+login);
        text.setLayoutX(50);
        text.setLayoutY(50);
        Group group = new Group(text);
        Scene scene = new Scene(group, 720, 500, Color.LIGHTGRAY);
        Stage newWindow = new Stage();
        newWindow.setScene(scene);
        newWindow.setTitle("User window");
        newWindow.initModality(Modality.WINDOW_MODAL);
        newWindow.initOwner(stage);
        newWindow.show();
    }

    private String login;
    private String password;
    private Basket basket;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }
}
