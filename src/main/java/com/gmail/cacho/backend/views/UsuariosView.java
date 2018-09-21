package com.gmail.cacho.backend.views;


import com.gmail.cacho.backend.entidad.Usuario;
import com.gmail.cacho.backend.jpa.DataProviderBuilder;
import com.gmail.cacho.backend.jpa.DataProviderService;
import com.gmail.sanfrancisco.view.MainView;
import com.vaadin.flow.component.AbstractField.ComponentValueChangeEvent;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.TextField;

import com.vaadin.flow.data.provider.ConfigurableFilterDataProvider;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;


import javax.annotation.PostConstruct;
import javax.inject.Inject;


@Tag("usuarios-view")
@HtmlImport("src/views/usuarios/usuarios-view.html")
@Route(value = "usuarios", layout = MainView.class)
//@RequiresPermissions(AppPermissions.USER_ADMIN)
public class UsuariosView extends PolymerTemplate<TemplateModel> {

    @Inject
    private DataProviderService<Usuario, String> dataProviderService;

    @Id("usersGrid")
    private Grid<Usuario> usersGrid;

    @Id
    private TextField filterField;

    private ConfigurableFilterDataProvider<Usuario, Void, String> dataProvider;

    @PostConstruct
    private void init() {
        dataProvider = new DataProviderBuilder<>(dataProviderService)
                .newDataProvider()
                .withConfigurableFilter();

        dataProvider.setFilter("");

        usersGrid.setDataProvider(dataProvider);
        usersGrid.addColumn(Usuario::getUsername)
                .setWidth("200px")
                .setHeader("Username")
                .setSortable(true)
                .setKey("username")
                .setFlexGrow(1);
        usersGrid.addColumn(user -> user.getRole())
                .setWidth("200px").setHeader("Roles").setFlexGrow(5);
        filterField.setValueChangeMode(ValueChangeMode.EAGER);
        filterField.addValueChangeListener(this::onFilterChange);
    }

    private void onFilterChange(ComponentValueChangeEvent<TextField, String> event) {
        String filter = event.getValue().trim();
        dataProvider.setFilter(filter);
        dataProvider.refreshAll();
    }

}
