package co.edu.uptc.firstJavaWebApp.controller;

import java.io.IOException;

import co.edu.uptc.firstJavaWebApp.model.Employee;
import co.edu.uptc.firstJavaWebApp.model.EmployeeList;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/introModifyEmployee")
public class IntroModifyEmployee extends HttpServlet {

    public IntroModifyEmployee() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String idParam = req.getParameter("emp_id");
            if (idParam != null && !idParam.isEmpty()) {
                int id = Integer.parseInt(idParam);
                EmployeeList empList = (EmployeeList) req.getSession().getAttribute("employeelist");

                if (empList != null) {
                    Employee found = empList.findEmployeeById(id);
                    if (found != null) {
                        req.setAttribute("employeeFound", found);
                    }
                }
            }
        } catch (NumberFormatException e) {
            req.setAttribute("errorMessage", "Ocurrió un error al intentar modificar el empleado.");
            req.setAttribute("homePage", req.getContextPath() + "/menu");
            req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
        }
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/modifyEmployee.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/modifyEmployee.jsp");
        rd.forward(req, resp);
    }
}
