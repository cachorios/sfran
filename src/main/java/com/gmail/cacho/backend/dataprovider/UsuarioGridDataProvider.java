package com.gmail.cacho.backend.dataprovider;

import com.gmail.cacho.backend.entidad.Usuario;
import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.backend.service.UsuarioServicio;
import com.vaadin.flow.data.provider.QuerySortOrder;
import com.vaadin.flow.data.provider.SortDirection;

import javax.inject.Inject;
import java.util.Arrays;

public class UsuarioGridDataProvider extends FilterablePageableDataProvider<Usuario, Long, String> {
    @Inject
    public UsuarioGridDataProvider(UsuarioServicio servicio) {
        super(servicio, Arrays.asList(new QuerySortOrder("nombre", SortDirection.ASCENDING)));
    }
}
