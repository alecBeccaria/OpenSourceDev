package Controllers;


import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

public class ScreenController {
    private static Stage stage;
    private static Scene scene;

    public static void changeScene(Event event, String strFXMLFileName) throws IOException {
        URL url = new URL("src\\main\\java\\" + strFXMLFileName);
    }

}
