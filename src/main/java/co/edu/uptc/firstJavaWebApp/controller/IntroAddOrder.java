package co.edu.uptc.firstJavaWebApp.controller;

import java.io.IOException;

import co.edu.uptc.firstJavaWebApp.model.Customer;
import co.edu.uptc.firstJavaWebApp.model.CustomerList;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/introAddOrder")
public class IntroAddOrder extends HttpServlet {

    public IntroAddOrder() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/addOrder.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerList customerList = (CustomerList) req.getSession().getAttribute("customerList");
        try {
            String idParam = req.getParameter("order_idCustomer");
            if (idParam != null && !idParam.isEmpty()) {
                int id = Integer.parseInt(idParam);
                if (customerList != null) {
                    Customer customerFound = customerList.findCustomerById(id);
                    if (customerFound != null) {
                        req.setAttribute("customerFound", customerFound);
                    } else {
                        req.setAttribute("errorMessage", "El cliente que busca no existe");
                        req.setAttribute("homePage", req.getContextPath() + "/menu");
                        req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
                        return;
                    }
                } else {
                    System.out.println("hola no se están mostrando los clientes");
                }
            } else {
                req.setAttribute("errorMessage", "Error, ingrese el documento de identidad del cliente");
                req.setAttribute("homePage", req.getContextPath() + "/menu");
                req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
                return;
            }
        } catch (Exception e) {
            req.setAttribute("errorMessage", "Ocurrió un error al intentar acceder a la página de agregar cliente.");
            req.setAttribute("homePage", req.getContextPath() + "/menu");
            req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
            return;
        }
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/addOrder.jsp");
        rd.forward(req, resp);
    }
}
