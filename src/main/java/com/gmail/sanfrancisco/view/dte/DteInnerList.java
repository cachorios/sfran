package com.gmail.sanfrancisco.view.dte;

import com.gmail.cacho.backend.entidad.Parametro;
import com.gmail.cacho.backend.enumeradores.ETipoParametro;
import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.view.componentes.ReportSelector;
import com.gmail.cacho.slapi.view.interfaces.IPresentableList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerListPolymer;
import com.gmail.cacho.slreport.jasper.ReporteCreator;
import com.gmail.cacho.slreport.view.DefaultPDFViewDialog;
import com.gmail.sanfrancisco.dataProvider.ParametroVarioDataProvider;
import com.gmail.sanfrancisco.entidad.Dte;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.VaadinServlet;
import org.vaadin.alejandro.PdfBrowserViewer;

import javax.enterprise.inject.spi.CDI;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DteInnerList extends DefaultInnerListPolymer<Dte> {

    private ReportSelector pdfBtn;
    private String filtro;
    private Long filtroLong;
    private Date filtroFechaInicial;
    private Date filtroFechaFinal;
    private Anchor xlsBtn;

    public DteInnerList(IPresentableList<Dte> presentable, String elTitulo) {
        super(presentable, elTitulo);

        pdfBtn = new ReportSelector("Imprimir", VaadinIcon.PRINT.create());

        pdfBtn.add("Listado", "dtes.jrxml", this::crearParametroReporte);
        pdfBtn.addform("Saldo de la tropa", "saldotropa.jrxml", this::dialogNotificacion);
        pdfBtn.addform("Precio por categoria", "preciocategoriaanimal.jrxml", this::formFilter);


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

    private Map<String, Object> crearParametroReporteIndividual() {
        filtroLong = this.getPresentable().getObjetoActivo().getId();
        String directorio = VaadinServlet.getCurrent().getServletContext().getRealPath("/frontend/images");

        Map<String, Object> mapa = new HashMap<String, Object>();
        mapa.put(C.SYS_REP_PARAM_ID, filtroLong);
        mapa.put(C.SYS_REP_PARAM_DIRECTORIO, directorio);
        return mapa;
    }

    private Component formFilter() {
        Component data = null;

        Dialog dialog = pdfBtn.getDialog();
        DatePicker desde = new DatePicker("Fecha Inicio");
        desde.setRequired(true);
        DatePicker hasta = new DatePicker("Fecha Final");
        hasta.setRequired(true);

        ComboBox tipoCategoria = new ComboBox("Categoria animal");
        tipoCategoria.setWidth("100%");
        ParametroVarioDataProvider dpTipoCategoria = CDI.current().select(ParametroVarioDataProvider.class).get();
        dpTipoCategoria.setTipo(ETipoParametro.CATEGORIA_ANIMAL);
        tipoCategoria.setDataProvider(dpTipoCategoria);
        tipoCategoria.setRequired(true);

        this.defineRangoFechas(desde, hasta);

        Button btnOk = new Button("Aceptar", e -> {

            if (desde.getValue() != null && hasta.getValue() != null && tipoCategoria.getValue() != null) {
                filtroFechaInicial = Date.from(desde.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
                filtroFechaFinal = Date.from(hasta.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
                filtroLong = ((Parametro) tipoCategoria.getValue()).getId();

                if (pdfBtn.getTipo() == 1) {
                    pdfBtn.genPdf(pdfBtn.getFileName(), pdfBtn.getRepFile(), this::crearParametroReporteConFechas);
                } else {
                    pdfBtn.genXls(pdfBtn.getFileName(), pdfBtn.getRepFile(), this::crearParametroReporteConFechas);
                }
            }else{
                desde.setInvalid(true);
                desde.setErrorMessage("Seleccione la fecha de finalización");

            }

        });

        Button btnCancel = new Button("Cancelar", e -> dialog.close());
        VerticalLayout contenedor = new VerticalLayout(desde, hasta, tipoCategoria, new HorizontalLayout(btnOk, btnCancel));

        dialog.setHeight("250px");
        dialog.setWidth("300px");

        dialog.removeAll();
        dialog.add(contenedor);
        dialog.open();

        return dialog;

    }

    private Component dialogNotificacion() {
        Component data = null;

        Dialog dialog = pdfBtn.getDialog();
        Label notificacion = new Label("Seleccione un DTE.");

        Button btnCancel = new Button("Cancelar", e -> dialog.close());
        VerticalLayout contenedor = new VerticalLayout(new HorizontalLayout(notificacion, btnCancel));

        dialog.setHeight("50px");
        dialog.setWidth("300px");

        dialog.removeAll();
        dialog.add(contenedor);

        if(this.getPresentable().getObjetoActivo() != null){
            if (pdfBtn.getTipo() == 1) {
                pdfBtn.genPdf(pdfBtn.getFileName(), pdfBtn.getRepFile(), this::crearParametroReporteIndividual);
            } else {
                pdfBtn.genXls(pdfBtn.getFileName(), pdfBtn.getRepFile(), this::crearParametroReporteIndividual);
            }
        } else {
            dialog.open();
        }

        return dialog;
    }

    private void defineRangoFechas(DatePicker startDatePicker, DatePicker endDatePicker) {
        startDatePicker.addValueChangeListener(event -> {
            LocalDate selectedDate = event.getValue();
            LocalDate endDate = endDatePicker.getValue();
            if (selectedDate != null) {
                endDatePicker.setMin(selectedDate.plusDays(1));
                if (endDate == null) {
                    endDatePicker.setOpened(true);
                    endDatePicker.setErrorMessage("Seleccione la fecha de finalización");
                }
            } else {
                endDatePicker.setMin(null);
                endDatePicker.setErrorMessage("Seleccione la fecha de inicio");
            }
        });

        endDatePicker.addValueChangeListener(event -> {
            LocalDate selectedDate = event.getValue();
            LocalDate startDate = startDatePicker.getValue();
            if (selectedDate != null) {
                startDatePicker.setMax(selectedDate.minusDays(1));
                if (startDate == null) {
                    startDatePicker.setErrorMessage("Seleccione la fecha de inicio");
                }
            } else {
                startDatePicker.setMax(null);
            }
        });
    }

    private Map<String, Object> crearParametroReporteConFechas() {

        String directorio = VaadinServlet.getCurrent().getServletContext().getRealPath("/frontend/images");

        Map<String, Object> mapa = new HashMap<String, Object>();
        mapa.put(C.SYS_REP_PARAM_DIRECTORIO, directorio);
        mapa.put(C.SYS_REP_PARAM_ID, filtroLong);
        mapa.put(C.SYS_REP_PARAM_FECHA_INICIAL, filtroFechaInicial);
        mapa.put(C.SYS_REP_PARAM_FECHA_FINAL, filtroFechaFinal);

        if (filtroFechaInicial == null) {
            mapa = null;
        }

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
