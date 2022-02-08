package tn.ipsas.gestconv.controllers.conventions;

import tn.ipsas.gestconv.models.beans.Convention;
import tn.ipsas.gestconv.models.dao.ConventionDAO;
import tn.ipsas.gestconv.utils.AuthUtils;
import tn.ipsas.gestconv.utils.HibernateUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "delconv", value = "/admin/convention/suprimer")
public class DeleteConventionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/index");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idconv = Integer.parseInt(request.getParameter("idconv"));
        ConventionDAO.deleteConvention(
                (Convention) HibernateUtil.get(Convention.class, idconv)
        );
        request.setAttribute("errorMessage", "Convention id=" + idconv + " suprimer");
        response.sendRedirect("/index");
    }
}
