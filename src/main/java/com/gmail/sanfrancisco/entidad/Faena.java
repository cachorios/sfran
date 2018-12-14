package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Usuario;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Faena extends AbstractEntidad {
    @NotNull
    private Date fecha;

    @NotNull
    private Integer numero;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "faena", fetch = FetchType.LAZY)
//    private List<FaenaProductor> faenaProductor;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private FaenaProductor faenaProductor;

    public Faena() {
        this.setFaenaProductor(new FaenaProductor());
    }

    public String toString() {
        return isNew() ? "Nueva Faena" : this.getFecha().toString();
    }

    @PrePersist
    @PreUpdate
    public void preUpdate(){
        return;

    }
}
