/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package nexus.task_mng.controllers;

import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import nexus.task_mng.App;
import nexus.task_mng.DAOs.project_dtlModel;
import nexus.task_mng.DAOs.project_hdModel;
import org.sql2o.Sql2oException;

/**
 * FXML Controller class
 *
 * @author shanise
 */
public class UpdateProjectController implements Initializable {
    
    @FXML
    private Button closeButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TextArea description;

    @FXML
    private MFXDatePicker end_date;

    @FXML
    private MFXTextField id;

    @FXML
    private Label notif;

    @FXML
    private MFXDatePicker start_date;

    @FXML
    private ChoiceBox<String> status;

    @FXML
    private MFXTextField title;

    @FXML
    void deleteProject(MouseEvent event) {
        Integer t_id = Integer.parseInt(this.id.getText());
          try {
            project_hdModel.deleteProject(t_id);
            Stage stage = (Stage) deleteButton.getScene().getWindow();
            stage.close();
            App.setRoot("home");
        } catch (IOException ex) {
            Logger.getLogger(UpdateProjectController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void returnHome(MouseEvent event) {
        try {
            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
            App.setRoot("home");
        } catch (IOException ex) {
            Logger.getLogger(UpdateTaskController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void updateProject(MouseEvent event) {
        Integer p_id = Integer.parseInt(this.id.getText());
        String p_title = this.title.getText();
        String p_desc = this.description.getText();
        LocalDate p_start = this.start_date.getValue();
        LocalDate p_end = this.end_date.getValue();
        String p_status = this.status.getValue();
        try{
            project_hdModel.updateProject(p_id, p_title, p_desc, p_start, p_end, p_status);
        notif.setText("Project Info Updated!");
        }catch(Sql2oException e){
            notif.setText(e.getMessage());
        }
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    ObservableList<String> statusList = FXCollections.observableArrayList("Ignored", "In Progress", "Completed");
    
    public void setScene(Integer p_id, String p_title, String p_desc, String p_start, String p_end, String p_status){
        id.setText(p_id.toString());
        title.setText(p_title);
        description.setText(p_desc);
        start_date.setValue(LocalDate.parse(p_start));
        end_date.setValue(LocalDate.parse(p_end));
        status.setValue(p_status);
        status.setItems(statusList);
    }

    
}
