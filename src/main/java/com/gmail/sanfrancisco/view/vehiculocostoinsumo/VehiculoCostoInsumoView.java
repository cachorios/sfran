package com.gmail.sanfrancisco.view.vehiculocostoinsumo;

import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.gmail.cacho.slapi.layout.MainView;
import com.gmail.cacho.slapi.view.AbstractDefaultView;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.sanfrancisco.entidad.VehiculoCostoInsumo;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route(value="vehiculocostoinsumo", layout = MainView.class)
@PageTitle("Insumos de Vehiculos")
@MenuIcon(VaadinIcon.SPECIALIST)
public class VehiculoCostoInsumoView extends AbstractDefaultView<VehiculoCostoInsumo> {
    @Inject
    public VehiculoCostoInsumoView(AbstractList<VehiculoCostoInsumo> list, AbstractPreview<VehiculoCostoInsumo> preview, AbstractForm<VehiculoCostoInsumo> form) {
        super(list, preview, form, EModoVista.EDITAR);
    }
}