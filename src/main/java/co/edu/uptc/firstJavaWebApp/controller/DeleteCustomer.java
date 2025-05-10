package co.edu.uptc.firstJavaWebApp.controller;

import java.io.IOException;

import co.edu.uptc.firstJavaWebApp.model.CustomerList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteCustomer")
public class DeleteCustomer extends HttpServlet {
    public DeleteCustomer(){
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
        int id = Integer.parseInt(req.getParameter("cust_id"));
        CustomerList customerList = (CustomerList) req.getSession().getAttribute("customerList");

        if (customerList != null) {
            boolean deleted = customerList.deleteCustomer(id);
            if (deleted) {
                resp.sendRedirect(req.getContextPath() + "/confirm.html");
            } else {
                req.setAttribute("errorMessage", "Cliente no encontrado");
                req.setAttribute("homePage", req.getContextPath() + "/menu");
                req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("errorMessage", "La lista de clientes está vacía");
            req.setAttribute("homePage", req.getContextPath() + "/menu");
            req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
        }

    } catch (Exception e) {
        req.setAttribute("errorMessage", "Ocurrió un error al intentar eliminar al cliente.");
        req.setAttribute("homePage", req.getContextPath() + "/menu");
        req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
    }
}



}
