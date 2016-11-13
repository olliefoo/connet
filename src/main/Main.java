package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage mainStage;
    private Parent rootLayout;

    @Override
    public void start(Stage primaryStage) throws Exception{
        mainStage = primaryStage;
        showWelcomeScreen(mainStage);
    }

    private void showWelcomeScreen(Stage mainStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/LoginScreen.fxml"));
        rootLayout = loader.load();
        Scene scene = new Scene(rootLayout);
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
