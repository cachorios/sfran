package com.gmail.sanfrancisco.view.facturacostovehiculo;

import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.gmail.cacho.slapi.layout.MainView;
import com.gmail.cacho.slapi.view.AbstractDefaultView;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.sanfrancisco.entidad.FacturaCostoVehiculo;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route(value="facturacostovehiculo", layout = MainView.class)
@PageTitle("Lista Facturas  de costos de Vehiculos")
@MenuIcon(VaadinIcon.SPECIALIST)
public class FacturaCostoVehiculoView extends AbstractDefaultView<FacturaCostoVehiculo> {
    @Inject
    public FacturaCostoVehiculoView(AbstractList<FacturaCostoVehiculo> list, AbstractPreview<FacturaCostoVehiculo> preview, AbstractForm<FacturaCostoVehiculo> form) {
        super(list, preview, form, EModoVista.EDITAR);
    }
}