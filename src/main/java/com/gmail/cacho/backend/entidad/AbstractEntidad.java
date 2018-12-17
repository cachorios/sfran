package com.gmail.cacho.backend.entidad;



import com.gmail.cacho.slapi.comunes.C;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@MappedSuperclass
public abstract class AbstractEntidad implements Serializable {

    @Id
    @TableGenerator(name = "tabgen", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tabgen")
    private Long id;


    @Version
    private int version;

    @Column(name="fechabaja")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date fechabaja;

    @Column
    private String usuarioalta;

    @Column(name="fechaalta")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date fechaalta;

    @Column
    private String usuarioumod;

    @Column(name="fechaumod")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date fechaumod;

    public Long getId() {
        return id;
    }

    protected void setId(Long id) {
        this.id = id;
    }


//    @PrePersist
    protected void setAltaData() {
//        String username = Sistema.getSistema().getSecurityControl().getNombreDeUsuarioActivo();
//        usuarioalta = usuarioumod = (username == null) ? Constantes.SYS_CAD_UNSESION : username;
//        fechaalta = fechaumod = Date.from(Instant.now());
    }

//    @PreUpdate
    protected void setUmodData() {
//        String username = Sistema.getSistema().getSecurityControl().getNombreDeUsuarioActivo();
//        usuarioalta = usuarioumod =  (username == null) ? Constantes.SYS_CAD_UNSESION : username;
//        fechaumod = Date.from(Instant.now());
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

    @Override
    public boolean equals(Object other) {
        return ((id == null) ? super.equals(other)
                : (this == other || ((other instanceof AbstractEntidad) && id.equals(((AbstractEntidad) other).getId()))));
    }

    @Override
    public int hashCode() {
        return (43 * 5 + (getId() == null ? 0 : getId().hashCode()));
    }
}
