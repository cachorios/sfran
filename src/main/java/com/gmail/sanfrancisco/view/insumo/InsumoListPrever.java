package com.gmail.sanfrancisco.view.insumo;

import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.cacho.slbase.core.Constantes;
import com.gmail.cacho.slreport.jasper.ReporteCreator;
import com.gmail.cacho.slreport.view.DefaultPDFViewDialog;
import com.gmail.sanfrancisco.entidad.Insumo;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.server.StreamResource;
import org.vaadin.alejandro.PdfBrowserViewer;

import java.util.HashMap;
import java.util.Map;

import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class InsumoListPrever extends AbstractPreview<Insumo> {
    private Button btnImprimir;
    private Long idComp;

    @Override
    public void crearElementos() {
        addItem("id", new PreviewItem<>(textField("ID"), Insumo::getId));
        addItem("descripcion", new PreviewItem<>(textField("Descripción"), Insumo::getDescripcion));
        addItem("tipo de insumo", new PreviewItem<>(textField("Tipo de insumo"), Insumo::getTipoInsumo));
        addItem("unidad", new PreviewItem<>(textField("Unidad"), Insumo::getUnidadMedida));
    }

    @Override
    protected void posGenerarVista() {
        btnImprimir = new Button(Constantes.CRUD_MSG_PRINT, VaadinIcon.PRINT.create());
        btnImprimir.setEnabled(false);
        btnImprimir.addClickListener((e) -> genPdf());
        add(btnImprimir);
    }

    @Override
    public void actualizar(Insumo item) {
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
        Map<String, Object> mapa = new HashMap<String, Object>();
        mapa.put(C.SYS_REP_PARAM_ID, idComp);
        return mapa;
    }

    private StreamResource createPdf() {
        return new ReporteCreator().streamResourceReport("/insumo.jrxml", crearMapaFechas(), "insumo");
    }
}
