package com.gmail.sanfrancisco.view.calendario;


import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.gmail.cacho.slapi.layout.MainView;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.stefan.fullcalendar.Entry;
import org.vaadin.stefan.fullcalendar.FullCalendar;
import org.vaadin.stefan.fullcalendar.FullCalendarBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Route(value="calendario-sf", layout = MainView.class)
@PageTitle("Calendario de Tareas")
@MenuIcon(VaadinIcon.CALENDAR_ENVELOPE)

public class CalendarioView extends Div {


    public CalendarioView() {
        FullCalendar calendar = FullCalendarBuilder.create().build();
        add(calendar);

        Entry entry = new Entry();
        entry.setTitle("Some event");
        entry.setStart(LocalDate.now().withDayOfMonth(3).atTime(10, 0));
        entry.setEnd(entry.getStart().plusHours(2));
        entry.setColor("#ff3333");

        calendar.addEntry(entry);


    }


}