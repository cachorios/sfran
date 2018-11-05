package com.gmail.sanfrancisco.view.vehiculo;

import com.gmail.cacho.slapi.view.interfaces.IPresentableList;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerListPolymer;
import com.gmail.cacho.slreport.jasper.ReporteCreator;
import com.gmail.cacho.slreport.view.DefaultPDFViewDialog;
import com.gmail.sanfrancisco.entidad.Vehiculo;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.server.StreamResource;
import org.vaadin.alejandro.PdfBrowserViewer;

import java.util.HashMap;
import java.util.Map;

public class VehiculoInnerList extends DefaultInnerListPolymer<Vehiculo> {

    private Button pdfBtn;

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
        Map<String, Object> mapa = new HashMap<String, Object>();
        return mapa;
    }

    private StreamResource createPdf() {
        return new ReporteCreator().streamResourceReport("/vehiculos.jrxml", crearMapaFechas(), "vehiculos");
    }
}
