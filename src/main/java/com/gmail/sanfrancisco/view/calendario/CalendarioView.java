package com.gmail.sanfrancisco.view.calendario;


import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.gmail.cacho.slapi.layout.MainView;
import com.gmail.cacho.slbase.core.Fecha;
import com.gmail.sanfrancisco.entidad.Agenda;
import com.gmail.sanfrancisco.repositorio.AgendaRepository;
import com.vaadin.flow.component.HasText;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.dom.ThemeList;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.stefan.fullcalendar.*;

import javax.enterprise.inject.spi.CDI;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;


@Route(value="agenda", layout = MainView.class)
@PageTitle("Calendario de Tareas")
@MenuIcon(VaadinIcon.CALENDAR_ENVELOPE)

public class CalendarioView extends Div {
    private static final String[] COLORS = {"tomato", "orange", "dodgerblue", "mediumseagreen", "gray", "slateblue", "violet"};
    private FullCalendar calendar;
    private Div toolbar;

    private Button buttonDatePicker;
    private ComboBox<Timezone> timezoneComboBox;
    private CalendarViewImpl viewMode = CalendarViewImpl.BASIC_WEEK;

    public CalendarioView() {
        createToolbar();
        add(toolbar);
        add(new Hr());

        getElement().getStyle().set("margin", "2rem");
        createCalendarInstance();

        add(calendar);

        initBaseLayoutSettings();

    }

    private void createCalendarInstance() {
        calendar = FullCalendarBuilder.create().withEntryLimit(5).build();
        calendar.changeView(CalendarViewImpl.BASIC_WEEK);

        calendar.setNowIndicatorShown(true);
        calendar.setNumberClickable(true);
        calendar.setTimeslotsSelectable(true);
        calendar.setBusinessHours(
                new BusinessHours(LocalTime.of(4, 0), LocalTime.of(18, 0),BusinessHours.DEFAULT_BUSINESS_WEEK),
                new BusinessHours(LocalTime.of(4, 0), LocalTime.of(18, 0), DayOfWeek.SATURDAY),
                new BusinessHours(LocalTime.of(0, 0), LocalTime.of(18, 0), DayOfWeek.SUNDAY)
        );

        /**
         * para editar un dato
         */
        calendar.addEntryClickedListener(event -> new AgendaDialog(calendar, event.getEntry(), false).open());

        calendar.addEntryResizedListener(event -> {
            event.applyChangesOnEntry();

            Entry entry = event.getEntry();

            Notification.show(entry.getTitle() + " Cambiado a " + entry.getStart() + " - " + entry.getEnd() + " " + calendar.getTimezone().getClientSideValue() + " por " + event.getDelta());
        });


        /**
         * Mover el objeto
         */
        calendar.addEntryDroppedListener(event -> {
            event.applyChangesOnEntry();

            Entry entry = event.getEntry();
            LocalDateTime start = entry.getStart();
            LocalDateTime end = entry.getEnd();

            String text = entry.getTitle() + " moved to " + start + " - " + end + " " + calendar.getTimezone().getClientSideValue()+ " by " + event.getDelta();

            //
//            if(entry instanceof ResourceEntry) {
//                Set<Resource> resources = ((ResourceEntry) entry).getResources();
//                if(!resources.isEmpty()) {
//                    text += text + " - rooms are " + resources;
//                }
//            }


            Notification.show(text);
        });

        /**
         * al navegar en el calendario actualizar las etiquetas
         */
        calendar.addViewRenderedListener(event -> updateIntervalLabel(buttonDatePicker, viewMode, event.getIntervalStart()));


        /**
         * Nuevo item de agenda, click sobre espacio no usado
         */
        calendar.addTimeslotsSelectedListener(event -> {
            Entry entry = new Entry();

            entry.setStart(calendar.getTimezone().convertToUTC(event.getStartDateTime()));
            entry.setEnd(calendar.getTimezone().convertToUTC(event.getEndDateTime()));
            entry.setAllDay(event.isAllDay());

            entry.setColor("dodgerblue");
            new AgendaDialog(calendar, entry, true).open();
        });

        calendar.setLocale(Locale.forLanguageTag("es"));
       // Timezone zone = new Timezone( ZoneId.of("America/Argentina/Buenos_Aires") );
//        calendar.setTimezone(zone);
        calendar.setWeekNumbersVisible(true);
        ////createTestEntries(calendar);
    }

    private void createToolbar() {
        Button buttonToday = new Button("Hoy", VaadinIcon.HOME.create(), e -> calendar.today());
        Button buttonPrevious = new Button("Previo", VaadinIcon.ANGLE_LEFT.create(), e -> calendar.previous());
        Button buttonNext = new Button("Sigueinte", VaadinIcon.ANGLE_RIGHT.create(), e -> calendar.next());
        buttonNext.setIconAfterText(true);

        Button vistaSemanaBasico = new Button("Semanal", e -> {viewMode = CalendarViewImpl.BASIC_WEEK; changeViewMode()  ;});
        Button vistaSemana = new Button("Agenda Semanal", e -> {viewMode = CalendarViewImpl.AGENDA_WEEK; changeViewMode()  ;});
        Button vistaListaSemana = new Button("Lista Semana", e -> {viewMode = CalendarViewImpl.LIST_WEEK; changeViewMode()  ;});
        Button vistaBasicDia = new Button("Diario", e -> {viewMode = CalendarViewImpl.BASIC_DAY; changeViewMode()  ;});
        Button vistaDia = new Button("Agenda Diaria", e -> {viewMode = CalendarViewImpl.AGENDA_DAY; changeViewMode()  ;});
        Button vistaListaDia = new Button("Lista Dia", e -> {viewMode = CalendarViewImpl.LIST_DAY; changeViewMode()  ;});
        Button vistaMes = new Button("Mensual", e -> {viewMode = CalendarViewImpl.MONTH; changeViewMode()  ;});
        Button vistaListaMes = new Button("Lista Mensual", e -> {viewMode = CalendarViewImpl.LIST_MONTH; changeViewMode()  ;});
        Button vistaAnio = new Button("Lista Anual", e -> {viewMode = CalendarViewImpl.LIST_YEAR; changeViewMode()  ;});


//        List<CalendarView> calendarViews = new ArrayList<>();
//        calendarViews.addAll(Arrays.asList(CalendarViewImpl.values()));
//        ////calendarViews.addAll(Arrays.asList(SchedulerView.values()));
//        comboBoxView = new ComboBox<>("", calendarViews);
//        comboBoxView.setValue(CalendarViewImpl.MONTH);
//        comboBoxView.addValueChangeListener(e -> {
//            CalendarView value = e.getValue();
//            calendar.changeView(value == null ? CalendarViewImpl.MONTH : value);
//        });

        // simulate the date picker light that we can use in polymer
        DatePicker gotoDate = new DatePicker();
        gotoDate.addValueChangeListener(event1 -> calendar.gotoDate(event1.getValue()));
        gotoDate.getElement().getStyle().set("visibility", "hidden");
        gotoDate.getElement().getStyle().set("position", "fixed");
        gotoDate.setWidth("0px");
        gotoDate.setHeight("0px");
        gotoDate.setWeekNumbersVisible(true);
        buttonDatePicker = new Button(VaadinIcon.CALENDAR.create());
        buttonDatePicker.getElement().appendChild(gotoDate.getElement());
        buttonDatePicker.addClickListener(event -> gotoDate.open());

        Button buttonHeight = new Button("Calendar height", event -> new HeightDialog().open());


        Checkbox cbWeekNumbers = new Checkbox("Nro. de Semana", event -> calendar.setWeekNumbersVisible(event.getValue()));

        ComboBox<Locale> comboBoxLocales = new ComboBox<>();

        List<Locale> items = Arrays.asList(CalendarLocale.getAvailableLocales());
        comboBoxLocales.setItems(items);
        comboBoxLocales.setValue(CalendarLocale.SPANISH);
        comboBoxLocales.addValueChangeListener(event -> calendar.setLocale(event.getValue()));
        comboBoxLocales.setRequired(true);
        comboBoxLocales.setPreventInvalidInput(true);

        timezoneComboBox = new ComboBox<>("");
        timezoneComboBox.setItemLabelGenerator(Timezone::getClientSideValue);
        timezoneComboBox.setItems(Timezone.getAvailableZones());
        timezoneComboBox.setValue(Timezone.UTC);
        timezoneComboBox.addValueChangeListener(event -> {
            Timezone value = event.getValue();
            calendar.setTimezone(value != null ? value : Timezone.UTC);
        });




        toolbar = new Div( buttonPrevious,buttonToday,buttonDatePicker,
                vistaSemanaBasico, vistaSemana, vistaListaSemana,
                vistaBasicDia, vistaDia, vistaListaDia,
                vistaMes, vistaListaMes, vistaAnio,
                buttonNext, buttonHeight);
        toolbar.setWidth("80%");

//        toolbar.getElement().getStyle().set("flex-grow", "1");

        toolbar.getElement().getStyle().set("display", "flex");
        toolbar.getElement().getStyle().set("align-items", "center");
        toolbar.getElement().getStyle().set("justify-content", "space-between");

        toolbar.getElement().getStyle().set("background", "#E8E8E8");

    }

    private void changeViewMode() {
        calendar.changeView(viewMode);

    }

    private void initBaseLayoutSettings() {
        setSizeFull();
        calendar.setHeightByParent();
        setFlexStyles(true);
    }
    private void setFlexStyles(boolean flexStyles) {
        if (flexStyles) {
            calendar.getElement().getStyle().set("flex-grow", "1");
            getElement().getStyle().set("display", "flex");
            getElement().getStyle().set("align-items", "center");
            getElement().getStyle().set("flex-direction", "column");
        } else {
            calendar.getElement().getStyle().remove("flex-grow");
            getElement().getStyle().remove("display");
            getElement().getStyle().remove("flex-direction");
        }
    }

    /**
     * al navegar en el calendario actualizar las etiquetas
     * @param intervalLabel
     * @param view
     * @param intervalStart
     */
    private void updateIntervalLabel(HasText intervalLabel, CalendarView view, LocalDate intervalStart) {
        String text = "--";
        String modo = "";
        Locale locale = calendar.getLocale();
        Date hasta;
        if (view == null) {
            modo = "MES";
            text = intervalStart.format(DateTimeFormatter.ofPattern("MMMM yyyy").withLocale(locale));
        } else if (view instanceof CalendarViewImpl) {
            switch ((CalendarViewImpl) view) {
                default:
                case MONTH:
                case LIST_MONTH:
                    text = intervalStart.format(DateTimeFormatter.ofPattern("MMMM yyyy").withLocale(locale));
                    modo = "MES";
                    break;
                case AGENDA_DAY:
                case BASIC_DAY:
                case LIST_DAY:
                    text = intervalStart.format(DateTimeFormatter.ofPattern("dd.MM.yyyy").withLocale(locale));
                    modo = "DIA";
                    break;
                case AGENDA_WEEK:
                case BASIC_WEEK:
                case LIST_WEEK:
                    text = intervalStart.format(DateTimeFormatter.ofPattern("dd.MM.yy").withLocale(locale)) + " - " + intervalStart.plusDays(6).format(DateTimeFormatter.ofPattern("dd.MM.yy").withLocale(locale)) + " (cw " + intervalStart.format(DateTimeFormatter.ofPattern("ww").withLocale(locale)) + ")";
                    modo = "SEMANA";
                    break;
                case LIST_YEAR:
                    text = intervalStart.format(DateTimeFormatter.ofPattern("yyyy").withLocale(locale));
                    modo = "ANIO";
                    break;
            }

        }
        hasta = getRangoHasta(intervalStart, modo);
        refreshData(Fecha.toDate(intervalStart), hasta);

        intervalLabel.setText(text);
    }

    private void refreshData(Date desde, Date hasta) {
        Calendar cal = Calendar.getInstance();

        calendar.removeAllEntries();
        AgendaRepository repo = CDI.current().select(AgendaRepository.class).get();

        cal.setTime(desde);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        desde = cal.getTime();

        cal.setTime(hasta);
        cal.set(Calendar.HOUR_OF_DAY, 24);
        hasta = cal.getTime();

        List<Agenda> lista = repo.agendaaByRangoFecha(desde, hasta);
        lista.forEach(agenda -> calendar.addEntry(agenda.getEntry()));
    }

    private Date getRangoHasta(LocalDate desde, String modo){
        Date hasta = null;
        switch (modo){
            default:
            case "MES":
                hasta = Fecha.finMes(Fecha.toDate(desde));
                break;
            case "DIA":
                hasta = Fecha.toDate(desde);
                break;
            case "SEMANA":
                hasta = Fecha.toDate(desde.plusDays(7));
                break;
            case "ANIO":
                hasta = Fecha.toDate(desde.plusDays(365));
                break;
        }
        return hasta;
    }


    public class HeightDialog extends Dialog {
        HeightDialog() {
            VerticalLayout dialogContainer = new VerticalLayout();
            add(dialogContainer);

            TextField heightInput = new TextField("", "500", "e. g. 300");
            Button byPixels = new Button("Set by pixels", e -> {
                calendar.setHeight(Integer.valueOf(heightInput.getValue()));

                CalendarioView.this.setSizeUndefined();
                setFlexStyles(false);
            });
            byPixels.getElement().setProperty("title", "Calendar height is fixed by pixels.");
            dialogContainer.add(new HorizontalLayout(heightInput, byPixels));

            Button autoHeight = new Button("Auto height", e -> {
                calendar.setHeightAuto();

                CalendarioView.this.setSizeUndefined();
                setFlexStyles(false);
            });
            autoHeight.getElement().setProperty("title", "Calendar height is set to auto.");
            dialogContainer.add(autoHeight);

            Button heightByBlockParent = new Button("Height by block parent", e -> {
                calendar.setHeightByParent();
                calendar.setSizeFull();

                CalendarioView.this.setSizeFull();
                setFlexStyles(false);
            });
            heightByBlockParent.getElement().setProperty("title", "Container is display:block + setSizeFull(). Calendar height is set to parent + setSizeFull(). Body element kept unchanged.");
            dialogContainer.add(heightByBlockParent);

            Button heightByBlockParentAndCalc = new Button("Height by block parent + calc()", e -> {
                calendar.setHeightByParent();
                calendar.getElement().getStyle().set("height", "calc(100vh - 450px)");

                CalendarioView.this.setSizeFull();
                setFlexStyles(false);
            });
            heightByBlockParentAndCalc.getElement().setProperty("title", "Container is display:block + setSizeFull(). Calendar height is set to parent + css height is calculated by calc(100vh - 450px) as example. Body element kept unchanged.");
            dialogContainer.add(heightByBlockParentAndCalc);

            Button heightByFlexParent = new Button("Height by flex parent", e -> {
                calendar.setHeightByParent();

                CalendarioView.this.setSizeFull();
                setFlexStyles(true);
            });
            heightByFlexParent.getElement().setProperty("title", "Container is display:flex + setSizeFull(). Calendar height is set to parent + flex-grow: 1. Body element kept unchanged.");
            dialogContainer.add(heightByFlexParent);

            Button heightByFlexParentAndBody = new Button("Height by flex parent and flex body", e -> {
                calendar.setHeightByParent();

                CalendarioView.this.setSizeUndefined();
                setFlexStyles(true);

                UI.getCurrent().getElement().getStyle().set("display", "flex");
            });
            heightByFlexParentAndBody.getElement().setProperty("title", "Container is display:flex. Calendar height is set to parent + flex-grow: 1. Body element is set to display: flex.");
            dialogContainer.add(heightByFlexParentAndBody);
        }
    }


    private void createTestEntries(FullCalendar calendar) {
        LocalDate now = LocalDate.now();



        createTimedEntry(calendar, "Grocery Store", now.withDayOfMonth(7).atTime(17, 30), 45, "violet");
        createTimedEntry(calendar, "Dentist", now.withDayOfMonth(20).atTime(11, 30), 60, "violet");
        createTimedEntry(calendar, "Cinema", now.withDayOfMonth(10).atTime(20, 30), 140, "dodgerblue");
        createDayEntry(calendar, "Short trip", now.withDayOfMonth(17), 2, "dodgerblue");
        createDayEntry(calendar, "John's Birthday", now.withDayOfMonth(23), 1, "gray");
        createDayEntry(calendar, "This special holiday", now.withDayOfMonth(4), 1, "gray");

        createDayEntry(calendar, "Multi 1", now.withDayOfMonth(12), 2, "tomato");
        createDayEntry(calendar, "Multi 2", now.withDayOfMonth(12), 2, "tomato");
        createDayEntry(calendar, "Multi 3", now.withDayOfMonth(12), 2, "tomato");
        createDayEntry(calendar, "Multi 4", now.withDayOfMonth(12), 2, "tomato");
        createDayEntry(calendar, "Multi 5", now.withDayOfMonth(12), 2, "tomato");
        createDayEntry(calendar, "Multi 6", now.withDayOfMonth(12), 2, "tomato");
        createDayEntry(calendar, "Multi 7", now.withDayOfMonth(12), 2, "tomato");
        createDayEntry(calendar, "Multi 8", now.withDayOfMonth(12), 2, "tomato");
        createDayEntry(calendar, "Multi 9", now.withDayOfMonth(12), 2, "tomato");
        createDayEntry(calendar, "Multi 10", now.withDayOfMonth(12), 2, "tomato");

        createDayBackgroundEntry(calendar, now.withDayOfMonth(4), 6, "#B9FFC3");
        createDayBackgroundEntry(calendar, now.withDayOfMonth(19), 2, "#CEE3FF");
        createTimedBackgroundEntry(calendar, now.withDayOfMonth(20).atTime(11, 0), 150, "#FBC8FF");
    }

    private void setValues(FullCalendar calendar, ResourceEntry entry, String title, LocalDateTime start, int amountToAdd, ChronoUnit unit, String color) {
        entry.setTitle(title);
        entry.setStart(start, calendar.getTimezone());
        entry.setEnd(entry.getStartUTC().plus(amountToAdd, unit));
        entry.setAllDay(unit == ChronoUnit.DAYS);
        entry.setColor(color);
    }

    private void createDayEntry(FullCalendar calendar, String title, LocalDate start, int days, String color) {
        ResourceEntry entry = new ResourceEntry();
        setValues(calendar, entry, title, start.atStartOfDay(), days, ChronoUnit.DAYS, color);
        calendar.addEntry(entry);
    }
    private void createTimedEntry(FullCalendar calendar, String title, LocalDateTime start, int minutes, String color) {
        createTimedEntry(calendar, title, start, minutes, color, (Resource[]) null);
    }

    private void createTimedEntry(FullCalendar calendar, String title, LocalDateTime start, int minutes, String color, Resource... resources) {
        ResourceEntry entry = new ResourceEntry();
        setValues(calendar, entry, title, start, minutes, ChronoUnit.MINUTES, color);
        if (resources != null && resources.length > 0) {
            entry.addResources(Arrays.asList(resources));
        }
        calendar.addEntry(entry);
    }

    private void createDayBackgroundEntry(FullCalendar calendar, LocalDate start, int days, String color) {
        ResourceEntry entry = new ResourceEntry();
        setValues(calendar, entry, "BG", start.atStartOfDay(), days, ChronoUnit.DAYS, color);

        entry.setRenderingMode(Entry.RenderingMode.BACKGROUND);
        calendar.addEntry(entry);
    }

    private void createTimedBackgroundEntry(FullCalendar calendar, LocalDateTime start, int minutes, String color) {
        ResourceEntry entry = new ResourceEntry();
        setValues(calendar, entry, "BG", start, minutes, ChronoUnit.MINUTES, color);

        entry.setRenderingMode(Entry.RenderingMode.BACKGROUND);
        calendar.addEntry(entry);
    }
}