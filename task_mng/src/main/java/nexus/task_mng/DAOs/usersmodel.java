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
public class usersmodel {
    
    private Integer id;
    private String first_name;
    private String surname;
    private Date dob;
    private Integer project_id;
    private String email;
    
    private final static String URL = "jdbc:postgresql://localhost:5432/javafx";
    private final static String USER = "postgres";
    private final static String PASSWORD = "Password123";
    
    private final static Sql2o sql2o;
    
    public final static String INSERT_QUERY = "INSERT INTO USERS(first_name, surname, dob, project_id, email)VALUES(:first_name, :surname, :dob, :project_id, :email)";
    public final static String UPDATE_QUERY = "UPDATE USERS SET first_name = :first_name, surname = :surname, dob=:dob, project_id = :project_id, email=:email WHERE id=:id";
    public final static String DELETE_QUERY = "DELETE FROM USERS WHERE id = :id";
    public final static String VIEWALL_QUERY = "SELECT * FROM USERS";
    public final static String VIEWONE_QUERY = "SELECT * FROM USERS WHERE id = :id";
    
    static{
        sql2o = new Sql2o(URL, USER, PASSWORD);
    }
    
    public static void insertUser(String first_name, String surname, Date dob, Integer project_id, String email){
        String fname = first_name;
        String lname = surname;
        Date user_dob = dob;
        Integer user_assign = project_id;
        String user_email = email;
        
        try(Connection con = sql2o.open()){
            con.createQuery(INSERT_QUERY)
                    .addParameter("first_name", fname)
                    .addParameter("surname", lname)
                    .addParameter("dob", user_dob)
                    .addParameter("project_id", user_assign)
                    .addParameter("email", user_email)
                    .executeUpdate();
        }catch(Throwable t){
            throw new Sql2oException("An error occured while executing Statement", t);
        }
    }
    
    public static void updateUser(Integer id, String first_name, String surname, Date dob, Integer project_id, String email){
        Integer user_id = id;
        String fname = first_name;
        String lname = surname;
        Date user_dob = dob;
        Integer user_assign = project_id;
        String user_email = email;
        
        try(Connection con = sql2o.open()){
            con.createQuery(UPDATE_QUERY)
                    .addParameter("first_name", fname)
                    .addParameter("surname", lname)
                    .addParameter("dob", user_dob)
                    .addParameter("project_id", user_assign)
                    .addParameter("email", user_email)
                    .addParameter(":id", user_id)
                    .executeUpdate();
        }catch(Throwable t){
            throw new Sql2oException("An error occured while executing Statement", t);
        }
    }
    
    public static void deleteUser(Integer id){
        Integer user_id = id;
        
        try(Connection con = sql2o.open()){
            con.createQuery(DELETE_QUERY)
                    .addParameter("id", user_id)
                    .executeUpdate();
        }catch(Throwable t){
            throw new Sql2oException("An error occured while executing Statement", t);
        }
    }
    
    public List<usersmodel> viewUser(Integer id){
        Integer user_id = id;
        
        try(Connection con = sql2o.open()){
            return con.createQuery(VIEWONE_QUERY)
                    .addParameter("id", user_id)
                    .executeAndFetch(usersmodel.class);
        }catch(Throwable t){
            throw new Sql2oException("An error occured while executing Statement", t);
        }
    }
    
    public List<usersmodel> viewUsers(){
        try(Connection con = sql2o.open()){
            return con.createQuery(VIEWALL_QUERY)
                    .executeAndFetch(usersmodel.class);
        }catch(Throwable t){
            throw new Sql2oException("An error occured while executing Statement", t);
        }
    }
}
