package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color; //add this when merging files


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable{

    @FXML private TextField username;
    @FXML private PasswordField password;

    public void initialize(URL url, ResourceBundle rb){

    }

    public void loginButtonClicked(ActionEvent event) throws IOException {
        String user = username.getText();
        String pass = password.getText();


        if(user.equals("Lift") && pass.equals("Tracker")){
            System.out.println("You have logged in successfully");

            Parent mainWindowParent = FXMLLoader.load(getClass().getResource("home.fxml"));
            Scene mainWindowScene = new Scene(mainWindowParent);

            Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            window.setScene(mainWindowScene);
            window.show();
        }

        else{
            System.out.println("Login unsuccessful");
        }
    }


}
