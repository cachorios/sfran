package com.gmail.cacho.slapi.layout;


import com.github.appreciated.app.layout.behaviour.AppLayout;
import com.github.appreciated.app.layout.behaviour.Behaviour;
import com.github.appreciated.app.layout.builder.AppLayoutBuilder;
import com.github.appreciated.app.layout.component.appbar.AppBarBuilder;
import com.github.appreciated.app.layout.component.appmenu.MenuHeaderComponent;
import com.github.appreciated.app.layout.component.appmenu.left.builder.LeftAppMenuBuilder;
import com.github.appreciated.app.layout.component.appmenu.top.TopClickableComponent;
import com.github.appreciated.app.layout.design.AppLayoutDesign;
import com.github.appreciated.app.layout.router.AppLayoutRouterLayout;
import com.gmail.cacho.slapi.Sistema;
import com.gmail.cacho.slapi.dialogs.WinChangePass;
import com.gmail.cacho.slapi.utils.MenuService;
import com.gmail.cacho.slbase.security.Events;
import com.vaadin.cdi.annotation.UIScoped;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.page.BodySize;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import javax.enterprise.inject.spi.CDI;

@UIScoped
@BodySize(height = "100vh", width = "100vw")
@Theme(value = Lumo.class, variant = Lumo.LIGHT)
@HtmlImport("frontend://styles/shared-styles.html")
@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
public class MainView extends AppLayoutRouterLayout {
    public MainView() {
        Sistema.getSistema().getEventBus().register(this);
    }

    @Override
    public AppLayout getAppLayout() {
        String username = Sistema.getSistema().getNombreUsuarioActivo();
        String diricono = Sistema.getSistema().getImagePath() + username + ".png";

        // Primero define ciertos componentes de la barra superior
        MenuHeaderComponent mhc = new MenuHeaderComponent(username, null, diricono);
        mhc.setAlignItems(FlexComponent.Alignment.CENTER);
        mhc.setSpacing(false);
        mhc.setPadding(false);
        mhc.setMargin(false);
        mhc.setSizeFull();
        TopClickableComponent tc1 = new TopClickableComponent(null, VaadinIcon.LOCK.create(),
                                                              clickEvent -> (new WinChangePass()).open());
        tc1.setSizeFull();
        TopClickableComponent tc2 = new TopClickableComponent(null, VaadinIcon.OUT.create(),
                                                              clickEvent -> Sistema.getSistema().getEventBus()
                                                                                 .post(new Events.UserLogoutEvent()));
        tc2.setSizeFull();

        // Aqui organiza el layout general con titulo
        // y con la barra superior (y establece el diseño)
        AppLayoutBuilder alb = AppLayoutBuilder.get(Behaviour.LEFT).withTitle(Sistema.getSistema().getTitulo())
                                               .withAppBar(AppBarBuilder.get().add(mhc).add(tc1).add(tc2).build())
                                               .withDesign(AppLayoutDesign.MATERIAL);

        // Aqui se comienza el armado del menu principal
        // y su parte superior (con imagen y nombre/version)
        LeftAppMenuBuilder lamb = LeftAppMenuBuilder.get();

        // Aqui completa el menu del centro segun la db, el
        // usuario activo en la sesion activa y los permisos
        CDI.current().select(MenuService.class).get().completarMenuDesdeDB(lamb);

        // Aqui va el pie del menu principal (fijo para Usuario)
        MenuHeaderComponent mhc2 = new MenuHeaderComponent(username, null,
                                                           Sistema.getSistema().getImagePath() + username + ".png");
        mhc2.setSpacing(false);

        return alb.withAppMenu(lamb.build()).build();
    }
}