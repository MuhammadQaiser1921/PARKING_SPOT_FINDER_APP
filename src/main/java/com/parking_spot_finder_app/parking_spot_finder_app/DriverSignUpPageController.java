package com.parking_spot_finder_app.parking_spot_finder_app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DriverSignUpPageController {
    @FXML
    private TextField EMAIL_SIGNUP,PASSWORD_SIGNUP,PHONE_SIGNUP,Name_SIGNUP;
    @FXML
    private Label SignUpLabel;
    String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    String phoneRegex = "^[0-9 ()+-]{1,20}$";
    String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()]).{8,}$";
    Pattern emailPattern = Pattern.compile(emailRegex);
    Pattern phonePattern = Pattern.compile(phoneRegex);
    Pattern passwordPattern = Pattern.compile(passwordRegex);
    public void CreateAccount(ActionEvent event) throws IOException, SQLException {
        if(!emailPattern.matcher(EMAIL_SIGNUP.getText()).matches()){
            SignUpLabel.setTextFill(Color.RED);
            SignUpLabel.setText("Invalid Phone Number");
            return;
        }
        if(!phonePattern.matcher(PHONE_SIGNUP.getText()).matches()){
            SignUpLabel.setTextFill(Color.RED);
            SignUpLabel.setText("Invalid Phone Number");
            return;
        }
        if(!passwordPattern.matcher(PASSWORD_SIGNUP.getText()).matches()){
            SignUpLabel.setTextFill(Color.RED);
            SignUpLabel.setText("Invalid Password");
            return;
        }
        if(EMAIL_SIGNUP.getText().isEmpty() || PASSWORD_SIGNUP.getText().isEmpty() || PHONE_SIGNUP.getText().isEmpty() || Name_SIGNUP.getText().isEmpty()){
            SignUpLabel.setTextFill(Color.RED);
            SignUpLabel.setText("Please fill all the fields");
            return;
        }
        Connection connection = DATABASE_ORACLE.connection();
        String query = "INSERT INTO UserPSF (Name_Driver, Email, PhoneNumber, Password, Profile_Status ) VALUES (?, ?, ?, ?, ?)";
        java.sql.PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, Name_SIGNUP.getText());
        statement.setString(2, EMAIL_SIGNUP.getText());
        statement.setString(3, PHONE_SIGNUP.getText());
        statement.setString(4, PASSWORD_SIGNUP.getText());
        statement.setString(5, "Active");
        int rowsInserted = statement.executeUpdate();
        if(rowsInserted > 0){
            SignUpLabel.setTextFill(Color.GREEN);
            SignUpLabel.setText("Account Created Successfully");
        }
        else{
            SignUpLabel.setTextFill(Color.RED);
            SignUpLabel.setText("Account Creation Failed");
        }
    }
    public void switchToLoginPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Driver_Login.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
