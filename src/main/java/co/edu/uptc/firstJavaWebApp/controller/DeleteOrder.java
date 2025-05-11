package co.edu.uptc.firstJavaWebApp.controller;

import java.io.IOException;

import co.edu.uptc.firstJavaWebApp.model.OrderList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteOrder")
public class DeleteOrder extends HttpServlet{
    public DeleteOrder(){
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("order_id"));
        OrderList orderList = (OrderList) req.getSession().getAttribute("orderList");

        if (orderList != null) {
            boolean deleted = orderList.deleteOrder(id);
            if (deleted) {
                resp.sendRedirect(req.getContextPath() + "/confirm.html");
            } else {
                req.setAttribute("errorMessage", "Pedido no encontrado");
                req.setAttribute("homePage", req.getContextPath() + "/menu");
                req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("errorMessage", "La lista de pedidos está vacía");
            req.setAttribute("homePage", req.getContextPath() + "/menu");
            req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
        }
        } catch (Exception e) {
            req.setAttribute("errorMessage", "Ocurrió un error al intentar eliminar el pedido.");
        req.setAttribute("homePage", req.getContextPath() + "/menu");
        req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
        }
    }

}
