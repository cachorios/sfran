package com.gmail.sanfrancisco.view.comisionista;

import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.view.componentes.ReportSelector;
import com.gmail.cacho.slapi.view.interfaces.IPresentableList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerListPolymer;
import com.gmail.cacho.slreport.jasper.ReporteCreator;
import com.gmail.cacho.slreport.view.DefaultPDFViewDialog;
import com.gmail.sanfrancisco.entidad.Comisionista;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.contextmenu.ContextMenu;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.server.StreamResource;
import org.vaadin.alejandro.PdfBrowserViewer;

import java.util.HashMap;
import java.util.Map;

public class ComisionistaInnerList extends DefaultInnerListPolymer<Comisionista> {
    private ReportSelector pdfBtn;
    private String filtro;
    private Anchor xlsBtn;

    public ComisionistaInnerList(IPresentableList<Comisionista> presentable, String elTitulo) {
        super(presentable, elTitulo);

        pdfBtn = new ReportSelector("Imprimir", VaadinIcon.PRINT.create());

        pdfBtn.add("Listado", "comisionistas.jrxml", this::crearParametroReporte);


        getToolBar().getBotonera().add(pdfBtn);
    }

    /*
    private void genPdf() {
        DefaultPDFViewDialog view = new DefaultPDFViewDialog();
        PdfBrowserViewer viewer = new PdfBrowserViewer(createPdf());
        viewer.setHeight("100%");
        view.getDialog().add(viewer);
        view.open();
    }

    private void genXLS() {
        DefaultPDFViewDialog view = new DefaultPDFViewDialog();
        Span label = new Span("Descargar Archivo :");

        xlsBtn = new Anchor(createXls(), "");
        xlsBtn.add(new Button("excel"));

        view.getDialog().add(label, xlsBtn );
        view.open();
    }



    private StreamResource createPdf() {
        return new ReporteCreator().streamResourceReport("/comisionistas.jrxml", crearMapaFechas(), "comisionistas");
    }

    private StreamResource createXls() {
        Map mapa = crearMapaFechas();
        mapa.put("IS_IGNORE_PAGINATION", Boolean.TRUE);
        return new ReporteCreator().createXlsResource("/comisionistas.jrxml", mapa, "comisionistas");
    }*/

    private Map<String, Object> crearParametroReporte() {
        filtro = ((IPresenterList) (this.getPresentable().getPresenter())).getDataProvider().getFiltro();

        Map<String, Object> mapa = new HashMap<String, Object>();
        mapa.put(C.SYS_REP_PARAM_ID, filtro);
        return mapa;
    }
}
