package nexus.task_mng.controllers;

import io.github.palexdev.materialfx.controls.MFXButton;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import nexus.task_mng.DAOs.project_dtlModel;
import nexus.task_mng.DAOs.project_hdModel;
import nexus.task_mng.DAOs.usersmodel;
import nexus.task_mng.DTOs.project_dtlDTO;
import nexus.task_mng.DTOs.project_hdDTO;
import nexus.task_mng.DTOs.usersDTO;

public class TaskTileController {

    @FXML
    public Text t_desc;

    @FXML
    public Text t_user;
    
    @FXML
    public Text t_status;
    
    public Integer t_id;

    @FXML
    private MFXButton updateTask;
    
    public void setTaskdtl(String tk_desc, Integer tk_user, String tk_status, Integer tk_id){
        t_desc.setText(tk_desc);
        t_status.setText(tk_status);
        usersmodel user = new usersmodel();
        List<usersDTO> users_list = user.viewUser(tk_user);
        t_user.setText(users_list.get(0).getFirst_name()+" "+users_list.get(0).getSurname());
        t_id = tk_id;
    }
    
    @FXML
    void updateTask(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../updateTask.fxml"));
            Parent root = (Parent) loader.load();
            UpdateTaskController tu_ctrl = loader.getController();
            
            project_dtlModel task = new project_dtlModel();
            List<project_dtlDTO> t_list = task.viewProjectDTL(t_id);
            
            project_hdModel project = new project_hdModel();
            List<project_hdDTO> p_list = project.viewProject(t_list.get(0).getProject_id());
            
            usersmodel user = new usersmodel();
            List<usersDTO> u_list = user.viewUser(t_list.get(0).getUser_id());
            
            tu_ctrl.setScene(t_list.get(0).get_id(), p_list.get(0).getTitle(), u_list.get(0).getFirst_name()+" "+u_list.get(0).getSurname(), t_list.get(0).getTask_desc(), t_list.get(0).getStart_date(), t_list.get(0).getEnd_date(), t_list.get(0).getStatus());
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(projectController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
