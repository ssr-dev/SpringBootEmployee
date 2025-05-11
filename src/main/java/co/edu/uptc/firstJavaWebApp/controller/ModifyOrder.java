package co.edu.uptc.firstJavaWebApp.controller;
import java.io.IOException;

import co.edu.uptc.firstJavaWebApp.model.Order;
import co.edu.uptc.firstJavaWebApp.model.OrderList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/modifyOrder")
public class ModifyOrder extends HttpServlet{

    public ModifyOrder(){
        super();
    }

    @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
        int id = Integer.parseInt(req.getParameter("order_id"));
        String description = req.getParameter("order_description");
        String orderStatus = req.getParameter("order_status");
        OrderList orderList = (OrderList) req.getSession().getAttribute("orderList");
        if (orderList == null) {
            req.setAttribute("errorMessage", "No se encontró la lista de pedidos.");
            req.setAttribute("homePage", req.getContextPath() + "/menu");
            req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
            return;
        }
        Order existingOrder = orderList.findOrderById(id); 
        if (existingOrder != null) {
            existingOrder.setDescriptionOrder(description);
            existingOrder.setOrderStatus(orderStatus);
            req.getSession().setAttribute("oper", "success");
            req.getSession().setAttribute("orderList", orderList);
            resp.sendRedirect(req.getContextPath() + "/confirm.html");
        } else {
            req.setAttribute("errorMessage", "Pedido no encontrado para modificar.");
            req.setAttribute("homePage", req.getContextPath() + "/menu");
            req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
        }

    } catch (Exception e) {
        req.setAttribute("errorMessage", "Ocurrió un error al intentar modificar el pedido.");
        req.setAttribute("homePage", req.getContextPath() + "/menu");
        req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
    }
}


}
