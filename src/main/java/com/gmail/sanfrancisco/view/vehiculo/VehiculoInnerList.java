package com.gmail.sanfrancisco.view.vehiculo;

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
import com.gmail.sanfrancisco.entidad.Vehiculo;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Anchor;
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

public class VehiculoInnerList extends DefaultInnerListPolymer<Vehiculo> {

    private ReportSelector pdfBtn;
    private String filtro;
    private Long filtroLong;
    private Long filtroTipoInsumo = 35705l;
    private Date filtroFechaInicial;
    private Date filtroFechaFinal;
    private Anchor xlsBtn;

    public VehiculoInnerList(IPresentableList<Vehiculo> presentable, String elTitulo) {
        super(presentable, elTitulo);

        pdfBtn = new ReportSelector("Imprimir", VaadinIcon.PRINT.create());

        pdfBtn.add("Listado", "vehiculos.jrxml", this::crearParametroReporte);
        pdfBtn.addform("Gastos de tipo vehiculo", "gastosvehiculo.jrxml", this::formFilter);


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

    private Component formFilter() {
        Component data = null;

        Dialog dialog = pdfBtn.getDialog();
        DatePicker desde = new DatePicker("Fecha Inicio");
        desde.setRequired(true);

        DatePicker hasta = new DatePicker("Fecha Final");
        hasta.setRequired(true);

        ComboBox tipoVehiculo = new ComboBox("Tipo Vehiculo");
        tipoVehiculo.setWidth("100%");
        ParametroVarioDataProvider dpTipoVehiculo = CDI.current().select(ParametroVarioDataProvider.class).get();
        dpTipoVehiculo.setTipo(ETipoParametro.TIPO_VEHICULO);
        tipoVehiculo.setDataProvider(dpTipoVehiculo);
        tipoVehiculo.setRequired(true);

        this.defineRangoFechas(desde, hasta);

        Button btnOk = new Button("Aceptar", e -> {

            if (desde.getValue() != null && hasta.getValue() != null && tipoVehiculo.getValue() != null) {
                filtroFechaInicial = Date.from(desde.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
                filtroFechaFinal = Date.from(hasta.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
                filtroLong = ((Parametro) tipoVehiculo.getValue()).getId();

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
        VerticalLayout contenedor = new VerticalLayout(desde, hasta, tipoVehiculo, new HorizontalLayout(btnOk, btnCancel));

            dialog.setHeight("300px");
            dialog.setWidth("300px");

            dialog.removeAll();
            dialog.add(contenedor);
            dialog.open();

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
