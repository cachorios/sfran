package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Parametro;
import com.gmail.cacho.backend.entidad.Usuario;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public @Data class Conductor extends AbstractEntidad {
    @NotNull
    @Size(min=3, max=60, message="El nombre debe contener entre 3 y 60 caracteres.")
//    @Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
    private String nombre;

    @NotNull
    @Size(min=11, max=11, message="El cuil debe contener 11 caracteres.")
    private String cuil;

    @NotNull
    @Size(min=5, max=11, message="El dni debe contener entre 5 y 11 caracteres.")
    private String dni;

    @NotNull
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date fechaNacimiento;

    @Size(min=6, max=20, message="El telefono debe contener entre 6 y 20 caracteres.")
    private String telefono;

    @NotNull
    @Size(min=6, max=20, message="El celular debe contener entre 6 y 20 caracteres.")
    private String celular;

    @NotNull
    @ManyToOne
    private Parametro operadoraTelefonica;

    @NotNull
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date fechaIngreso;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conductor", fetch = FetchType.LAZY)
    private List<Licencia> licencias;


    @ManyToOne
    private Usuario usuario;

    public Conductor() {
        licencias = new ArrayList<>();
    }

    public void setLicencias(List<Licencia> licencias) {
        this.licencias = licencias;
    }

    @PrePersist
    @PreUpdate
    public void preUpdate(){
        for(Licencia lic: licencias){
            if(lic.getConductor() == null){
                lic.setConductor(this);
            }
        }
    }

    @Override
    public String toString() {
        String leyenda = "Nuevo Conductor";
        if(!isNew()){
            leyenda = getNombre();
        }
        return leyenda;
    }
}
