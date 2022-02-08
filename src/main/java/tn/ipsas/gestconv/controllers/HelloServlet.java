package tn.ipsas.gestconv.controllers;

import tn.ipsas.gestconv.models.beans.User;
import tn.ipsas.gestconv.models.beans.utils.TypeConventionType;
import tn.ipsas.gestconv.models.dao.ConventionDAO;
import tn.ipsas.gestconv.utils.AuthUtils;
import tn.ipsas.gestconv.utils.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "helloServlet", value = {"/","/index"})
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if ( !AuthUtils.testAuth(request, response) ) {
            // On arrete
            return;
        };
        request.setAttribute("typeConventions", TypeConventionType.values());

        String action = request.getParameter("action");
        List conventions = null;

        if ("recherche_simple".equals(action)) {
            // Si recherche simple
            String q = request.getParameter("q");
            request.setAttribute("q", q);
            conventions = ConventionDAO.search(q);
        } else {
            if ( "recherche_avancee".equals(action)){
                // recherche avancée
                String q = request.getParameter("q");
                request.setAttribute("q", q);
                String type_convention = request.getParameter("type_convention");
                request.setAttribute("type_convention", type_convention);
                conventions = ConventionDAO.advanced_search(q, type_convention);
            } else {
                //autre
                conventions = ConventionDAO.getAllConvention();
            }
        }

        request.setAttribute("conventions", conventions);
        request.getServletContext()
                .getRequestDispatcher("/templates/index.jsp")
                .forward(request, response);
    }
    public void destroy() {
    }
}