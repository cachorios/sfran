package com.gmail.sanfrancisco.view.graseriacostoinsumoimpuesto;

import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.gmail.cacho.slapi.layout.MainView;
import com.gmail.cacho.slapi.view.AbstractDefaultView;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.sanfrancisco.entidad.GraseriaCostoInsumoImpuesto;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route(value="graseriacostoinsumoimpuesto", layout = MainView.class)
@PageTitle("Impuestos de insumos en Graserias")
@MenuIcon(VaadinIcon.SPECIALIST)
public class GraseriaCostoInsumoImpuestoView extends AbstractDefaultView<GraseriaCostoInsumoImpuesto> {
    @Inject
    public GraseriaCostoInsumoImpuestoView(AbstractList<GraseriaCostoInsumoImpuesto> list, AbstractPreview<GraseriaCostoInsumoImpuesto> preview, AbstractForm<GraseriaCostoInsumoImpuesto> form) {
        super(list, preview, form, EModoVista.EDITAR);
    }
}
