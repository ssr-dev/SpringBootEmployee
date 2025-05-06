package co.edu.uptc.firstJavaWebApp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/introDeleteEmployee")
public class IntroDeleteEmployee extends HttpServlet{

    public IntroDeleteEmployee(){
        super();
    }

    @Override
         protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/deleteEmployee.jsp");
            rd.forward(req, resp);
         }

    @Override
         protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/deleteEmployee.jsp");
            rd.forward(req, resp);
         }
}
