/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nexus.task_mng.DAOs;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import nexus.task_mng.DTOs.project_hdDTO;
import nexus.task_mng.DTOs.statusCountDTO;

import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import org.sql2o.data.Table;
/**
 *
 * @author owenc
 */
public class project_hdModel {
    
    private final static String URL = "jdbc:postgresql://localhost:5432/javafx";
    private final static String USER = "postgres";
    private final static String PASSWORD = "Password123";
    
    private final static Sql2o sql2o;
    
    public final static String INSERT_QUERY = "INSERT INTO public.\"PROJECT_HD\"(title, description, start_date, end_date, status)VALUES(:title, :description, :start_date, :end_date, :status)";
    public final static String UPDATE_QUERY = "UPDATE public.\"PROJECT_HD\" SET title = :title, description = :description, start_date=:start_date, end_date = :end_date, status=:status WHERE id=:id";
    public final static String DELETE_QUERY = "DELETE FROM public.\"PROJECT_HD\" WHERE id = :id";
    public final static String VIEWALL_QUERY = "SELECT * FROM public.\"PROJECT_HD\"";
    public final static String VIEWONE_QUERY = "SELECT * FROM public.\"PROJECT_HD\" WHERE id = :id";
    public final static String VIEWONE2_QUERY = "SELECT * FROM public.\"PROJECT_HD\" WHERE title = :title";
    public final static String STATUS_QUERY = "SELECT status, COUNT(status) status_count FROM public.\"PROJECT_HD\" GROUP BY status";  

    
    static{
        sql2o = new Sql2o(URL, USER, PASSWORD);
    }
    
    public static void insertProject(String title, String description, LocalDate start_date, LocalDate end_date, String status){
        
        try(Connection con = sql2o.open()){
            con.createQuery(INSERT_QUERY)
                    .addParameter("title", title)
                    .addParameter("description", description)
                    .addParameter("start_date", start_date)
                    .addParameter("end_date", end_date)
                    .addParameter("status", status)
                    .executeUpdate();
        }catch(Throwable t){
            throw new Sql2oException("An error occured while executing Statement", t);
        }
    }
    
    public static void updateProject(Integer id, String title, String description, LocalDate start_date, LocalDate end_date, String status){
        
        try(Connection con = sql2o.open()){
            con.createQuery(UPDATE_QUERY)
                    .addParameter("title", title)
                    .addParameter("description", description)
                    .addParameter("start_date", start_date)
                    .addParameter("end_date", end_date)
                    .addParameter("status", status)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch(Throwable t){
            throw new Sql2oException("An error occured while executing Statement", t);
        }
    }
    
    public static void deleteProject(Integer id){
        
        try(Connection con = sql2o.open()){
            con.createQuery(DELETE_QUERY)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch(Throwable t){
            throw new Sql2oException("An error occured while executing Statement", t);
        }
    }
    
    public List<project_hdDTO> viewProject(Integer id){
        
        ArrayList<project_hdDTO> proj_list = new ArrayList<>();
        
        try(Connection con = sql2o.open()){
            Table proj_tbl = con.createQuery(VIEWONE_QUERY)
                    .addParameter("id", id)
                    .executeAndFetchTable();
            proj_tbl.rows().forEach(
                row -> {
                    project_hdDTO proj_res = new project_hdDTO();
                    proj_res.set_id(row.getInteger("id"));
                    proj_res.setTitle(row.getString("title"));
                    proj_res.setDescription(row.getString("description"));
                    proj_res.setStart_date(row.getDate("start_date").toString());
                    proj_res.setEnd_date(row.getDate("end_date").toString());
                    proj_res.setStatus(row.getString("status"));
                    proj_list.add(proj_res);
                });
            return proj_list;
        }catch(Throwable t){
            throw new Sql2oException("An error occured while executing Statement", t);
        }
    }
    
    public List<project_hdDTO> viewProjects(){
        
        ArrayList<project_hdDTO> proj_list = new ArrayList<>();
        
        try(Connection con = sql2o.open()){
            Table proj_tbl = con.createQuery(VIEWALL_QUERY)
                    .executeAndFetchTable();
            proj_tbl.rows().forEach(
                row -> {
                    project_hdDTO proj_res = new project_hdDTO();
                    proj_res.set_id(row.getInteger("id"));
                    proj_res.setTitle(row.getString("title"));
                    proj_res.setDescription(row.getString("description"));
                    proj_res.setStart_date(row.getDate("start_date").toString());
                    proj_res.setEnd_date(row.getDate("end_date").toString());
                    proj_res.setStatus(row.getString("status"));
                    proj_list.add(proj_res);
                });
            return proj_list;
        }catch(Throwable t){
            throw new Sql2oException("An error occured while executing Statement", t);
        }
    }
    
    public List<project_hdDTO> viewProject2(String title){

        ArrayList<project_hdDTO> proj_list = new ArrayList<>();

        try(Connection con = sql2o.open()){
            Table proj_tbl = con.createQuery(VIEWONE2_QUERY)
                    .addParameter("title", title)
                    .executeAndFetchTable();
            proj_tbl.rows().forEach(
                row -> {
                    project_hdDTO proj_res = new project_hdDTO();
                    proj_res.set_id(row.getInteger("id"));
                    proj_res.setTitle(row.getString("title"));
                    proj_res.setDescription(row.getString("description"));
                    proj_res.setStart_date(row.getDate("start_date").toString());
                    proj_res.setEnd_date(row.getDate("end_date").toString());
                    proj_res.setStatus(row.getString("status"));
                    proj_list.add(proj_res);
                });
            return proj_list;
        }catch(Throwable t){
            throw new Sql2oException("An error occured while executing Statement", t);
        }
    }
    
    public List<statusCountDTO> statusCount(){
        ArrayList<statusCountDTO> status_list = new ArrayList<>();
        
        try(Connection con = sql2o.open()){
            Table status_tbl = con.createQuery(STATUS_QUERY)
                    .executeAndFetchTable();
            status_tbl.rows().forEach(
                row -> {
                    statusCountDTO status_res = new statusCountDTO();
                    status_res.setStatus(row.getString("status"));
                    status_res.setStatus_count(row.getInteger("status_count"));
                    status_list.add(status_res);
                });
            return status_list;
        }catch(Throwable t){
            throw new Sql2oException("An error occured while executing statement", t);
        }
    }
    
}
