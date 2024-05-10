module com.parking_spot_finder_app.parking_spot_finder_app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.parking_spot_finder_app.parking_spot_finder_app to javafx.fxml;
    exports com.parking_spot_finder_app.parking_spot_finder_app;
}