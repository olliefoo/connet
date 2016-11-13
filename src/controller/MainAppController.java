package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by cbbjs on 11/12/2016.
 */
public class MainAppController {
    @FXML
    private ListView listView;
    @FXML
    private Button profileButton;
    @FXML
    private Button selectButton;
    @FXML
    private Button logoutButton;
    @FXML
    private void handleSelectPressed() throws IOException {
        //if (isInputValid()) {
            Stage stage = (Stage) selectButton.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass()
                    .getResource("../view/MatchedScreen.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        //}
    }
    @FXML
    private void handleLogOutPressed() throws IOException {
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass()
                .getResource("../view/LoginScreen.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    private void handleProfilePressed() throws IOException {
        Stage stage = (Stage) profileButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass()
                .getResource("../view/ProfileScreen.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }
}
