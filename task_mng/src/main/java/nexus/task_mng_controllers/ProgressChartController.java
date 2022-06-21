/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package nexus.task_mng_controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import nexus.task_mng.App;

/**
 * FXML Controller class
 *
 * @author shanise
 */
public class ProgressChartController implements Initializable {

    @FXML
    private BorderPane bp;
    @FXML
    private PieChart pieChart;
    @FXML
    private BarChart<?, ?> barChart;
    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Grapefruit", 13),
                new PieChart.Data("Oranges", 25),
                new PieChart.Data("Plums", 10),
                new PieChart.Data("Pears", 22),
                new PieChart.Data("Apples", 30));
        pieChart.setData(pieChartData);
        
        
        // TODO
        XYChart.Series series1 = new XYChart.Series<>();
        series1.setName("Projects");  
        series1.getData().add(new XYChart.Data("austria", 01.34));
        series1.getData().add(new XYChart.Data("brazil", 48.82));
        series1.getData().add(new XYChart.Data("france", 10));
        series1.getData().add(new XYChart.Data("italy", 35.15));
        series1.getData().add(new XYChart.Data("usa", 100)); 
        barChart.getData().addAll(series1);
        
    }
    
    @FXML
    private void homepage(MouseEvent event) throws IOException {
        App.setRoot("home");
    }

    
}
