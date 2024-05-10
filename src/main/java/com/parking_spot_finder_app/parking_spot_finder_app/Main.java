package com.parking_spot_finder_app.parking_spot_finder_app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        try {
/*
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Driver_Login.fxml")));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
            Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("pngwing.com.png")));
            stage.getIcons().add(icon);
           // root.setStyle("-fx-background-color: #d9d9d9");// Set background color for all scene

            stage.setTitle("Parking Spot Finder");
*/


            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Operator_Login.fxml")));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("pngwing.com.png")));
            stage.getIcons().add(icon);
            // root.setStyle("-fx-background-color: #d9d9d9");// Set background color for all scene

            stage.setTitle("Parking Spot Finder");


        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}