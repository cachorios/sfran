package com.gmail.sanfrancisco.view.licencia;

import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.gmail.cacho.slapi.layout.MainView;
import com.gmail.cacho.slapi.view.AbstractDefaultView;
import com.gmail.cacho.slapi.view.AbstractForm;
import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.sanfrancisco.entidad.Licencia;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route(value="licencias", layout = MainView.class)
@PageTitle("Lista de Licencias")
@MenuIcon(VaadinIcon.SPECIALIST)
public class LicenciaView extends AbstractDefaultView<Licencia> {
    @Inject
    public LicenciaView(AbstractList<Licencia> list, AbstractPreview<Licencia> preview, AbstractForm<Licencia> form) {
        super(list, preview, form, EModoVista.EDITAR);
    }
}
