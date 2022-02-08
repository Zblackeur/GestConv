package tn.ipsas.gestconv.models.beans;

import javax.persistence.*;

@Entity
@Table(name = "participant")
public class Participant {
    @Id
    @Column(name = "id_participant", nullable = false)
    private Integer id;

    @Column(name = "nom_participant", nullable = false, length = 45)
    private String nomParticipant;

    public void setTypeParticipant(String typeParticipant) {
        this.typeParticipant = typeParticipant;
    }

    //    @Lob
//    @Enumerated(EnumType.STRING)
    @Column(name = "type_participant", nullable = false)
    private String typeParticipant;

    @OneToOne(optional = false)
    @JoinColumn(name = "User_username", nullable = false)
    private User user;


    public String getNomParticipant() {
        return nomParticipant;
    }

    public void setNomParticipant(String nomParticipant) {
        this.nomParticipant = nomParticipant;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}