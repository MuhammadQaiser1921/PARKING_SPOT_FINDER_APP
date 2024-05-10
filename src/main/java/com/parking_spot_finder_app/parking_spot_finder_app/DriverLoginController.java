package com.parking_spot_finder_app.parking_spot_finder_app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class DriverLoginController {
    @FXML
    private TextField usernameFieldPSFD;
    @FXML
    private PasswordField passwordFieldPSFD;
    @FXML
    private Label Error_Login_D;

    private Connection connection;

    public DriverLoginController() {
        this.connection = DATABASE_ORACLE.connection(); // Ensure you handle your database connection lifecycle properly.
    }

    public void switchToDashboard(ActionEvent event) {
        String email = usernameFieldPSFD.getText();
        String password = passwordFieldPSFD.getText();

        try {
            if (authenticate(email, password)) {
                loadDashboard(event);
            } else {
                Error_Login_D.setText("Invalid username or password.");
            }
        } catch (SQLException e) {
            Error_Login_D.setText("Database error.");
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean authenticate(String email, String password) throws SQLException {
        String query = "SELECT * FROM UserPSF WHERE Email = ? AND Password = ? And Profile_Status = 'Active'";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int userId = rs.getInt("UserID");
                String userName = rs.getString("Name_Driver");
                String userPhone = rs.getString("PhoneNumber");

                UserSession.createInstance(userId, userName, email, userPhone); // Create user session
                return true;
            }
            return false;
        }
    }
    private void loadDashboard(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Home_Driver.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToSignUp(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Driver_SignUp_Page.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
