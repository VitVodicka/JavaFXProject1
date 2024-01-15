module com.example.javafxproject1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;


    opens com.example.javafxproject1 to javafx.fxml;
    exports com.example.javafxproject1;
}