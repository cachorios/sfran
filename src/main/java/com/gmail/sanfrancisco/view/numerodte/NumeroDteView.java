package com.gmail.sanfrancisco.view.numerodte;

import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.gmail.cacho.slapi.layout.MainView;
import com.gmail.cacho.slapi.view.AbstractDefaultView;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.sanfrancisco.entidad.NumeroDte;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route(value="nrodte", layout = MainView.class)
@PageTitle("Lista de Numeros de DTE")
@MenuIcon(VaadinIcon.SPECIALIST)
public class NumeroDteView extends AbstractDefaultView<NumeroDte> {
    @Inject
    public NumeroDteView(AbstractList<NumeroDte> list, AbstractPreview<NumeroDte> preview, AbstractForm<NumeroDte> form) {
        super(list, preview, form, EModoVista.EDITAR);
    }
}
