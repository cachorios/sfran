package com.gmail.sanfrancisco.view.dtedetallecategoria;

import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerForm;
import com.gmail.cacho.slapi.view.interfaces.IPresenterForm;
import com.gmail.sanfrancisco.entidad.DteDetalleCategoria;
import com.vaadin.flow.component.Focusable;

import javax.inject.Inject;

public class DteDetalleCategoriaForm extends AbstractForm<DteDetalleCategoria> {

    @Inject
    public DteDetalleCategoriaForm(IPresenterForm<DteDetalleCategoria> presenter) {
        super(presenter);
    }

    @Override
    protected ILayoutInnerForm<DteDetalleCategoria> generarLayout(AbstractForm<DteDetalleCategoria> padre, String titulo) {
        return new DteDetalleCategoriaInnerForm(padre, titulo);
    }

    @Override
    protected Focusable getPrimerElementoForm() {
        return null;
    }

    @Override
    public String getTagVista() {
        return "RCV_TAG_DTEDETALLECATEGORIA";
    }

    @Override
    public Class<DteDetalleCategoria> getEntityType() {
        return DteDetalleCategoria.class;
    }

    @Override
    public String getTitulo() {
        return "Categorias de un DTE";
    }
}