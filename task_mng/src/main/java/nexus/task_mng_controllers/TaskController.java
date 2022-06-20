/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package nexus.task_mng_controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import nexus.task_mng.App;

/**
 * FXML Controller class
 *
 * @author shanise
 */
public class TaskController implements Initializable {

    @FXML
    private BorderPane homepage;
    @FXML
    private BorderPane ap;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void newProject(MouseEvent event) {
    }

    @FXML
    private void home(MouseEvent event) {
    }

    @FXML
    private void home(ActionEvent event) {
    }

    @FXML
    private void updateProject(MouseEvent event) {
    }

    @FXML
    private void deleteProject(MouseEvent event) {
    }

    @FXML
    private void updateTask(MouseEvent event) throws IOException {
        App.setRoot("updateTask");
    }
    
}
