package com.gmail.sanfrancisco.view.consignatario;

import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.gmail.cacho.slapi.layout.MainView;
import com.gmail.cacho.slapi.view.AbstractDefaultView;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.sanfrancisco.entidad.Consignatario;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route(value="consignatario", layout = MainView.class)
@PageTitle("Lista de Consignatario")
@MenuIcon(VaadinIcon.SPECIALIST)
public class ConsignatarioView extends AbstractDefaultView<Consignatario> {
    @Inject
    public ConsignatarioView(AbstractList<Consignatario> list, AbstractPreview<Consignatario> preview, AbstractForm<Consignatario> form) {
        super(list, preview, form, EModoVista.EDITAR);
    }
}

