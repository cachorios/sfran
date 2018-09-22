package com.gmail.cacho.slapi.view.interfaces;

import com.vaadin.flow.component.Component;


/**
 * Esta interface representa el comportamiento público generico deseable
 * de una clase que implementa un 'Layout' para un objeto visualizable del
 * sistema.
 *
 * @author larios
 * @version 20180201
 */
public interface ILayout {
    /**
     * Este metodo es el encargado de devolver el Layout generado y representado
     * por la clase que implementa esta interfase.
     *
     * @return el Layout generado y contenido en la clase.
     */
    Component getLayout();

    /**
     * Este metodo permite registrar todos los componentes iniciales de un layout.
     */
    void registrarComponentesDefault();

    /**
     * Este metodo deberia permitir obtener los valores de estilos visuales que han
     * sido aplicados al presente objeto visualizable. Es como una puerta de entrada a
     * la gestion de estilos de visualización a los objetos visuales del sistema.
     *
     * @param estilo el estilo que quiere establecerse
     * @return  el valor en el objeto visual para el estilo solicitado
     */
    String getEstiloVisual(String estilo);

    /**
     * Este metodo deberia permitir establecer valores de estilos visuales al
     * presente layout.
     *
     * @param estilo el estilo que quiere establecerse
     * @param valor el valor para el estilo a establecer
     */
    void setEstiloVisual(String estilo, String valor);
}
