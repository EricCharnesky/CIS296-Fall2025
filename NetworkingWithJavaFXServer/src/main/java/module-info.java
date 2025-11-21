module com.example.javafxhelloworld {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxhelloworld to javafx.fxml;
    exports com.example.javafxhelloworld;
}