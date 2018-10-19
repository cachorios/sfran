package com.gmail.sanfrancisco.view.comisionista;

import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.cacho.slapi.view.utils.ViewTools;
import com.gmail.cacho.slbase.core.Constantes;
import com.gmail.cacho.slreport.jasper.ReporteCreator;
import com.gmail.cacho.slreport.view.DefaultPDFViewDialog;
import com.gmail.sanfrancisco.entidad.Comisionista;
import com.gmail.sanfrancisco.entidad.Consignatario;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.server.StreamResource;
import org.vaadin.alejandro.PdfBrowserViewer;

import java.util.HashMap;
import java.util.Map;

import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class ComisionistaListPrever extends AbstractPreview<Comisionista> {
    private Button btnImprimir;
    private Long idComp;
    private final Dialog dialog = new Dialog();

    @Override
    public void crearElementos() {
        addItem("id", new PreviewItem<>(textField("ID"), Comisionista::getId));
        addItem("nombre", new PreviewItem<>(textField("Nombre"), Comisionista::getNombre));
        addItem("cuil", new PreviewItem<>(textField("CUIL"), Comisionista::getCuil));
        addItem("celular", new PreviewItem<>(textField("Nro.Cel."), Comisionista::getCelular));
        addItem("telefono", new PreviewItem<>(textField("Nro.Tel."), Comisionista::getTelefono));
        addItem("domicilio", new PreviewItem<>(textField("Domicilio"), Comisionista::getDomicilio));
        addItem("celular", new PreviewItem<>(textField("Nro.Cle."), Comisionista::getCelular));
        addItem("email", new PreviewItem<>(textField("Email"), Comisionista::getEmail));
    }
    @Override
    protected void posGenerarVista() {
        btnImprimir = new Button(Constantes.CRUD_MSG_PRINT, VaadinIcon.PRINT.create());
        btnImprimir.setEnabled(false);
        btnImprimir.addClickListener((e) -> genPdf());
        add(btnImprimir);
    }

    @Override
    public void actualizar(Comisionista item) {
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
        return new ReporteCreator().streamResourceReport("/comisionista.jrxml", crearMapaFechas(), "comisionista");
    }
}
