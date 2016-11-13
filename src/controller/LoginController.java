package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Model.Database;
import Model.User;


import java.io.IOException;

/**
 * Created by cbbjs on 11/12/2016.
 */
public class LoginController {
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Button loginButton;
    @FXML
    private Button cancelButton;


    private boolean isInputValid() {
        String errorMessage = "";

        String username = usernameField.getText();
        String password = passwordField.getText();


        if (username == null || username.length() == 0
                || !Database.containsUsername(username)) {
            errorMessage += "Username does not exist. Please register first.\n";
        }
        if (password == null || password.length() == 0) {
                errorMessage += "Wrong password. Try again.\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message if bad data
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }

    @FXML
    private void handleLoginPressed() throws IOException {
        if (isInputValid()) {
            User user = Database.getUser(usernameField.getText());
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass()
                    .getResource("../view/MainAppScreen.fxml"));
            Stage stage = (Stage) loginButton.getScene().getWindow();
            Parent root = loader.load();
            loader.<MainAppController>getController().setUser(user);
            stage.setScene(new Scene(root));
            stage.show();
        }
    }
    @FXML
    private void handleCancelPressed() throws IOException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass()
                .getResource("../view/WelcomeScreen.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }
}
