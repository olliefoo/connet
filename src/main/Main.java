package main;

import Model.Database;
import controller.WelcomeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;

public class Main extends Application {

    // Creates a single instance of the database classes
    public static Database database = new Database();
    //public static ReportDatabase reportDatabase = new ReportDatabase();
    private Stage mainStage;
    private Parent rootLayout;

    @Override
    public void start(Stage primaryStage) throws Exception{
        mainStage = primaryStage;
        showWelcomeScreen(mainStage);
    }

    public Stage getMainStage() {
        return mainStage;
    }
    private void showWelcomeScreen(Stage mainStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/WelcomeScreen.fxml"));
        rootLayout = loader.load();

        // Give the controller access to the main app.
        WelcomeController controller = loader.getController();
        //controller.setMainApp(this);

        mainStage.setTitle("Clean Water Crowdsourcing");
        // Show the scene containing the root layout.
        Scene scene = new Scene(rootLayout);
        mainStage.setScene(scene);
        mainStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}
