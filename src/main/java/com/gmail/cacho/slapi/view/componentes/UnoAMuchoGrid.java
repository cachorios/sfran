package com.gmail.cacho.slapi.view.componentes;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.templatemodel.TemplateModel;

import java.util.List;

@Tag("uno-mucho")
@HtmlImport("src/components/uno-mucho.html")
public class UnoAMuchoGrid<T> extends PolymerTemplate<UnoAMuchoGrid.Model> {

    public interface Model extends TemplateModel {
        void setTitulo(String titulo);
    }

    @Id("titulo")
    private H4 titulo;
    @Id("toolbar")
    private ToolBar toolBar;

    @Id("grid")
    private Grid<T> grid;

    private List<T> items;



    public UnoAMuchoGrid( String titulo, List items) {
        this.titulo.setText(titulo);
        this.items = items;
        toolBar.setFilterVisible(false);
    }

    public UnoAMuchoGrid iniciar(){
        this.grid.setItems(items);
        return this;
    }

    public Grid<T> getGrid(){
        return grid;
    }

    /**
     * getColumns
     * @param grid
     *
     * en caso de extender, se puede utilizar para setear las columnas...
     * tambien podria usarse getGrid()
     */
    public void setColumns(Grid grid){};



}
