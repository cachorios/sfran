package com.gmail.cacho.backend.entidad;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

@MappedSuperclass
public abstract class AbstractEntidad implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private int version;

    @Column(name = "fechabaja")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date fechabaja;

    @Column(name = "usuarioalta")
    private String usuarioalta;

    @Column(name = "fechaalta")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date fechaalta;

    @Column(name = "usuarioumod")
    private String usuarioumod;

    @Column(name = "fechaumod")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date fechaumod;

    public Long getId() {
        return id;
    }

    protected void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if(this.id == null) {
            return false;
        }

        if (obj instanceof AbstractEntidad && obj.getClass().equals(getClass())) {
            return this.id.equals(((AbstractEntidad) obj).id);
        }

        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @PrePersist
    protected void setAltaData() {
        String username = "TEST"; //Sistema.getSistema().getSecurityControl().getNombreDeUsuarioActivo();
        usuarioalta = usuarioumod = "TEST"; //(username == null) ? Constantes.SYS_CAD_UNSESION : username;
        fechaalta = fechaumod = Date.from(Instant.now());
    }

    @PreUpdate
    protected void setUmodData() {
        String username = "TEST"; //Sistema.getSistema().getSecurityControl().getNombreDeUsuarioActivo();
        usuarioalta = usuarioumod =  "TEST";  //(username == null) ? Constantes.SYS_CAD_UNSESION : username;
        fechaumod = Date.from(Instant.now());
    }
}
