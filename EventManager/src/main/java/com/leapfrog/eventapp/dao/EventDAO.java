/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.eventapp.dao;

import com.leapfrog.eventapp.entity.Event;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author USER
 */
public interface EventDAO {
    int insert(Event event)throws SQLException,ClassNotFoundException;
    List<Event> getAll()throws SQLException,ClassNotFoundException;
}
