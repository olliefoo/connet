package controller;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import Model.Database;
import Model.Profile;
import Model.User;

import java.io.File;
import java.io.IOException;

public class ProfileController {

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField streetField;

    @FXML
    private TextField stateField;

    @FXML
    private TextField cityField;

    @FXML
    private TextField zipField;

    @FXML
    private Button confirmButton;

    @FXML
    private ComboBox<String> dayField;

    @FXML
    private ComboBox<String> yearField;

    @FXML
    private ComboBox<String> monthField;

    @FXML
    private RadioButton maleRadioButton;

    @FXML
    private RadioButton femaleRadioButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button uploadButton;
    @FXML
    private ImageView profilePic;

    private Stage dialogStage;

    private final ToggleGroup group = new ToggleGroup();

    private User user;
    private Profile profile;

    /**
     * Sets the current user in the controller
     * @param u
     */
    public void setUser(User u) {
        user = u;
        profile = user.getProfile();
        setup();
    }

    /**
     * Fill in the textboxes/comboboxes with the previous stored Profile values
     *
     */
    private void setup() {
        maleRadioButton.setToggleGroup(group);
        femaleRadioButton.setToggleGroup(group);
        if (profile.getGender()) {
            femaleRadioButton.setSelected(true);
        } else {
            maleRadioButton.setSelected(true);
        }

        firstNameField.setText(profile.getFirstname());
        lastNameField.setText(profile.getLastname());
        emailField.setText(profile.getEmail());
        phoneField.setText(profile.getPhone());
        streetField.setText(profile.getStreet());
        cityField.setText(profile.getCity());
        stateField.setText(profile.getState());
        zipField.setText(profile.getZip());
        monthField.setValue(profile.getMonth());
        dayField.setValue(profile.getDay());
        yearField.setValue(profile.getYear());

        monthField.getItems().addAll(
                "January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"
        );

        dayField.getItems().addAll(
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
                "13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
                "23", "24", "25", "26", "27", "28", "29", "30", "31"
        );

        yearField.getItems().addAll(
                "2016", "2015", "2014", "2013", "2012", "2011", "2010",
                "2009", "2008", "2007", "2006", "2005", "2004", "2003",
                "2002", "2001", "2000", "1999", "1998", "1997", "1996",
                "1995", "1994", "1993", "1992", "1991", "1990", "1989",
                "1988", "1987", "1986", "1985", "1984", "1983", "1982",
                "1981", "1980", "1979", "1978", "1976", "1975", "1974",
                "1973", "1972", "1971", "1970", "1969", "1968", "1967",
                "1966", "1965", "1964", "1963", "1962", "1961", "1960",
                "1959", "1958", "1957", "1956", "1955", "1954", "1953",
                "1952", "1951", "1950"
        );
    }

    /**
     * Sets the user's attributes using the inputs from the various fields.
     *
     */
    private void setValues() {
        //set variables of user to input values
        String fName = firstNameField.getText();
        String lName = lastNameField.getText();
        String mail = emailField.getText();
        String pNumber = phoneField.getText();
        String street = streetField.getText();
        String city = cityField.getText();
        String state = stateField.getText();
        String zip = zipField.getText();
        String month = monthField.getValue();
        String day = dayField.getValue();
        String year = yearField.getValue();
        boolean gender;
        if (femaleRadioButton.isSelected()) {
            gender = true;
        } else {
            gender = false;
        }

        profile.setName(fName,lName);
        profile.setPhone(pNumber);
        profile.setAddress(street, city, state, zip);
        profile.setEmail(mail);
        profile.setMonth(month);
        profile.setDay(day);
        profile.setYear(year);
        profile.setGender(gender);
    }

    /**
     * Handles the Update button press. When pressed, the inputs will be saved
     * to the user and the user will be lead back to the AppStartScreen.
     *
     * @throws IOException
     */
    @FXML
    private void handleUpdatePressed() throws IOException {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();

        if (firstName == null || firstName.length() == 0 ||
                lastName == null || lastName.length() == 0) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Missing Fields");
            alert.setHeaderText("Please enter required fields");
            alert.setContentText("Please enter both your first name and last " +
                    "name to continue.");

            alert.showAndWait();
        } else {
            setValues();
            Database.saveAll();
            FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("../view/MainAppScreen.fxml"));
            Stage stage = (Stage) confirmButton.getScene().getWindow();
            Parent root = loader.load();
            loader.<MainAppController>getController().setUser(user);
            stage.setScene(new Scene(root));
            stage.show();
        }
    }

    @FXML
    private void handleCancelPressed() throws IOException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass()
                .getResource("../view/MainAppScreen.fxml"));
        Parent root = loader.load();
        loader.<MainAppController>getController().setUser(user);
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void handleUploadPressed() throws IOException {
        FileChooser fc = new FileChooser();
        File files = fc.showOpenDialog(null);
        if (files != null) {
            Image image = new Image(files.toURI().toString(), 200, 130, true, true);
            profilePic.setImage(image);
        }
    }

}