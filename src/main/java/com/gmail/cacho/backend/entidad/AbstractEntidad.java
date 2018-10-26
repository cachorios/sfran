package com.gmail.cacho.backend.entidad;

import com.gmail.cacho.backend.jpa.convert.LocalDateConverter;
import com.gmail.cacho.slapi.comunes.C;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

@MappedSuperclass
public abstract class AbstractEntidad implements Serializable, Cloneable {

    @Id
    @TableGenerator(name = "tabgen", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private int version;

    @Column
//    @Temporal(value = TemporalType.TIMESTAMP)
    @Convert(converter = LocalDateConverter.class)
    private LocalDate fechabaja;

    @Column
    private String usuarioalta;

    @Column
//    @Temporal(value = TemporalType.TIMESTAMP)
    @Convert(converter = LocalDateConverter.class)
    private LocalDate fechaalta;

    @Column
    private String usuarioumod;

    @Column
//    @Temporal(value = TemporalType.TIMESTAMP)
    @Convert(converter = LocalDateConverter.class)
    private LocalDate fechaumod;

    public Long getId() {
        return id;
    }

    protected void setId(Long id) {
        this.id = id;
    }


//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if(this.id == null) {
//            return false;
//        }
//
//        if (obj instanceof AbstractEntidad && obj.getClass().equals(getClass())) {
//            return this.id.equals(((AbstractEntidad) obj).id);
//        }
//
//        return false;
//    }

    @Override
    public boolean equals(Object other) {
        return ((id == null) ? super.equals(other)
                : (this == other || ((other instanceof AbstractEntidad) && id.equals(((AbstractEntidad) other).getId()))));
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
        fechaalta = fechaumod = LocalDate.from(Instant.now());
    }

    @PreUpdate
    protected void setUmodData() {
        String username = "TEST"; //Sistema.getSistema().getSecurityControl().getNombreDeUsuarioActivo();
        usuarioalta = usuarioumod =  "TEST";  //(username == null) ? Constantes.SYS_CAD_UNSESION : username;
        fechaumod = LocalDate.from(Instant.now());
    }

    public boolean isNew() {
        return (id == null);
    }

    public String toSimpleString() {
        return (isNew() ? C.SYS_CAD_NEW : toString());
    }

    public LocalDate getFechaumod() {
        return fechaumod;
    }

    public void setFechaumod(LocalDate fechaumod) {
        this.fechaumod = fechaumod;
    }
}
