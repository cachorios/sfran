package com.gmail.sanfrancisco.view.conductor;

import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.cacho.slbase.core.Constantes;
import com.gmail.cacho.slreport.jasper.ReporteCreator;
import com.gmail.cacho.slreport.view.DefaultPDFViewDialog;
import com.gmail.sanfrancisco.entidad.Conductor;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.VaadinServlet;
import org.vaadin.alejandro.PdfBrowserViewer;

import java.util.HashMap;
import java.util.Map;

import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class ConductorListPrever extends AbstractPreview<Conductor> {
    private Button btnImprimir;
    private Long idComp;

    @Override
    public void crearElementos() {
        addItem("Nombre", new PreviewItem<>(textField("Nombre"), Conductor::getNombre));
        addItem("D.N.I.", new PreviewItem<>(textField("DNI"), Conductor::getDni));
        addItem("C.U.I.L.", new PreviewItem<>(textField("Cuil"), Conductor::getCuil));
        addItem("Celular", new PreviewItem<>(textField("Nro.Cel."), Conductor::getCelular));
        addItem("Operadora", new PreviewItem<>(textField("Operadora telefonica"), Conductor::getOperadoraTelefonica));
        addItem("Telefono", new PreviewItem<>(textField("Nro.Tel."), Conductor::getTelefono));
    }
    @Override
    protected void posGenerarVista() {
        btnImprimir = new Button(Constantes.CRUD_MSG_PRINT, VaadinIcon.PRINT.create());
        btnImprimir.setEnabled(false);
        btnImprimir.addClickListener((e) -> genPdf());
        add(btnImprimir);
    }

    @Override
    public void actualizar(Conductor item) {
        super.actualizar(item);

        if (registroPreview != null) {
            idComp = item.getId();
            btnImprimir.setEnabled(true);
        } else {
            idComp = 0L;
            btnImprimir.setEnabled(false);
        }
    }


    private void genPdf() {
        DefaultPDFViewDialog view = new DefaultPDFViewDialog();
        PdfBrowserViewer viewer = new PdfBrowserViewer(createPdf());
        viewer.setHeight("100%");
        view.getDialog().add(viewer);
        view.open();

    }
    private Map<String, Object> crearMapaFechas() {
        String directorio = VaadinServlet.getCurrent().getServletContext().getRealPath("/frontend/images");

        Map<String, Object> mapa = new HashMap<String, Object>();
        mapa.put(C.SYS_REP_PARAM_ID, idComp);
        mapa.put(C.SYS_REP_PARAM_DIRECTORIO, directorio);
        return mapa;
    }

    private StreamResource createPdf() {
        return new ReporteCreator().streamResourceReport("/conductor.jrxml", crearMapaFechas(), "conductor");
    }
}
