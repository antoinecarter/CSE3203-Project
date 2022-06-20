/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nexus.task_mng.DAOs;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
/**
 *
 * @author owenc
 */
public class project_dtlModel {
    
    private final static String URL = "jdbc:postgresql://localhost:5432/javafx";
    private final static String USER = "postgres";
    private final static String PASSWORD = "Password123";
    
    private final static Sql2o sql2o;
    
    public final static String INSERT_QUERY = "INSERT INTO public.\"PROJECT_DTL\"(project_id, user_id, task_desc, start_date, end_date, status)VALUES(:project_id, :user_id, :task_desc, :start_date, :end_date, :status)";
    public final static String UPDATE_QUERY = "UPDATE public.\"PROJECT_DTL\" SET project_id = :project_id, user_id = :user_id, task_desc=:task_desc, start_date = :start_date, end_date=:end_date, status = :status WHERE id=:id";
    public final static String DELETE_QUERY = "DELETE FROM public.\"PROJECT_DTL\" WHERE id = :id";
    public final static String VIEWALL_QUERY = "SELECT * FROM public.\"PROJECT_DTL\"";
    public final static String VIEWONE_QUERY = "SELECT * FROM public.\"PROJECT_DTL\" WHERE id = :id";
    
    static{
        sql2o = new Sql2o(URL, USER, PASSWORD);
    }
    
    public static void insertProjectDTL(Integer project_id, Integer user_id, String task_desc, LocalDate start_date, LocalDate end_date, String status){
        
        try(Connection con = sql2o.open()){
            con.createQuery(INSERT_QUERY)
                    .addParameter("project_id", project_id)
                    .addParameter("user_id", user_id)
                    .addParameter("task_desc", task_desc)
                    .addParameter("start_date", start_date)
                    .addParameter("end_date", end_date)
                    .addParameter("status", status)
                    .executeUpdate();
        }catch(Throwable t){
            throw new Sql2oException("An error occured while executing Statement", t);
        }
    }
    
    public static void updateProjectDTL(Integer id, Integer project_id, Integer user_id, String task_desc, Date start_date, Date end_date, String status){
        
        try(Connection con = sql2o.open()){
            con.createQuery(UPDATE_QUERY)
                    .addParameter("project_id", project_id)
                    .addParameter("user_id", user_id)
                    .addParameter("task_desc", task_desc)
                    .addParameter("start_date", start_date)
                    .addParameter("end_date", end_date)
                    .addParameter("status", status)
                    .addParameter(":id", id)
                    .executeUpdate();
        }catch(Throwable t){
            throw new Sql2oException("An error occured while executing Statement", t);
        }
    }
    
    public static void deleteProjectDTL(Integer id){
        
        try(Connection con = sql2o.open()){
            con.createQuery(DELETE_QUERY)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch(Throwable t){
            throw new Sql2oException("An error occured while executing Statement", t);
        }
    }
    
    public List<project_dtlModel> viewProjectDTL(Integer id){
        
        try(Connection con = sql2o.open()){
            return con.createQuery(VIEWONE_QUERY)
                    .addParameter("id", id)
                    .executeAndFetch(project_dtlModel.class);
        }catch(Throwable t){
            throw new Sql2oException("An error occured while executing Statement", t);
        }
    }
    
    public List<project_dtlModel> viewProjectDTLs(){
        try(Connection con = sql2o.open()){
            return con.createQuery(VIEWALL_QUERY)
                    .executeAndFetch(project_dtlModel.class);
        }catch(Throwable t){
            throw new Sql2oException("An error occured while executing Statement", t);
        }
    }
}
