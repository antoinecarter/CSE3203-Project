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
public class usersDTO {
    private Integer id;
    private String first_name;
    private String surname;
    private Date dob;
    private Integer project_id;
    private String email;
    
    public Integer get_id(){
        return id;
    }
    
    public String getFirst_name(){
        return first_name;
    }
    
    public String getSurname(){
        return surname;
    }
    
    public Date getDOB(){
        return dob;
    }
    
    public Integer getProject_id(){
        return project_id;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void set_id(Integer id){
        this.id = id;
    }
    
    public void setFirst_name(String first_name){
        this.first_name = first_name;
    }
    
    public void setSurname(String surname){
        this.surname = surname;
    }
    
    public void setDOB(Date dob){
        this.dob = dob;
    }
    
    public void setProject_id(Integer project_id){
        this.project_id = project_id;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
}
