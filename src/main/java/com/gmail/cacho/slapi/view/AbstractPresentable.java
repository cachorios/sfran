package com.gmail.cacho.slapi.view;


import com.gmail.cacho.backend.entidad.AbstractEntidad;
import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slapi.view.enums.EModoVista;
import com.gmail.cacho.slapi.view.interfaces.IPresentable;
import com.gmail.cacho.slapi.view.interfaces.IVisualizable;
import com.gmail.cacho.slapi.view.interfaces.IVisualizableGestionable;
import com.gmail.cacho.slapi.view.utils.ComponenteVista;
import com.gmail.cacho.slbase.logging.L;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.HasValue;

import java.util.ArrayList;
import java.util.List;


/**
 * Esta clase es la implementación por defecto de la interfase IPresentableList e
 * implementa un objeto presentable del sistema asociado a un esquema de listado de
 * registros asociados a un Entidad particular del Sistema.
 * En cada caso, para cada Entidad del Sistema deseada, se debe heredar de esta clase
 * y clase heredada debe tener la anotación @ViewScope e inyectar (vía la anotación @
 * Inject) el Presenter que corresponda, el cual controlara el comportamiento de este
 * objeto presentable.
 * NOTA: esta clase permite ser utilizada como una vista principal, es decir llamada
 * directamente desde el Menú del sistema, o bien dentro del un tab como parte de un
 * Formulario (CRUD o no ) que la contiene. En el primer caso, el atributo 'padre' debe
 * permanecer null y en el segundo caso debe ser establecido (vía el metodo setPadre())
 * al Formulario que lo contiene.
 *
 * @param <T> la Entidad del Sistema que se gestionará vía listado dentro de este objeto presentable
 * @author cachorios-jmfragueiro
 * @version 20180204
 */
public abstract class AbstractPresentable<T extends AbstractEntidad> implements IVisualizableGestionable, IPresentable<T> {
    private IVisualizable padre;
    private List<ComponenteVista> componentesVista;
    private EModoVista modoVista;

    public AbstractPresentable() {
        componentesVista = new ArrayList<>();
    }

    protected void setModoVista(EModoVista modoVista) {
        this.modoVista = (modoVista == null) ? EModoVista.VER : modoVista;
    }

    protected void definirComportamientoComponentes() {
        componentesVista.forEach(b -> b.getComponente().addClickListener(b.getCl()));
    }

    protected void actualizarEstadoBotones() {
        visualizarBotones();
        habilitarBotones();
    }

    protected void visualizarBotones() {
        // primero verificar por permisos del usuario
        getPresenter().aplicarPermisos();

        // finalmente verifica por si existe un panel asociado
        componentesVista.stream()
                        .filter(bv -> bv.getComponente().isVisible())
                        .forEach(bv -> bv.getComponente().setVisible(esVisualizable(bv)));
    }

    protected void habilitarBotones() {
        componentesVista.stream()
                        .filter(bv -> bv.getComponente().isVisible())
                        .forEach(bv -> bv.getComponente().setEnabled(esHabilitable(bv)));
    }

    public void focusField(HasValue<?,?> field) {
        if (field instanceof Focusable) {
            ((Focusable) field).focus();
        } else {
            L.warning(C.MSJ_ERR_CANTFOCUS.concat(C.SYS_CAD_LOGSEP).concat(field.getClass().getName()));
        }
    }

    @Override
    abstract public String getTagVista();

    @Override
    public void registrarComponenteVista(ComponenteVista componente) {
        componentesVista.add(componente);
    }

    @Override
    public List<ComponenteVista> getComponentesVista() {
        return componentesVista;
    }

    @Override
    public abstract Class<T> getEntityType();

    @Override
    public String getTitulo() {
        return C.WIN_TIT_GENERICO;
    }

    @Override
    public void setPadre(IVisualizable padre) {
        this.padre = padre;
    }

    @Override
    public IVisualizable getPadre() {
        return padre;
    }

    @Override
    public EModoVista getModoVista() {
        return modoVista;
    }

    @Override
    public void establecerEstadoInicial() {

    }
}