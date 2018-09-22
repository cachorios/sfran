package com.gmail.cacho.slbase.core.interfaces;


import com.gmail.cacho.backend.seguridad.general.SlbaseAccessControl;
import com.gmail.cacho.slbase.core.enums.ENivelAplicacion;


/**
 * Esta interfase representa el comportamiento deseable de una clase que implemente y controle un sistema
 * basado en el framework. La implementacion debe encargarse de brindar cierto tipo de funciones basicas
 * esperadas a una instancia especifica para un sistema determinado. Basicamente son 5 funciones basicas:
 * Cores, Logging, Persistencia, Seguridad. Se deberia crear una clase que implemente la interface y utilice
 * el patron singleton para asegurar que exista solo una instancia accesible de la misma.
 * Esta interfaz es parametrica para que puedan establecerse, mas abajo en la jerarquia, las clases concretas
 * encargadas de la interfaz de usuario (U) y del manejo de eventos (E).
 *
 * @author jmfragueiro
 * @version 20161011
 */
public interface IControladorSistema<U, E> {
    /**
     * Retorna el valor definido para la propiedad de configuracion solicitada.
     *
     * @param key La clave de la propiedad de configuracion deseada.
     * @return El valor establecido para la clave de dicha propiedad.
     */
    String getProperty(String key);

    /**
     * Retorna el nivel de aplicacion definido para el sistema.
     *
     * @return El valor del nivel de aplicacion definido para el sistema.
     */
    ENivelAplicacion getNivelAplicacion();

    /**
     * Retorna el nombre (interno) del sistema.
     *
     * @return El nombre (interno) del sistema.
     */
    String getNombre();

    /**
     * Retorna el titulo (nombre visible) del sistema.
     *
     * @return El titulo (nombre visible) del sistema.
     */
    String getTitulo();

    /**
     * Retorna la versión del código del sistema.
     *
     * @return La versión del código del sistema.
     */
    String getVersion();

    /**
     * Retorna el nombre (interno) de la base de datos del sistema.
     *
     * @return El nombre (interno) de la base de datos del sistema.
     */
    String getDatabase();

    /**
     * Retorna el path (interno) del sistema. Este es un valor que puede ser tomado
     * como base para encontrar recursos del sistema dentro del filesystem del s.o.
     *
     * @return El path (interno) del sistema.
     */
    String getPath();

    /**
     * Retorna el path (interno) donde se deben depositar las imagenes de usuario del sistema.
     *
     * @return El path de las imagenes de usuario del sistema.
     */
    String getImagePath();

    /**
     * Retorna el nombre del icono del sistema. Este es un valor que debe ser tomado
     * junto con el directorio de imagenes del sistema (ver getImagePath()) para asi
     * obtener un icono asociado al sistema.
     *
     * @return El nombre del icono del sistema.
     */
    String getIcon();

    /**
     * Retorna el nombre del icono del sistema. Este es un valor que debe ser tomado
     * junto con el directorio de imagenes del sistema (ver getImagePath()) para asi
     * obtener un icono peuqenio que pueda ser utilizado en el menu asociado al sistema.
     *
     * @return El nombre del icono para el menu del sistema.
     */
    String getMenuIcon();

    /**
     * Este metodo se deberia encargar de iniciar el sistema en forma ordenada comenzando por configurar
     * los valores básicos del sistema, verificar la integridad del sistema, iniciar el sistema de logging
     * (con el nivel de ejecución deseado), luego iniciar el mecanismo de persistencia de datos, y finalmente
     * iniciando, si se debe, la interfaz de usuario. Deberia lanzar una FatalErrorException si hay problemas.
     * No se espera que este metodo sea llamado mas de una vez.
     *
     * @param ui La interfaz de usuario (UI) principal para el sistema.
     */
    void iniciar(U ui, E eventbus);

    /**
     * Este metodo debe encargarse de retornar la UI principal del sistema, de manera de que pueda ser
     * accedida desde diferentes lugares a necesidad.
     *
     * @return La interface de usuario (UI) principal del sistema.
     */
    U getUIPpal();

    /**
     * Este metodo debe encargarse de retornar el gestor de eventos principal del sistema, de manera de
     * que pueda ser accedida desde diferentes lugares a necesidad.
     *
     * @return La interface de usuario (UI) principal del sistema.
     */
    E getEventBus();

    /**
     * Este metodo debe iniciar la sesion activa en curso.
     */
    void logon();

    /**
     * Este metodo debe cerrar la sesion activa en curso.
     */
    void logoff();

    /**
     * Este metodo deberia encargarse de mostrar un mensaje por pantalla.
     *
     * @param mensaje El mensaje a mostrar.
     * @param desc    Una descripcion sbre el mensaje mostrado.
     */
    void mostrarMensaje(ENivelAplicacion nivel, String mensaje, String desc);

    /**
     * Este metodo debe permitir armar un cuadro de mensaje para consulta, por Si o por No
     * (No equivale a cancelar), para operaciones que requieran de una respuesta positiva
     * para avanzar.
     */
    void mostrarBoxConsultaSiNo(String titulo, String mensaje, String textYes, String textNo, Runnable onYes);

    /**
     * Este método retorna el pre-salt "oculto" utilizado por a aplicación.
     *
     * @return el pre-salt utilizado para encriptar password en la aplicación.
     */
    String getPreSalt();

    /**
     * Este metodo permite obtener el gestor de seguridad de usuario del sistema.
     *
     * @return el controlador de seguridad de usuario del sistema.
     */
    SlbaseAccessControl getSecurityControl();

    /**
     * Este metodo permite obtener el nombre del usuario activo en el sistema. Esto NO implica que dicho
     * usuario se encuentre logeado al mismo.
     *
     * @return el nombre del usuario activo en el sistema o null si no hay ninguno
     */
     String getNombreUsuarioActivo();

    /**
     * Este metodo debería cerrar el sistema en forma ordenada cerrando los servs de logging, de persistencia
     * y cualquier otro que fuese abierto por el sistema. No se deberían capturar ni relanzar excepciones durante
     * el view.
     */
    void finalizar();
}
