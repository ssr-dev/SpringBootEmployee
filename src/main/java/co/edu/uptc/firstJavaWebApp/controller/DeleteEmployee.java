package co.edu.uptc.firstJavaWebApp.controller;

import java.io.IOException;

import co.edu.uptc.firstJavaWebApp.model.EmployeeList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteEmployee")
public class DeleteEmployee extends HttpServlet {

    public DeleteEmployee() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("emp_id"));
            EmployeeList empList = (EmployeeList) req.getSession().getAttribute("employeelist");

            if (empList != null) {
                boolean deleted = empList.deleteEmployee(id);
                if (deleted) {
                    resp.sendRedirect(req.getContextPath() + "/confirm.html");
                } else {
                    req.setAttribute("errorMessage", "Empleado no encontrado o no se pudo eliminar.");
                    req.setAttribute("homePage", req.getContextPath() + "/menu");
                    req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
                }
            }
        } catch (Exception e) {
            req.setAttribute("errorMessage", "Ocurrió un error al intentar eliminar el empleado.");
            req.setAttribute("homePage", req.getContextPath() + "/menu");
            req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
        }
    }
}

