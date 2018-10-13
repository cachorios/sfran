package com.gmail.sanfrancisco.view.insumocostovehiculo;

import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.gmail.cacho.slapi.layout.MainView;
import com.gmail.cacho.slapi.view.AbstractDefaultView;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.sanfrancisco.entidad.InsumoCostoVehiculo;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route(value="insumocostovehiculo", layout = MainView.class)
@PageTitle("Lista de Insumos de costo de vehiculo")
@MenuIcon(VaadinIcon.SPECIALIST)
public class InsumoCostoVehiculoView extends AbstractDefaultView<InsumoCostoVehiculo> {
    @Inject
    public InsumoCostoVehiculoView(AbstractList<InsumoCostoVehiculo> list, AbstractPreview<InsumoCostoVehiculo> preview, AbstractForm<InsumoCostoVehiculo> form) {
        super(list, preview, form, EModoVista.EDITAR);
    }
}