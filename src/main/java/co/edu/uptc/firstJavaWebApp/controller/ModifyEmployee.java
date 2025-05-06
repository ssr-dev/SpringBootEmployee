package co.edu.uptc.firstJavaWebApp.controller;

import java.io.IOException;

import co.edu.uptc.firstJavaWebApp.model.Employee;
import co.edu.uptc.firstJavaWebApp.model.EmployeeList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/modifyEmployee")
public class ModifyEmployee extends HttpServlet {

    public ModifyEmployee() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("emp_id"));
            String name = req.getParameter("emp_name");
            String email = req.getParameter("emp_email");
            long phone = Long.parseLong(req.getParameter("emp_phone"));
            Employee emp = new Employee();
            emp.setId(id);
            emp.setName(name);
            emp.setEmail(email);
            emp.setPhone(phone);
            EmployeeList empList = (EmployeeList) req.getSession().getAttribute("employeelist");

            if (empList == null) {
                req.setAttribute("errorMessage", "No se encontró la lista de empleados.");
                req.setAttribute("homePage", req.getContextPath() + "/menu");
                req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
                return;
            }

            boolean searchEmployee = empList.modifyEmployee(emp);
            if (searchEmployee) {
                req.getSession().setAttribute("oper", "success");
                req.getSession().setAttribute("employeelist", empList);
                resp.sendRedirect(req.getContextPath() + "/confirm.html");
            } else {
                req.setAttribute("errorMessage", "Empleado no encontrado para modificar.");
                req.setAttribute("homePage", req.getContextPath() + "/menu");
                req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            req.setAttribute("errorMessage", "Ocurrió un error al intentar modificar el empleado.");
            req.setAttribute("homePage", req.getContextPath() + "/menu");
            req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
        }
    }
}
