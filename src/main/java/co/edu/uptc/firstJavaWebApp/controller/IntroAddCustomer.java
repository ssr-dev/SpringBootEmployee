package co.edu.uptc.firstJavaWebApp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/introAddCustomer")

public class IntroAddCustomer extends HttpServlet{

    public IntroAddCustomer(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/addCustomer.jsp"); 
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/addCustomer.jsp"); 
            rd.forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("errorMessage", "Ocurrió un error al intentar acceder a la página de agregar un cliente");
            req.setAttribute("homePage", req.getContextPath() + "/menu");
            req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
        }

    }





}
