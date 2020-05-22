package com.step.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sscerbatiuc
 */
public class ViewController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<String> emps = new ArrayList<>();
        emps.add("John");
        emps.add("Jake");
        emps.add("Peter");
        emps.add("Peter");
        emps.add("Peter");
        emps.add("Peter");
        emps.add("Peter");
        session.setAttribute("list", emps);
        resp.sendRedirect("view.jsp");
    }
    
    
}
