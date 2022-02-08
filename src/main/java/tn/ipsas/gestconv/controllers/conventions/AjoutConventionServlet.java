package tn.ipsas.gestconv.controllers.conventions;

import tn.ipsas.gestconv.models.beans.Convention;
import tn.ipsas.gestconv.models.beans.Participant;
import tn.ipsas.gestconv.models.beans.utils.TypeConventionType;
import tn.ipsas.gestconv.models.dao.ConventionDAO;
import tn.ipsas.gestconv.models.dao.ParticipantDAO;
import tn.ipsas.gestconv.utils.AuthUtils;
import tn.ipsas.gestconv.utils.HibernateUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ajoutConvention" , urlPatterns={"/convention/ajout"})
public class AjoutConventionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if ( !AuthUtils.testAuth(request, response) ) {
            // On arrete
            return;
        };
        if ( !AuthUtils.isAdmin(request, response) ) {
            // On arrete
            return;
        };

        request.setAttribute("participants", ParticipantDAO.getAll());
        request.setAttribute("typeConventions", TypeConventionType.values());
        request.getServletContext()
                .getRequestDispatcher("/templates/ajoutConvention.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
        if ( !AuthUtils.testAuth(request, response) ) {
            // On arrete
            return;
        };
        if ( !AuthUtils.isAdmin(request, response) ) {
            // On arrete
            return;
        };

        String errorMessage="";
        String[] participantsId = request.getParameterValues("participants_id");
        String titreConvention = request.getParameter("titre_convention");
        String typeConvention = request.getParameter("type_convention");
        String objetConvention = request.getParameter("objet_convention");
        LocalDate dateEntreeVigueur = LocalDate.parse(request.getParameter("date_entree_vigueur"));
        LocalDate dateExpiration = LocalDate.parse(request.getParameter("date_expiration"));

        List<Participant> listParticipants = new ArrayList<>();
        for (String p_Id:participantsId) {
            Participant p = (Participant) HibernateUtil.get(Participant.class, Integer.parseInt(p_Id));
            listParticipants.add(p);
        }

        Convention convention = new Convention();
        convention.setObjetConvention(objetConvention);
        convention.setTitreConvention(titreConvention);
        convention.setTypeConvention(typeConvention);
        convention.setDateEntreeVigueur(dateEntreeVigueur);
        convention.setDateExpiration(dateExpiration);

            try {
                convention.setDateEdition(LocalDate.now());
                ConventionDAO.saveConvention(convention, listParticipants);

                response.sendRedirect("/index");
                System.out.println("Sauvegarde réusie. Redirection vers la page d'acceuil!");
            } catch (Exception e) {
                errorMessage = e.getMessage();
                request.setAttribute("errorMessage", errorMessage);
                doGet(request, response);
                System.out.println("Message d'erreur !!!!!!");
            }
    }
}
