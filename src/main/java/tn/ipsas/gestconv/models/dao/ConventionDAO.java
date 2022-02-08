package tn.ipsas.gestconv.models.dao;

import org.hibernate.Session;
import tn.ipsas.gestconv.models.beans.Convention;
import tn.ipsas.gestconv.models.beans.Participant;
import tn.ipsas.gestconv.models.beans.ParticipantConvention;
import tn.ipsas.gestconv.utils.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Objects;

public class ConventionDAO {

    /**
     * @param convention :convention à enregistrer
     * @param participants : Liste de participant qui participent a la convention
     */
    public static void saveConvention(Convention convention,
                                      List<Participant> participants) {
        int convention_id = (int) HibernateUtil.create(convention);
        for (Participant participant : participants) {
            // Enregistrement dans la table participant convention
            ParticipantConventionDAO.save(
                    convention_id,
                    participant.getId()
            );
        }
    }

    /**
     * Mise a jour d'une convention
     *
     * @param convention Convention
     */
    public static void updateConvention(Convention convention) {
        HibernateUtil.update(convention);
    }

    /**
     * Suprimme la conventions passée en paramètre
     *
     * @param convention Objet Convention
     */
    public static void deleteConvention(Convention convention) {
        List<ParticipantConvention> participantConventions =(List<ParticipantConvention>) HibernateUtil.getAll(ParticipantConvention.class);

        for (ParticipantConvention pc : participantConventions) {
            if (Objects.equals(pc.getId().getIdConvention(), convention.getId())) {
                HibernateUtil.delete(pc);
            }
        }
        HibernateUtil.delete(convention);
    }

    /**
     * Get Convention By ID
     */
    public static Convention getConvention(int id) {
        return (Convention) HibernateUtil.get(Convention.class, id);
    }

    /**
     * Get all Conventions
     *
     * @return La liste de toutes les conventions.
     */
    public static List getAllConvention() {
        return HibernateUtil.getAll(Convention.class);
    }

    public static List<Convention> search(String q) {
        List<Convention> listOfConvention = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Convention> query = builder.createQuery(Convention.class);
        Root<Convention> root = query.from(Convention.class);
        query.select(root).where(
                builder.like(root.get("objetConvention"), "%" + q + "%")
        );
        listOfConvention = session.createQuery(query).getResultList();

        return listOfConvention;
    }


    public static List<Convention> advanced_search(String q, String type) {
        List<Convention> listOfConvention = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Convention> query = builder.createQuery(Convention.class);
        Root<Convention> root = query.from(Convention.class);
        query.select(root).where(
                builder.like(root.get("objetConvention"), "%" + q + "%")
        ).where(builder.like(root.get("typeConvention"), type));
        listOfConvention = session.createQuery(query).getResultList();

        return listOfConvention;
    }
}

