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
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.page.BodySize;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import de.kaesdingeling.hybridmenu.HybridMenu;
import de.kaesdingeling.hybridmenu.components.HMLabel;
import de.kaesdingeling.hybridmenu.components.LeftMenu;
import de.kaesdingeling.hybridmenu.data.MenuConfig;
import de.kaesdingeling.hybridmenu.design.DesignItem;

import javax.enterprise.inject.spi.CDI;

import static com.github.appreciated.app.layout.entity.Section.HEADER;

@BodySize(height = "100vh", width = "100vw")
@HtmlImport("frontend://styles/shared-styles.html")
@Theme(value = Lumo.class, variant = Lumo.LIGHT)
@HtmlImport("frontend://styles/shared-styles.html")
@HtmlImport("frontend://styles/shared-styles.html")
public class MainView extends AppLayoutRouterLayout {
    public MainView() {
        Sistema.getSistema().getEventBus().register(this);
    }

    @Override
    public AppLayout getAppLayout() {
        // Primero define ciertos componentes de la barra superior
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
                .withAppBar(AppBarBuilder.get().add(tc1).add(tc2).build())
                .withDesign(AppLayoutDesign.DEFAULT);//.MATERIAL);

        // Aqui se comienza el armado del menu principal
        // y su parte superior (con imagen y nombre/version)
        LeftAppMenuBuilder lamb = LeftAppMenuBuilder.get();
        String sistema = Sistema.getSistema().getNombre();
        String username = Sistema.getSistema().getNombreUsuarioActivo();
        String diricono = Sistema.getSistema().getImagePath() + username + ".png";
        MenuHeaderComponent header = new MenuHeaderComponent(username, null, diricono);
        header.setAlignItems(FlexComponent.Alignment.CENTER);
        lamb.addToSection(header, HEADER);

        // Aqui completa el menu del centro segun la db, el
        // usuario activo en la sesion activa y los permisos
        CDI.current().select(MenuService.class).get().completarMenuDesdeDB(lamb);

        return alb.withAppMenu(lamb.build()).build();
    }
}