package com.gmail.sanfrancisco.view.vehiculocosto;

import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.gmail.cacho.slapi.layout.MainView;
import com.gmail.cacho.slapi.view.AbstractDefaultView;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.sanfrancisco.entidad.VehiculoCosto;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route(value="vehiculocosto", layout = MainView.class)
@PageTitle("Lista Facturas  de costos de Vehiculos")
@MenuIcon(VaadinIcon.SPECIALIST)
public class VehiculoCostoView extends AbstractDefaultView<VehiculoCosto> {
    @Inject
    public VehiculoCostoView(AbstractList<VehiculoCosto> list, AbstractPreview<VehiculoCosto> preview, AbstractForm<VehiculoCosto> form) {
        super(list, preview, form, EModoVista.EDITAR);
    }
}