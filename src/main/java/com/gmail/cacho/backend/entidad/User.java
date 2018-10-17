package com.gmail.cacho.backend.entidad;


import javax.persistence.*;

@Entity
//@NamedQuery(
//        name = User.FILTERED_FETCH_ROLES,
//        query = "SELECT e FROM User e LEFT JOIN FETCH e.roles " +
//                "WHERE e.username like :filter")
@Table(name = "user")
public class User extends AbstractEntidad {
    public static final String FILTERED_FETCH_ROLES = "filteredFetchRoles";

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String salt;
    private String hash;

    @Version
    private int version;

    @Override
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }


}
