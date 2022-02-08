package tn.ipsas.gestconv.utils;
import tn.ipsas.gestconv.models.beans.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthUtils {
    /**
     * Return either user is authenticated or none
     */
    public static Boolean  isAuthenticated(HttpServletRequest request){
        User user = (User) request.getSession(true).getAttribute("user");
        return user != null;
    }
    public static Boolean redirectToLoginIsNotLogin(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        if (!isAuthenticated(req)){
            req.getServletContext().setAttribute("message", "Veuillez vous connecté d'abord. ");
            req.getServletContext()
                        .getRequestDispatcher("/templates/login.jsp")
                        .forward(req, res);
            return true;
        }
        return false;
    }
    public static Boolean isAdmin(HttpServletRequest req, HttpServletResponse res, String s){

        if (isAuthenticated(req)){
            User user = (User) req.getSession(true).getAttribute("user");
            return "ADMIN".equals(user.getRole());
        }
        return false;
    }
    public static Boolean deniedAccessIfNotAdmin(HttpServletRequest req, HttpServletResponse res, String s) throws IOException, ServletException {
        redirectToLoginIsNotLogin(req, res);
        if(isAdmin(req, res, s)){
            res.sendRedirect(s);
            return false;
        }
        return true;
    }

    public static User login(String username, String password) {
        return null;
    }
}
