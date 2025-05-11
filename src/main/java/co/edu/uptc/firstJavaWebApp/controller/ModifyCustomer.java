package co.edu.uptc.firstJavaWebApp.controller;
import java.io.IOException;

import co.edu.uptc.firstJavaWebApp.model.Customer;
import co.edu.uptc.firstJavaWebApp.model.CustomerList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/modifyCustomer")
public class ModifyCustomer extends HttpServlet{

    public ModifyCustomer(){
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(req.getParameter("cust_id"));
            String name = req.getParameter("cust_name");
            String email = req.getParameter("cust_email");
            String address = req.getParameter("cust_address");
            Customer customer = new Customer();
            customer.setId(id);
            customer.setEmail(email);
            customer.setAddress(address);
            customer.setName(name);
            CustomerList custList = (CustomerList) req.getSession().getAttribute("customerList");
            if (custList == null){
                req.setAttribute("errorMessage", "No se encontró la lista de clientes.");
                req.setAttribute("homePage", req.getContextPath()+"/menu");
                req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
                return;
            }
            boolean searchCustomer = custList.modifyCustomer(customer);
            if (searchCustomer){
                req.getSession().setAttribute("oper", "success");
                req.getSession().setAttribute("employeelist", custList);
                resp.sendRedirect(req.getContextPath() + "/confirm.html");
            }
            else {
                req.setAttribute("errorMessage", "Cliente no encontrado para modificar.");
                req.setAttribute("homePage", req.getContextPath() + "/menu");
                req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
            }
        }catch (Exception e){
            req.setAttribute("errorMessage", "Ocurrió un error al intentar modificar el cliente.");
            req.setAttribute("homePage", req.getContextPath() + "/menu");
            req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
        }
    }
    


}
