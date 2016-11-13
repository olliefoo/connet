package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import main.User;

import java.io.File;
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

    User user;

    public void setUser(User u) {
        user = u;
    }

    @FXML
    private void handleConfirmPressed() throws IOException {
        //if (isInputValid()) {
            Stage stage = (Stage) confirmButton.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass()
                    .getResource("../view/MainAppScreen.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        //}
    }
    @FXML
    private void handleCancelPressed() throws IOException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass()
                .getResource("../view/MainAppScreen.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    private void handleUploadPressed() throws IOException {
        FileChooser fc = new FileChooser();
        File selectedPic = fc.showOpenDialog(null);
        String path = "";
        if (selectedPic != null) {
            path += selectedPic.getAbsolutePath();
        } else {
            System.out.println("File is not valid");
        }
        profilePic = new ImageView(new Image(getClass().getResourceAsStream(path), 200, 150, true ,true));
        user.getProfile().setProfilePic(profilePic.getImage());
    }
}
