/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nexus.task_mng.DTOs;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author owenc
 */
public class project_hdDTO {
    private Integer id;
    private String title;
    private String description;
    private String start_date;
    private String end_date;
    private String status;
    
    public Integer get_id(){
        return id;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getDescription(){
        return description;
    }
    
    public String getStart_date(){
        return start_date;
    }
    
    public String getEnd_date(){
        return end_date;
    }
    
    public String getStatus(){
        return status;
    }
    
    public void set_id(Integer id){
        this.id = id;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public void setStart_date(String start_date){
        this.start_date = start_date;
    }
    
    public void setEnd_date(String end_date){
        this.end_date = end_date;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
}
