package com.gmail.cacho.slapi.view.interfaces;


import com.gmail.cacho.slapi.view.utils.ComponenteVista;

import java.util.List;

/**
 * Esta interface representa el comportamiento de un objeto visualizable que puede
 * ser gestionado para, entre otras cosas, determinarse qué cosas puede mostrar y
 * qué cosas permite hacer. Representa un estadío intermedio entre el definido por
 * IVisualizable y el definido por IPresentable<T extends Entidad> (en este último
 * ya se requiere de una Entidad que 'encamine' el funcionamiento del objeto visual)
 * de manera de poder 'colgar' desde aquí la jerarquía de comportamiento de objetos
 * que deben ser gestionados pero no tienen una entidad (clase Entidad) asociada.
 *
 * @author larios
 * @version 20180201
 */
public interface IVisualizableGestionable extends IVisualizable {
    /**
     * Un objeto gestionable debe tener un "TAG de Recurso de Vista" que servirá para
     * identificar elemento de acción que posea y, de esta manera, definir acciones que
     * sean comunes sobre estos, como por ejemplo cuáles activar en función de permisos
     * del usuario sobre dichos recursos.
     * Cada elemento de acción (denominado "RECURSO") de un objeto visual gestionable,
     * que se quiera identificar y gestionar, deberá tener un TAG de Recurso formado por
     * el TAG (un String) del objeto visual gestionable y el TAG (también un String) del
     * recurso en cuestión.
     * El TAG del Recurso debe ser seteado en el Componente (aqui ya hablamos de Vaadin),
     * durante la creación del mismo (por código o Designer), dentro del atributo "Data"
     * de dicho componente (con setData(...)) u otro atributo que reemplace a Data en un
     * futuro.
     * Además, debe existir un "PARAMETRO" (objeto de Tipo Parametro y por ello registro
     * en tabla Parametros) de tipo ETipoParametro.RECURSO (ordinal 1 de la enumeración)
     * que tenga en su atributo "nombre" (obtenido vía getNombre()) el String resultado
     * formado por "TAG-VIEW-GESTIONABLE"+Recursos.RCV_TAG_SPARATOR+"TAG-RECURSO" y que
     * representará al RECURSO en cuestión.
     * A partir de entonces, se podrá crear un PERMISO (registro en la tabla Permisos)
     * sobre dicho RECURSO, dado el Parametro generado para el mismo y dado un tipo de
     * permiso como ETipoPermiso.EJECUTAR (ordinal 5 de la enumeración ETipoPermiso).
     * Finalmente dicho permiso podrá ser asignado a un ROL determinado y entonces, para
     * mostrar un componente, es preciso que el USUARIO actual tenga un ROL que tenga un
     * PERMISO definidos sobre dicho RECURSO.
     * NOTA: obviamente cada TAG (para cada tipo de vista) debería ser único dentro de
     * ese objeto visual presentable.
     *
     * @return el TAG especifico para la vista.
     */
    String getTagVista();

    /**
     * Un objeto visual gestionable debe tener un título, sea que se muestre o no el
     * mismo. Debe ser un texto (String) que pueda ser mostrado por pantalla y 'sirva'
     * de explicación para el mismo.
     *
     * @return el título para el objeto visual gestionable.
     */
    String getTitulo();

    /**
     * Este método permite registrar un componente RECURSO en la vista, de manera de que
     * el mismo puede ser gestionado por el encargado de administrar recursos y permisos
     * (ver getTagVista() mas arriba).
     *
     * @param componente el RECURSO a registrar para el objeto visual gestionable.
     */
    void registrarComponenteVista(ComponenteVista componente);

    /**
     * Este metodo debe retornar la lista completa de componentes RECURSOS susceptibles de
     * ser administrados para el objeto visual gestionable.
     *
     * @return la lista de botones administrables para el objeto visual gestionable.
     */
    List<ComponenteVista> getComponentesVista();
}
