/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.step.web;

import com.step.web.dao.Employee;
import com.step.web.dao.EmployeeDao;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sscerbatiuc
 */
@WebServlet(urlPatterns="/update-employee")
public class UpdateController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Employee edited?
        EmployeeDao dao = new EmployeeDao();
        String id = req.getParameter("id"); // update-employee?id=23
        Map<Integer, Employee> byId = dao.getById(id);
        HttpSession session = req.getSession();
        session.setAttribute("employeeById", byId);
        // Session
        resp.sendRedirect("update.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        EmployeeDao empDao = new EmployeeDao();
        empDao.update(id, name, "---", "---");
        resp.sendRedirect("view");
    }
    
    
    
    
}
