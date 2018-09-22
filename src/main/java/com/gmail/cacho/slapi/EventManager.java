package com.gmail.cacho.slapi;


import com.gmail.sanfrancisco.HasLogger;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;

public class EventManager implements SubscriberExceptionHandler, HasLogger {
    private final EventBus eventBus = new EventBus(this);

    public void post(final Object event) {
        getLogger().info("Evento Lanzado al Manejador de Eventos", event);
        eventBus.post(event);
    }

    public void register(final Object object) {
        getLogger().info("Registrando Fuente de Eventos", object);
        eventBus.register(object);
    }

    public void unregister(final Object object) {
        getLogger().info("DESRegistrando Fuente de Eventos", object);
        eventBus.unregister(object);
    }

    @Override
    public final void handleException(final Throwable exception, final SubscriberExceptionContext context) {
        exception.printStackTrace();
    }
}
