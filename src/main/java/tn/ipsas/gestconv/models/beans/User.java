package tn.ipsas.gestconv.models.beans;

import tn.ipsas.gestconv.models.beans.utils.RoleType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @Column(name = "username", nullable = false, length = 45)
    private String id;

    @Column(name = "password", nullable = false, length = 45)
    private String password;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    //    @Lob
//    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private String role;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}