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

@WebServlet("/introModifyCustomer")
public class IntroModifyCustomer extends HttpServlet{

    public IntroModifyCustomer(){
        super();
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String idParam = req.getParameter("cust_id");
            if (idParam != null && idParam.isEmpty()){
                int id = Integer.parseInt(idParam);
                CustomerList customerList = (CustomerList) req.getSession().getAttribute("customerList");
                if (customerList != null){
                    Customer customerFound = customerList.findCustomerById(id);
                    if (customerFound != null){
                        req.setAttribute("customerFound", customerFound);
                    }else {
                        req.setAttribute("errorMessage", "El cliente que busca no existe");
                        req.setAttribute("homePage", req.getContextPath()+"/menu");
                        req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
                    }
                }
            }
        }catch(Exception e){
            req.setAttribute("errorMessage", "Ocurrió un error al intentar modificar el cliente.");
            req.setAttribute("homePage", req.getContextPath() + "/menu");
            req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
        }
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/jsp/modifyCustomer.jsp");
        rd.forward(req, resp);
    }

     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/jsp/modifyCustomer.jsp");
        rd.forward(req, resp);
    }

}
