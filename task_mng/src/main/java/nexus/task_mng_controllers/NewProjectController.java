/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package nexus.task_mng_controllers;


import nexus.task_mng.DAOs.project_hdModel;
import nexus.task_mng.DTOs.project_hdDTO;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author shanise
 */
public class NewProjectController implements Initializable {
    
    ObservableList<String> statusList = FXCollections.observableArrayList("Ignored", "In Progress", "Completed");
    
    @FXML
    private TextArea description;


    @FXML
    private MFXDatePicker end_date;

    @FXML
    private MFXDatePicker start_date;


    @FXML
    private MFXTextField title;
    
    @FXML
    private ChoiceBox<String> status;
    

    @FXML
    void createProject(MouseEvent event) {
        String project_title = this.title.getText();
        String project_desc = this.description.getText();
        LocalDate projectStartDate = this.start_date.getValue();
        LocalDate projectEndDate = this.end_date.getValue();
        String projectStatus = this.status.getValue();
        project_hdModel.insertProject(project_title, project_desc, projectStartDate, projectEndDate, projectStatus);
    }
    
    

    @FXML
    void returnHome(MouseEvent event) {

    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        status.setValue("Ignored");
        status.setItems(statusList);
    } 
      


    
}
