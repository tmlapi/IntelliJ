module Main {
    requires javafx.controls;
    requires javafx.fxml;

    exports Controllers;
    opens model to javafx.base;


    opens Controllers to javafx.fxml;
    exports Main;
}