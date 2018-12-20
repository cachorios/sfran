package com.gmail.sanfrancisco.view.manual;

import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.gmail.cacho.slapi.layout.MainView;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;

@Tag("ayuda-fran")
@HtmlImport("src/views/manual/manual.html")
@Route(value="ayuda", layout = MainView.class)
@PageTitle("Ayuda del Sistema")
@MenuIcon(VaadinIcon.EYE)
public class Ayuda  extends PolymerTemplate<Ayuda.AyudaModel> {
    public interface AyudaModel extends TemplateModel{}

    public Ayuda() {

    }
}
