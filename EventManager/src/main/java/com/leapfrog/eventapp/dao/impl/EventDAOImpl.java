/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.eventapp.dao.impl;

import com.leapfrog.eventapp.dao.EventDAO;
import com.leapfrog.eventapp.db.DbConnection;
import com.leapfrog.eventapp.entity.Event;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class EventDAOImpl implements EventDAO {
    private DbConnection db=new DbConnection();
    @Override
    public int insert(Event event) throws SQLException, ClassNotFoundException {
        db.connect();
        String sql="INSERT INTO tbl_events(event_title,event_description,start_date,end_date,invite,status) VALUES(?,?,?,?,?,?)";
        PreparedStatement stmt=db.initStatement(sql);
        stmt.setString(1,event.getTitle());
        stmt.setString(2, event.getDescription());
        stmt.setDate(3, new java.sql.Date(event.getStartDate().getTime()));
        stmt.setDate(4, new java.sql.Date(event.getEndDate().getTime()));
        stmt.setBoolean(5, event.isInvite());
        stmt.setBoolean(6, event.isStatus());
        int result=db.executeUpdate();
        db.close();
        return result;
    }

    @Override
    public List<Event> getAll() throws SQLException, ClassNotFoundException {
        List<Event> eventList=new ArrayList<>();
        db.connect();
        db.initStatement("Select * FROM tbl_events");
        ResultSet rs=db.executeQuery();
        while(rs.next()){
            Event event=new Event();
            event.setId(rs.getInt("event_id"));
            event.setTitle(rs.getString("event_title"));
            event.setDescription(rs.getString("event_description"));
            event.setStartDate(rs.getDate("start_date"));
            event.setEndDate(rs.getDate("end_date"));
            event.setInvite(rs.getBoolean("invite"));
            event.setStatus(rs.getBoolean("status"));
            eventList.add(event);
        }
        db.close();
        return eventList;
    }
    
}
