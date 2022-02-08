package tn.ipsas.gestconv.controllers.auth;

import tn.ipsas.gestconv.models.beans.User;
import tn.ipsas.gestconv.models.dao.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TestServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext()
                .getRequestDispatcher("/templates/login.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = UserDAO.getUser(username);
        if(user != null && user.getPassword().equals(password)) {
            // Authentification success

            request.getSession(true)
                    .setAttribute("user", user);
            request.getSession().setAttribute("successMessage", user.getId() + " , bienvenue !");

            response.sendRedirect("/index");

        } else {
            request.setAttribute("errorMessage", "Nom d'utilisateur ou mots de passe invalide");
            request.setAttribute("username", username);
            doPost(request, response);
        }
    }
}
