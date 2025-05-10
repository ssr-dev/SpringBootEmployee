package co.edu.uptc.firstJavaWebApp.controller;
import java.io.IOException;

import co.edu.uptc.firstJavaWebApp.model.Customer;
import co.edu.uptc.firstJavaWebApp.model.CustomerList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addCustomer")
public class AddCustomerController extends HttpServlet{

    public AddCustomerController(){
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        try {
            CustomerList custList = (CustomerList) req.getSession().getAttribute("customerList");
            if (custList == null){
                custList = new CustomerList();
                req.getSession().setAttribute("customerList", custList);
            }
            int id= Integer.parseInt(req.getParameter("cust_id"));
            if (custList.isIdAvailable(id)){
                String name = req.getParameter("cust_name");
                String email = req.getParameter("cust_email");
                String address = req.getParameter("cust_address");
                Customer customer = new Customer(name, address, email, id);
                custList.addCustomer(customer);
                req.getSession().setAttribute("oper", "success");
                resp.sendRedirect(req.getContextPath()+"/confirm.html");
            } else {
                req.setAttribute("errorMessage", "El documento de identidad ya existe en el sistema.");
                req.setAttribute("homePage", req.getContextPath() + "/menu");
                req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            req.setAttribute("errorMessage", "Ocurrió un error inesperado al agregar el cliente.");
            req.setAttribute("homePage", req.getContextPath() + "/menu");
            req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
        }
    }



}
