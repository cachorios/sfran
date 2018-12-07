package com.gmail.sanfrancisco.view.cuerocostoinsumoimpuesto;

import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.gmail.cacho.slapi.layout.MainView;
import com.gmail.cacho.slapi.view.AbstractDefaultView;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.sanfrancisco.entidad.CueroCostoInsumoImpuesto;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route(value="cuerocostoinsumoimpuesto", layout = MainView.class)
@PageTitle("Impuestos de insumos en Cueros")
@MenuIcon(VaadinIcon.SPECIALIST)
public class CueroCostoInsumoImpuestoView extends AbstractDefaultView<CueroCostoInsumoImpuesto> {
    @Inject
    public CueroCostoInsumoImpuestoView(AbstractList<CueroCostoInsumoImpuesto> list, AbstractPreview<CueroCostoInsumoImpuesto> preview, AbstractForm<CueroCostoInsumoImpuesto> form) {
        super(list, preview, form, EModoVista.EDITAR);
    }
}