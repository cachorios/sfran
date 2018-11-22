package com.gmail.sanfrancisco.view.conductor;

import com.gmail.cacho.backend.enumeradores.ETipoParametro;
import com.gmail.cacho.backend.jpa.convert.LocalDateADateConverter;
import com.gmail.cacho.slapi.view.componentes.UnoaMuchoGrid;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.cacho.slapi.view.renders.DateRenderer;
import com.gmail.sanfrancisco.dataProvider.ParametroVarioDataProvider;
import com.gmail.sanfrancisco.entidad.Conductor;
import com.gmail.sanfrancisco.entidad.Licencia;
import com.gmail.sanfrancisco.view.licencia.LicenciaForm;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.converter.StringToLongConverter;


import javax.enterprise.inject.spi.CDI;

import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class ConductorInnerForm extends DefaultInnerDialog<Conductor> {

    private TextField id;
    private TextField nombre;
    private TextField dni;
    private TextField cuil;
    private DatePicker fechaNacimiento;
    private TextField telefono;
    private TextField celular;
    private ComboBox operadoraTelefonica;
    private DatePicker fechaIngreso;

    private Grid<Licencia> licenciaGrid;
    private UnoaMuchoGrid<Conductor, Licencia> licencias;

    public ConductorInnerForm(IPresentableForm<Conductor> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {

//        setHeight("420px");
        setWidth("700px");

        id = textField("ID","20em");
        id.setPreventInvalidInput(true);
        nombre = textField("Nombre");
        dni = textField("DNI");
        cuil = textField("CUIL");

        fechaNacimiento = new DatePicker("Fecha Nacimiento");
        fechaNacimiento.setWidth("100%");
        fechaNacimiento.setRequired(true);

        celular = textField("Nro. Celular");
        telefono = textField("Nro. Telefono");

        operadoraTelefonica = new ComboBox("Operadora");
        operadoraTelefonica.setWidth("100%");
        ParametroVarioDataProvider dp = CDI.current().select(ParametroVarioDataProvider.class).get();
        dp.setTipo(ETipoParametro.OPERADORA_TEL);
        operadoraTelefonica.setDataProvider(dp);

        fechaIngreso = new DatePicker("Fecha Ingreso");
        fechaIngreso.setWidth("100%");
        fechaIngreso.setRequired(true);

        form.add(
                envolver(id),

                envolver(nombre),

                envolver(dni,"48%"),
                envolver(cuil, "48%"),

                envolver(fechaNacimiento,"48%"),
                envolver(fechaIngreso,"48%"),

                envolver(telefono,"28%"),
                envolver(celular,"28%"),
                envolver(operadoraTelefonica,"40%"),

                envolver(getLicencias())

        );

    }

    private Component getLicencias() {
        licencias = new UnoaMuchoGrid<>("Licencias", getPresentable().getObjetoActivo() , this.getPresentable().getObjetoActivo().getLicencias());

        licencias.getGrid().addColumn(Licencia::getTipoLicencia)
                .setHeader("Tipo")
                .setWidth("20%");
        licencias.getGrid().addColumn(new DateRenderer<>(Licencia::getVencimiento,"dd/MM/yyyy"))
                .setHeader("Vencimiento")
                .setWidth("12%");
        licencias.getGrid().addColumn(new DateRenderer<>(Licencia::getVencimientoNac,"dd/MM/yyyy"))
                .setHeader("Vencimiento nacional")
                .setWidth("10%");
        licencias.getGrid().addColumn(new DateRenderer<>(Licencia::getVencimientoCurso,"dd/MM/yyyy"))
                .setHeader("Vencimiento curso")
                .setWidth("6%");
        licencias.getGrid().addColumn(Licencia::getLicenciaCarga)
                .setHeader("Habilitado para cargas")
                .setWidth("6%");

        licencias
                .withForm(LicenciaForm.class)
                .withVer()
                .withNuevo(Licencia.class)
                .withEditar()
                .withBorrar()
        ;
        licencias.getGrid().setHeight("10rem");
        return licencias.iniciar();
    }

    @Override
    public Focusable getPrimerElementoForm() {
        return nombre;
    }

    @Override
    public void bindFormFields(BeanValidationBinder<Conductor> binder) {

        binder.forField(id)
                .withConverter(new StringToLongConverter(0l, "No es un nro válido."))
                .withNullRepresentation(0l)
                .bind(Conductor::getId, null);

        binder.forField(fechaNacimiento)
                .withConverter(new LocalDateADateConverter())
                .bind("fechaNacimiento");

        binder.forField(fechaIngreso)
                .withConverter(new LocalDateADateConverter())
                .bind("fechaIngreso");

        binder.bind(operadoraTelefonica, "operadoraTelefonica");


        binder.bindInstanceFields(this);
    }
}
