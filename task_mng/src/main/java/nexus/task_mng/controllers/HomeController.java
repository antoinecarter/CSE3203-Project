/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package nexus.task_mng.controllers;

import nexus.task_mng.controllers.projectController;
import nexus.task_mng.App;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import nexus.task_mng.DAOs.project_dtlModel;
import nexus.task_mng.DAOs.project_hdModel;
import nexus.task_mng.DAOs.usersmodel;
import nexus.task_mng.DTOs.project_dtlDTO;
import nexus.task_mng.DTOs.project_hdDTO;
import nexus.task_mng.DTOs.statusCount1DTO;
import nexus.task_mng.DTOs.statusCountDTO;
import nexus.task_mng.DTOs.usersDTO;

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
    public Text pj_id;

    @FXML
    public Text pj_name;
    
    @FXML
    private VBox p_container; 
    
    @FXML
    private VBox t_container;
    
    @FXML
    private VBox u_container;
    
    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;
    
    
    @FXML
    private PieChart pieChart;
    
    
    @FXML
    private BarChart barChart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    /*
        Author: matt
        Date:  Apr 18, 2020 
        Source: https://stackoverflow.com/questions/61285124/for-loop-in-fxml-file-how-to-send-data-from-controller-to-fxml-file
    */

       project_hdModel projs = new project_hdModel();
       List<project_hdDTO> proj_list = projs.viewProjects();
       List<String> col = new ArrayList<String>();
       for(int i = 0; i<proj_list.size(); i++){
           try{
               
               FXMLLoader loader = new FXMLLoader(getClass().getResource("../project.fxml"));
               Parent projects = loader.load();
               projectController p_ctrl = loader.getController();
               p_ctrl.setP_name(proj_list.get(i).getTitle(), proj_list.get(i).getStatus(), proj_list.get(i).get_id());
               p_container.getChildren().add(projects);
           } catch (IOException ex) {
               Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
           
       project_dtlModel tasks = new project_dtlModel();
       List<project_dtlDTO> tasks_list = tasks.viewProjectDTLs();
       List<String> col_2 = new ArrayList<String>();
       
       for(int j=0;j<tasks_list.size();j++){
           try {
               FXMLLoader loader1 = new FXMLLoader(getClass().getResource("../tasktile.fxml"));
               Parent t = loader1.load();
               TaskTileController t_ctrl = loader1.getController();
               t_ctrl.setTaskdtl(tasks_list.get(j).getTask_desc(), tasks_list.get(j).getUser_id(),tasks_list.get(j).getStatus(), tasks_list.get(j).get_id());
               t_container.getChildren().add(t);
           } catch (IOException ex) {
               Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       
       usersmodel users = new usersmodel();
       List<usersDTO> users_list = users.viewUsers();
       List<String> col2 = new ArrayList<String>();
       
       for(int k=0; k<users_list.size();k++){
           try {
               FXMLLoader loader2 = new FXMLLoader(getClass().getResource("../user.fxml"));
               Parent u = loader2.load();
               userTileController u_ctrl = loader2.getController();
               u_ctrl.setU_details(users_list.get(k).getFirst_name()+" "+users_list.get(k).getSurname(), users_list.get(k).getEmail(), users_list.get(k).get_id());
               u_container.getChildren().add(u);
           } catch (IOException ex) {
               Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

       project_hdModel status1 = new project_hdModel();
       List<statusCountDTO> status1_list = status1.statusCount();
       for(int l=0; l<status1_list.size(); l++){
           pieChartData.add(new PieChart.Data(status1_list.get(l).getStatus(), status1_list.get(l).getStatus_count()));
       }
       pieChart.setData(pieChartData);
       XYChart.Series series1 = new XYChart.Series();
       XYChart.Series series2 = new XYChart.Series();
       XYChart.Series series3 = new XYChart.Series();
       
       List<String> statusList = FXCollections.observableArrayList("Ignored", "In Progress", "Completed");
       project_dtlModel status2 = new project_dtlModel();

        List<statusCount1DTO> ignored_list = status2.statusCount(statusList.get(0));
        series1.setName("Ignored");
        for(int n=0;n<ignored_list.size(); n++){
            series1.getData().add(new XYChart.Data(ignored_list.get(n).getTitle(),ignored_list.get(n).getStatus_count()));
        }
        
        List<statusCount1DTO> in_progress_list = status2.statusCount(statusList.get(1));
        series2.setName("In Progress");
        for(int n=0;n<in_progress_list.size(); n++){
            series2.getData().add(new XYChart.Data(in_progress_list.get(n).getTitle(),in_progress_list.get(n).getStatus_count()));
        }
        
        List<statusCount1DTO> completed_list = status2.statusCount(statusList.get(2));
        series3.setName("Completed");
        for(int n=0;n<completed_list.size(); n++){
            series3.getData().add(new XYChart.Data(completed_list.get(n).getTitle(),completed_list.get(n).getStatus_count()));
        }
        
        barChart.getData().addAll(series1, series2, series3);
    }
    
    public void setid_name(String id, String desc){
        pj_id.setText(id);
        pj_name.setText(desc);  
    }
    

    @FXML
    void newProject(MouseEvent event) throws IOException {
        App.setRoot("newProject");
    }
    
    @FXML
    void newTask(MouseEvent event) {
        try {
            App.setRoot("newTask");
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @FXML
    void newUser(MouseEvent event) throws IOException {
           App.setRoot("newUser");
    }

    @FXML
    private void home(MouseEvent event) {
    }

    @FXML
    private void home(ActionEvent event) {
    }

    @FXML
    private void updateProject(MouseEvent event) {
    }

    @FXML
    private void deleteProject(MouseEvent event) {
    }
    
    

    
    
}
