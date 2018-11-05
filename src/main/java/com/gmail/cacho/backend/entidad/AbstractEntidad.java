package com.gmail.cacho.backend.entidad;


import com.gmail.cacho.slapi.Sistema;
import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slbase.core.Constantes;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@MappedSuperclass
public abstract class AbstractEntidad implements Serializable, Cloneable {

    @Id
    @TableGenerator(name = "tabgen", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tabgen")
    private Long id;

    @Version
    private int version;

    @Column(name="fechabaja")
    @Temporal(value = TemporalType.TIMESTAMP)
//    @Convert(converter = LocalDateConverter.class)
    private Date fechabaja;

    @Column
    private String usuarioalta;

    @Column(name="fechaalta")
    @Temporal(value = TemporalType.TIMESTAMP)
//    @Convert(converter = LocalDateConverter.class)
    private Date fechaalta;

    @Column
    private String usuarioumod;

    @Column(name="fechaumod")
    @Temporal(value = TemporalType.TIMESTAMP)
//    @Convert(converter = LocalDateConverter.class)
    private Date fechaumod;

    public Long getId() {
        return id;
    }

    protected void setId(Long id) {
        this.id = id;
    }


    //    @PrePersist
    protected void setAltaData() {
        String username = Sistema.getSistema().getSecurityControl().getNombreDeUsuarioActivo();
        usuarioalta = usuarioumod = (username == null) ? Constantes.SYS_CAD_UNSESION : username;
        fechaalta = fechaumod = Date.from(Instant.now());
    }

//    @PreUpdate
    protected void setUmodData() {
        String username = Sistema.getSistema().getSecurityControl().getNombreDeUsuarioActivo();
        usuarioalta = usuarioumod =  (username == null) ? Constantes.SYS_CAD_UNSESION : username;
        fechaumod = Date.from(Instant.now());
    }

    public boolean isNew() {
        return (id == null);
    }

    public String toSimpleString() {
        return (isNew() ? C.SYS_CAD_NEW : toString());
    }

    public Date getFechaumod() {
        return fechaumod;
    }

    public void setFechaumod(Date fechaumod) {
        this.fechaumod = fechaumod;
    }
}
