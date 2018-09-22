package com.gmail.cacho.slapi.view.customs.commons;


import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.slapi.Sistema;
import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.cacho.slapi.view.interfaces.IPresentableForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.cacho.slapi.view.interfaces.IVisualizable;
import com.gmail.cacho.slbase.core.Constantes;
import com.gmail.cacho.slbase.core.enums.ENivelAplicacion;
import com.gmail.cacho.slbase.core.excepciones.MessageException;
import com.gmail.cacho.slbase.view.excepciones.VistaErrorException;
import com.vaadin.flow.component.AbstractCompositeField;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

public abstract class AbstractCustomAdd<T extends AbstractEntidad> extends AbstractCompositeField<HorizontalLayout,AbstractCustomAdd<T>, T > {
    private IVisualizable padre;
    private T valor;
    private String titulo;
    private TextField codigo = new TextField();
    private Button add = new Button();
    private Button ver = new Button();
    private TextField descripcion = new TextField();
    private boolean conVer, editar;

    public AbstractCustomAdd(String caption, boolean conVer, IVisualizable padre, boolean editar) {
        super(null);
        
        
//        setCaption(caption);
        getContent().setClassName("small");

        this.conVer = conVer;
        this.editar = editar;
        this.padre = padre;
        this.titulo = caption;

    }

    public void setEditable(boolean editable, boolean agregable) {
        codigo.setEnabled(editable);
        add.setEnabled(agregable);
        ver.setEnabled(true);
    }

    public IVisualizable getPadre() {
        return padre;
    }

    private Button completarAgregar(Button add) {
        add.setClassName("small");
        add.getElement().setProperty("title",((editar) ? C.CRUD_FORM_BTN_EDITAR : C.CRUD_FORM_BTN_AGREGAR));
        add.setIcon(((editar) ? VaadinIcon.EDIT.create() : VaadinIcon.PLUS_CIRCLE_O.create()));
        add.addFocusListener(e -> setearShortcuts());
        add.addClickListener(e -> {
            try {
                agregarElemento();
            } catch (Exception ex) {
                Sistema.getSistema().mostrarMensaje(ENivelAplicacion.ERROR, Constantes.MSJ_ERR_CS_CANTSHOW_SELECT, ex.getMessage());
            }

        });
        return add;
    }

    private Button completarVer(Button ver) {
        ver.setClassName("small");
        ver.getElement().setProperty("title",C.CRUD_MSG_VER);
        ver.setIcon(VaadinIcon.EYE.create());
        ver.addFocusListener(e -> setearShortcuts());
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
        return ver;
    }

    private void agregarElemento() {
        if (padre != null
                && padre instanceof IPresentableForm
                && ((IPresentableForm) padre).hasUnsavedChanges()) {
                    ((IPresenterForm) ((IPresentableForm) padre).getPresenter()).formSaveAndContinue(this::abrirForm);
        } else {
            abrirForm();
        }
    }

    private void abrirForm() {
        if (editar) {
            getFormAgregar().iniciar(EModoVista.EDITAR, getValue());
        } else {
            getFormAgregar().setExecutableOnSaveOK(this::onFormSaveOK);
            getFormAgregar().iniciar(EModoVista.NUEVO, null);
        }
    }

    private void setearShortcuts() {
//        ver.setClickShortcut(ShortcutAction.KeyCode.F3);
//        add.setClickShortcut(((editar) ? ShortcutAction.KeyCode.F5 : ShortcutAction.KeyCode.F4));
    }

    protected String getCodigo() { return valor.getId().toString(); }

    protected String getDescripcion() { return valor.toSimpleString(); }

    protected void onCambioValorManual(String valor) {
        try {
            if (valor != null) {
                T val = getElemento(valor);
                if (val != null) {
                    setValue(val);
                    return;
                }
            }
            throw new VistaErrorException(C.MSJ_ERR_CS_NOITEM);
        } catch(MessageException ex) {
            Sistema.getSistema().mostrarMensaje(ENivelAplicacion.ERROR, Constantes.MSJ_ERR_CS_CANTSHOW_ITEM, ex.getSimpleMenssage());
        } catch(Exception ex) {
            Sistema.getSistema().mostrarMensaje(ENivelAplicacion.ERROR, Constantes.MSJ_ERR_CS_CANTSHOW_ITEM, ex.getMessage());
        }
    }

    protected abstract T getElemento(String codigo);

    protected abstract void verElemento();

    protected IPresentableForm<T> getFormAgregar() { return null; }

    protected void onFormSaveOK() { }


    @Override
    protected HorizontalLayout initContent() {
        HorizontalLayout layout = new HorizontalLayout();

        //codigo.setValueChangeTimeout(Constantes.SYS_TEXTCHANGEDELAY);
        codigo.addValueChangeListener(e -> onCambioValorManual(e.getValue()));
        codigo.setClassName("small");
        codigo.addClassName("custom_select_width");
        codigo.addFocusListener(e -> setearShortcuts());
        codigo.setEnabled(editar);

        HorizontalLayout grupoCodigo = new HorizontalLayout();
        grupoCodigo.setWidth("-1px");
        grupoCodigo.add(codigo, completarAgregar(add));
//        grupoCodigo.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        layout.add(grupoCodigo);
        layout.setFlexGrow(0,grupoCodigo);

//        descripcion.setStyleName("small");
        descripcion.setWidth("100%");
        descripcion.setEnabled(false);
        if (conVer) {
            HorizontalLayout grupoDesc = new HorizontalLayout();
            grupoDesc.setWidth("-1px");
            grupoDesc.add(descripcion, completarVer(ver));
            //grupoDesc.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
            layout.add(grupoDesc);
            layout.setFlexGrow(1,grupoDesc);
        } else {
            layout.add(descripcion);
            layout.setFlexGrow(1,descripcion);
        }

        layout.setWidth("100%");
        layout.setMargin(false);
        layout.setSpacing(false);

        return layout;
    }


    @Override
    public void setValue(T value) {
        valor = value;
        codigo.setValue(getCodigo());
        descripcion.setValue(getDescripcion());
        ver.focus();
    }

    @Override
    public T getValue() {
        return valor;
    }

    @Override
    protected void setPresentationValue(T t) {
        this.initContent();
        this.setModelValue(t, true);
    }
}