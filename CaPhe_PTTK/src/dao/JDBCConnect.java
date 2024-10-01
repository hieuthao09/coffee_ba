/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class JDBCConnect {
    Connection con = null ;
    Statement st = null;
    ResultSet rs = null;
    String strServer;
    String strDatabase;
    String strUser;
    String strPassword;

    public Statement getSt() {
        return st;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
    
    public Connection getCon() {
        return con;
    }

    public ResultSet getRs() {
        return rs;
    }
    
    public JDBCConnect() {
        connectDatabase();
    }
     public JDBCConnect(String user, String pass, String database, String server) {
        strUser = user;
        strPassword = pass;
        strDatabase = database;
        strServer = server;
        connectDatabase();
    }
    private void connectDatabase()
    {
        try {
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBCConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
         String connectionURL = "jdbc:sqlserver://"+ strServer 
                    + ":1433;databaseName="+strDatabase
                    +";user=" + strUser
                    + ";password=" +strPassword + ";encrypt=true;trustServerCertificate=true";
        try {
                con = DriverManager.getConnection(connectionURL);
                if(con!=null)
                        System.out.println("Ket noi thanh cong");
                else
                    System.out.println("Ket noi khong thanh cong");
                
            } catch (SQLException ex) {
                Logger.getLogger(JDBCConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
