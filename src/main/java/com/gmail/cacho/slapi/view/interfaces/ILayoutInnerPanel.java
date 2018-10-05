package com.gmail.cacho.slapi.view.interfaces;

/**
 * Esta interface representa el comportamiento público generico deseable
 * de una clase que implementa un 'Layout' para un objeto presentable de
 * tipo 'FORM CRUD' (ejemplo AbstractForm) del sistema.
 *
 * @author larios
 * @version 20180201
 */
public interface ILayoutInnerPanel extends ILayoutInner {
    IManageablePanel getManageable();
}
