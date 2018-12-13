package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.slbase.core.Fecha;
import lombok.Data;
import org.vaadin.stefan.fullcalendar.Entry;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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

    public Agenda() {
        setEntry(new Entry());
    }

    public Entry getEntry(){
        String titulo = title;
        if(conductor != null && comisionista != null){
            titulo =  conductor.getNombre()+ " - " + comisionista.getNombre() + "\n "+ titulo;
        }

        return new Entry(
                getId() == null ? null :  getId().toString(),
                titulo,
                Fecha.toLocalDateTime(start),
                Fecha.toLocalDateTime(end),
                allDay,
                editable,
                color,description
        );

    }

    public void setEntry(Entry entry){
        title = entry.getTitle();
        start =  Fecha.toDate(entry.getStart());
        end = Fecha.toDate(entry.getEnd());
        allDay = entry.isAllDay();
        editable = entry.isEditable();
        color = entry.getColor();
        description = entry.getDescription();
    }

}
