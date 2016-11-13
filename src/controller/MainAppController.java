package controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;
import Model.Conventions;
import Model.User;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by cbbjs on 11/12/2016.
 */
public class MainAppController {
    private User user;
    @FXML
    private Button profileButton;
    @FXML
    private Button selectButton;
    @FXML
    private Button logoutButton;

    @FXML
    TableView table;

    @FXML
    TableColumn numberCol;

    @FXML
    TableColumn locationCol;

    @FXML
    TableColumn DateCol;

    @FXML
    TableColumn timeCol;
    @FXML
    TableColumn TopicCol;

    private int reportIndex;

    private ArrayList<Conventions> ConventionList;

    public void setUser(User u) {
        user = u;
    }
    @FXML
    private void initialize() {
        Conventions conv1 = new Conventions();
        Conventions conv2 = new Conventions();
        Conventions conv3 = new Conventions();
        conv1.setNum(1);
        conv2.setNum(2);
        conv3.setNum(3);
        conv1.setTopics("Rocket Science");
        conv2.setTopics("Football Strategies");
        conv3.setTopics("Intro to Medicines");
        conv1.setDate("11/13/2016");
        conv2.setDate("11/13/2016");
        conv3.setDate("11/13/2016");
        conv3.setTime("9:30 A.M.");
        conv3.setTime("2:20 P.M.");
        conv3.setTime("1:40 P.M.");
        conv1.setLocation("Klaus");
        conv2.setLocation("Mason Building");
        conv3.setLocation("College of Computing");
        ObservableList<Conventions> list
                = FXCollections.observableArrayList();
        list.add(conv1);
        list.add(conv2);
        list.add(conv3);
        numberCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Conventions, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Conventions, String> r) {
                return new SimpleStringProperty(Integer.toString(r.getValue().getNumber()));
            }
        });
        TopicCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Conventions, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Conventions, String> r) {
                return new SimpleStringProperty(r.getValue().getTopics());
            }
        });
        locationCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Conventions, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Conventions, String> r) {
                return new SimpleStringProperty(r.getValue().getLocation());
            }
        });

        DateCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Conventions, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Conventions, String> r) {
                return new SimpleStringProperty(r.getValue().getDate());
            }
        });

        timeCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Conventions, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Conventions, String> r) {
                return new SimpleStringProperty(r.getValue().getTime());
            }
        });
        table.setItems(list);

    }
    public boolean isProfileCreated() {
        return (user.getProfile().getFirstname() != null &&
                user.getProfile().getLastname() != null);
    }

    public boolean isIndexValid() {
        return(reportIndex > 0);
    }
    @FXML
    private void handleSelectPressed() throws IOException {
        if (isProfileCreated()) {
            reportIndex = table.getSelectionModel().getSelectedIndex() + 1;
            System.out.println(reportIndex);
            if (isIndexValid()) {
                FXMLLoader loader = new FXMLLoader(getClass()
                        .getResource("../view/MatchedScreen.fxml"));
                Stage stage = (Stage) selectButton.getScene().getWindow();

                Parent root = loader.load();
                stage.setScene(new Scene(root));
                stage.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Wrong Convention");
                alert.setHeaderText("Please choose correct convention");
                alert.setContentText("You have not selected a convention.");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Access Denied");
            alert.setHeaderText("Please Edit Profile");
            alert.setContentText("Please edit your profile first to proceed.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleLogOutPressed() throws IOException {
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass()
                .getResource("../view/LoginScreen.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    private void handleProfilePressed() throws IOException {
        Stage stage = (Stage) profileButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass()
                .getResource("../view/ProfileScreen.fxml"));
        Parent root = loader.load();
        loader.<ProfileController>getController().setUser(user);
        stage.setScene(new Scene(root));
        stage.show();
    }
}
