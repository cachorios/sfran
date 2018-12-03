package com.gmail.sanfrancisco.view.comisionista;

import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.view.componentes.ReportSelector;
import com.gmail.cacho.slapi.view.interfaces.IPresentableList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerListPolymer;

import com.gmail.sanfrancisco.entidad.Comisionista;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Anchor;

import com.vaadin.flow.component.icon.VaadinIcon;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.VaadinServlet;


import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ComisionistaInnerList extends DefaultInnerListPolymer<Comisionista> {
    private ReportSelector pdfBtn;
    private String filtro;
    private Long filtroLong;
    private Date filtroFechaInicial;
    private Date filtroFechaFinal;
    private Anchor xlsBtn;

    public ComisionistaInnerList(IPresentableList<Comisionista> presentable, String elTitulo) {
        super(presentable, elTitulo);

        pdfBtn = new ReportSelector("Imprimir", VaadinIcon.PRINT.create());

        pdfBtn.add("Listado", "comisionistas.jrxml", this::crearParametroReporte);
        pdfBtn.add("Rendimiento", "productorrendimiento.jrxml", this::dialogFecha);
        pdfBtn.add("Saldo", "saldocomisionista.jrxml", this::crearParametroReporteConFechas);


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

    private Map<String, Object> crearParametroReporteConFechas() {


        filtroLong = this.getPresentable().getObjetoActivo().getId();
        String directorio = VaadinServlet.getCurrent().getServletContext().getRealPath("/frontend/images");

        Map<String, Object> mapa = new HashMap<String, Object>();
        mapa.put(C.SYS_REP_PARAM_DIRECTORIO, directorio);
        mapa.put(C.SYS_REP_PARAM_ID, filtro);

        mapa.put(C.SYS_REP_PARAM_FECHA_INICIAL, filtroFechaInicial);
        mapa.put(C.SYS_REP_PARAM_FECHA_FINAL, filtroFechaFinal);

        dialogFecha();

        if(filtroFechaInicial == null){
            mapa = null;
        }

        return mapa;
    }

    private Map<String, Object> dialogFecha(){
        Dialog dialog = new Dialog();
        dialog.setCloseOnEsc(false);
        dialog.setCloseOnOutsideClick(false);
        dialog.setWidth("300px");

        DatePicker desde = new DatePicker("Fecha Inicio");
        DatePicker hasta = new DatePicker("Fecha Final");
        Button btnOk = new Button("Aceptar", e -> {
            filtroFechaInicial = Date.from(desde.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
            filtroFechaInicial = Date.from(hasta.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        });

        Button btnCancel = new Button("Cancelar", e -> dialog.close());


        VerticalLayout contenedor = new VerticalLayout(desde, hasta, new HorizontalLayout(btnOk, btnCancel));

        dialog.add(contenedor);

        dialog.open();

        return null;
    }
}
