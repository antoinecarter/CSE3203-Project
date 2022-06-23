package nexus.task_mng.controllers;

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
import nexus.task_mng.DAOs.usersmodel;
import nexus.task_mng.DTOs.usersDTO;

public class userTileController {

    @FXML
    public Text t_email;

    @FXML
    public Text t_username;
    
    public Integer u_id;
    
    @FXML
    void updateUser(MouseEvent event) {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../updateUser.fxml"));
            Parent root = (Parent) loader.load();
            UpdateUserController uu_ctrl = loader.getController();
            usersmodel user = new usersmodel();
            List<usersDTO> u_list = user.viewUser(u_id);
            uu_ctrl.setScene(u_list.get(0).get_id(),u_list.get(0).getFirst_name(),u_list.get(0).getSurname(), u_list.get(0).getDOB(),u_list.get(0).getEmail());
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            stage.setOnCloseRequest(new_event ->{stage.close();});

        } catch (IOException ex) {
            Logger.getLogger(projectController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void setU_details(String uName, String uEmail, Integer id){
        t_username.setText(uName);
        t_email.setText(uEmail);
        u_id = id;
    }
    
    

}
