package co.edu.uptc.firstJavaWebApp.controller;

import java.io.IOException;

import co.edu.uptc.firstJavaWebApp.model.CustomerList;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/showCustomers")
public class ShowCustomers extends HttpServlet{

    public ShowCustomers(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        CustomerList customerList = (CustomerList) session.getAttribute("customerList");

        if (customerList == null) {
            customerList = new CustomerList();
            session.setAttribute("customerList", customerList);
        }

        req.setAttribute("customers", customerList.getCustomerList());

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/showCustomers.jsp");
        rd.forward(req, resp);
    }

}
