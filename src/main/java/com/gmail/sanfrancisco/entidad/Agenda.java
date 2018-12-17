package com.gmail.sanfrancisco.entidad;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.slbase.core.Fecha;
import org.vaadin.stefan.fullcalendar.Entry;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
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

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public boolean isAllDay() {
        return allDay;
    }

    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Entry.RenderingMode getRenderingMode() {
        return renderingMode;
    }

    public void setRenderingMode(Entry.RenderingMode renderingMode) {
        this.renderingMode = renderingMode;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public Comisionista getComisionista() {
        return comisionista;
    }

    public void setComisionista(Comisionista comisionista) {
        this.comisionista = comisionista;
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
