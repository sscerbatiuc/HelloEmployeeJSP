package com.step.web;

import com.step.web.dao.Employee;
import com.step.web.dao.EmployeeDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
        EmployeeDao dao = new EmployeeDao();
        Map<Integer, Employee> emps = dao.getAll();
        session.setAttribute("employeesMap", emps);
        req.getRequestDispatcher("view.jsp").forward(req, resp); // /view
    }
    
}
