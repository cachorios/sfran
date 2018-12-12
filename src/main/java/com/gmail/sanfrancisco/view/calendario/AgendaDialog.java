package com.gmail.sanfrancisco.view.calendario;

import com.gmail.cacho.slbase.core.Fecha;
import com.gmail.sanfrancisco.entidad.Agenda;
import com.gmail.sanfrancisco.repositorio.AgendaRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.dom.ThemeList;
import org.vaadin.stefan.fullcalendar.Entry;
import org.vaadin.stefan.fullcalendar.FullCalendar;

import javax.enterprise.inject.spi.CDI;

public class AgendaDialog  extends Dialog {
    private static final String[] COLORS = {"tomato", "orange", "dodgerblue", "mediumseagreen", "gray", "slateblue", "violet"};
    private AgendaRepository repository;
    AgendaDialog(FullCalendar calendar, Entry entry, boolean newInstance) {

        Agenda agendaEntry;
        repository = CDI.current().select(AgendaRepository.class).get();

        if(newInstance ){
            agendaEntry = new Agenda();
        }else{
            Long id = Long.valueOf(entry.getId());
            agendaEntry = repository.findBy(id);
        }

        setCloseOnEsc(true);
        setCloseOnOutsideClick(true);

        VerticalLayout layout = new VerticalLayout();
        layout.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.STRETCH);
        layout.setSizeFull();

        TextField fieldTitle = new TextField("Titulo");
        fieldTitle.focus();

        ComboBox<String> fieldColor = new ComboBox<>("Color", COLORS);
        TextArea fieldDescription = new TextArea("Descripción");

        layout.add(fieldTitle, fieldColor, fieldDescription);

        TextField fieldStart = new TextField("Inicio");
        fieldStart.setEnabled(false);

        TextField fieldEnd = new TextField("Fin");
        fieldEnd.setEnabled(false);



        fieldStart.setValue( calendar.getTimezone().formatWithZoneId(entry.getStartUTC()) );
        fieldEnd.setValue(calendar.getTimezone().formatWithZoneId(entry.getEndUTC()));

        agendaEntry.setStart( Fecha.toDate(entry.getStart()));
        agendaEntry.setEnd(Fecha.toDate(entry.getEnd()));


        Checkbox fieldAllDay = new Checkbox("Evento del día");
        fieldAllDay.setValue(entry.isAllDay());
        fieldAllDay.setEnabled(false);

        layout.add(fieldStart, fieldEnd, fieldAllDay);

        Binder<Agenda> binder = new Binder<>(Agenda.class);
        binder.forField(fieldTitle)
                .asRequired()
                .bind("title");

        binder.bind(fieldColor, "color");
        binder.bind(fieldDescription, "description");

        binder.setBean(agendaEntry);

        HorizontalLayout buttons = new HorizontalLayout();
        Button buttonSave;
        if (newInstance) {
            buttonSave = new Button("Crear", e -> {
                if (binder.validate().isOk()) {
                    Agenda agenda;
                    agenda = repository.save(agendaEntry);
                    calendar.addEntry(agenda.getEntry());

                }
            });
        } else {
            buttonSave = new Button("Guardar", e -> {
                if (binder.validate().isOk()) {
                    calendar.updateEntry(agendaEntry.getEntry());
                    repository.save(agendaEntry);
                }
            });
        }
        buttonSave.addClickListener(e -> close());
        buttons.add(buttonSave);

        Button buttonCancel = new Button("Cancelar", e -> close());
        buttonCancel.getElement().getThemeList().add("tertiary");
        buttons.add(buttonCancel);

        if (!newInstance) {
            Button buttonRemove = new Button("Quitar", e -> {
                calendar.removeEntry(entry);
                repository.remove(agendaEntry);
                close();
            });
            ThemeList themeList = buttonRemove.getElement().getThemeList();
            themeList.add("error");
            themeList.add("tertiary");
            buttons.add(buttonRemove);
        }

        add(layout, buttons);
    }
}