/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nexus.task_mng.DTOs;

import java.util.Date;

/**
 *
 * @author owenc
 */
public class project_dtlDTO {
    private Integer id;
    private Integer project_id;
    private Integer user_id;
    private String task_desc;
    private String start_date;
    private String end_date;
    private String status;
    
    public Integer get_id(){
        return id;
    }
    
    public Integer getProject_id(){
        return project_id;
    }
    
    public Integer getUser_id(){
        return user_id;
    }
    
    public String getTask_desc(){
        return task_desc;
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
    
    public void set_id(int id){
        this.id = id;
    }
    
    public void setProject_id(int project_id){
        this.project_id = project_id;
    }
    
    public void setUser_id(int user_id){
        this.user_id = user_id;
    }
    
    public void setTask_desc(String task_desc){
        this.task_desc = task_desc;
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
