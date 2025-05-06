package co.edu.uptc.firstJavaWebApp.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/menu")
public class MenuController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/menu.jsp").forward(req, resp);
        }

        //HttpServletRequest
        // - Saber que datos mandaron, de qué página - reenviar la petición a otra página
        
        // HttpServletResponse
        // - Mandar información de vuelta al navegador  -decidir el tipo del contenido a enviar - Redireccionar a otra página -Escribir directamente al navegador 

}
 