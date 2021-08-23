module UserEditor {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;

    opens Controllers to javafx.fxml, javafx.graphics;
    exports Controllers;

}