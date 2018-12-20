package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FaenaProductor extends AbstractEntidad {
    @NotNull
    @ManyToOne
    private Productor productor;

    @ManyToOne
    private Dte tropa;

//    @ManyToOne
//    private Faena faena;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "faenaProductor", fetch = FetchType.LAZY)
    private List<FaenaCabezera> faenaCabezera;

    public FaenaProductor() {
        faenaCabezera = new ArrayList<>();
    }

    public Productor getProductor() {
        return productor;
    }

    public void setProductor(Productor productor) {
        this.productor = productor;
    }

    public Dte getTropa() {
        return tropa;
    }

    public void setTropa(Dte tropa) {
        this.tropa = tropa;
    }

    public List<FaenaCabezera> getFaenaCabezera() {
        return faenaCabezera;
    }

    public void setFaenaCabezera(List<FaenaCabezera> faenaCabezera) {
        this.faenaCabezera = faenaCabezera;
    }

    @Override
    public String toString() { return isNew() ? "Nuevo Faena-Productor" : this.productor.toString(); }

    @Override
    @PrePersist
    protected void setAltaData() {
        super.setAltaData();
        faenaCabezera.forEach(cabezera ->
        {
            if(cabezera.getCantidad() == null){
                cabezera.setCantidad(0);
            }
            cabezera.setFaenaProductor(this);
        } );
    }

    @Override
    @PreUpdate
    protected void setUmodData() {
        super.setUmodData();
        faenaCabezera.forEach(cabezera ->
            {
                if(cabezera.getCantidad() == null){
                    cabezera.setCantidad(0);
                }
            cabezera.setFaenaProductor(this);
        } );
    }
}
