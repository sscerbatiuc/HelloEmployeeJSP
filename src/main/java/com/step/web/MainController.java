package com.step.web;

import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sscerbatiuc
 */
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        session.setAttribute("currentDateTime", LocalDateTime.now());
//        session.setAttribute("numbersArray", new int[]{1,2,3,4,5,6,7,8,9,10});
        resp.sendRedirect("index.jsp");
    }
    
    
}
