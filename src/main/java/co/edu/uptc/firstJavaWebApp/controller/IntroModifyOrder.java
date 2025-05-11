package co.edu.uptc.firstJavaWebApp.controller;

import java.io.IOException;

import co.edu.uptc.firstJavaWebApp.model.Order;
import co.edu.uptc.firstJavaWebApp.model.OrderList;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/introModifyOrder")
public class IntroModifyOrder extends HttpServlet{

    public IntroModifyOrder(){
        super();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String idOrderParam = req.getParameter("order_id");
            if (idOrderParam != null && !idOrderParam.isEmpty()){
                int idOrder = Integer.parseInt(idOrderParam);
                OrderList orderList = (OrderList) req.getSession().getAttribute("orderList");
                if (orderList != null){
                    Order orderFound = orderList.findOrderById(idOrder);
                    if (orderFound != null){
                        req.setAttribute("orderFound", orderFound);
                    }else {
                    req.setAttribute("errorMessage", "El pedido que busca no existe");
                    req.setAttribute("homePage", req.getContextPath()+"/menu");
                    req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
                    return;
                    }
                }
            }
        } catch (NumberFormatException e) {
            req.setAttribute("errorMessage", "Ocurrió un error al intentar modificar el pedido");
            req.setAttribute("homePage", req.getContextPath() + "/menu");
            req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
            return;
        }
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/jsp/editOrder.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/jsp/editOrder.jsp");
        rd.forward(req, resp);
    }

}
