module com.example.propertyassessment {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.base;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.swing;
    requires javafx.web;
    requires javafx.swt;


    opens com.example.propertyassessment to javafx.fxml;
    exports com.example.propertyassessment;
}