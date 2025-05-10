package co.edu.uptc.firstJavaWebApp.controller;

import co.edu.uptc.firstJavaWebApp.model.EmployeeList;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/showEmployees")
public class ShowEmployees extends HttpServlet {

    public ShowEmployees() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        EmployeeList empList = (EmployeeList) session.getAttribute("employeelist");

        if (empList == null) {
            empList = new EmployeeList();
            session.setAttribute("employeelist", empList);
        }

        req.setAttribute("empleados", empList.getEmployeeList());

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/showEmployees.jsp");
        rd.forward(req, resp);
    }

}

