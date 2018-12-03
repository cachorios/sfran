package com.gmail.sanfrancisco.view.vehiculocostoinsumoimpuesto;

import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.gmail.cacho.slapi.layout.MainView;
import com.gmail.cacho.slapi.view.AbstractDefaultView;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.sanfrancisco.entidad.VehiculoCostoInsumoImpuesto;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route(value="vehiculocostoinsumoimpuesto", layout = MainView.class)
@PageTitle("Lista de Impuestos de costo de vehiculo")
@MenuIcon(VaadinIcon.SPECIALIST)
public class VehiculoCostoInsumoImpuestoView extends AbstractDefaultView<VehiculoCostoInsumoImpuesto> {
    @Inject
    public VehiculoCostoInsumoImpuestoView(AbstractList<VehiculoCostoInsumoImpuesto> list, AbstractPreview<VehiculoCostoInsumoImpuesto> preview, AbstractForm<VehiculoCostoInsumoImpuesto> form) {
        super(list, preview, form, EModoVista.EDITAR);
    }
}