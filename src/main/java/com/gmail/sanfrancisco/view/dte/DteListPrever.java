package com.gmail.sanfrancisco.view.dte;

import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.utils.PreviewItem;
import com.gmail.cacho.slbase.core.Constantes;
import com.gmail.cacho.slreport.jasper.ReporteCreator;
import com.gmail.cacho.slreport.view.DefaultPDFViewDialog;
import com.gmail.sanfrancisco.entidad.Dte;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.VaadinServlet;
import org.vaadin.alejandro.PdfBrowserViewer;

import java.util.HashMap;
import java.util.Map;

import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class DteListPrever extends AbstractPreview<Dte> {
    private Button btnImprimir;
    private Long idComp;
    private VerticalLayout prod = new VerticalLayout();

    @Override
    public void crearElementos() {

        addItem("totalcomisionista", new PreviewItem<>(textField("Total factura"), Dte::getTotalComisionista));
        addItem("entrega en efectivo", new PreviewItem<>(textField("Entrega en efectivo"), Dte::getImporteEntrega));
        addItem("ajustes", new PreviewItem<>(textField("Ajustes"), Dte::getAjustes));
    }

    public void addProductores() {
       // ArrayList<Productor> productors = new ArrayList<>();
        prod.removeAll();
        prod.add(new Label("Productores: "));

        if(this.registroPreview.getCategorias() != null) {
            this.registroPreview.getCategorias().forEach(c -> {
                //productors.add(c.getProductor());
                if(c.getProductor() != null) {
                    prod.add(new Label(c.getProductor().getNombre()));
                }
            });
        }

    }

    @Override
    protected void posGenerarVista() {
        btnImprimir = new Button(Constantes.CRUD_MSG_PRINT, VaadinIcon.PRINT.create());
        btnImprimir.setEnabled(false);
        btnImprimir.addClickListener((e) -> genPdf());
        add(btnImprimir);
    }

    @Override
    public void actualizar(Dte item) {
//        removeAll();
        super.actualizar(item);

        if (registroPreview != null) {
            idComp = item.getId();
            btnImprimir.setEnabled(true);
        } else {
            idComp = 0L;
            btnImprimir.setEnabled(false);
        }

        crearElementos();
        addProductores();

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
        String directorio = VaadinServlet.getCurrent().getServletContext().getRealPath("/frontend/images");

        mapa.put(C.SYS_REP_PARAM_DIRECTORIO, directorio);
        mapa.put(C.SYS_REP_PARAM_ID, idComp);
        return mapa;
    }

    private StreamResource createPdf() {
        return new ReporteCreator().streamResourceReport("/dte.jrxml", crearMapaFechas(), "dte");
    }
}