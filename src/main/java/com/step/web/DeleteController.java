/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.step.web;

import com.step.web.dao.EmployeeDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sscerbatiuc
 */
@WebServlet(urlPatterns = "/delete-employee")
public class DeleteController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        EmployeeDao empDao = new EmployeeDao();
        empDao.deleteEmployee(id);
        resp.sendRedirect("view");
    }
    
    
}
