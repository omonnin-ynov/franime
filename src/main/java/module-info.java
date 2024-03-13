module com.example.franime {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens Franime to javafx.fxml;
    exports Franime;
    exports Franime.rating;
    opens Franime.rating to javafx.fxml;
    exports Franime.csv;
    opens Franime.csv to javafx.fxml;
    exports Franime.model;
    opens Franime.model to javafx.fxml;
    exports Franime.controller;
    opens Franime.controller to javafx.fxml;
}