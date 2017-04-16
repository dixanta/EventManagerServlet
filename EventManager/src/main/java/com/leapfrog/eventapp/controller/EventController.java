/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.eventapp.controller;

import com.leapfrog.eventapp.dao.EventDAO;
import com.leapfrog.eventapp.dao.impl.EventDAOImpl;
import com.leapfrog.eventapp.entity.Event;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
@WebServlet(displayName = "event",urlPatterns = {"/event/*"})
public class EventController extends HttpServlet {

    private EventDAO eventDAO=new EventDAOImpl();
    private String viewPath="/WEB-INF/views/event/";
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url=req.getRequestURI().toLowerCase();
        if(url.contains("/event/add")){
            add(req, resp);
        }else{
            try{
            req.setAttribute("events",eventDAO.getAll());
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            req.getRequestDispatcher(viewPath+"index.jsp").forward(req, resp);
        }
    }
    
    private void add(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
        req.getRequestDispatcher(viewPath+"add.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Event event=new Event();
        event.setTitle(req.getParameter("event_title"));
        event.setDescription(req.getParameter("event_desc"));
        try{
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            event.setStartDate(format.parse(req.getParameter("start_date")));
            event.setEndDate(format.parse(req.getParameter("end_date")));
        }catch(ParseException pe){
            System.out.println(pe.getMessage());
        }
        event.setInvite((req.getParameter("invite")==null));
        event.setStatus(true);
        try{
        eventDAO.insert(event);
        resp.sendRedirect(req.getContextPath()+"/event");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    
    
    
    
    
    
}
