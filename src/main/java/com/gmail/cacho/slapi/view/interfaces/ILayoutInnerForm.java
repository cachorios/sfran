package com.gmail.cacho.slapi.view.interfaces;


import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.data.binder.BeanValidationBinder;


/**
 * Esta interface representa el comportamiento público generico deseable
 * de una clase que implementa un 'Layout' para un objeto presentable de
 * tipo 'FORM CRUD' (ejemplo AbstractForm) del sistema.
 *
 * @author larios
 * @version 20180201
 */
public interface ILayoutInnerForm<T extends AbstractEntidad> extends ILayoutInner {
    void mostrar();

    IPresentableForm<T> getPresentable();

    void bindFormFields(BeanValidationBinder<T> binder);

    Button getGuarAddButton();

    void cerrar();
}
