package co.edu.uptc.firstJavaWebApp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/introaddemployee")
public class IntroAddEmployeeController extends HttpServlet{

    public IntroAddEmployeeController(){
        super();
    }
     @Override
     //GET se usa para pedir información, Muestra la información, responde a la petició de abrir la página en el navegador...
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //RequestDispatcher  toma la petición y la lleva a otra página sin cambiar la URL
        // con getRequestDispatcher está buscando esa otra página del servidor
         RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/addemployee.jsp");
         //lleva internamente a esa página, el navegador no cambia y la URL sigue igual
         rd.forward(req, resp);
         // resp.sendRedirect("/addemployee.jsp"); el navegador hace una petición a esa URL y la URL cambia, se usa cuando el usuario va a otra página
    }

    //POST se usa para enviar la información (rellenar formularios)
     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         try {
             RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/addemployee.jsp");
             rd.forward(req, resp);
         } catch (Exception e) {
             req.setAttribute("errorMessage", "Ocurrió un error al intentar acceder a la página de agregar empleado.");
             req.setAttribute("homePage", req.getContextPath() + "/menu");
             req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
         }
         // resp.sendRedirect(req.getContextPath());
    }

}
