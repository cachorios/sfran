package com.gmail.cacho.slbase.logging.interfaces;


import com.gmail.cacho.slbase.core.enums.ENivelAplicacion;

/**
 * Esta interfase es la que representa el comportamiento deseable de una clase que implemente y controle un
 * servicio de logging, el cual debe encargarse de registrar mensajes a cualquier salida determinada. Este
 * servicio de logging debe utilizar el nivel de ejecución de un sistema (un valor de enum ENivelAplicacion)
 * para establecer que mensajes logear o como comportarse respecto del modo en que se ejecuta la aplicacion.
 *
 * @author jmfragueiro
 * @version 20161011
 */
public interface IControladorLogging {
    /**
     * Metodo para registrar (logear) un mensaje al destino del servicio. En este caso el mensaje
     * no tendria nada "extra" para mostrar y ademas deberia de salir con el nivel de aplicacion
     * establecido para el sistema en curso.
     *
     * @param mensaje El mensaje a registrar (logear).
     * @author jmfragueiro  (20161011)
     */
    void logear(String mensaje);

    /**
     * Metodo para registrar (logear) un mensaje al destino del servicio. En este caso el mensaje
     * si tendria algo "extra" para mostrar y ademas deberia de salir con el nivel de aplicacion
     * establecido para el sistema en curso.
     *
     * @param mensaje El mensaje a registrar (logear).
     * @param extra   Una cadena extra que se debería anexar al mensaje (o puede ser null).
     * @author jmfragueiro  (20161011)
     */
    void logear(String mensaje, String extra);

    /**
     * Metodo para registrar (logear) un mensaje al destino del servicio. En este caso el mensaje
     * no tendria nada "extra" para mostrar, pero deberia de salir con el nivel de aplicacion que
     * se pasa como argumento.
     *
     * @param nivel   El nivel del mensaje (debe ser un valor de enum ENivelAplicacion)
     *                que se debe utilizar para filtrar lo que se registra efectivamente,
     *                dado que solo lo que supere el nivel de mensaje de la instancia actual
     *                del servicio debera quedar registrado.
     * @param mensaje El mensaje a registrar (logear).
     * @author jmfragueiro  (20161011)
     */
    void logear(ENivelAplicacion nivel, String mensaje);

    /**
     * Metodo para registrar (logear) un mensaje al destino del servicio. En este caso el mensaje
     * si tendria algo "extra" para mostrar, y ademas deberia de salir con el nivel de aplicacion
     * que se pasa como argumento.
     *
     * @param nivel   El nivel del mensaje (debe ser un valor de enum ENivelAplicacion)
     *                que se debe utilizar para filtrar lo que se registra efectivamente,
     *                dado que solo lo que supere el nivel de mensaje de la instancia actual
     *                del servicio debera quedar registrado.
     * @param mensaje El mensaje a registrar (logear).
     * @param extra   Una cadena extra que se debería anexar al mensaje (o puede ser null).
     * @author jmfragueiro  (20161011)
     */
    void logear(ENivelAplicacion nivel, String mensaje, String extra);

    /**
     * Metodo para finalizar el servicio de logging, el cual debería cerrar en forma ordenada el mismo y todos
     * los recursos asociados, descargando lo que tenga en curso (además obvio deberia logear su propio cierre).
     *
     * @author jmfragueiro  (20161011)
     */
    void terminar();
}
