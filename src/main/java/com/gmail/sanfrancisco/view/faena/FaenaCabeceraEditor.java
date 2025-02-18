package com.gmail.sanfrancisco.view.faena;

import com.gmail.cacho.backend.enumeradores.ETipoParametro;
import com.gmail.cacho.slapi.view.customs.params.ParamCSComponent;
import com.gmail.cacho.slapi.view.interfaces.IPresentable;
import com.gmail.sanfrancisco.converter.IntegerConverter;
import com.gmail.sanfrancisco.entidad.DteDetalleCategoria;
import com.gmail.sanfrancisco.entidad.FaenaCabezera;
import com.gmail.sanfrancisco.entidad.FaenaDetalle;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.HasValueAndElement;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.internal.AbstractFieldSupport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;

import com.vaadin.flow.shared.Registration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static com.gmail.cacho.slapi.view.utils.ViewTools.envolver;

@Tag("faena-cabecera")
@HtmlImport("src/views/faena/faena-cabecera.html")
public class FaenaCabeceraEditor extends Div implements HasValueAndElement<AbstractField.ComponentValueChangeEvent<FaenaCabeceraEditor, List<FaenaCabezera>>, List<FaenaCabezera>> {

    IPresentable padre;

    private final AbstractFieldSupport<FaenaCabeceraEditor,List<FaenaCabezera>> fieldSupport;

    private boolean hasChanges = false;
    //    private BeanValidationBinder<FaenaCabezera> binderFC = new BeanValidationBinder<>(FaenaCabezera.class);
    FaenaDetallesEditor detallesEditor;

    public FaenaCabeceraEditor(IPresentable padre, FaenaDetallesEditor detallesEditor) {

        this.padre = padre;
        this.detallesEditor = detallesEditor;

        this.fieldSupport = new AbstractFieldSupport<>(this, Collections.emptyList(),
                Objects::equals, c ->  {});
        setWidth("100%");
    }

    @Override
    public void setValue(List<FaenaCabezera> faenaCabezeras) {
        fieldSupport.setValue(faenaCabezeras);
        hasChanges = false;
        removeAll();

        if (faenaCabezeras != null) {
            faenaCabezeras.forEach(this::createItem);
        }
        setHasChanges(false);
    }

    private Item createItem(FaenaCabezera faenaCabezera) {
        Item item = new Item();
        add(item);
        item.setValue(faenaCabezera);
        return item;
    }

    @Override
    public List<FaenaCabezera> getValue() {
        return fieldSupport.getValue();
    }

    @Override
    public Registration addValueChangeListener(ValueChangeListener<? super AbstractField.ComponentValueChangeEvent<FaenaCabeceraEditor, List<FaenaCabezera>>> valueChangeListener) {
        return fieldSupport.addValueChangeListener(valueChangeListener);
    }

    public boolean hasChanges() {
        return hasChanges;
    }

    private void setHasChanges(boolean hasChanges) {
        this.hasChanges = hasChanges;
        if (hasChanges) {
            ///fireEvent(new com.gmail..views.sfran.events.ValueChangeEvent(this));
        }
    }

    protected class Item extends HorizontalLayout implements HasValueAndElement<AbstractField.ComponentValueChangeEvent<Item, FaenaCabezera>, FaenaCabezera> {
        private ParamCSComponent categoria;
        private TextField cantidad;
        private TextField faenado;
        private TextField diferencia;
        private TextField kgVivo;
        private TextField aFaenar;
        private Button btnAgregar;
        private final AbstractFieldSupport<Item, FaenaCabezera> fieldSupport;
        private BeanValidationBinder<FaenaCabezera> binder = new BeanValidationBinder<>(FaenaCabezera.class);
        private List dato;

        Item() {
            this.setWidth("100%");
            this.fieldSupport = new AbstractFieldSupport<>(this, null, Objects::equals, c -> {});

            categoria = new ParamCSComponent("", padre , true, true, "Categorias", ETipoParametro.CATEGORIA_ANIMAL);
            categoria.setEnabled(false);

            cantidad    = new TextField(); cantidad.setWidth("10%");    cantidad.setEnabled(false);
            faenado     = new TextField(); faenado.setWidth("10%");     faenado.setEnabled(false);
            diferencia  = new TextField(); diferencia.setWidth("10%");  diferencia.setEnabled(false);
            kgVivo      = new TextField(); kgVivo.setWidth("10%");      kgVivo.setEnabled(false);

            aFaenar     = new TextField(); aFaenar.setWidth("10%");
            btnAgregar = new Button("Cargar"); btnAgregar.setWidth("100%");
            btnAgregar.setEnabled(false);

            aFaenar.setPreventInvalidInput(true);
            aFaenar.addValueChangeListener( this::aFaenarChanged);

            binder.forField(aFaenar)
                    .withConverter(new IntegerConverter())
                    .bind("cantidad");

            add(
                envolver(categoria,"40%"),
                cantidad,
                faenado,
                diferencia,
                kgVivo,
                aFaenar,
                envolver(btnAgregar,"10%")
            );
        }

        private void aFaenarChanged(AbstractField.ComponentValueChangeEvent<TextField, String> event) {
            btnAgregar.setEnabled(false);
            if(event.isFromClient()) {
                if (event.getOldValue() == "" || Integer.valueOf(event.getOldValue()) == 0) {
                    Integer dif = Integer.valueOf(cantidad.getValue()) - Integer.valueOf(faenado.getValue());
                    if (Integer.valueOf(event.getValue()) > dif) {
                        aFaenar.clear();
                        aFaenar.focus();
                        Notification.show("No puede faenar mas de lo disponible!", 3000, Notification.Position.MIDDLE);
                        return;
                    }
                }else{
//                    aFaenar.setValue(event.getOldValue());
//                    aFaenar.focus();
//                    Notification.show("No puede faenar mas de lo disponible!", 3000, Notification.Position.MIDDLE);
                }
            }
            if(!aFaenar.isEmpty()){
                if(Integer.valueOf(aFaenar.getValue())>0) {
                    btnAgregar.setEnabled(true);
                }
            }
        }

        @Override
        public void setValue(FaenaCabezera faenaCabezera) {
            fieldSupport.setValue(faenaCabezera);
            DteDetalleCategoria d = faenaCabezera.getCategoria();
            categoria.setValue(d.getCategoria());
            cantidad.setValue(d.getCantidad().toString());
            kgVivo.setValue(d.getKgVivo().toString());
            faenado.setValue(faenaCabezera.getFaenado().toString());
            btnAgregar.addClickListener(e -> crearDetalle(faenaCabezera, Integer.valueOf(aFaenar.getValue())));
            Integer dif = 0;
            dif = d.getCantidad() - faenaCabezera.getFaenado();
            diferencia.setValue( dif.toString() );

            binder.setBean(faenaCabezera);
        }

        private void crearDetalle(FaenaCabezera faenaCabezera, int cantidad) {
            if(faenaCabezera.getCantidad()>0) {
                detallesEditor.removeAll();

                if (faenaCabezera.getFaenaDetalle() == null || faenaCabezera.getFaenaDetalle().size() == 0 ) {
                    ArrayList<FaenaDetalle> adetalle = new ArrayList<>();
                    for (int i = 0; i < faenaCabezera.getCantidad(); i++){
                        adetalle.add(new FaenaDetalle(i+1,faenaCabezera.getCategoria().getCategoria(),0.0,0.0 ));
                    }
                    faenaCabezera.setFaenaDetalle(adetalle);
                }else
                if(faenaCabezera.getFaenaDetalle().size() > cantidad ){
                    Integer j = faenaCabezera.getFaenaDetalle().size() -1;
                    for (int i = j; i>= cantidad; i--){
                        faenaCabezera.getFaenaDetalle().remove(i);
                    }
                }else
                    if(faenaCabezera.getFaenaDetalle().size() < cantidad ){
                        Integer j = faenaCabezera.getFaenaDetalle().size() ;
                        for (int i = j ; i < cantidad ; i++){
                            faenaCabezera.getFaenaDetalle().add(new FaenaDetalle(i+1,faenaCabezera.getCategoria().getCategoria(),0.0,0.0 ));

                        }

                }
                detallesEditor.setValue(faenaCabezera.getFaenaDetalle());
//            }else{
//                Notification.show("No puede faena mas de los disponible!!", 1000, Notification.Position.MIDDLE);
            }


        }

        @Override
        public FaenaCabezera getValue() {
            return fieldSupport.getValue();
        }

        @Override
        public Registration addValueChangeListener(ValueChangeListener<? super AbstractField.ComponentValueChangeEvent<Item, FaenaCabezera>> valueChangeListener) {
            return fieldSupport.addValueChangeListener(valueChangeListener);
        }

    }
}
