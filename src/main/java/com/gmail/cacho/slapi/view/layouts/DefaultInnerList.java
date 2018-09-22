package com.gmail.cacho.slapi.view.layouts;


import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.comunes.Recursos;
import com.gmail.cacho.slapi.view.AbstractPreview;
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
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.ThemableLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

import java.util.Arrays;

@Tag("list-view")
@HtmlImport("frontend://src/views/crud/listpreview_style.html")
public class DefaultInnerList<T extends AbstractEntidad> extends VerticalLayout implements ILayoutInnerList<T> {
    private IPresentableList<T> presentable;
    private H2 titulo;
    private HorizontalLayout topbar;
    private HorizontalLayout contenido;
    private TextField filtro;
    private HorizontalLayout areaFiltro, prebotones, botonera, posbotones;
    private Grid<T> grilla;
    private Button verButton;
    private Button nuevoButton;
    private Button editarButton;
    private Button borrarButton;
    private String baseTitulo;

    public DefaultInnerList(IPresentableList<T> presentable, String elTitulo) {
        this.presentable = presentable;

        setearEstiloGeneral();
        generarVista((baseTitulo = elTitulo));
    }

    private void setearEstiloGeneral() {
        this.setMargin(false);
        this.setSpacing(false);
        this.setPadding(false);
        this.setSizeFull();
    }

    protected void generarVista(String eltitulo) {
        // 1.TITULO
        if (eltitulo != null && !eltitulo.isEmpty()) {
            titulo = generarTitulo(eltitulo);
        }

        // 2.TOPBAR (FILTRO+BOTONES)
        topbar = generarTopBar();

        // 3.CONTENIDO (GRILLA+PREVIEW)
        contenido = generarContenido();

        // 4.ARMADO FINAL
        add(titulo, topbar, contenido);
        setearFlexGrow();

       // 5.REGISTRA LOS COMPONENTES POR DEFECTO DEL LIST
        registrarComponentesDefault();
        setearShortcuts();
    }

    protected H2 generarTitulo(String eltitulo) {
        return new H2(eltitulo);
    }

    protected HorizontalLayout generarTopBar() {
        HorizontalLayout topBar = new HorizontalLayout();

        topBar.setClassName("view-toolbar");
        topBar.setWidth("100%");
        topBar.setSpacing(true);
        topBar.setMargin(true);

        areaFiltro = generarAreaFiltro();
        prebotones = generarAreaPreBotones();
        botonera = generarAreaBotones();
        posbotones = generarAreaPosBotones();

        topBar.add(areaFiltro, prebotones, botonera, posbotones);

        topBar.setFlexGrow(1,areaFiltro);
        topBar.setFlexGrow(0,prebotones,botonera,posbotones);

        topBar.setAlignSelf(Alignment.START,areaFiltro);
        topBar.setAlignSelf(Alignment.START,prebotones,botonera,posbotones);

        return topBar;
    }

    protected HorizontalLayout generarContenido() {
        grilla = generarGrilla();

        HorizontalLayout contenido = new HorizontalLayout();
        contenido.setSizeFull();
        contenido.add(grilla);
        contenido.setFlexGrow(1, grilla);
        if (presentable.getPreview() != null) {
            configurarPreview(contenido);
        }

        return contenido;
    }

    protected void setearFlexGrow() {
        this.setFlexGrow(0, titulo);
        this.setFlexGrow(0,topbar);
        this.setFlexGrow(1,contenido);
    }

    protected HorizontalLayout generarAreaFiltro() {
        HorizontalLayout areaFiltro = new HorizontalLayout();

        filtro = new TextField();
        filtro.setPlaceholder("Búsqueda...");
        filtro.setPrefixComponent(new Icon("lumo", "search"));
        filtro.addClassNames("view-toolbar__search-field");
        filtro.getElement().addEventListener("keyup", e -> {
            System.out.println("Value is now: " +
                                       e.getEventData().getString("element.value"));

            presentable.refrescarLista(filtro.getValue());
        }).addEventData("element.value").setFilter("event.keyCode == "+ Key.F2);

        ////filtro.addShortcutListener(new FocusShortcut(filtro, ShortcutAction.KeyCode.F2));
        ////filtro.addValueChangeListener(e -> presentable.refrescarLista(e.getValue()));

        areaFiltro.setWidth("100%");
        areaFiltro.add(filtro);

        return areaFiltro;
    }

    protected HorizontalLayout generarAreaPreBotones() {
        return new HorizontalLayout();
    }

    protected HorizontalLayout generarAreaBotones() {
        HorizontalLayout botonera = new HorizontalLayout();

        botonera.add(generarVerButton(), generarNuevoButton(), generarEditarButton(), generarBorrarButton());
        botonera.setFlexGrow(1, verButton, nuevoButton, editarButton, borrarButton);
        botonera.setAlignItems(Alignment.END);

        return botonera;

    }

    protected HorizontalLayout generarAreaPosBotones() {
        return new HorizontalLayout();
    }

    protected Button generarVerButton() {
        verButton = new Button(C.CRUD_MSG_VER);
        ////verButton.setStyleName("small borderless");
        verButton.setIcon(VaadinIcon.SEARCH.create());
        verButton.getElement().setProperty("data",Recursos.RCV_BTN_VER);

        return verButton;
    }

    protected Button generarNuevoButton() {
        nuevoButton = new Button(C.CRUD_MSG_AGREGAR);
        ////nuevoButton.setStyleName("small borderless");
        nuevoButton.setIcon(VaadinIcon.PLUS_CIRCLE_O.create());
        nuevoButton.getElement().setProperty("data", Recursos.RCV_BTN_NUEVO);

        return nuevoButton;
    }

    protected Button generarEditarButton() {
        editarButton = new Button(C.CRUD_MSG_EDITAR);
        ////editarButton.setStyleName("small primary borderless");
        editarButton.setIcon(VaadinIcon.EDIT.create());
        editarButton.getElement().setProperty("data",Recursos.RCV_BTN_EDITAR);

        return editarButton;
    }

    protected Button generarBorrarButton() {
        borrarButton = new Button(C.CRUD_MSG_BORRAR);
        ////borrarButton.setStyleName("small danger borderless");
        borrarButton.setIcon(VaadinIcon.TRASH.create());
        borrarButton.getElement().setProperty("data",Recursos.RCV_BTN_BORRAR);

        return borrarButton;
    }

    protected Grid<T> generarGrilla() {
        Grid<T> grid = new Grid<>();

        grid.setSelectionMode(Grid.SelectionMode.SINGLE);
        //grid.setSizeFull();

        // NOTA: la grilla de un listado NO debería permitir la deselección de filas.
        ((GridSingleSelectionModel)grid.getSelectionModel()).setDeselectAllowed(false);

        grid.setDataProvider(((IPresenterList<T>)presentable.getPresenter()).getDataProvider());

        if (presentable.getListaCols() != null) {
            presentable.getListaCols().forEach(col -> {
                if (col.tieneFormato()) {
                    grid.addColumn(col.getProveedor())
                            .setHeader(col.getTitulo())
                            .setSortable(col.isOrdenable())
//                            .setId(col.getPropiedad())
                     ;
                          //.setHidable(true)
                          //todo: ver como poner el renderer //.setRenderer(col.getRenderer());
                } else {

                    grid.addColumn(col.getProveedor())
                            .setHeader(col.getTitulo())
                            .setSortable(col.isOrdenable())
//                            .setId(col.getPropiedad())
                    ;
//                          .setHidable(true);
                }
            });
        }

        grid.deselectAll();
        grid.addSelectionListener(e -> {
              if (e.isFromClient() && e.getFirstSelectedItem().isPresent()) {
                  presentable.setObjetoActivo(e.getFirstSelectedItem().get());
              }
        });
        grid.getDataProvider().addDataProviderListener(e -> actualizarCantidadRegistros());
        actualizarCantidadRegistros();

        return grid;
    }

    protected void configurarPreview(HorizontalLayout layout) {
        AbstractPreview pv = (AbstractPreview) presentable.getPreview();
        pv.iniciar(presentable.getModoVista(), null);
        layout.add((Component) pv);
        layout.setFlexGrow(0, pv);
    }

    private void setearShortcuts() {
        //todo: Ver como hacer
        //        componentesVista.stream()
        //                        .filter(b -> b.getShortcut() != null)
        //                        .forEach(b -> b.getComponente().setClickShortcut(b.getShortcut()));
    }

    private String getTextoCantidad() {
        Long cntregs = ((AbstractPresenterList)presentable.getPresenter()).getCantidadRegActual();
        Long totregs = ((AbstractPresenterList)presentable.getPresenter()).getCantidadRegTotal();
        return Constantes.SYS_CAD_SPACE.concat(Constantes.SYS_CAD_OPENTYPE)
                                       .concat(cntregs.toString())
                                       .concat(Constantes.SYS_CAD_SPACE)
                                       .concat(Constantes.SYS_CAD_BARRA)
                                       .concat(Constantes.SYS_CAD_SPACE)
                                       .concat(totregs.toString())
                                       .concat(Constantes.SYS_CAD_SPACE)
                                       .concat(Constantes.SYS_CAD_TXTREGS)
                                       .concat(Constantes.SYS_CAD_CLOSETPE);
    }

    @Override
    public H2 getTitulo() {
        return titulo;
    }

    @Override
    public TextField getFiltro() {
        return filtro;
    }

    @Override
    public HorizontalLayout getTopBar() {
        return topbar;
    }

    @Override
    public Grid<T> getGrilla() {
        return grilla;
    }

    @Override
    public ThemableLayout getContenido() {
        return contenido;
    }

    @Override
    public Button getVerButton() {
        return verButton;
    }

    @Override
    public IPresentableList<T> getPresentable() {
        return presentable;
    }

    @Override
    public void actualizarCantidadRegistros() {
        if (presentable.getPadre() != null) {
            if (presentable.getTabPadre() != null) {
                presentable.getTabPadre().setLabel(presentable.getTitulo().concat(getTextoCantidad()));
            }
        } else {
            if (getTitulo() != null && getTitulo().getText() != null && baseTitulo != null) {
                getTitulo().setText(baseTitulo.concat(getTextoCantidad()));
            }
        }
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
        return topbar;
    }

    @Override
    public HorizontalLayout getAreaFiltro() {
        return areaFiltro;
    }

    @Override
    public HorizontalLayout getPrebotones() {
        return prebotones;
    }

    @Override
    public HorizontalLayout getBotonera() {
        return botonera;
    }

    @Override
    public HorizontalLayout getPosbotones() {
        return posbotones;
    }

    @Override
    public VerticalLayout getLayout() {
        return this;
    }

    @Override
    public void registrarComponentesDefault() {
        if (getVerButton() != null) {
            presentable.registrarComponenteVista(new ComponenteVista(getVerButton(),
                                                                     Arrays.asList(EModoVista.VER,
                                                                       EModoVista.NUEVO,
                                                                       EModoVista.EDITAR,
                                                                       EModoVista.BORRAR),
                                                                     true,
                                                                     true,
                                                                        Key.F3,
                                                         e -> ((IPresenterList<T>)presentable.getPresenter()).listView()));
        }
        if (getNuevoButton() != null) {
            presentable.registrarComponenteVista(new ComponenteVista(getNuevoButton(),
                                                         Arrays.asList(EModoVista.EDITAR,
                                                                       EModoVista.NUEVO),
                                                         true,
                                                         false,
                                                          Key.F4,
                                                         e -> ((IPresenterList<T>)presentable.getPresenter()).listAdd()));
        }
        if (getEditarButton() != null) {
            presentable.registrarComponenteVista(new ComponenteVista(getEditarButton(),
                                                         Arrays.asList(EModoVista.EDITAR,
                                                                       EModoVista.BORRAR),
                                                         true,
                                                         true,
                                                         Key.F5,
                                                         e -> ((IPresenterList<T>)presentable.getPresenter()).listEdit()));
        }
        if (getBorrarButton() != null) {
            presentable.registrarComponenteVista(new ComponenteVista(getBorrarButton(),
                                                         Arrays.asList(EModoVista.EDITAR,
                                                                       EModoVista.BORRAR),
                                                         false,
                                                         true,
                                                         Key.F4,
                                                         e -> ((IPresenterList<T>)presentable.getPresenter()).listRemove()));
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
}