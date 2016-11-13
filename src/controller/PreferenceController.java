package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import Model.User;


/**
 * Created by Owner on 11/12/2016.
 */
public class PreferenceController {

    @FXML
    ToggleButton p1;
    @FXML
    ToggleButton p2;
    @FXML
    ToggleButton p3;
    @FXML
    ToggleButton p4;
    @FXML
    ToggleButton p5;
    @FXML
    ToggleButton p6;
    @FXML
    ToggleButton p7;
    @FXML
    ToggleButton p8;
    @FXML
    ToggleButton p9;
    @FXML
    ToggleButton p10;
    @FXML
    ToggleButton p11;
    @FXML
    ToggleButton p12;
    @FXML
    Button okButton;

    User user;

    public void setUser(User user) {
        this.user = user;
    }

    @FXML
    private void submitPreferences() {
        if(p1.isSelected()) {
            user.getPreferences().add(1);
        }
        if(p2.isSelected()) {
            user.getPreferences().add(2);
        }
        if(p3.isSelected()) {
            user.getPreferences().add(3);
        }
        if(p4.isSelected()) {
            user.getPreferences().add(4);
        }
        if(p5.isSelected()) {
            user.getPreferences().add(5);
        }
        if(p6.isSelected()) {
            user.getPreferences().add(6);
        }
        if(p7.isSelected()) {
            user.getPreferences().add(8);
        }
        if(p9.isSelected()) {
            user.getPreferences().add(9);
        }
        if(p10.isSelected()) {
            user.getPreferences().add(10);
        }
        if(p11.isSelected()) {
            user.getPreferences().add(11);
        }
        if(p12.isSelected()) {
            user.getPreferences().add(12);
        }
    }


}
