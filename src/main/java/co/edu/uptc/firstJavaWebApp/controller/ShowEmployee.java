package co.edu.uptc.firstJavaWebApp.controller;

import co.edu.uptc.firstJavaWebApp.model.Employee;
import co.edu.uptc.firstJavaWebApp.model.EmployeeList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/showEmployee")
public class ShowEmployee extends HttpServlet {

    public ShowEmployee() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("emp_id"));
            EmployeeList empList = (EmployeeList) req.getSession().getAttribute("employeelist");

            if (empList == null || empList.findEmployeeById(id) == null) {
                req.setAttribute("errorMessage", "Empleado no encontrado.");
                req.setAttribute("homePage", req.getContextPath() + "/menu");
                req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
            } else {
                Employee emp = empList.findEmployeeById(id);
                req.setAttribute("empleado", emp);
                req.getRequestDispatcher("/WEB-INF/jsp/showEmployee.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            req.setAttribute("errorMessage", "Ocurrió un error al buscar el empleado.");
            req.setAttribute("homePage", req.getContextPath() + "/menu");
            req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
        }
    }
}
