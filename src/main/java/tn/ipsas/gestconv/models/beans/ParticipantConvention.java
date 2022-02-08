package tn.ipsas.gestconv.models.beans;

import tn.ipsas.gestconv.models.beans.utils.ParticipantConventionId;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "participant_convention")
public class ParticipantConvention {
    @EmbeddedId
    private ParticipantConventionId id;

    @Column(name = "date_signature", nullable = false)
    private LocalDate dateSignature;

    public LocalDate getDateSignature() {
        return dateSignature;
    }

    public void setDateSignature(LocalDate dateSignature) {
        this.dateSignature = dateSignature;
    }

    public ParticipantConventionId getId() {
        return id;
    }

    public void setId(ParticipantConventionId id) {
        this.id = id;
    }
}