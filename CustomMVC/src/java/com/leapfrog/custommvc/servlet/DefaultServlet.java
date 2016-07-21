/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.custommvc.servlet;

import com.leapfrog.custommvc.dao.CourseDAO;
import com.leapfrog.custommvc.dao.impl.CourseDAOImpl;
import com.leapfrog.custommvc.entity.Course;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rajesh
 */
@WebServlet(name = "default", urlPatterns = {"/", "/home"})
public class DefaultServlet extends HttpServlet{
    
    private CourseDAO courseDAO;

    @Override
    public void init() throws ServletException {
        courseDAO = new CourseDAOImpl();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        try{
            courseDAO.insert(new Course(0, "Android Development", "Native Android Development", 20000, true));
            request.setAttribute("courses", courseDAO.getAll());
        }
        catch(ClassNotFoundException | SQLException ce){
            
        }
        request.getRequestDispatcher("/WEB-INF/views/default.jsp").forward(request, response);
    }    
}
