import com.company.base.Base;
import com.company.basket.Basket;
import com.company.user.Admin;
import com.company.user.Client;
import com.company.user.User;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;

public class Main extends Application{
    Base base = new Base();

    public static void main(String[] args) {
        /*Base base = new Base();
        base.writeOutFileUsers();
        User admin = new Admin("admin", "admin");
        //User pavel = new Client("pavel", "pavel");
        base.addUser(admin);
        //base.addUser(pavel);
        //base.addUser("kolya", "kolyapassword");
        //base.writeInFileUsers();
        System.out.println(base);*/
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        //Base base = new Base();
        base.writeOutFileUsers();
        User admin = new Admin("admin", "admin");
        //User pavel = new Client("pavel", "pavel");
        base.addUser(admin);
        //base.addUser(pavel);
        //base.addUser("kolya", "kolyapassword");
        //base.writeInFileUsers();
        System.out.println(base);

        Button btn = new Button();
        Button btn1 = new Button();

        btn.setText("Log in");
        btn.setLayoutX(115.0);
        btn.setLayoutY(120.0);
        btn1.setText("Register");
        btn1.setLayoutX(205.0);
        btn1.setLayoutY(120.0);

        TextField login = new TextField("Login");
        TextField password = new TextField("Password");
        login.setLayoutX(115.0);
        login.setLayoutY(50.0);
        password.setLayoutX(115.0);
        password.setLayoutY(80.0);


        Label lbl = new Label();
        lbl.setLayoutX(10);
        lbl.setLayoutY(50);

        btn.setOnAction(e -> {lbl.setText(login.getText());});

        btn1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                Label secondLabel = new Label("I'm a Label on new Window");

                StackPane secondaryLayout = new StackPane();
                secondaryLayout.getChildren().add(secondLabel);

                Scene secondScene = new Scene(secondaryLayout, 230, 100);

                // New window (Stage)
                Stage newWindow = new Stage();
                newWindow.setTitle("Second Stage");
                newWindow.setScene(secondScene);

                // Specifies the modality for new window.
                newWindow.initModality(Modality.WINDOW_MODAL);

                // Specifies the owner Window (parent) for new window
                newWindow.initOwner(stage);

                // Set position of second window, related to primary window.
                newWindow.setX(stage.getX() + 200);
                newWindow.setY(stage.getY() + 100);

                newWindow.show();
            }
        });


        Group root = new Group(btn, btn1, login, password, lbl);
        Scene scene = new Scene(root);
        scene.setFill(Color.ALICEBLUE);
        stage.setScene(scene);

        stage.setTitle("Enter/Register");
        stage.setWidth(400);
        stage.setHeight(260);

        stage.show();
    }
    @Override
    public void stop() throws Exception {

        System.out.println("Application stops");
        System.out.println("DataBase save");
        base.writeInFileUsers();
        super.stop();
    }
}