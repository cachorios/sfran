package com.gmail.sanfrancisco.view.dtedetallecategoria;

import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.gmail.cacho.slapi.layout.MainView;
import com.gmail.cacho.slapi.view.AbstractDefaultView;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.sanfrancisco.entidad.DteDetalleCategoria;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route(value="dte-categorias", layout = MainView.class)
@PageTitle("Lista de Detalles de categorias en DTE")
@MenuIcon(VaadinIcon.SPECIALIST)
public class DteDetalleCategoriaView extends AbstractDefaultView<DteDetalleCategoria> {
    @Inject
    public DteDetalleCategoriaView(AbstractList<DteDetalleCategoria> list, AbstractPreview<DteDetalleCategoria> preview, AbstractForm<DteDetalleCategoria> form) {
        super(list, preview, form, EModoVista.EDITAR);
    }
}