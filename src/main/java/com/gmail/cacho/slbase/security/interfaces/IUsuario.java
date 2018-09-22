package com.gmail.cacho.slbase.security.interfaces;



import com.gmail.cacho.backend.entidad.Parametro;
import com.gmail.cacho.slbase.security.enums.ETipoPermiso;
import com.gmail.cacho.slbase.security.excepciones.SecurityErrorException;

import java.util.Set;

/**
 * Esta interfase representa al comportamiento basico de un usuario de la aplicacion dentro del
 * framework y permite obtener, ademas de los datos minimos propios del usuario, una interface
 * para administrar los roles de seguridad que se asignan al mismo.
 */
public interface IUsuario {
    /**
     * Este metodo debe retornar el nombre 'visible' del usuario representado por esta instancia
     * de IUsuario llamada.
     *
     * @return Retorna una cadena con el nombre 'visible' del usuario representado.
     */
    String getUsername();

    /**
     * Este metodo verifica si una cadena pasada como argumento coincide con el password
     * registrado para el usuario especifico.
     *
     * @param password La cadena pasada como password a verificar.
     * @return Retorna 'true' si la cadena coincide con el password o, si no, 'false'.
     */
    boolean isPasswordOK(String password);

    /**
     * Este metodo verifica si el usuario posee un permiso determinado, en donde el permiso se establece
     * a partir de un tipo de permiso sobre un recurso determinado de la aplicacion. Puede lanzar una
     * excepcion de seguridad si tiene problemas para validar un permiso.
     *
     * @param recurso El recurso a verificar.
     * @param tipo    El tipo de permiso a verificar para el recurso determinado.
     * @return Retorna 'true' si el usuario posee el permiso o, si no, 'false'.
     */
    boolean poseePermiso(Parametro recurso, ETipoPermiso tipo) throws SecurityErrorException;

    /**
     * Este metodo debe retornar el conjunto (sin repeticiones) de los permisos que posee el
     * usuario, tomando a cada permiso como una cadena formada por el nombre del tipo de permiso
     * asignado concatenado a la cadena constante SYS_CAD_REFER concatenado al nombre del recurso
     * (es decir el atributo "nombre" del objeto Parametro que representa al recurso). Ejemplo:
     * "EJECUTAR->RCV_TAG_CAJA.RCV_BTN_VER"
     *
     * @return Retorna conjunto de cadenas que representan a los permisos del usuario.
     */
    Set<String> getConjuntoCadenasPermisosAsociados();
}
