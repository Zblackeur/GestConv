package tn.ipsas.gestconv.utils;
import tn.ipsas.gestconv.models.beans.User;
import tn.ipsas.gestconv.models.beans.utils.RoleType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class AuthUtils {

    /**
     * Tester si l'utilisateur est authentifier
     */
    public static Boolean testAuth(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            request.setAttribute("errorMessage", "Connectez-vous d'abord!");
            request.getServletContext()
                    .getRequestDispatcher("/templates/login.jsp")
                    .forward(request, response);
            return false;
        }
        return true;
    }

    public static boolean isAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            request.setAttribute("errorMessage", "Connectez-vous d'abord!");
            request.getServletContext()
                    .getRequestDispatcher("/templates/login.jsp")
                    .forward(request, response);
            return false;
        }
        if (!Objects.equals(user.getRole(), String.valueOf(RoleType.ADMIN))){
            request.setAttribute("errorMessage", "Vous n'etes pas Administrateur");
            request.getServletContext()
                    .getRequestDispatcher("/templates/userNotAllow.jsp")
                    .forward(request, response);
            return false;
        }
        return true;
    }
}
