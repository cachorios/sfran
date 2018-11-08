package com.gmail.cacho.slapi.view.componentes;

import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.comunes.R;
import com.gmail.cacho.slapi.view.interfaces.IPresentable;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.grid.Grid;

import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.templatemodel.TemplateModel;

import java.util.List;

@Tag("uno-mucho")
@HtmlImport("src/components/uno-mucho.html")
public class UnoAMuchoGrid<S extends AbstractEntidad ,T extends AbstractEntidad> extends PolymerTemplate<UnoAMuchoGrid.Model> implements IPresenterList<T> {

    /**
     * <S> es el objeto UNO, del "uno a mucho"
     */
    private S padre;

    private Button verButton;
    private Button nuevoButton;
    private Button editarButton;
    private Button borrarButton;

    public interface Model extends TemplateModel {
        void setTitulo(String titulo);
    }

    @Id("titulo")
    private H4 titulo;
    @Id("toolbar")
    private ToolBar toolBar;

    @Id("grid")
    private Grid<T> grid;

    //private List<T> items;
    DataProvider dp;


    public UnoAMuchoGrid( String titulo, S padre, List items) {
        this.titulo.setText(titulo);
        //this.items = items;
        this.padre = padre;
        toolBar.setFilterVisible(false);

        dp = DataProvider.ofCollection(items);

        verButton = toolBar.getVerButton();
        nuevoButton = toolBar.getNuevoButton();
        editarButton = toolBar.getEditarButton();
        borrarButton = toolBar.getBorrarButton();

        verButton.getElement().setProperty("data", R.RCV_BTN_VER);
        nuevoButton.getElement().setProperty("data", R.RCV_BTN_NUEVO);
        editarButton.getElement().setProperty("data", R.RCV_BTN_EDITAR);
        borrarButton.getElement().setProperty("data", R.RCV_BTN_BORRAR);

        toolBar.setVerText("");
        toolBar.setNuevoText("");
        toolBar.setEditarText("");
        toolBar.setBorrarText("");

    }

    public UnoAMuchoGrid iniciar(){
        this.grid.setDataProvider(dp);
//                setItems(items);
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


    @Override
    public FilterablePageableDataProvider<T, Long, String> getDataProvider() {
        return null;
    }

    @Override
    public void setItemPadre(Object item) {
        padre = (S) item;
    }

    @Override
    public S getItemPadre() {
        return padre;
    }

    @Override
    public long getCantidadRegActual() {
        return 0;
    }

    @Override
    public long getCantidadRegTotal() {
        return 0;
    }

    @Override
    public void alActualizarSeleccion(List<T> seleccion) {

    }

    @Override
    public void listList(Object parametro) {

    }

    @Override
    public void listView() {

    }

    @Override
    public void listAdd() {

    }

    @Override
    public void listEdit() {

    }

    @Override
    public void listRemove() {

    }

    @Override
    public void setPresentable(IPresentable<T> presentable) {

    }

    @Override
    public IPresentable<T> getPresentable() {
        return null;
    }

    @Override
    public void aplicarPermisos() {

    }
}
