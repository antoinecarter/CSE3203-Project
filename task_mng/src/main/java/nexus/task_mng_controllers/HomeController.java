/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package nexus.task_mng_controllers;

import nexus.task_mng.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author shanise
 */
public class HomeController implements Initializable {

    @FXML
    private BorderPane ap;
    @FXML
    private BorderPane bp;
    @FXML
    private Tab manageProject;
    @FXML
    private Tab task;
    @FXML
    private AnchorPane rootPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    void newProject(MouseEvent event) throws IOException {
        App.setRoot("newProject");
    }


    @FXML
    private void updateProject(MouseEvent event) throws IOException {
        App.setRoot("updateProject");
    }

    @FXML
    private void deleteProject(MouseEvent event) {
    }

    @FXML
    private void task(MouseEvent event) throws IOException {
        App.setRoot("task");
    }

    @FXML
    private void newTask(MouseEvent event) throws IOException {
        App.setRoot("newTask");
    }

    @FXML
    private void progressChart(MouseEvent event) throws IOException {
        App.setRoot("progressChart");
    }
    
    
}
