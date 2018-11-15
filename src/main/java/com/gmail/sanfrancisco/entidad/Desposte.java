package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.entidad.Usuario;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public @Data class Desposte extends AbstractEntidad {
//    @Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
@NotNull
private Date fecha;
}
