module FinalWebScrape {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens Controllers to javafx.fxml;
    exports Controllers;
}