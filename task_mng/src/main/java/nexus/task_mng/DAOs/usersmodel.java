/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nexus.task_mng.DAOs;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import nexus.task_mng.DTOs.usersDTO;

import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import org.sql2o.data.Table;

/**
 *
 * @author owenc
 */
public class usersmodel {
    
    private final static String URL = "jdbc:postgresql://localhost:5432/javafx";
    private final static String USER = "postgres";
    private final static String PASSWORD = "Password123";
    
    private final static Sql2o sql2o;
    
    public final static String INSERT_QUERY = "INSERT INTO public.\"USERS\"(first_name, surname, dob, email)VALUES(:first_name, :surname, :dob,  :email)";
    public final static String UPDATE_QUERY = "UPDATE public.\"USERS\" SET first_name = :first_name, surname = :surname, dob=:dob,  email=:email WHERE id=:id";
    public final static String DELETE_QUERY = "DELETE FROM public.\"USERS\" WHERE id = :id";
    public final static String VIEWALL_QUERY = "SELECT * FROM public.\"USERS\"";
    public final static String VIEWONE_QUERY = "SELECT * FROM public.\"USERS\" WHERE id = :id";
    public final static String VIEWONE2_QUERY = "SELECT * FROM public.\"USERS\" WHERE first_name||' '|| surname = :username";

    static{
        sql2o = new Sql2o(URL, USER, PASSWORD);
    }
    
    public static void insertUser(String first_name, String surname, LocalDate dob, String email){
        
        try(Connection con = sql2o.open()){
            con.createQuery(INSERT_QUERY)
                    .addParameter("first_name", first_name)
                    .addParameter("surname", surname)
                    .addParameter("dob", dob)
                    .addParameter("email", email)
                    .executeUpdate();
        }catch(Throwable t){
            throw new Sql2oException("An error occured while executing Statement", t);
        }
    }
    
    public static void updateUser(Integer id, String first_name, String surname, LocalDate dob, String email){

        
        try(Connection con = sql2o.open()){
            con.createQuery(UPDATE_QUERY)
                    .addParameter("first_name", first_name)
                    .addParameter("surname", surname)
                    .addParameter("dob", dob)
                    .addParameter("email", email)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch(Throwable t){
            throw new Sql2oException("An error occured while executing Statement", t);
        }
    }
    
    public static void deleteUser(Integer id){
        
        try(Connection con = sql2o.open()){
            con.createQuery(DELETE_QUERY)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch(Throwable t){
            throw new Sql2oException("An error occured while executing Statement", t);
        }
    }
    /*
    
    Source: https://www.tabnine.com/code/java/methods/org.sql2o.data.Table/rows
    */
    public List<usersDTO> viewUser(Integer id){
        
        ArrayList<usersDTO> users_list = new ArrayList<>();
        
        try(Connection con = sql2o.open()){
            Table users_tbl = con.createQuery(VIEWONE_QUERY)
                    .addParameter("id", id)
                    .executeAndFetchTable();
            users_tbl.rows().forEach(
                row -> {
                    usersDTO user_res = new usersDTO();
                    user_res.set_id(row.getInteger("id"));
                    user_res.setFirst_name(row.getString("first_name"));
                    user_res.setSurname(row.getString("surname"));
                    user_res.setDOB(row.getDate("dob").toString());
                    user_res.setEmail(row.getString("email"));
                    users_list.add(user_res);
                });
            return users_list;
        }catch(Throwable t){
            throw new Sql2oException("An error occured while executing Statement", t);
        }
    }
    
    public List<usersDTO> viewUsers(){
        
        ArrayList<usersDTO> users_list = new ArrayList<>();
        
        try(Connection con = sql2o.open()){
            Table users_tbl = con.createQuery(VIEWALL_QUERY)
                    .executeAndFetchTable();
            users_tbl.rows().forEach(
                row -> {
                    usersDTO user_res = new usersDTO();
                    user_res.set_id(row.getInteger("id"));
                    user_res.setFirst_name(row.getString("first_name"));
                    user_res.setSurname(row.getString("surname"));
                    user_res.setDOB(row.getDate("dob").toString());
                    user_res.setEmail(row.getString("email"));
                    users_list.add(user_res);
                });
            return users_list;
        }catch(Throwable t){
            throw new Sql2oException("An error occured while executing Statement", t);
        }
    }
    
    public List<usersDTO> viewUser2(String username){
        
        ArrayList<usersDTO> users_list = new ArrayList<>();
        
        try(Connection con = sql2o.open()){
            Table users_tbl = con.createQuery(VIEWONE2_QUERY)
                    .addParameter("username", username)
                    .executeAndFetchTable();
            users_tbl.rows().forEach(
                row -> {
                    usersDTO user_res = new usersDTO();
                    user_res.set_id(row.getInteger("id"));
                    user_res.setFirst_name(row.getString("first_name"));
                    user_res.setSurname(row.getString("surname"));
                    user_res.setDOB(row.getDate("dob").toString());
                    user_res.setEmail(row.getString("email"));
                    users_list.add(user_res);
                });
            return users_list;
        }catch(Throwable t){
            throw new Sql2oException("An error occured while executing Statement", t);
        }
    }
}
