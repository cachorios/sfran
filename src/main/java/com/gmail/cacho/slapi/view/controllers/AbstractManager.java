package com.gmail.cacho.slapi.view.controllers;


import com.gmail.cacho.slapi.view.interfaces.IManager;
import com.gmail.cacho.slapi.view.interfaces.IVisualizableGestionable;
import com.gmail.cacho.slapi.view.utils.ComponenteVista;
import com.vaadin.flow.component.button.Button;

public abstract class AbstractManager implements IManager {
    private IVisualizableGestionable visuatable;

    @Override
    public void setGestionable(IVisualizableGestionable presentable) {
        this.visuatable = presentable;
    }

    @Override
    public IVisualizableGestionable getGestionable() {
        return visuatable;
    }

    @Override
    final public void aplicarPermisos() {
        for (ComponenteVista b : visuatable.getComponentesVista()) {
            Button componente = b.getComponente();
            componente.setVisible(true); //
        }                                //
//            try {
//                if (!Sistema.getSistema().getSecurityControl().isUserSignedIn()) {
//                    componente.setVisible(false);
//                } else if (componente.getData().equals(R.RCV_BTN_ALLCAN)) {
//                    componente.setVisible(true);
//                } else {
//                    componente.setVisible(
//                            Sistema.getSistema()
//                                   .getSecurityControl()
//                                   .usuarioActivoPoseeCadenaPermiso(
//                                           ETipoPermiso.EJECUTAR.name()
//                                                .concat(Constantes.SYS_CAD_REFER)
//                                                .concat(visuatable.getTagVista())
//                                                .concat(R.RCV_TAG_SPARATOR)
//                                                .concat((String) componente.getData())));
//                }
//            } catch (Exception sec) {
//                componente.setVisible(false);
//            }
//
//            componente.setEnabled(componente.isVisible());
//        }
    }
}
