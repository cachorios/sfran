package com.gmail.sanfrancisco.view.consignatario;

import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.cacho.slbase.core.Constantes;
import com.gmail.cacho.slreport.jasper.ReporteCreator;
import com.gmail.cacho.slreport.view.DefaultPDFViewDialog;
import com.gmail.sanfrancisco.entidad.Consignatario;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.VaadinServlet;
import org.vaadin.alejandro.PdfBrowserViewer;

import java.util.HashMap;
import java.util.Map;

import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class ConsignatarioListPrever extends AbstractPreview<Consignatario> {
    private Button btnImprimir;
    private Long idComp;

    @Override
    public void crearElementos() {

        addItem("id", new PreviewItem<>(textField("ID"), Consignatario::getId));
        addItem("nombre", new PreviewItem<>(textField("Rázon social"), Consignatario::getNombre));
        addItem("cuil", new PreviewItem<>(textField("CUIL"), Consignatario::getCuil));
        addItem("celular", new PreviewItem<>(textField("Nro.Cel."), Consignatario::getCelular));
        addItem("telefono", new PreviewItem<>(textField("Nro.Tel."), Consignatario::getTelefono));
        addItem("domicilio", new PreviewItem<>(textField("Domicilio"), Consignatario::getDomicilio));
        addItem("email", new PreviewItem<>(textField("Email"), Consignatario::getEmail));

    }

    @Override
    protected void posGenerarVista() {
        btnImprimir = new Button(Constantes.CRUD_MSG_PRINT, VaadinIcon.PRINT.create());
        btnImprimir.setEnabled(false);
        btnImprimir.addClickListener((e) -> genPdf());
        add(btnImprimir);
    }

    @Override
    public void actualizar(Consignatario item) {
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
        return new ReporteCreator().streamResourceReport("/consignatario.jrxml", crearMapaFechas(), "consignatario");
    }
}
