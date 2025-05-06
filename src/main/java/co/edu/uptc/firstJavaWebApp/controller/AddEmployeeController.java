package co.edu.uptc.firstJavaWebApp.controller;

import java.io.IOException;
import co.edu.uptc.firstJavaWebApp.model.Employee;
import co.edu.uptc.firstJavaWebApp.model.EmployeeList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addemployee")
public class AddEmployeeController extends HttpServlet {

    public AddEmployeeController() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            EmployeeList empList = (EmployeeList) req.getSession().getAttribute("employeelist");

            if (empList == null) {
                empList = new EmployeeList();
                req.getSession().setAttribute("employeelist", empList);
            }

            int id = Integer.parseInt(req.getParameter("emp_id"));

            if (empList.isIdAvailable(id)) {
                String name = req.getParameter("emp_name");
                String email = req.getParameter("emp_email");
                long phone = Long.parseLong(req.getParameter("emp_phone"));
                Employee emp = new Employee(id, name, email, phone);

                empList.addEmployee(emp);
                req.getSession().setAttribute("oper", "success");

                resp.sendRedirect(req.getContextPath() + "/confirm.html");
            } else {
                req.setAttribute("errorMessage", "El ID del empleado ya existe.");
                req.setAttribute("homePage", req.getContextPath() + "/menu");
                req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            req.setAttribute("errorMessage", "Ocurrió un error inesperado al agregar el empleado.");
            req.setAttribute("homePage", req.getContextPath() + "/menu");
            req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
        }
    }
}

