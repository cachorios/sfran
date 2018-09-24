package com.gmail.sanfrancisco.view.conductor;

import com.gmail.cacho.slapi.layout.MainView;
import com.gmail.cacho.slapi.view.AbstractDefaultView;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.sanfrancisco.entidad.Conductor;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route(value="conductores", layout = MainView.class)
@PageTitle("Lista de Conductores")
public class ConductorView extends AbstractDefaultView<Conductor> {
    @Inject
    public ConductorView(AbstractList<Conductor> list, AbstractPreview<Conductor> preview) {
//    public ConductorView(ConductorList list, ConductorListPrever preview) {
        super(list, preview,  EModoVista.EDITAR);
    }
}

// public ConductorView(AbstractList<Conductor> list, AbstractPreview<Conductor> preview) {


/*

@Route(value="parametros", layout = MainView.class)
@PageTitle("Lista de Parametros")
@MenuIcon(VaadinIcon.COGS)
public class ParamView extends AbstractDefaultView<Parametro> {
    @Inject
    public ParamView(ParamList list, ParamPreview preview, ParamForm form) {
        super(list, preview, form, EModoVista.EDITAR);
    }
}

 */