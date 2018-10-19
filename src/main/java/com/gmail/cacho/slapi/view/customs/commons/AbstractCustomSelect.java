package com.gmail.cacho.slapi.view.customs.commons;


import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.Sistema;
import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.interfaces.IVisualizable;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.cacho.slapi.view.utils.ViewTools;
import com.gmail.cacho.slbase.core.Constantes;
import com.gmail.cacho.slbase.core.enums.ENivelAplicacion;
import com.vaadin.flow.component.AbstractCompositeField;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;

import java.util.List;


@HtmlImport("frontend://src/views/crud/custom-select.html")
@Tag("custom-select")
public abstract class AbstractCustomSelect<T extends AbstractEntidad> extends AbstractCompositeField<VerticalLayout,AbstractCustomSelect<T>, T> {
    private IVisualizable padre;
    private T valor, itemAdd;
    private String titulo;
    private Button find = new Button();
    private Button ver = new Button();
    private Button del = new Button();
    private Label lblCaption = new Label();
    private TextField codigo ;
    private TextField descripcion = new TextField();
    private boolean conBuscar, conVer, conAdd;
    private FilterablePageableDataProvider<T, Long, String> dataProvider;

    public AbstractCustomSelect(String caption, boolean conBuscar, boolean conVer, boolean conAdd, IVisualizable padre) {

        super(null);
        lblCaption.setText(caption);
        lblCaption.setWidth("100%");


        codigo = new TextField();
        this.conBuscar = conBuscar;
        this.conVer = conVer;
        this.conAdd = conAdd;
        this.padre = padre;
        this.titulo = caption;

        this.getContent().setAlignItems(FlexComponent.Alignment.BASELINE);
        this.getContent().setClassName("cselect");

    }

    @Override
    protected VerticalLayout initContent() {
        VerticalLayout content = new VerticalLayout();
        content.setPadding(false);
        content.setMargin(false);
        content.setSpacing(false);
        content.setHeight(ViewTools.ALTO_DEFAULT);

        HorizontalLayout layout = new HorizontalLayout();
        layout.setWidth("100%");
        layout.setMargin(false);
        layout.setSpacing(false);
        layout.setPadding(false);

        lblCaption.setClassName("lbl-caption");

        content.add(lblCaption, layout);

        codigo.setValueChangeMode(ValueChangeMode.ON_BLUR );
         //setValueChangeTimeout(Constantes.SYS_TEXTCHANGEDELAY);
        codigo.addValueChangeListener(e -> onCambioValorManual(e.getValue()));
        codigo.addClassName("codigo");
        codigo.addFocusListener(e -> setearShortcuts());
        codigo.setEnabled(false);

        if (conBuscar) {
            layout.add(codigo, completarBorrar(del), completarBuscar(find) );
            codigo.setEnabled(true);
        } else {
            layout.add(codigo);
        }


        descripcion.setEnabled(false);
        descripcion.setWidth("65%");

        if (conVer) {
            layout.add(descripcion, completarVer(ver));
        } else {
            layout.add(descripcion);
        }
        layout.expand(descripcion);

        return content;
    }
    protected Button completarBuscar(Button find) {
        //find.setClassName("");
        find.getElement().setProperty("title", C.CRUD_MSG_BUSCAR);
        find.setIcon(VaadinIcon.SEARCH.create());
        find.addClickListener(e -> {
            try {
                buscarElemento();
            } catch (Exception ex) {
                Sistema.getSistema().mostrarMensaje(ENivelAplicacion.ERROR, Constantes.MSJ_ERR_CS_CANTSHOW_SELECT, ex.getMessage());
            }

        });
        find.addFocusListener(e -> setearShortcuts());
        return find;
    }

    protected Button completarBorrar(Button del) {
//        del.setClassName("");
        del.getElement().setProperty("title",C.CRUD_MSG_LIMPIAR);
        del.setIcon(VaadinIcon.ERASER.create());
        del.addClickListener(e -> limpiar());
        del.addFocusListener(e -> setearShortcuts());
        return del;
    }

    protected Button completarVer(Button ver) {
        ////ver.setStyleName("small");
        ver.getElement().setProperty("title",C.CRUD_MSG_VER);
        ver.setIcon(VaadinIcon.EYE.create());
        ver.addClickListener(e -> {
            try {
                if (getValue() != null) {
                    verElemento();
                } else {
                    Sistema.getSistema()
                           .mostrarMensaje(ENivelAplicacion.ERROR, Constantes.MSJ_ERR_CS_NOITEM, titulo.toUpperCase());
                }
            } catch (Exception ex) {
                Sistema.getSistema().mostrarMensaje(ENivelAplicacion.ERROR, Constantes.MSJ_ERR_CS_CANTSHOW_ITEM, ex.getMessage());
            }
        });
        ver.addFocusListener(e -> setearShortcuts());
        return ver;
    }

    protected String getCodigo() { return valor.getId().toString(); }

    protected String getDescripcion() { return valor.toSimpleString(); }

    public void buscarElemento() {
        WinCustomSelect winCustomSelect = new WinCustomSelect<>(getListTitulo(), getDataProvider(), getListaCols(), this);
        winCustomSelect.open();
    }

    protected IPresentableForm<T> getFormAgregar() { return null; }

    protected void onCambioValorManual(String valor) {
        try {
            if (valor != null && valor != "") {
                T val = getElemento(valor);
                if (val != null) {
                    setValue(val);
                    return;
                }
            }
        } catch(Exception ex) {
            Sistema.getSistema().mostrarMensaje(ENivelAplicacion.ERROR, Constantes.MSJ_ERR_CS_CANTSHOW_ITEM, C.MSJ_ERR_CS_NOITEM);
            //descripcion.setValue("Valor invalido...");
            codigo.setValue(getCodigo());
        }
    }

    protected abstract T getElemento(String codigo);

    protected abstract void verElemento();

    protected abstract String getListTitulo();

    protected abstract List<ColumnList> getListaCols();

    protected abstract FilterablePageableDataProvider<T, Long, String> generarDataProvider();

    private void setearShortcuts() {
        ////
        /*
        find.setClickShortcut(ShortcutAction.KeyCode.F2);
        ver.setClickShortcut(ShortcutAction.KeyCode.F3);
        del.setClickShortcut(ShortcutAction.KeyCode.F6);
        */
    }

    public void setEditable(boolean editable) {
        if (conBuscar) {
            find.setEnabled(editable);
            codigo.setEnabled(editable);
        } else {
            find.setEnabled(false);
            codigo.setEnabled(false);
        }
        ver.setEnabled(true);
    }

    public FilterablePageableDataProvider<T, Long, String> getDataProvider() {
        if (dataProvider == null) {
            dataProvider = generarDataProvider();
        }
        return dataProvider;
    }

    public IVisualizable getPadre() {
        return padre;
    }

    public boolean conAdd() { return conAdd; }

    public T getItemAdd() { return itemAdd; }

    public void setItemAdd(T itemAdd) { this.itemAdd = itemAdd; }

    public void limpiar() {
        ////setValue(null);
        codigo.clear();
        descripcion.clear();
    }



    @Override
    protected void setPresentationValue(T t) {

    }

    public void setValue(T t) {
        valor = t;
        if (valor != null) {
            codigo.setValue(getCodigo());
            descripcion.setValue(getDescripcion());
        }
        del.setEnabled(valor != null);

        this.setModelValue(valor,true);
        ver.focus();
    }


    @Override
    public T getValue() {
        return valor;
    }


}