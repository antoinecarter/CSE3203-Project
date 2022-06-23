package nexus.task_mng;

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */

/*
Author: Onur Baskirt
Date: September 29, 2021
Source: https://www.swtestacademy.com/database-operations-javafx/
*/

/*
Author: Sajawal Ayaz
Date: Aug 4, 2017
Source: https://www.youtube.com/watch?v=SGZUQvuqL5Q

*/

/*
Author: javacodingcommunity
Date: May 24, 2021
Project: Connect JavaFX to PostgreSQL database
Source: https://github.com/javacodingcommunity/javafxandpostgresql

*/
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("home"), 822, 519);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}