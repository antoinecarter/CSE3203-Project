/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package nexus.task_mng.controllers;

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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author shanise
 */
public class HomeController implements Initializable {

    @FXML
    private BorderPane homepage;
    @FXML
    private BorderPane ap;

    
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    private void home(ActionEvent event) {
    }
    
    @FXML
    private void home(MouseEvent event) {
        homepage.setCenter(ap);
    }
    
    @FXML
    private void newProject(MouseEvent event) {
        loadPage("newProject");
    }
    @FXML
    private void updateProject(MouseEvent event) {
        loadPage("updateProject");
    }

    @FXML
    private void deleteProject(MouseEvent event) {
    }
    
    private void loadPage(String page){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
                    } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        homepage.setCenter(root);
    }
    
}
