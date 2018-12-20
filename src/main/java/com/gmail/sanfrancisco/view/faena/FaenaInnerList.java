package com.gmail.sanfrancisco.view.faena;

import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.view.componentes.ReportSelector;
import com.gmail.cacho.slapi.view.interfaces.IPresentableList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerListPolymer;
import com.gmail.sanfrancisco.entidad.Faena;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.VaadinServlet;

import java.util.HashMap;
import java.util.Map;

public class FaenaInnerList extends DefaultInnerListPolymer<Faena> {

    private ReportSelector pdfBtn;
    private Long filtroLong;
    private Anchor xlsBtn;

    public FaenaInnerList(IPresentableList<Faena> presentable, String elTitulo) {
        super(presentable, elTitulo);

        pdfBtn = new ReportSelector("Imprimir", VaadinIcon.PRINT.create());

        pdfBtn.addform("Listado", "faena.jrxml", this::dialogNotificacion);


        getToolBar().getBotonera().add(pdfBtn);
    }

    private Map<String, Object> crearParametroReporteIndividual() {
        filtroLong = this.getPresentable().getObjetoActivo().getFaenaProductor().getId();
        String directorio = VaadinServlet.getCurrent().getServletContext().getRealPath("/frontend/images");
        String subreporte = VaadinServlet.getCurrent().getServletContext().getRealPath("/reportes");

        Map<String, Object> mapa = new HashMap<String, Object>();
        mapa.put(C.SYS_REP_PARAM_ID, filtroLong);
        mapa.put(C.SYS_REP_PARAM_DIRECTORIO, directorio);
        mapa.put(C.SYS_REP_PARAM_SUBREPORTE, subreporte);
        return mapa;
    }

    private Component dialogNotificacion() {
        Component data = null;

        Dialog dialog = pdfBtn.getDialog();
        Label notificacion = new Label("Seleccione una Faena.");

        Button btnCancel = new Button("Cancelar", e -> dialog.close());
        VerticalLayout contenedor = new VerticalLayout(new HorizontalLayout(notificacion, btnCancel));

        dialog.setHeight("50px");
        dialog.setWidth("300px");

        dialog.removeAll();
        dialog.add(contenedor);

        if(this.getPresentable().getObjetoActivo() != null){
            if (pdfBtn.getTipo() == 1) {
                pdfBtn.genPdf(pdfBtn.getFileName(), pdfBtn.getRepFile(), this::crearParametroReporteIndividual);
            } else {
                pdfBtn.genXls(pdfBtn.getFileName(), pdfBtn.getRepFile(), this::crearParametroReporteIndividual);
            }
        } else {
            dialog.open();
        }

        return dialog;
    }
}
