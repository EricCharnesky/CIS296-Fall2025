module com.example.javafxhelloworld {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.javafxhelloworld to javafx.fxml;
    exports com.example.javafxhelloworld;
}