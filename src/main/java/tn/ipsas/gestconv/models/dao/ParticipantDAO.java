package tn.ipsas.gestconv.models.dao;

import tn.ipsas.gestconv.models.beans.Participant;
import tn.ipsas.gestconv.utils.HibernateUtil;

import java.util.List;

public class ParticipantDAO {

    /**
     * @param participant Save Participant
     */
    public static void saveParticipant(Participant participant) {
        HibernateUtil.create(participant);
    }
    public static List getAll(){
       return HibernateUtil.getAll(Participant.class);
    }
}

