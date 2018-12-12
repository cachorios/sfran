package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.slbase.core.Fecha;
import lombok.Data;
import org.vaadin.stefan.fullcalendar.Entry;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.ZoneId;
import java.util.Date;

@Entity
@Data
public class Agenda extends AbstractEntidad {
    private boolean editable;
    private String title;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date start;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date end;
    private boolean allDay;
    private String color;
    private String description;
    private Entry.RenderingMode renderingMode;

    @ManyToOne
    private Conductor conductor;

    @ManyToOne
    private Comisionista comisionista;


    public Entry getEntry(){

        return new Entry(
                getId().toString(),
                title,
                start.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                end.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                allDay,
                editable,
                color,description
        );
    }

}
