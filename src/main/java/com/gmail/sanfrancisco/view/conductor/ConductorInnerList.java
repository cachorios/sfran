package com.gmail.sanfrancisco.view.conductor;

import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.view.componentes.ReportSelector;
import com.gmail.cacho.slapi.view.interfaces.IPresentableList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerListPolymer;
import com.gmail.cacho.slreport.jasper.ReporteCreator;
import com.gmail.cacho.slreport.view.DefaultPDFViewDialog;
import com.gmail.sanfrancisco.entidad.Conductor;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.contextmenu.ContextMenu;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.VaadinServlet;
import org.vaadin.alejandro.PdfBrowserViewer;

import java.util.HashMap;
import java.util.Map;

public class ConductorInnerList extends DefaultInnerListPolymer<Conductor> {

    private ReportSelector pdfBtn;
    private String filtro;
    private Anchor xlsBtn;

    public ConductorInnerList(IPresentableList<Conductor> presentable, String elTitulo) {
        super(presentable, elTitulo);

        pdfBtn = new ReportSelector("Imprimir", VaadinIcon.PRINT.create());

        pdfBtn.add("Listado", "conductores.jrxml", this::crearParametroReporte);


        getToolBar().getBotonera().add(pdfBtn);
    }

    private Map<String, Object> crearParametroReporte() {
        filtro = ((IPresenterList) (this.getPresentable().getPresenter())).getDataProvider().getFiltro();
        String directorio = VaadinServlet.getCurrent().getServletContext().getRealPath("/frontend/images");

        Map<String, Object> mapa = new HashMap<String, Object>();
        mapa.put(C.SYS_REP_PARAM_ID, filtro);
        mapa.put(C.SYS_REP_PARAM_DIRECTORIO, directorio);
        return mapa;
    }

    /*private Button pdfBtn;
    private String filtro;
    private Anchor xlsBtn;

    public ConductorInnerList(IPresentableList<Conductor> presentable, String elTitulo) {
        super(presentable, elTitulo);

        pdfBtn = new Button(VaadinIcon.PRINT.create());

        final ContextMenu contextMenu = new ContextMenu(pdfBtn);
        contextMenu.setOpenOnClick(true);
        contextMenu.addItem("PDF", (e) -> genPdf());
        contextMenu.addItem("XLS", (e) -> genXLS());

        getToolBar().getBotonera().add(pdfBtn);
    }

    private void genXLS() {
        DefaultPDFViewDialog view = new DefaultPDFViewDialog();
        Span label = new Span("Descargar Archivo :");

        xlsBtn = new Anchor(createXls(), "");
        xlsBtn.add(new Button("excel"));

        view.getDialog().add(label, xlsBtn );
        view.open();
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
        return new ReporteCreator().streamResourceReport("/conductores.jrxml", crearMapaFechas(), "conductores");
    }

    private StreamResource createXls() {
        Map mapa = crearMapaFechas();
        mapa.put("IS_IGNORE_PAGINATION", Boolean.TRUE);
        return new ReporteCreator().createXlsResource("/conductores.jrxml", mapa, "conductores");
    }*/

}
