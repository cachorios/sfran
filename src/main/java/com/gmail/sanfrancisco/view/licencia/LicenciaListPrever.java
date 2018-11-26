package com.gmail.sanfrancisco.view.licencia;

import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.cacho.slbase.core.Constantes;
import com.gmail.cacho.slreport.jasper.ReporteCreator;
import com.gmail.cacho.slreport.view.DefaultPDFViewDialog;
import com.gmail.sanfrancisco.entidad.Licencia;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.VaadinServlet;
import org.vaadin.alejandro.PdfBrowserViewer;

import java.util.HashMap;
import java.util.Map;

import static com.gmail.cacho.slapi.view.utils.ViewTools.dateField;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class LicenciaListPrever extends AbstractPreview<Licencia> {
    private Button btnImprimir;
    private Long idComp;

    @Override
    public void crearElementos() {
        addItem("tipo de licencia", new PreviewItem<>(textField("Tipo de licencia"), Licencia::getTipoLicencia));
        addItem("vencimiento", new PreviewItem<>(dateField("Vencimiento"), Licencia::getVencimiento));
        addItem("venimiento del carnet", new PreviewItem<>(dateField("Vencimiento del carnet"), Licencia::getVencimientoNac));
        addItem("vencimiento del curso", new PreviewItem<>(dateField("Vencimiento del curso"), Licencia::getVencimientoCurso));
        addItem("habilitado para carga", new PreviewItem<>(new Checkbox("Habilitado para carga"), Licencia::getLicenciaCarga));
    }

    @Override
    protected void posGenerarVista() {
        btnImprimir = new Button(Constantes.CRUD_MSG_PRINT, VaadinIcon.PRINT.create());
        btnImprimir.setEnabled(false);
        btnImprimir.addClickListener((e) -> genPdf());
        add(btnImprimir);
    }

    @Override
    public void actualizar(Licencia item) {
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
        mapa.put(C.SYS_REP_PARAM_DIRECTORIO, directorio);
        mapa.put(C.SYS_REP_PARAM_ID, idComp);
        return mapa;
    }

    private StreamResource createPdf() {
        return new ReporteCreator().streamResourceReport("/licencia.jrxml", crearMapaFechas(), "licencia");
    }
}
