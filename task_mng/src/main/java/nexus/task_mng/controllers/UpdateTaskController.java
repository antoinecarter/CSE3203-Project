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
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import nexus.task_mng.App;
import nexus.task_mng.DAOs.project_dtlModel;
import nexus.task_mng.DAOs.project_hdModel;
import nexus.task_mng.DAOs.usersmodel;
import nexus.task_mng.DTOs.project_dtlDTO;
import nexus.task_mng.DTOs.project_hdDTO;
import nexus.task_mng.DTOs.usersDTO;
import org.sql2o.Sql2oException;

/**
 * FXML Controller class
 *
 * @author shanise
 */
public class UpdateTaskController implements Initializable {
    
    @FXML
    private Button closeButton;

    @FXML
    private Button deleteButton;

    @FXML
    private MFXDatePicker end_date;

    @FXML
    private MFXTextField id;

    @FXML
    private Label notif;

    @FXML
    private ChoiceBox<String> project_id;

    @FXML
    private MFXDatePicker start_date;

    @FXML
    private ChoiceBox<String> status;

    @FXML
    private MFXTextField task;

    @FXML
    private ChoiceBox<String> user_id;

    @FXML
    void deleteTask(MouseEvent event) {
           Integer t_id = Integer.parseInt(this.id.getText());
          try {
            project_dtlModel.deleteProjectDTL(t_id);
            Stage stage = (Stage) deleteButton.getScene().getWindow();
            stage.close();
            App.setRoot("home");
        } catch (IOException ex) {
            Logger.getLogger(UpdateTaskController.class.getName()).log(Level.SEVERE, null, ex);
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
    void updateTask(MouseEvent event) {
        Integer t_id = Integer.parseInt(this.id.getText());
        
        String t_proj_id = this.project_id.getValue();
        project_hdModel proj = new project_hdModel();
        List<project_hdDTO> p_list = proj.viewProject2(t_proj_id);
        Integer p_id = p_list.get(0).get_id();
        
        String t_u_id = this.user_id.getValue();
        usersmodel user = new usersmodel();
        List<usersDTO> u_list = user.viewUser2(t_u_id);
        Integer u_id = u_list.get(0).get_id();
        
        String task_desc = this.task.getText();
        LocalDate t_start_date = this.start_date.getValue();
        LocalDate t_end_date = this.end_date.getValue();
        String t_status = this.status.getValue();
        try{
            project_dtlModel.updateProjectDTL(t_id, p_id, u_id, task_desc, t_start_date, t_end_date, t_status);
            notif.setText("Task Info Updated!");
        }catch(Sql2oException e){
            notif.setText(e.getMessage());
        }

    }   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        projectListing();
        userListing();
    }   
    
    public void setScene(Integer t_id, String proj_id, String u_id, String task_desc, String t_start_date, String t_end_date, String t_status){
        id.setText(t_id.toString());
        project_id.setValue(proj_id);
        project_id.setItems(projectList);
        user_id.setValue(u_id);
        user_id.setItems(userList);
        task.setText(task_desc);
        start_date.setValue(LocalDate.parse(t_start_date));
        end_date.setValue(LocalDate.parse(t_end_date));
        status.setValue(t_status);
        status.setItems(statusList);
        
    }
    ObservableList<String> statusList = FXCollections.observableArrayList("Ignored", "In Progress", "Completed");

    ObservableList<String> userList = FXCollections.observableArrayList();
    ObservableList<String> projectList = FXCollections.observableArrayList();
    public void  userListing(){
        usersmodel users  = new usersmodel();
        List<usersDTO> u_list = users.viewUsers();
        for(int i=0; i<u_list.size(); i++){
            userList.add(u_list.get(i).getFirst_name()+" "+u_list.get(i).getSurname());
        }
    }
    
    public void  projectListing(){
        project_hdModel projects  = new project_hdModel();
        List<project_hdDTO> p_list = projects.viewProjects();
        for(int i=0; i<p_list.size(); i++){
            projectList.add(p_list.get(i).getTitle());
        }
    }
    

    
}
