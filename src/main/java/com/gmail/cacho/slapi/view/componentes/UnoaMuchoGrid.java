package com.gmail.cacho.slapi.view.componentes;

import com.gmail.cacho.backend.entidad.AbstractEntidad;

import com.gmail.cacho.slapi.comunes.R;
import com.gmail.cacho.slapi.view.AbstractForm;

import com.gmail.cacho.slapi.view.enums.EModoVista;

import com.gmail.cacho.slapi.view.interfaces.IVisualizable;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.grid.Grid;

import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.notification.Notification;

import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.templatemodel.TemplateModel;

import javax.enterprise.inject.spi.CDI;
import java.util.List;

@Tag("uno-mucho")
@HtmlImport("src/components/uno-mucho.html")
public class UnoaMuchoGrid<S extends AbstractEntidad ,T extends AbstractEntidad > extends PolymerTemplate<UnoaMuchoGrid.Model> implements IVisualizable {

    /**
     * <S> es el objeto UNO, del "uno a mucho"
     */
    private S padre;

    private Button verButton;
    private Button nuevoButton;
    private Button editarButton;
    private Button borrarButton;
    private T registroActivo;
    private EModoVista modo = EModoVista.VER;

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

    private Class formClass;
    private AbstractForm  form;


    public UnoaMuchoGrid(String titulo, S padre, List items ) {
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

        verButton.setVisible(false);
        nuevoButton.setVisible(false);
        editarButton.setVisible(false);
        borrarButton.setVisible(false);

        grid.setSelectionMode(Grid.SelectionMode.SINGLE);
        grid.addSelectionListener(e -> {
            if (e.isFromClient() && e.getFirstSelectedItem().isPresent()) {
                registroActivo = e.getFirstSelectedItem().get();
            } else {
                registroActivo = null;
            }

        });



    }

    public <U extends AbstractForm> UnoaMuchoGrid withForm(Class<U> form){
        this.formClass = form;
        return this;
    }

    public UnoaMuchoGrid withVer(){
        if(formClass != null){
            verButton.setVisible(true);
        }else{
            Notification.show("No se ha definido un formClass para mostrar los datos");
        }
        return this;
    }

    public UnoaMuchoGrid withNuevo(){
        if(formClass != null){
            nuevoButton.setVisible(true);
        }else{
            Notification.show("No se ha definido un formClass para mostrar los datos");
        }
        return this;
    }

    public UnoaMuchoGrid withEditar(){
        if(formClass != null){
            editarButton.setVisible(true);
        }else{
            Notification.show("No se ha definido un formClass para mostrar los datos");
        }
        return this;
    }

    public UnoaMuchoGrid withBorrar(){
        borrarButton.setVisible(true);
        return this;
    }

    public UnoaMuchoGrid iniciar(){
        this.grid.setDataProvider(dp);
        this.acciones();

//                setItems(items);

        return this;
    }

    private AbstractForm getForm(){
        if(form  == null){
            form = (AbstractForm) CDI.current().select(formClass).get();
        }
        return form;
    }

    private void acciones(){
        getForm().setExecutableOnSaveOK(this::onFormSaveOK);
        if(verButton.isVisible()){
            verButton.addClickListener(e -> verAcction(e));
        }

        if(editarButton.isVisible()){
            editarButton.addClickListener(e -> editarAcction(e));
        }



    }

    private void verAcction(ClickEvent<Button> e) {
        AbstractForm frm = getForm();
        frm.setPadre(this);
        modo = EModoVista.VER;
        frm.iniciar(modo, registroActivo  );
//        new ComisionistaForm(new ComisionistaFormPresenter(CDI.current().select(ComisionistaService.class).get()), this.getPadre())
//                .iniciar(EModoVista.VER, getValue());
    }

    private void editarAcction(ClickEvent<Button> e) {
        AbstractForm frm = getForm();
        modo = EModoVista.EDITAR;
        frm.setPadre(this);
        frm.iniciar(modo, registroActivo  );

//        new ComisionistaForm(new ComisionistaFormPresenter(CDI.current().select(ComisionistaService.class).get()), this.getPadre())
//                .iniciar(EModoVista.VER, getValue());
    }


    private void onFormSaveOK() {
        ////AbstractForm<T> form = (AbstractForm<T>) ((IPresentableList<T>) getPresentable()).getForm();
        if (form.getModoVista().equals(EModoVista.NUEVO)) {
            dp.refreshAll();
            this.getGrid().setDataProvider(dp);
        } else {
            dp.refreshItem(registroActivo);
            this.getGrid().setDataProvider(dp);
        }
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


    public ToolBar getToolBar() {
        return toolBar;
    }




    public void registrarComponentesDefault() {
//        if (getVerButton() != null) {
//            presentable.registrarComponenteVista(new ComponenteVista(getVerButton(),
//                    Arrays.asList(EModoVista.VER, EModoVista.NUEVO,
//                            EModoVista.EDITAR, EModoVista.BORRAR),
//                    true, true, Key.F3,
//                    e -> ((IPresenterList<T>) presentable.getPresenter())
//                            .listView()));
//        }
//        if (getNuevoButton() != null) {
//            presentable.registrarComponenteVista(
//                    new ComponenteVista(getNuevoButton(), Arrays.asList(EModoVista.EDITAR, EModoVista.NUEVO), true, false,
//                            Key.F4, e -> ((IPresenterList<T>) presentable.getPresenter()).listAdd()));
//        }
//        if (getEditarButton() != null) {
//            presentable.registrarComponenteVista(
//                    new ComponenteVista(getEditarButton(), Arrays.asList(EModoVista.EDITAR, EModoVista.BORRAR), true, true,
//                            Key.F5, e -> ((IPresenterList<T>) presentable.getPresenter()).listEdit()));
//        }
//        if (getBorrarButton() != null) {
//            presentable.registrarComponenteVista(
//                    new ComponenteVista(getBorrarButton(), Arrays.asList(EModoVista.EDITAR, EModoVista.BORRAR), false, true,
//                            Key.F4, e -> ((IPresenterList<T>) presentable.getPresenter()).listRemove()));
//        }

    }

    @Override
    public void iniciar(EModoVista modo, AbstractEntidad item) {

    }

    @Override
    public EModoVista getModoVista() {
        return modo;
    }

    @Override
    public Component getViewComponent() {
        return null;
    }

    @Override
    public void cerrar() {

    }

    @Override
    public IVisualizable getPadre() {
        return this;
    }

    @Override
    public void setPadre(IVisualizable padre) {

    }


}
