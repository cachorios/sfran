package com.gmail.cacho.slapi.view.layouts;


import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.slapi.comunes.R;
import com.gmail.cacho.slapi.view.AbstractPreview;
import com.gmail.cacho.slapi.view.componentes.ListPreview;
import com.gmail.cacho.slapi.view.componentes.ToolBar;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerList;
import com.gmail.cacho.slapi.view.interfaces.IPresentableList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.utils.ComponenteVista;
import com.gmail.cacho.slbase.core.Constantes;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridSingleSelectionModel;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.ThemableLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.templatemodel.TemplateModel;

import java.util.Arrays;

@Tag("list-view")
@HtmlImport("frontend://src/components/crud/list-view.html")
public class DefaultInnerListPolymer<T extends AbstractEntidad> extends PolymerTemplate<DefaultInnerListPolymer.BindingModel>
        implements ILayoutInnerList<T> {

    public interface BindingModel extends TemplateModel {
        void setTitulo(String titulo);
    }

    public void setTitulo(String titulo) {
        getModel().setTitulo(titulo);
    }

    private IPresentableList<T> presentable;

    @Id("titulo")
    private H2 titulo;

    private TextField filtro;

    @Id("toolbar")
    private ToolBar toolBar;

    @Id("grid")
    private Grid<T> grilla;

    @Id("list-preview")
    private ListPreview preview;


    private Button verButton;
    private Button nuevoButton;
    private Button editarButton;
    private Button borrarButton;

    private String baseTitulo;

    public DefaultInnerListPolymer(IPresentableList<T> presentable, String elTitulo) {
        this.presentable = presentable;
        generarVista((baseTitulo = elTitulo));
        actualizarCantidadRegistros();

    }

    protected void generarVista(String eltitulo) {
        // 2.TOPBAR (FILTRO+BOTONES)
        generarTopBar();

        // 3.CONTENIDO (GRILLA+PREVIEW)
        //        contenido = generarContenido();
        generarGrilla();


//        preview.setVisible(false);
        preview.setVisible(false);
        if (presentable.getPreview() != null) {
            configurarPreview();
            preview.setVisible(true);
        }

        // 5.REGISTRA LOS COMPONENTES POR DEFECTO DEL LIST
        registrarComponentesDefault();
        setearShortcuts();
    }

    protected void generarTopBar() {
        toolBar.setPlaceHolder("Búsqueda...");
        toolBar.addFilterChangeListener(e -> presentable.refrescarLista( toolBar.getFilter()  ));

        verButton = toolBar.getVerButton();
        nuevoButton = toolBar.getNuevoButton();
        editarButton = toolBar.getEditarButton();
        borrarButton = toolBar.getBorrarButton();

        verButton.getElement().setProperty("data", R.RCV_BTN_VER);
        nuevoButton.getElement().setProperty("data", R.RCV_BTN_NUEVO);
        editarButton.getElement().setProperty("data", R.RCV_BTN_EDITAR);
        borrarButton.getElement().setProperty("data", R.RCV_BTN_BORRAR);

        toolBar.setVerText("ver");
        toolBar.setNuevoText("Nuevo");
        toolBar.setEditarText("Editar");
        toolBar.setBorrarText("Borrar");
    }

    protected void generarGrilla() {
        // NOTA: la grilla de un listado NO debería permitir la deselección de filas.
        ((GridSingleSelectionModel) grilla.getSelectionModel()).setDeselectAllowed(false);
        grilla.setSelectionMode(Grid.SelectionMode.SINGLE);
        grilla.setDataProvider(((IPresenterList<T>) presentable.getPresenter()).getDataProvider());

        if (presentable.getListaCols() != null) {
            presentable.getListaCols().forEach(col -> {
                if (col.tieneFormato()) {
                    grilla.addColumn(col.getRenderer())
                          .setHeader(col.getTitulo())
                          .setSortable(col.isOrdenable())
                          .setKey(col.getPropiedad())
                          .setWidth(col.getWidth());
                } else {
                    grilla.addColumn(col.getProveedor())
                          .setHeader(col.getTitulo())
                          .setSortable(col.isOrdenable())
                          .setKey(col.getPropiedad())
                          .setWidth(col.getWidth());
                }
            });
        }else{
            this.presentable.setCols(grilla);
        }

        grilla.deselectAll();
        grilla.addSelectionListener(e -> {
            if (e.isFromClient() && e.getFirstSelectedItem().isPresent()) {
                presentable.setObjetoActivo(e.getFirstSelectedItem().get());
            }
        });
        grilla.getDataProvider().addDataProviderListener(e -> actualizarCantidadRegistros());
        actualizarCantidadRegistros();

    }


    protected void configurarPreview() {

        AbstractPreview pv = (AbstractPreview) presentable.getPreview();
        pv.iniciar(presentable.getModoVista(), null);
        preview.getContenido().add(pv);

    }

    private void setearShortcuts() {
        //todo: Ver como hacer
        //        componentesVista.stream()
        //                        .filter(b -> b.getShortcut() != null)
        //                        .forEach(b -> b.getComponente().setClickShortcut(b.getShortcut()));
    }

    private String getTextoCantidad() {
        Long cntregs = ((AbstractPresenterList) presentable.getPresenter()).getCantidadRegActual();
        Long totregs = ((AbstractPresenterList) presentable.getPresenter()).getCantidadRegTotal();
        return Constantes.SYS_CAD_SPACE.concat(Constantes.SYS_CAD_OPENTYPE).concat(cntregs.toString())
                                       .concat(Constantes.SYS_CAD_SPACE).concat(Constantes.SYS_CAD_BARRA)
                                       .concat(Constantes.SYS_CAD_SPACE).concat(totregs.toString())
                                       .concat(Constantes.SYS_CAD_SPACE).concat(Constantes.SYS_CAD_TXTREGS)
                                       .concat(Constantes.SYS_CAD_CLOSETPE);
    }

    @Override
    public H2 getTitulo() {
        return null; //titulo;
    }

    @Override
    public TextField getFiltro() {
        return toolBar.getTextFieldFilter();
    }

    @Override
    public HorizontalLayout getTopBar() {
        return null;
    }

    @Override
    public Grid<T> getGrilla() {
        return grilla;
    }

    @Override
    public ThemableLayout getContenido() {
        return null; //contenido;
    }

    @Override
    public IPresentableList<T> getPresentable() {
        return presentable;
    }

    @Override
    public void actualizarCantidadRegistros() {
        if (presentable.getPadre() != null) {
            if (presentable.getTabpadre() != null) {
                //todo: ver como mostrar el titulo ocn padere
                presentable.getTabpadre().setLabel(presentable.getTitulo().concat(getTextoCantidad()));
            }
        } else {
            if (baseTitulo != null) {
                titulo.setText(baseTitulo.concat(getTextoCantidad()));
            }
        }
    }

    @Override
    public Button getVerButton() {
        return verButton;
    }

    @Override
    public Button getNuevoButton() {
        return nuevoButton;
    }

    @Override
    public Button getEditarButton() {
        return editarButton;
    }

    @Override
    public Button getBorrarButton() {
        return borrarButton;
    }

    @Override
    public HorizontalLayout getTopbar() {
        return null;  // topbar;
    }

    @Override
    public HorizontalLayout getAreaFiltro() {
        return null; // areaFiltro;
    }

    @Override
    public HorizontalLayout getPrebotones() {
        return null; // prebotones;
    }

    @Override
    public HorizontalLayout getBotonera() {
        return null; // botonera;
    }

    @Override
    public HorizontalLayout getPosbotones() {
        return null; //posbotones;
    }

    @Override
    public Component getLayout() {
        return this;
    }

    @Override
    public void registrarComponentesDefault() {
        if (getVerButton() != null) {
            presentable.registrarComponenteVista(new ComponenteVista(getVerButton(),
                                                                     Arrays.asList(EModoVista.VER, EModoVista.NUEVO,
                                                                                   EModoVista.EDITAR, EModoVista.BORRAR),
                                                                     true, true, Key.F3,
                                                                     e -> ((IPresenterList<T>) presentable.getPresenter())
                                                                             .listView()));
        }
        if (getNuevoButton() != null) {
            presentable.registrarComponenteVista(
                    new ComponenteVista(getNuevoButton(), Arrays.asList(EModoVista.EDITAR, EModoVista.NUEVO), true, false,
                                        Key.F4, e -> ((IPresenterList<T>) presentable.getPresenter()).listAdd()));
        }
        if (getEditarButton() != null) {
            presentable.registrarComponenteVista(
                    new ComponenteVista(getEditarButton(), Arrays.asList(EModoVista.EDITAR, EModoVista.BORRAR), true, true,
                                        Key.F5, e -> ((IPresenterList<T>) presentable.getPresenter()).listEdit()));
        }
        if (getBorrarButton() != null) {
            presentable.registrarComponenteVista(
                    new ComponenteVista(getBorrarButton(), Arrays.asList(EModoVista.EDITAR, EModoVista.BORRAR), false, true,
                                        Key.F4, e -> ((IPresenterList<T>) presentable.getPresenter()).listRemove()));
        }
    }

    @Override
    public void setEstiloVisual(String estilo, String valor) {
        getElement().getStyle().set(estilo, valor);
    }

    @Override
    public String getEstiloVisual(String estilo) {
        return getElement().getStyle().get(estilo);
    }

    public ToolBar getToolBar() {
        return toolBar;
    }
}

