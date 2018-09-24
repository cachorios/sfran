package com.gmail.cacho.backend.views.parametro;


import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.gmail.cacho.backend.entidad.Parametro;
import com.gmail.cacho.slapi.layout.MainView;
import com.gmail.cacho.slapi.view.AbstractDefaultView;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route(value="parametros", layout = MainView.class)
@PageTitle("Lista de Parametros")
@MenuIcon(VaadinIcon.COGS)
public class ParamView extends AbstractDefaultView<Parametro> {
    @Inject
    public ParamView(ParamList list, ParamPreview preview, ParamForm form) {
        super(list, preview, form, EModoVista.EDITAR);
    }
}
