/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.eventapp.db;

import com.leapfrog.eventapp.constant.DbConstant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class DbConnection {
    private Connection conn;
    private PreparedStatement stmt;

    public DbConnection() {
    }
    
    public void connect()throws ClassNotFoundException,SQLException{
        Class.forName(DbConstant.DB_DRIVER);
        conn=DriverManager.getConnection(DbConstant.DB_URL, DbConstant.DB_USER,DbConstant.DB_PASSWORD);
    }
    
    public PreparedStatement initStatement(String sql)throws SQLException{
        stmt=conn.prepareStatement(sql);
        return stmt;
    }
    
    public int executeUpdate()throws SQLException{
        return stmt.executeUpdate();
    }
    
    public ResultSet executeQuery()throws SQLException{
        return stmt.executeQuery();
    }
    public void close()throws SQLException{
        if(conn!=null && !conn.isClosed()){
            conn.close();
            conn=null;
        }
    }
}
