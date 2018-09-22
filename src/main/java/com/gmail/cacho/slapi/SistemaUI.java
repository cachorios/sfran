package com.gmail.cacho.slapi;


import com.gmail.cacho.slapi.layout.MainView;
import com.gmail.cacho.slbase.security.Events;
import com.google.common.eventbus.Subscribe;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import org.apache.shiro.authz.annotation.RequiresUser;


@Route(value = "", layout = MainView.class)
@RequiresUser
public class SistemaUI extends Div {
    public SistemaUI() {
        Sistema.getSistema().iniciar(this, new EventManager());
        Sistema.getSistema().getEventBus().register(this);
        setClassName("sin-magenes");
    }

    @Subscribe
    public void userLogout(final Events.UserLogoutEvent event) {
        Sistema.getSistema().logoff();
    }
}
