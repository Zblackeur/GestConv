package tn.ipsas.gestconv.models.beans;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "convention")
public class Convention {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_convention", nullable = false)
    private Integer id;

    @Column(name = "date_edition", nullable = false)
    private LocalDate dateEdition;

    @Column(name = "date_entree_vigueur", nullable = false)
    private LocalDate dateEntreeVigueur;

    @Column(name = "date_expiration", nullable = false)
    private LocalDate dateExpiration;

    @Column(name = "objet_convention", nullable = false, length = 255)
    private String objetConvention;

    @Column(name = "titre_convention", nullable = false)
    private String titreConvention;

    @Column(name = "type_convention", length = 45)
    private String typeConvention;

    public String getTypeConvention() {
        return typeConvention;
    }

    public void setTypeConvention(String typeConvention) {
        this.typeConvention = typeConvention;
    }

    public String getTitreConvention() {
        return titreConvention;
    }

    public void setTitreConvention(String titreConvention) {
        this.titreConvention = titreConvention;
    }

    public String getObjetConvention() {
        return objetConvention;
    }

    public void setObjetConvention(String objetConvention) {
        this.objetConvention = objetConvention;
    }

    public LocalDate getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(LocalDate dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public LocalDate getDateEntreeVigueur() {
        return dateEntreeVigueur;
    }

    public void setDateEntreeVigueur(LocalDate dateEntreeVigueur) {
        this.dateEntreeVigueur = dateEntreeVigueur;
    }

    public LocalDate getDateEdition() {
        return dateEdition;
    }

    public void setDateEdition(LocalDate dateEdition) {
        this.dateEdition = dateEdition;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}