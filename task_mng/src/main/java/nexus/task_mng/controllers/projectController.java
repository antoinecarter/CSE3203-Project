package nexus.task_mng.controllers;

import io.github.palexdev.materialfx.controls.MFXButton;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import nexus.task_mng.App;
import nexus.task_mng.DAOs.project_hdModel;
import nexus.task_mng.DTOs.project_hdDTO;

public class projectController {

    @FXML
    public Label p_name;

    @FXML
    public Label p_status;
    
    @FXML
    public MFXButton proj;
    
    
    @FXML
    public Integer p_id;
    
    
    @FXML
    public void setID_Name(MouseEvent event){
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../home.fxml"));
            Parent root = (Parent) loader.load();
            HomeController h_ctrl = loader.getController();
            h_ctrl.setid_name(proj.getText(), p_name.getText());
        } catch (IOException ex) {
            Logger.getLogger(projectController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
    
    public void setP_name(String pj_name, String pj_status, Integer pj_id){
        p_name.setText(pj_name);
        p_status.setText(pj_status);
        p_id = pj_id;
    }
    
    
    @FXML
    void updateProject(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../updateProject.fxml"));
            Parent root = (Parent) loader.load();
            UpdateProjectController up_ctrl = loader.getController();
            project_hdModel project = new project_hdModel();
            List<project_hdDTO> p_list = project.viewProject(p_id);
            up_ctrl.setScene(p_list.get(0).get_id(),p_list.get(0).getTitle(),p_list.get(0).getDescription(), p_list.get(0).getStart_date(),p_list.get(0).getEnd_date(), p_list.get(0).getStatus());
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(projectController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
