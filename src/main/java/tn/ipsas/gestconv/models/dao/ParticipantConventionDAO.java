package tn.ipsas.gestconv.models.dao;

import tn.ipsas.gestconv.models.beans.ParticipantConvention;
import tn.ipsas.gestconv.models.beans.utils.ParticipantConventionId;
import tn.ipsas.gestconv.utils.HibernateUtil;

import java.time.LocalDate;

public class ParticipantConventionDAO {
    /**
     *
     * @param idConvention : id de la convention
     * @param idParticipant : id du participant
     */
    public static void save(int idConvention, int idParticipant) {
        //
        ParticipantConvention participantConvention = new ParticipantConvention();

        //
        ParticipantConventionId participantConventionId = new ParticipantConventionId();
        participantConventionId.setIdConvention(idConvention);
        participantConventionId.setIdParticipant(idParticipant);

        //
        participantConvention.setId(participantConventionId);
        participantConvention.setDateSignature(LocalDate.now());

        //
        HibernateUtil.create(participantConvention);
    }

}
