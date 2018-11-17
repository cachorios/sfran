package com.gmail.sanfrancisco.view.vehiculo;

import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.view.componentes.ReportSelector;
import com.gmail.cacho.slapi.view.interfaces.IPresentableList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerListPolymer;
import com.gmail.cacho.slreport.jasper.ReporteCreator;
import com.gmail.cacho.slreport.view.DefaultPDFViewDialog;
import com.gmail.sanfrancisco.entidad.Vehiculo;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.VaadinServlet;
import org.vaadin.alejandro.PdfBrowserViewer;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class VehiculoInnerList extends DefaultInnerListPolymer<Vehiculo> {

    private ReportSelector pdfBtn;
    private String filtro;
    private Long filtroLong;
    private Long filtroTipoInsumo;
    private Date filtroFechaInicial;
    private Date filtroFechaFinal;
    private Anchor xlsBtn;

    public VehiculoInnerList(IPresentableList<Vehiculo> presentable, String elTitulo) {
        super(presentable, elTitulo);

        pdfBtn = new ReportSelector("Imprimir", VaadinIcon.PRINT.create());

        pdfBtn.add("Listado", "vehiculos.jrxml", this::crearParametroReporte);
        pdfBtn.add("Gastos de tipo vehiculo", "gastosvehiculo.jrxml", this::crearParametroReporte);


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

    private Map<String, Object> crearParametroReporteConFechas() {
        String directorio = VaadinServlet.getCurrent().getServletContext().getRealPath("/frontend/images");
        filtroLong = this.getPresentable().getObjetoActivo().getId();
        filtroTipoInsumo = new Long(0);
        filtroFechaInicial = new Date();
        filtroFechaInicial = new Date();

        Map<String, Object> mapa = new HashMap<String, Object>();
        mapa.put(C.SYS_REP_PARAM_DIRECTORIO, directorio);
        mapa.put(C.SYS_REP_PARAM_ID, filtroLong);
        mapa.put(C.SYS_REP_PARAM_TIPO_INSUMO, filtroTipoInsumo);
        mapa.put(C.SYS_REP_PARAM_FECHA_INICIAL, filtroFechaInicial);
        mapa.put(C.SYS_REP_PARAM_FECHA_FINAL, filtroFechaFinal);
        return mapa;
    }

    /*private Button pdfBtn;
    private String filtro;

    public VehiculoInnerList(IPresentableList<Vehiculo> presentable, String elTitulo) {
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
        return new ReporteCreator().streamResourceReport("/vehiculos.jrxml", crearMapaFechas(), "vehiculos");
    }*/
}
