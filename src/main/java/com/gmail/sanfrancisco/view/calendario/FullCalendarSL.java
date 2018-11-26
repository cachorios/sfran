package com.gmail.sanfrancisco.view.calendario;


import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import org.vaadin.stefan.fullcalendar.FullCalendarScheduler;

@Tag("sl-full-calendar")
@HtmlImport("frontend://src/components/sl-full-calendar.html")
public class FullCalendarSL  extends FullCalendarScheduler {
    FullCalendarSL(int entryLimit) {
        super(entryLimit);
    }

}
