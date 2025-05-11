package co.edu.uptc.firstJavaWebApp.controller;

import co.edu.uptc.firstJavaWebApp.model.CustomerList;
import co.edu.uptc.firstJavaWebApp.model.Order;
import co.edu.uptc.firstJavaWebApp.model.OrderList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/showOrder")
public class ShowOrder extends HttpServlet {

    public ShowOrder() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int customerId = Integer.parseInt(req.getParameter("customer_id"));

            CustomerList customerList = (CustomerList) req.getSession().getAttribute("customerlist");
            if (customerList == null || customerList.findCustomerById(customerId) == null) {
                req.setAttribute("errorMessage", "El cliente con ID " + customerId + " no existe.");
                req.setAttribute("homePage", req.getContextPath() + "/menu");
                req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
                return;
            }

            OrderList orderList = (OrderList) req.getSession().getAttribute("orderList");
            if (orderList == null) {
                req.setAttribute("errorMessage", "No se encontró la lista de pedidos.");
                req.setAttribute("homePage", req.getContextPath() + "/menu");
                req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
                return;
            }

            List<Order> customerOrders = new ArrayList<Order>();
            for (Order order : orderList.getOrderList()) {
                if (order.getIdCustomerOrder() == customerId) {
                    customerOrders.add(order);
                }
            }

            if (customerOrders.isEmpty()) {
                req.setAttribute("errorMessage", "No se encontraron pedidos para el cliente con ID " + customerId + ".");
                req.setAttribute("homePage", req.getContextPath() + "/menu");
                req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
            } else {
                req.setAttribute("orders", customerOrders);
                req.getRequestDispatcher("/WEB-INF/jsp/showOrder.jsp").forward(req, resp);
            }

        } catch (Exception e) {
            req.setAttribute("errorMessage", "Ocurrió un error al buscar los pedidos.");
            req.setAttribute("homePage", req.getContextPath() + "/menu");
            req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
        }
    }
}
