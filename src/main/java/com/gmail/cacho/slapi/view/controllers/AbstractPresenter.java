package com.gmail.cacho.slapi.view.controllers;


import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.slapi.Sistema;
import com.gmail.cacho.slapi.comunes.Recursos;
import com.gmail.cacho.slapi.view.interfaces.IPresentable;
import com.gmail.cacho.slapi.view.interfaces.IPresenter;
import com.gmail.cacho.slapi.view.interfaces.IVisualizableGestionable;
import com.gmail.cacho.slapi.view.utils.ComponenteVista;
import com.gmail.cacho.slbase.core.Constantes;
import com.gmail.cacho.slbase.security.enums.ETipoPermiso;
import com.vaadin.flow.component.button.Button;


public abstract class AbstractPresenter<T extends AbstractEntidad> implements IPresenter<T> {
    private IPresentable<T> presentable;

    @Override
    public void setPresentable(IPresentable<T> presentable) {
        this.presentable = presentable;
    }

    @Override
    public IPresentable<T> getPresentable() {
        return presentable;
    }

    @Override
    final public void aplicarPermisos() {
        for (ComponenteVista b : ((IVisualizableGestionable)presentable).getComponentesVista()) {
            Button componente = b.getComponente();
            try {
                if (!Sistema.getSistema().getSecurityControl().isUserSignedIn()) {
                    componente.setVisible(false);
                } else if (componente.getElement().getProperty("data").equals(Recursos.RCV_BTN_ALLCAN)) {
                    componente.setVisible(true);
                } else {
                    componente.setVisible(
                            Sistema.getSistema()
                                   .getSecurityControl()
                                   .usuarioActivoPoseeCadenaPermiso(
                                           ETipoPermiso.EJECUTAR.name()
                                                .concat(Constantes.SYS_CAD_REFER)
                                                .concat(((IVisualizableGestionable)presentable).getTagVista())
                                                .concat(Recursos.RCV_TAG_SPARATOR)
                                                .concat(componente.getElement().getProperty("data"))));
                }
            } catch (Exception sec) {
                componente.setVisible(false);
            }

            componente.setEnabled(componente.isVisible());
        }
    }
}
