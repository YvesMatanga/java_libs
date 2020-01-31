/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.sql;

//import com.ibatis.common.jdbc.ScriptRunner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yves Matanga
 */

/*this class handles all the possible and basic sql connections --connect /disconnect/update/run script/execute query for retrieval*/

public class SqlConnection {
    
    protected Connection conn = null;
    protected Statement stmt = null;
    protected ResultSet Result_Set = null; 
    
    /*default constructor*/
    public SqlConnection(){
       /*default constructor connect to mysql and to the root straight */
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }    
    
    /*general constructor*/
    public SqlConnection(String className){
        try {
            Class.forName(className);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    //getters
    public Connection getConn() {
        return conn;
    }
    
    //other methods
    
    /*default connection : to mysql via root user*/
    public void connect(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/mysql?user=root&password=root");//connect to root
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //general connection (on local host)
    public void connect(String sgbd,String db,String username,String password){
        connect("localhost",sgbd,db,username,password);
    }
    
    public void connect(String host,String sgbd,String db,String username,String password){
        try {
            conn = DriverManager.getConnection("jdbc:"+sgbd+"://"+host+"/"
                    +db+"?user="+username+"&password="+password);
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void connect(SqlDatabase SqlDb){
        //connect to Database
        connect(SqlDb.getHost(),
                SqlDb.getDBMS(),
                SqlDb.getDatabase(),
                SqlDb.getUsername(),
                SqlDb.getPassword());
    }
    
    //disconnect
    public void disconnect(){
        try {
            conn.close();
            try {
                this.finalize();
            } catch (Throwable ex) {
                Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  /*  
    public void runScript(String filePath){
        ScriptRunner runner = new ScriptRunner(conn,false,false);
        try {
            runner.runScript(new BufferedReader(new FileReader(filePath)));//runscript
        } catch (IOException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   */
    public int executeUpdate(String query){        
        
        int nb_of_row_affected = 0;
        
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            nb_of_row_affected = stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nb_of_row_affected;/*return number of row affected by update*/
    }
    
   
    public ResultSet executeQuery(String query){
         try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Result_Set = stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return Result_Set; /*return result set that can be read as 
         * folows while(rs.next()) {......rs.getInt getString.......}
         */
    }
    
    public Statement createStatement(){
        try {
            return conn.createStatement();
        } catch (SQLException ex) {
            return null;
        }
    }
}
