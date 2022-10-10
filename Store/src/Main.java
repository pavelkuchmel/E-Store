import com.company.base.Base;
import com.company.categories.Categories;
import com.company.product.Product;
import com.company.user.User;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.text.Text;

public class Main extends Application{

    Base base = new Base();

    /*static Categories c1 = new Categories("Eat");
    static Categories c2 = new Categories("Fruits");
    static Categories c3 = new Categories("Vegetables");
    static Product p1 = new Product("Meat", 10.0, 5);
    static Product p2 = new Product("Soup", 15.5, 4);
    static Product p3 = new Product("HotDog", 28.2,2);
    static Product p4 = new Product("Apple", 5.2, 4);
    static Product p5 = new Product("Watermelon", 22.0,5);
    static Product p6 = new Product("Cucumber", 7.0, 5);
    static Product p7 = new Product("Potato", 2.5, 3);*/

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        /*c1.addProduct(p1);
        c1.addProduct(p2);
        c1.addProduct(p3);
        c2.addProduct(p4);
        c2.addProduct(p5);
        c3.addProduct(p6);
        c3.addProduct(p7);
        base.addCategories(c1);
        base.addCategories(c2);
        base.addCategories(c3);*/

        base.readerFileCategories();
        base.readerFileUsers();
        TextField login = new TextField("Login");
        TextField password = new TextField("Password");
        login.setLayoutX(115.0);
        login.setLayoutY(50.0);
        password.setLayoutX(115.0);
        password.setLayoutY(80.0);

        Button btnLogin = new Button();
        Button btnRegister = new Button();
        btnLogin.setText("Log in");
        btnLogin.setLayoutX(115.0);
        btnLogin.setLayoutY(120.0);
        btnLogin.setMinWidth(60);
        btnRegister.setText("Register");
        btnRegister.setLayoutX(205.0);
        btnRegister.setLayoutY(120.0);
        btnRegister.setMinWidth(60);
        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (login.getText().equals("admin")){
                    if (password.getText().equals("admin")){
                        Text textNewWindow = new Text("You are login as administrator");
                        textNewWindow.setLayoutX(30);
                        textNewWindow.setLayoutY(30);
                        Group groupNewWindow = new Group(textNewWindow);
                        Scene sceneNewWindow = new Scene(groupNewWindow,720, 500, Color.LIGHTGRAY);
                        Stage newWindow = new Stage();
                        newWindow.centerOnScreen();
                        newWindow.setScene(sceneNewWindow);
                        newWindow.setTitle("Administrator");
                        newWindow.initModality(Modality.WINDOW_MODAL);
                        newWindow.initOwner(stage);
                        newWindow.show();

                    }
                    else {
                        windowInfo(stage, "Invalid password");
                    }
                }
                else {
                    if (!base.checkUserLogin(login.getText())){
                        if (base.checkUserPassword(login.getText(), password.getText())){
                            base.getUser(base.indexLogin(login.getText())).userWindow(stage);
                        }
                        else {
                            windowInfo(stage, "Invalid password");
                        }
                    }
                    else {
                        windowInfo(stage, "Invalid login");
                    }
                }
            }
        });
        btnRegister.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(base.checkUserLogin(login.getText())) {
                    User user = new User(login.getText(), password.getText());
                    base.addUser(user);
                    windowInfo(stage, "Account registered");
                }
                else windowInfo(stage, "This login is occupied");
            }
        });
        password.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                btnLogin.fire();
            }
        });

        Group buttons = new Group(btnLogin, btnRegister);
        Group textfields = new Group(login, password);
        Group group = new Group(textfields, buttons);

        Scene scene = new Scene(group);
        scene.setFill(Color.LIGHTGRAY);
        stage.setScene(scene);
        stage.setTitle("E-Store. Authorization");
        stage.setWidth(400);
        stage.setHeight(250);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        base.writeFileUsers();
        base.writeFileCategories();
        super.stop();
    }

    public static void windowInfo(Stage stage, String textInfo){
        Text text = new Text(textInfo);
        text.setFont(new Font(14));
        StackPane.setAlignment(text, Pos.TOP_CENTER);
        StackPane.setMargin(text, new Insets(30, 0, 0, 0));
        Button btnOk = new Button("Ok");
        StackPane.setAlignment(btnOk, Pos.BOTTOM_CENTER);
        StackPane.setMargin(btnOk,new Insets(0, 0, 20, 0));
        StackPane group = new StackPane(text, btnOk);
        Scene scene = new Scene(group, 250, 110, Color.LIGHTGRAY);
        Stage newWindow = new Stage();
        btnOk.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                newWindow.close();
            }
        });
        newWindow.setScene(scene);
        newWindow.setTitle("Error");
        newWindow.initModality(Modality.WINDOW_MODAL);
        newWindow.initOwner(stage);
        newWindow.show();
    }
    /*public static void userWindow(Stage stage){
        Text text = new Text("You are login as user");
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
    }*/
}