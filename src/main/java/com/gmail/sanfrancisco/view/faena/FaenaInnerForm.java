package com.gmail.sanfrancisco.view.faena;

import com.gmail.cacho.backend.jpa.convert.LocalDateADateConverter;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.layouts.DefaultInnerDialog;
import com.gmail.sanfrancisco.converter.IntegerConverter;
import com.gmail.sanfrancisco.entidad.*;
import com.gmail.sanfrancisco.repositorio.FaenaRepositorio;
import com.gmail.sanfrancisco.view.dte.DteCS;
import com.gmail.sanfrancisco.view.productor.ProductorCS;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.HasValueAndElement;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.internal.AbstractFieldSupport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.BindingValidationStatus;
import com.vaadin.flow.shared.Registration;

import javax.enterprise.inject.spi.CDI;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static com.gmail.cacho.slapi.view.utils.ViewTools.dateField;
import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;
import static com.gmail.cacho.slapi.view.utils.ViewTools.textField;

public class FaenaInnerForm extends DefaultInnerDialog<Faena> {
    private DatePicker fecha;
    private TextField numero;
    private FaenaProductorEditor faenaProductorEditor;

    private FaenaCabeceraEditor cabecera;
    private FaenaDetallesEditor detallesEditor;

    public FaenaInnerForm(IPresentableForm<Faena> presentable, String elTitulo) {
        super(presentable, elTitulo);
    }

    @Override
    protected void generarForm(Div form) {
        setWidth("1100px");

        numero = textField("Numero");
        fecha = dateField("Fecha");
        faenaProductorEditor = new FaenaProductorEditor();
        detallesEditor = new FaenaDetallesEditor( this.getPresentable() );
        cabecera = new FaenaCabeceraEditor(getPresentable(), detallesEditor);

        form.add(
            envolver(fecha, "48%"),
            envolver(numero, "50%"),
            envolver(faenaProductorEditor,"100%"),
            cabeceraFarnaCab(),
            cabecera,
            cabeceraDetalle(),
            detallesEditor
        );

    }

    private HorizontalLayout cabeceraFarnaCab() {
        HorizontalLayout hlLabel = new HorizontalLayout(
                envolver(new Label("Categoria"), "40%"),
                envolver(new Label("Cantidad"), "10%"),
                envolver(new Label("Faenado"), "10%"),
                envolver(new Label("Dif."), "10%"),
                envolver(new Label("Kg vivo"), "10%"),
                envolver(new Label("a Faenar"), "10%"),
                envolver(new Label("Accion"), "10%")
        );
        hlLabel.setWidth("100%");
        hlLabel.setClassName("faena-header");
        return hlLabel;

    }

    public HorizontalLayout cabeceraDetalle() {
        HorizontalLayout hlLabel = new HorizontalLayout(
                envolver(new Label("Orden"), "15%"),
                envolver(new Label("Categoria"), "50%"),
                envolver(new Label("Peso Izq."), "17%"),
                envolver(new Label("Peso Der."), "17%")
        );

        hlLabel.setWidth("100%");
        hlLabel.setClassName("faena-header");
        return hlLabel;
    }

    @Override
    public Focusable getPrimerElementoForm() { return numero; }



    @Override
    public void bindFormFields(BeanValidationBinder<Faena> binder) {
        binder.forField(fecha)
                .withConverter(new LocalDateADateConverter())
                .bind(Faena::getFecha, Faena::setFecha);

        binder.forField(numero).withConverter(new IntegerConverter()).bind("numero");
        binder.forField(faenaProductorEditor).bind("faenaProductor");
        binder.bindInstanceFields(this);
    }


    protected class FaenaProductorEditor extends HorizontalLayout implements HasValueAndElement<AbstractField.ComponentValueChangeEvent<FaenaProductorEditor, FaenaProductor>,FaenaProductor> {
        private ProductorCS productorCS;
        private DteCS dteCS;

        AbstractFieldSupport<FaenaProductorEditor, FaenaProductor> fieldSupport;
        private BeanValidationBinder<FaenaProductor> binderFP = new BeanValidationBinder<>(FaenaProductor.class);

        FaenaProductorEditor(){
            this.setWidth("100%");
            fieldSupport = new AbstractFieldSupport<>(this, null, Objects::equals, c->{});

            productorCS = new ProductorCS("Productor", getPresentable(), true, true, false);
            productorCS.addValueChangeListener(e-> {this.productorChanged(e, dteCS);});
            binderFP.forField(productorCS).bind("productor");

            dteCS = new DteCS("Tropa", getPresentable(), true, true, false);
            dteCS.setEnabled(false);
            dteCS.addValueChangeListener(e-> {this.dteChanged(e);});
            binderFP.forField(dteCS).bind("tropa");

            add(envolver(productorCS, "50%"),
                    envolver(dteCS, "50%"));

        }

        @Override
        public void setValue(FaenaProductor faenaProductor) {
            if(faenaProductor == null){
                faenaProductor = new FaenaProductor();
            }
            fieldSupport.setValue(faenaProductor);
            binderFP.setBean(faenaProductor);
            getPresentable().setHasChanges(false);
        }

        @Override
        public FaenaProductor getValue() {
            return fieldSupport.getValue();
        }

        @Override
        public Registration addValueChangeListener(ValueChangeListener<? super AbstractField.ComponentValueChangeEvent<FaenaProductorEditor, FaenaProductor>> valueChangeListener) {
            return fieldSupport.addValueChangeListener(valueChangeListener);
        }

        private void productorChanged(HasValue.ValueChangeEvent<?> e, DteCS dteCS) {
            if(e.isFromClient()) {
                if (productorCS.getValue() != null) {
                    dteCS.setEnabled(true);
                    dteCS.setProductor((Productor) productorCS.getValue());
                    dteCS.limpiar();
                    dteCS.setValue(null);
                    if (e.isFromClient()) {
                        getPresentable().setHasChanges(true);
                        limpiar();
                    }
                }
            }
        }

        private void dteChanged(HasValue.ValueChangeEvent<?> e) {
            limpiar();

            if (dteCS.getValue() != null) {
                FaenaRepositorio repo = CDI.current().select(FaenaRepositorio.class).get();
                List list = repo.SaldoCategoria(dteCS.getValue());
                if (list.size() > 0) {
                    //if ( !(getPresentable().getObjetoActivo().isNew() || cabecera.getValue().size()==0) ) {

                    if ( !(getPresentable().getObjetoActivo().isNew() || getPresentable().getObjetoActivo().getFaenaProductor().getFaenaCabezera().size()==0) ) {
//
                        cabecera.setValue(getPresentable().getObjetoActivo().getFaenaProductor().getFaenaCabezera());
                    } else {
                        binderFP.getBean().getFaenaCabezera().clear();
                        list.forEach(elemento -> crearElemento((Object[]) elemento));
                        cabecera.setValue(binderFP.getBean().getFaenaCabezera());
                    }
                    if (e.isFromClient()) {
                        getPresentable().setHasChanges(true);
                    }
                } else {
                    Notification.show("No hay animales para faenar", 4000, Notification.Position.BOTTOM_END);
                    return;
                }
            } else {
                //limpiar();
            }

        }

        private void limpiar(){
            cabecera.removeAll();
            detallesEditor.removeAll();
            cabecera.getValue().clear();
            detallesEditor.getValue().clear();
        }

        private void crearElemento(Object[] e){
            FaenaCabezera fc = new FaenaCabezera();
            DteDetalleCategoria dc = (DteDetalleCategoria)e[0];
            Long faenado = (Long)e[1];
            if(faenado< dc.getCantidad()) {
                fc.setCategoria(dc);
                fc.setFaenado(faenado.intValue());
                binderFP.getBean().getFaenaCabezera().add(fc);
            }else{
                Notification.show("No hay disponible para faena!", 5000, Notification.Position.TOP_END);
            }
        }

        public Stream<HasValue<?, ?>> validate() {
            Stream<HasValue<?, ?>> errorFields = binderFP.validate().getFieldValidationErrors().stream()
                    .map(BindingValidationStatus::getField);

            //return Stream.concat(errorFields, itemsEditor.validate());
            return errorFields;
        }

    }
}

//todo: el valor" de "a faenar debes ser como maximo el valor de "dif."
//todo: si el valor a faenar es cero que no este habilitado el boon cargar
//todo: cuando editas un detalle que dispare el poder guardar
//todo: al cambiar la cantidad de faenar, si ya tiene dato, cambiar el tamaño del arrelog para seguir
//todo: en detalle, cuando pierde el foco en peso derecho iar a peso izq, de la siguiente fila