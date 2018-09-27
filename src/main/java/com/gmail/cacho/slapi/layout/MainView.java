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


@UIScoped
@BodySize(height = "100vh", width = "100vw")
@Theme(value = Lumo.class, variant = Lumo.LIGHT)
@HtmlImport("frontend://styles/shared-styles.html")
@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
public class MainView extends HybridMenu {

        @Override
        public boolean init(VaadinSession vaadinSession, UI ui) {

            withConfig(MenuConfig.get().withDesignItem(DesignItem.getWhiteDesign()).withBreadcrumbs(false));

//        TopMenu topMenu = getTopMenu();

            // topMenu.add(HMTextField.get(VaadinIcon.SEARCH, "Search ..."));

//        topMenu.add(HMButton.get()
//                .withIcon(VaadinIcon.HOME)
//                .withDescription("Home")
//                .withNavigateTo(ParamView.class));


            LeftMenu leftMenu = getLeftMenu();

            leftMenu.add(HMLabel.get()
                    .withCaption("<b>Hybrid</b> Menu")
                    .withIcon(new Image("./frontend/hybridmenu/logo.png", "HybridMenu Logo")));

//        getBreadCrumbs().setRoot(leftMenu.add(HMButton.get()
//                .withCaption("Home")
//                .withIcon(VaadinIcon.HOME)
//                .withNavigateTo(ParamView.class)));

//        leftMenu.add(HMButton.get()
//                .withCaption("Notification Builder")
//                .withIcon(VaadinIcon.BELL)
//                .withNavigateTo(NotificationBuilderPage.class));


//		leftMenu.add(HMButton.get()
//				.withCaption("Theme Builder")
//				.withIcon(FontAwesome.WRENCH)
//				.withNavigateTo(ThemeBuilderPage.class));
//

        /*
        HMSubMenu memberList = leftMenu.add(HMSubMenu.get()
                .withCaption("Member")
                .withIcon(VaadinIcon.USERS));

        memberList.add(HMButton.get()
                .withCaption("Settings")
                .withIcon(VaadinIcon.COGS)
                .withNavigateTo(SettingsPage.class));

        memberList.add(HMButton.get()
                .withCaption("Member")
                .withIcon(VaadinIcon.USERS)
                .withNavigateTo(ParamView.class));

        memberList.add(HMButton.get()
                .withCaption("Group")
                .withIcon(VaadinIcon.USERS)
                .withNavigateTo(ParamView.class));

        HMSubMenu memberListTwo = memberList.add(HMSubMenu.get()
                .withCaption("Member")
                .withIcon(VaadinIcon.USERS));

        memberListTwo.add(HMButton.get()
                .withCaption("Settings")
                .withIcon(VaadinIcon.COGS)
                .withNavigateTo(SettingsPage.class));

        memberListTwo.add(HMButton.get()
                .withCaption("Member")
                .withIcon(VaadinIcon.USERS)
                .withNavigateTo(ParamView.class));


        HMSubMenu demoSettings = leftMenu.add(HMSubMenu.get()
                .withCaption("Settings")
                .withIcon(VaadinIcon.COGS));

        demoSettings.add(HMButton.get()
                .withCaption("White Theme")
                .withIcon(VaadinIcon.PALETE)
                .withClickListener(e -> switchTheme(DesignItem.getWhiteDesign())));

        demoSettings.add(HMButton.get()
                .withCaption("Dark Theme")
                .withIcon(VaadinIcon.PALETE)
                .withClickListener(e -> switchTheme(DesignItem.getDarkDesign())));

        demoSettings.add(HMButton.get()
                .withCaption("Minimal")
                .withIcon(VaadinIcon.COG)
                .withClickListener(e -> getLeftMenu().toggleSize()));
        */

            CDI.current().select(MenuService.class).get().completarHybridMenuDesdeDB(leftMenu);
            return true;
        }
}
