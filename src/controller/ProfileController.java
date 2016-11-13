package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by cbbjs on 11/12/2016.
 */
public class ProfileController {
    @FXML
    private Button confirmButton;
    @FXML
    private Button cancelButton;

    @FXML
    private ImageView profilePic;


    @FXML
    private void handleConfirmPressed() throws IOException {
        if (isInputValid()) {
            Stage stage = (Stage) confirmButton.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass()
                    .getResource("../view/MainAppScreen.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        }
    }
    @FXML
    private void handleCancelPressed() throws IOException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass()
                .getResource("../view/MainAppScreen.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

}
