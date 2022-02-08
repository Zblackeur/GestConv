package tn.ipsas.gestconv.models.beans.utils;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ParticipantConventionId implements Serializable {
    private static final long serialVersionUID = -4422337507220095355L;
    @Column(name = "id_participant", nullable = false)
    private Integer idParticipant;
    @Column(name = "id_convention", nullable = false)
    private Integer idConvention;

    public Integer getIdConvention() {
        return idConvention;
    }

    public void setIdConvention(Integer idConvention) {
        this.idConvention = idConvention;
    }

    public Integer getIdParticipant() {
        return idParticipant;
    }

    public void setIdParticipant(Integer idParticipant) {
        this.idParticipant = idParticipant;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idParticipant, idConvention);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ParticipantConventionId entity = (ParticipantConventionId) o;
        return Objects.equals(this.idParticipant, entity.idParticipant) &&
                Objects.equals(this.idConvention, entity.idConvention);
    }
}