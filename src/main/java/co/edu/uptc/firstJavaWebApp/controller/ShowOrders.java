package co.edu.uptc.firstJavaWebApp.controller;

import java.io.IOException;

import co.edu.uptc.firstJavaWebApp.model.OrderList;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/showOrders")
public class ShowOrders extends HttpServlet{

    public ShowOrders(){
        super();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderList orderList = (OrderList) req.getSession().getAttribute("orderList");
        if (orderList == null){
            orderList = new OrderList();
            req.getSession().setAttribute("orderList", orderList);
        }
        req.setAttribute("orders", orderList.getOrderList());
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/showAllOrder.jsp");
        rd.forward(req, resp);
    }

}
