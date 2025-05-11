package co.edu.uptc.firstJavaWebApp.controller;

import java.io.IOException;
import java.util.List;

import co.edu.uptc.firstJavaWebApp.model.Order;
import co.edu.uptc.firstJavaWebApp.model.OrderList;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/introShowOrder")
public class IntroShowOrder extends HttpServlet {

    public IntroShowOrder() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/showOrder.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String customerIdParam = req.getParameter("customer_id");
        HttpSession session = req.getSession();
        OrderList orderList = (OrderList) session.getAttribute("orderList");

        if (customerIdParam != null && !customerIdParam.isEmpty() && orderList != null) {
            try {
                int customerId = Integer.parseInt(customerIdParam);
                List<Order> foundOrders = orderList.findOrdersByCustomerId(customerId);
                req.setAttribute("orders", foundOrders);
            } catch (NumberFormatException e) {
                // Puedes agregar un mensaje de error si lo deseas
                req.setAttribute("orders", null);
            }
        } else {
            req.setAttribute("orders", null);
        }

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/showOrder.jsp");
        rd.forward(req, resp);
    }
}
