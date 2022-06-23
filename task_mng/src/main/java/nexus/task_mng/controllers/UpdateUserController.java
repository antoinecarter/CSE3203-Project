package nexus.task_mng.controllers;

import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import nexus.task_mng.App;
import nexus.task_mng.DAOs.usersmodel;
import org.sql2o.Sql2oException;

public class UpdateUserController implements Initializable{
    
    @FXML
    private Button closeButton;
    
    
    @FXML
    private Button deleteButton;
    
    @FXML
    private MFXDatePicker dob;

    @FXML
    private MFXTextField email;

    @FXML
    private MFXTextField fname;

    @FXML
    private MFXTextField id;

    @FXML
    private MFXTextField lname;
    
    @FXML
    private Label notif;
    
    
    @FXML
    void deleteUser(MouseEvent event) {
          Integer u_id = Integer.parseInt(this.id.getText());
          try {
            usersmodel.deleteUser(u_id);
            Stage stage = (Stage) deleteButton.getScene().getWindow();
            stage.close();
            App.setRoot("home");
        } catch (IOException ex) {
            Logger.getLogger(UpdateUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void returnHome(MouseEvent event) {
        try {
            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
            App.setRoot("home");
        } catch (IOException ex) {
            Logger.getLogger(UpdateUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void updateUser(MouseEvent event) {
        Integer u_id = Integer.parseInt(this.id.getText());
        String first_name = this.fname.getText();
        String surname = this.lname.getText();
        LocalDate date_of_birth = this.dob.getValue();
        String email_address = this.email.getText();
        try{
        usersmodel.updateUser(u_id, first_name, surname, date_of_birth, email_address);
        notif.setText("User Profile Updated!");
        }catch(Sql2oException e){
            notif.setText(e.getMessage());
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    } 
    
    public void setScene(Integer u_id, String u_fname, String u_lname, String u_dob, String u_email){
        id.setText(u_id.toString());
        fname.setText(u_fname);
        lname.setText(u_lname);
        dob.setValue(LocalDate.parse(u_dob));
        email.setText(u_email);
    }

}
