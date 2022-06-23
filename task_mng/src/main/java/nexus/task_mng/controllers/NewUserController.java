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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import nexus.task_mng.App;
import nexus.task_mng.DAOs.usersmodel;
import org.sql2o.Sql2oException;

/**
 *
 * @author owenc
 */

public class NewUserController implements Initializable{

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
    void createUser(MouseEvent event) {
        String first_name = this.fname.getText();
        String surname = this.lname.getText();
        LocalDate date_of_birth = this.dob.getValue();
        String email_address = this.email.getText();
        try{
        usersmodel.insertUser(first_name, surname, date_of_birth, email_address);
        this.notif.setText("User Created Successfully!");
        }catch(Sql2oException e){
            this.notif.setText(e.getMessage());
        }
    }

    @FXML
    void goBack(MouseEvent event) {
        try {
            App.setRoot("home");
        } catch (IOException ex) {
            Logger.getLogger(NewUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
