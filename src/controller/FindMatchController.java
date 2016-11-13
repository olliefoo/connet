package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import Model.User;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Owner on 11/12/2016.
 */
public class FindMatchController {

    @FXML
    private TextField conventionName;

    @FXML
    private Button returnButton;

    @FXML
    private TextField matchedUser;

    private User user;
    private int reportIndex = 1;

    public void setUser(User u) {
        user = u;
        conventionName.setText("Rocket Science");
        matchedUser.setText("Bryan Kim");
    }


    @FXML
    private void handleReturnClicked() throws IOException{
        Stage stage = (Stage) returnButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass()
                .getResource("../view/MainAppScreen.fxml"));
        Parent root = loader.load();
        loader.<MainAppController>getController().setUser(user);
        stage.setScene(new Scene(root));
        stage.show();
    }


}
