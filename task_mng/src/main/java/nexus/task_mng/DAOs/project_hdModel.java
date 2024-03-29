/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nexus.task_mng.DAOs;
import java.util.Date;
import java.util.List;

import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
/**
 *
 * @author owenc
 */
public class project_hdModel {
    private Integer id;
    private String title;
    private String description;
    private Date start_date;
    private Date end_date;
    private String status;
    
    private final static String URL = "jdbc:postgresql://localhost:5432/javafx";
    private final static String USER = "postgres";
    private final static String PASSWORD = "Password123";
    
    private final static Sql2o sql2o;
    
    public final static String INSERT_QUERY = "INSERT INTO PROJECT_HD(title, description, start_date, end_date, status)VALUES(:title, :description, :start_date, :end_date, :status)";
    public final static String UPDATE_QUERY = "UPDATE PROJECT_HD SET title = :title, description = :description, start_date=:start_date, end_date = :end_date, status=:status WHERE id=:id";
    public final static String DELETE_QUERY = "DELETE FROM PROJECT_HD WHERE id = :id";
    public final static String VIEWALL_QUERY = "SELECT * FROM PROJECT_HD";
    public final static String VIEWONE_QUERY = "SELECT * FROM PROJECT_HD WHERE id = :id";
    
    static{
        sql2o = new Sql2o(URL, USER, PASSWORD);
    }
    
    public static void insertProject(String title, String description, Date start_date, Date end_date, String status){
        String project_title = title;
        String project_desc = description;
        Date project_start_date = start_date;
        Date project_end_date = end_date;
        String project_status = status;
        
        try(Connection con = sql2o.open()){
            con.createQuery(INSERT_QUERY)
                    .addParameter("title", project_title)
                    .addParameter("description", project_desc)
                    .addParameter("start_date", project_start_date)
                    .addParameter("end_date", project_end_date)
                    .addParameter("status", project_status)
                    .executeUpdate();
        }catch(Throwable t){
            throw new Sql2oException("An error occured while executing Statement", t);
        }
    }
    
    public static void updateProject(Integer id, String title, String description, Date start_date, Date end_date, String status){
        Integer project_id = id;
        String project_title = title;
        String project_desc = description;
        Date project_start_date = start_date;
        Date project_end_date = end_date;
        String project_status = status;
        
        try(Connection con = sql2o.open()){
            con.createQuery(UPDATE_QUERY)
                    .addParameter("title", project_title)
                    .addParameter("description", project_desc)
                    .addParameter("start_date", project_start_date)
                    .addParameter("end_date", project_end_date)
                    .addParameter("status", project_status)
                    .addParameter(":id", project_id)
                    .executeUpdate();
        }catch(Throwable t){
            throw new Sql2oException("An error occured while executing Statement", t);
        }
    }
    
    public static void deleteProject(Integer id){
        Integer project_id = id;
        
        try(Connection con = sql2o.open()){
            con.createQuery(DELETE_QUERY)
                    .addParameter("id", project_id)
                    .executeUpdate();
        }catch(Throwable t){
            throw new Sql2oException("An error occured while executing Statement", t);
        }
    }
    
    public List<project_hdModel> viewProject(Integer id){
        Integer project_id = id;
        
        try(Connection con = sql2o.open()){
            return con.createQuery(VIEWONE_QUERY)
                    .addParameter("id", project_id)
                    .executeAndFetch(project_hdModel.class);
        }catch(Throwable t){
            throw new Sql2oException("An error occured while executing Statement", t);
        }
    }
    
    public List<project_hdModel> viewProjects(){
        try(Connection con = sql2o.open()){
            return con.createQuery(VIEWALL_QUERY)
                    .executeAndFetch(project_hdModel.class);
        }catch(Throwable t){
            throw new Sql2oException("An error occured while executing Statement", t);
        }
    }
}
