package tn.ipsas.gestconv.controllers.conventions;

import tn.ipsas.gestconv.models.beans.Convention;
import tn.ipsas.gestconv.models.dao.ConventionDAO;
import tn.ipsas.gestconv.utils.AuthUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DetailConventionServlet", value = "/convention/detail")
public class DetailConventionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if ( !AuthUtils.testAuth(request, response) ) {
            // On arrete
            return;
        };

        int idconv = Integer.parseInt(request.getParameter("idconv"));
        Convention convention = ConventionDAO.getConvention(idconv);
        request.setAttribute("convention", convention);
        request.getServletContext()
                .getRequestDispatcher("/templates/detailConvention.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
