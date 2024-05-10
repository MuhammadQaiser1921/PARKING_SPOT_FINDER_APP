package com.parking_spot_finder_app.parking_spot_finder_app;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class OperatorProfileController {
    @FXML private TextField operatorIdField, nameField, lotIdField, lotNameField, emailField, phoneNumberField, addressField, capacityField, hourlyRateField;
    @FXML private Button logoutButton, backButton;

    private final Connection connection = DATABASE_ORACLE.connection(); // Assumed DBConnect class handles database connections

    public OperatorProfileController() {
        // Constructor might be empty if connection handling is done elsewhere
    }

    @FXML
    private void initialize() {
        loadOperatorDetails();
    }

    private void loadOperatorDetails() {
        // Suppose the operator ID is obtained from a login session management class
        int operatorId = OperatorSession.getInstance().getOperatorId(); // This would depend on your session management implementation

        String sql = "SELECT op.OperatorID, op.Name, pl.LotID, pl.LotName, op.Email, op.PhoneNumber, pl.Address, pl.Capacity, pl.HourlyRate " +
                "FROM OperatorPSF op JOIN ParkingLotPSF pl ON op.OperatorID = pl.OperatorID WHERE op.OperatorID = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, operatorId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                operatorIdField.setText(String.valueOf(rs.getInt("OperatorID")));
                nameField.setText(rs.getString("Name"));
                lotIdField.setText(String.valueOf(rs.getInt("LotID")));
                lotNameField.setText(rs.getString("LotName"));
                emailField.setText(rs.getString("Email"));
                phoneNumberField.setText(rs.getString("PhoneNumber"));
                addressField.setText(rs.getString("Address"));
                capacityField.setText(String.valueOf(rs.getInt("Capacity")));
                hourlyRateField.setText(String.format("%.2f", rs.getDouble("HourlyRate")));
            } else {
                System.out.println("No data found for this operator.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error retrieving operator details: " + e.getMessage());
        }
    }

    @FXML
    private void handleLogout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void handleBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Dashboard.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
