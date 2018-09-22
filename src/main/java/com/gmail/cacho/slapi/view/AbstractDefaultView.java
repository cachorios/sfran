package com.gmail.cacho.slapi.view;


import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.cacho.slapi.view.interfaces.IVisualizable;
import com.gmail.cacho.slbase.logging.L;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import javax.annotation.PostConstruct;
import java.io.Serializable;

/**
 * Esta clase implementa el funcionamiento de una Vista Inicial por defecto para el Sistema.
 * Esto implica que debería ser la clase padre de la jerarquia de clases que responden a los
 * eventos "iniciales" en una cadena de vistas del Sistema: los eventos desencadenados por
 * las opciones del menu pricnipal. Cada una de las clases hijas estará relacionada a una
 * opción específica del menu que actúa sobre una Entidad específica del Sistema y deberia
 * estar "anotada" de la siguiente manera (Ejemplo para la entidad Titulo):
 * \@CDIView("Titulo")
 * \@MenuCaption("Titulos")
 * \@MenuIcon(VaadinIcons.TABLE)
 * , donde, como se ve, se hace referencia al nombre de la vista, a el texto de la opción
 * de menú, y a el icno que acompaña a dicho texto en el menu (si hubiere uno).
 *
 * @param <T> la Entidad del Sistema que se gestionará vía listado dentro de este objeto presentable
 * @author cachorios-jmfragueiro
 * @version 20180204
 */
public abstract class AbstractDefaultView<T extends AbstractEntidad> extends VerticalLayout implements Serializable {
    private IVisualizable principal;
    private EModoVista modo;

    protected AbstractDefaultView(AbstractForm<T> form, EModoVista modo) {
        this.principal = form;
        this.modo = modo;
        L.info(C.MSG_ACC_OPENVIEW, this.getClass().getSimpleName()
                                       .concat(C.SYS_CAD_OPENTYPE)
                                       .concat(principal.getClass().getSimpleName())
                                       .concat(C.SYS_CAD_LOGSEP)
                                       .concat(modo.toString())
                                       .concat(C.SYS_CAD_CLOSETPE));
    }

    protected AbstractDefaultView(AbstractPanel panel, EModoVista modo) {
        this.principal = panel;
        this.modo = modo;
        L.info(C.MSG_ACC_OPENVIEW, this.getClass().getSimpleName()
                                       .concat(C.SYS_CAD_OPENTYPE)
                                       .concat(principal.getClass().getSimpleName())
                                       .concat(C.SYS_CAD_LOGSEP)
                                       .concat(modo.toString())
                                       .concat(C.SYS_CAD_CLOSETPE));
    }

    protected AbstractDefaultView(AbstractList<T> list, EModoVista modo) {
        this.principal = list;
        this.modo = modo;
        L.info(C.MSG_ACC_OPENVIEW, this.getClass().getSimpleName()
                                       .concat(C.SYS_CAD_OPENTYPE)
                                       .concat(principal.getClass().getSimpleName())
                                       .concat(C.SYS_CAD_LOGSEP)
                                       .concat(modo.toString())
                                       .concat(C.SYS_CAD_LOGSEP)
                                       .concat(C.SYS_CAD_CLOSETPE));
    }

    protected AbstractDefaultView(AbstractList<T> list, AbstractPreview<T> preview, EModoVista modo) {
        this(list, modo);
        list.setPreview(preview);
    }

    protected AbstractDefaultView(AbstractList<T> list, AbstractPreview<T> preview, AbstractForm<T> form, EModoVista modo) {
        this(list, preview, modo);
        list.setForm(form);
    }

    protected AbstractDefaultView(AbstractList<T> list, AbstractForm<T> form, EModoVista modo) {
        this(list, modo);
        list.setForm(form);
    }

    @PostConstruct
    public void init() {
        setSpacing(false);
        setMargin(false);
        setPadding(false);
        setClassName("view");
        principal.iniciar(((modo != null) ? modo : EModoVista.VER), null);
        removeAll();
        add(principal.getViewComponent());
    }
}


