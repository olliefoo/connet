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
public class RegisterController {
    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField confirmField;

    @FXML
    private TextField emailField;

    @FXML
    private Button registerButton;

    @FXML
    private Button cancelButton;


    private boolean isInputValid() {
        String errorMessage = "";
        if (usernameField.getText() == null
                || usernameField.getText().length() == 0) {
            errorMessage += "Username cannot be blank\n";
        } else if (passwordField.getText() == null
                || passwordField.getText().length() == 0) {
            errorMessage += "Password cannot be blank\n";
        } else if (emailField.getText() == null
                || emailField.getText().length() == 0) {
            errorMessage += "Email cannot be blank\n";
        } else if (!(confirmField.getText()
                .equals(confirmField.getText()))) {
            errorMessage += "Verification must match the original password\n";
        } else if (Database.containsEmail(emailField.getText())) {
            errorMessage += "Email is already being used\n";
        } else if (Database.containsUsername(usernameField.getText())) {
            errorMessage += "Username is already being used\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message if bad data
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please Correct Invalid Fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

    @FXML
    private void handleRegistrationPressed() throws IOException {
        if (isInputValid()) {
            Database.add(new User(usernameField.getText(),
                    passwordField.getText(), emailField.getText()));
            Database.addEmail(emailField.getText());
            Database.addUsername(usernameField.getText());
            Database.saveAll();
            Stage stage = (Stage) registerButton.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass()
                    .getResource("../view/WelcomeScreen.fxml"));
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
