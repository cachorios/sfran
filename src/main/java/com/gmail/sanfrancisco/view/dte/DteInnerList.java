package com.gmail.sanfrancisco.view.dte;

import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.view.componentes.ReportSelector;
import com.gmail.cacho.slapi.view.interfaces.IPresentableList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerListPolymer;
import com.gmail.cacho.slreport.jasper.ReporteCreator;
import com.gmail.cacho.slreport.view.DefaultPDFViewDialog;
import com.gmail.sanfrancisco.entidad.Dte;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.server.StreamResource;
import org.vaadin.alejandro.PdfBrowserViewer;

import java.util.HashMap;
import java.util.Map;

public class DteInnerList extends DefaultInnerListPolymer<Dte> {

    private ReportSelector pdfBtn;
    private String filtro;
    private Long filtroLong;
    private Anchor xlsBtn;

    public DteInnerList(IPresentableList<Dte> presentable, String elTitulo) {
        super(presentable, elTitulo);

        pdfBtn = new ReportSelector("Imprimir", VaadinIcon.PRINT.create());

        pdfBtn.add("Listado", "dtes.jrxml", this::crearParametroReporte);
        pdfBtn.add("Saldo de la tropa", "saldotropa.jrxml", this::crearParametroReporteIndividual);


        getToolBar().getBotonera().add(pdfBtn);
    }

    private Map<String, Object> crearParametroReporte() {
        filtro = ((IPresenterList) (this.getPresentable().getPresenter())).getDataProvider().getFiltro();

        Map<String, Object> mapa = new HashMap<String, Object>();
        mapa.put(C.SYS_REP_PARAM_ID, filtro);
        return mapa;
    }

    private Map<String, Object> crearParametroReporteIndividual() {
        filtroLong = this.getPresentable().getObjetoActivo().getId();

        Map<String, Object> mapa = new HashMap<String, Object>();
        mapa.put(C.SYS_REP_PARAM_ID, filtroLong);
        return mapa;
    }

    /*private Button pdfBtn;
    private String filtro;

    public DteInnerList(IPresentableList<Dte> presentable, String elTitulo) {
        super(presentable, elTitulo);
        pdfBtn = new Button(VaadinIcon.PRINT.create());
        pdfBtn.addClickListener((e) -> genPdf());

        getToolBar().getBotonera().add(pdfBtn);
    }

    private void genPdf() {
        DefaultPDFViewDialog view = new DefaultPDFViewDialog();
        PdfBrowserViewer viewer = new PdfBrowserViewer(createPdf());
        viewer.setHeight("100%");
        view.getDialog().add(viewer);
        view.open();
    }
    private Map<String, Object> crearMapaFechas() {
        filtro = ((IPresenterList) (this.getPresentable().getPresenter())).getDataProvider().getFiltro();

        Map<String, Object> mapa = new HashMap<String, Object>();
        mapa.put(C.SYS_REP_PARAM_ID, filtro);
        return mapa;
    }

    private StreamResource createPdf() {
        return new ReporteCreator().streamResourceReport("/dtes.jrxml", crearMapaFechas(), "dtes");
    }*/
}
