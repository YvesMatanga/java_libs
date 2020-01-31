/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_libs.sql;

/**
 *
 * @author Yves Matanga
 */

//Singleton Class
public class SqlDatabase {
    private static SqlDatabase instance;
    private String DBMS;
    private String Username;
    private String Password;
    private String Database;
    private String Host;
    
    private SqlDatabase(){
        Username = "root";
        Password = "root";
        Database = "eengineeringlabs_db";
        Host = "localhost";
        DBMS = "mysql";
    }
    
    
    //constructor
    public static SqlDatabase getInstance(){
        if(instance == null){
            instance = new SqlDatabase();//create the only instance
        }
        return instance;
    }
    
    //getters and setters
    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getDatabase() {
        return Database;
    }

    public void setDatabase(String Database) {
        this.Database = Database;
    }

    public String getHost() {
        return Host;
    }

    public void setHost(String Host) {
        this.Host = Host;
    }

    public String getDBMS() {
        return DBMS;
    }

    public void setDBMS(String DBMS) {
        this.DBMS = DBMS;
    }
    
    
    
}
