package co.edu.uptc.firstJavaWebApp.controller;

import java.io.IOException;

import co.edu.uptc.firstJavaWebApp.model.Customer;
import co.edu.uptc.firstJavaWebApp.model.Order;
import co.edu.uptc.firstJavaWebApp.model.OrderList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addOrder")
public class AddOrder extends HttpServlet{

    public AddOrder(){
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            OrderList orderlist = (OrderList) req.getSession().getAttribute("orderList");
            if (orderlist == null){
                orderlist = new OrderList();
                req.getSession().setAttribute("orderList", orderlist);
            }
            int idOrder = orderlist.generateUniqueId();
            Customer customerOrder = (Customer) req.getSession().getAttribute("customerFound");
            int idCustomer = Integer.parseInt(req.getParameter("order_idCustomer"));
            String dateOrder = req.getParameter("order_dateOrder");
            String descriptionOrder = req.getParameter("order_description");
            String orderStatus = "Creado";
            Order ord = new Order(idOrder, idCustomer, dateOrder, descriptionOrder, orderStatus);
            orderlist.addOrder(ord);
            req.getSession().setAttribute("oper", "success");
            req.setAttribute("errorMessage", "El pedido se ha agregado, el id del pedido es: "+idOrder);
            req.setAttribute("homePage", req.getContextPath() + "/menu");
            req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);

        } catch (Exception e) {
            req.setAttribute("errorMessage", "Ocurrió un error inesperado al crear un pedido.");
            req.setAttribute("homePage", req.getContextPath() + "/menu");
            req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
        }
    }


}
