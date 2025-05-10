package co.edu.uptc.firstJavaWebApp.controller;

import java.io.IOException;
import co.edu.uptc.firstJavaWebApp.model.CustomerList;
import co.edu.uptc.firstJavaWebApp.model.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/showCustomer")
public class ShowCustomer extends HttpServlet{

    public ShowCustomer(){
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("cust_id"));
            CustomerList customerList = (CustomerList) req.getSession().getAttribute("customerList");
            if (customerList == null || customerList.findCustomerById(id) == null){
                 req.setAttribute("errorMessage", "Cliente no encontrado.");
                req.setAttribute("homePage", req.getContextPath() + "/menu");
                req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
            } else {
                Customer customer = customerList.findCustomerById(id);
                req.setAttribute("customer", customer);
                req.getRequestDispatcher("/WEB-INF/jsp/showCustomer.jsp").forward(req, resp);
            }

        }catch(Exception e){
            req.setAttribute("errorMessage", "Ocurrió un error al buscar al cliente.");
            req.setAttribute("homePage", req.getContextPath() + "/menu");
            req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
        }
    }
}
