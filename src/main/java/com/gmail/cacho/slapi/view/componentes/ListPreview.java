package com.gmail.cacho.slapi.view.componentes;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.templatemodel.TemplateModel;

@Tag("list-preview")
@HtmlImport("src/components/crud/list-preview.html")
public class ListPreview extends PolymerTemplate<ListPreview.Model> {
    @Id("preview-contenido")
    private Div contenido;
    public interface Model extends TemplateModel {
    }

    public ListPreview()  {

    }

    public Div getContenido(){
        return contenido;
    }
}
