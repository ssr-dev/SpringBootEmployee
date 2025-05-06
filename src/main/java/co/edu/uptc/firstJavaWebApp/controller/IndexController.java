package co.edu.uptc.firstJavaWebApp.controller;

import co.edu.uptc.firstJavaWebApp.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/index")
public class IndexController extends HttpServlet {

    public IndexController() {
        super();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");

            if (user.checkUserInput(username, password)) {
                resp.sendRedirect(req.getContextPath() + "/menu");
            } else {
                req.setAttribute("errorMessage", "Usuario o contraseña incorrectos.");
                req.setAttribute("homePage", req.getContextPath() + "/index");
                req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            req.setAttribute("errorMessage", "Ocurrió un error inesperado. Intente de nuevo.");
            req.setAttribute("homePage", req.getContextPath() + "/index");
            req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
        }
    }
}

