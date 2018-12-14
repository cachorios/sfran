package com.gmail.sanfrancisco.view.comisionista;

import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.view.componentes.ReportSelector;
import com.gmail.cacho.slapi.view.interfaces.IPresentableList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerListPolymer;

import com.gmail.sanfrancisco.entidad.Comisionista;

import com.gmail.sanfrancisco.repositorio.ComisionistaRepositorio;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Anchor;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.VaadinServlet;


import javax.enterprise.inject.spi.CDI;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class ComisionistaInnerList extends DefaultInnerListPolymer<Comisionista> {
    private ReportSelector pdfBtn;
    private String filtro;
    private Long filtroLong;
    private Date filtroFechaInicial;
    private Date filtroFechaFinal;

    public ComisionistaInnerList(IPresentableList<Comisionista> presentable, String elTitulo) {
        super(presentable, elTitulo);

        pdfBtn = new ReportSelector("Imprimir", VaadinIcon.PRINT.create());

        pdfBtn.add("Listado", "comisionistas.jrxml", this::crearParametroReporte);
        pdfBtn.addform("Rendimiento", "productorrendimiento.jrxml", this::formFilter);
        pdfBtn.addform("Saldo", "saldocomisionista.jrxml", this::formFilter);

        getToolBar().getBotonera().add(pdfBtn);
    }

    private Map<String, Object> crearParametroReporte() {
        filtro = ((IPresenterList) (this.getPresentable().getPresenter())).getDataProvider().getFiltro();
        String directorio = VaadinServlet.getCurrent().getServletContext().getRealPath("/frontend/images");

        Map<String, Object> mapa = new HashMap<String, Object>();
        mapa.put(C.SYS_REP_PARAM_DIRECTORIO, directorio);
        mapa.put(C.SYS_REP_PARAM_ID, filtro);
        return mapa;
    }

    private Component formFilter() {
        Component data = null;

        Dialog dialog = pdfBtn.getDialog();
        Label notificacion = new Label("Seleccione un comisionista.");
        Button btnOk;

        DatePicker desde = new DatePicker("Fecha Inicio");
        desde.setRequired(true);
        DatePicker hasta = new DatePicker("Fecha Final");
        hasta.setRequired(true);
        this.defineRangoFechas(desde, hasta);

        btnOk = new Button("Aceptar", e -> {

            if (desde.getValue() != null && hasta.getValue() != null) {
                filtroFechaInicial = Date.from(desde.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
                filtroFechaFinal = Date.from(hasta.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

                if (pdfBtn.getTipo() == 1) {
                    pdfBtn.genPdf(pdfBtn.getFileName(), pdfBtn.getRepFile(), this::crearParametroReporteConFechas);
                } else {
                    pdfBtn.genXls(pdfBtn.getFileName(), pdfBtn.getRepFile(), this::crearParametroReporteConFechas);
                }
            } else {
                desde.setInvalid(true);
                desde.setErrorMessage("Seleccione la fecha de finalización");

            }

        });

        Button btnCancel = new Button("Cancelar", e -> dialog.close());
        VerticalLayout contenedor;
        if(this.getPresentable().getObjetoActivo() != null) {
            contenedor = new VerticalLayout(desde, hasta, new HorizontalLayout(btnOk, btnCancel));
            dialog.setHeight("200px");
            dialog.setWidth("300px");
        } else {
            contenedor = new VerticalLayout(new HorizontalLayout(notificacion, btnCancel));
            dialog.setHeight("50px");
            dialog.setWidth("300px");
        }

        dialog.removeAll();
        dialog.add(contenedor);
        dialog.open();

        return dialog;

    }

    private void defineRangoFechas(DatePicker startDatePicker, DatePicker endDatePicker) {
        startDatePicker.addValueChangeListener(event -> {
            LocalDate selectedDate = event.getValue();
            LocalDate endDate = endDatePicker.getValue();
            if (selectedDate != null) {
                endDatePicker.setMin(selectedDate.plusDays(1));
                if (endDate == null) {
                    endDatePicker.setOpened(true);
                    endDatePicker.setErrorMessage("Seleccione la fecha de finalización");
                }
            } else {
                endDatePicker.setMin(null);
                endDatePicker.setErrorMessage("Seleccione la fecha de inicio");
            }
        });

        endDatePicker.addValueChangeListener(event -> {
            LocalDate selectedDate = event.getValue();
            LocalDate startDate = startDatePicker.getValue();
            if (selectedDate != null) {
                startDatePicker.setMax(selectedDate.minusDays(1));
                if (startDate == null) {
                    startDatePicker.setErrorMessage("Seleccione la fecha de inicio");
                }
            } else {
                startDatePicker.setMax(null);
            }
        });
    }

    private Map<String, Object> crearParametroReporteConFechas() {
        Comisionista com = this.getPresentable().getObjetoActivo();
        filtroLong = com.getId();

        String directorio = VaadinServlet.getCurrent().getServletContext().getRealPath("/frontend/images");

        java.sql.Date sDate = new java.sql.Date(0);
        java.sql.Date sqlDate = new java.sql.Date(filtroFechaInicial.getTime());

        ComisionistaRepositorio repo = CDI.current().select(ComisionistaRepositorio.class).get();
        Double saldoAnteriorCabezera = repo.saldoAnteriorCabezera(com, sDate, sqlDate);
        saldoAnteriorCabezera = saldoAnteriorCabezera == null ? 0.0 : saldoAnteriorCabezera;
        Double saldoAnteriorDetalle = repo.saldoAnteriorDetalle(com, sDate, sqlDate);
        saldoAnteriorDetalle = saldoAnteriorDetalle == null ? 0.0 : saldoAnteriorDetalle;
        Double saldoAnterior = saldoAnteriorDetalle - saldoAnteriorCabezera;

        Map<String, Object> mapa = new HashMap<String, Object>();
        mapa.put(C.SYS_REP_PARAM_DIRECTORIO, directorio);
        mapa.put("p_SaldoAnterior", saldoAnterior);
        mapa.put(C.SYS_REP_PARAM_ID, filtroLong);

        mapa.put(C.SYS_REP_PARAM_FECHA_INICIAL, filtroFechaInicial);
        mapa.put(C.SYS_REP_PARAM_FECHA_FINAL, filtroFechaFinal);

        if (filtroFechaInicial == null) {
            mapa = null;
        }

        return mapa;
    }

}
