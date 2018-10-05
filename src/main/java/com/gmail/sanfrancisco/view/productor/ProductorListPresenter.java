package com.gmail.sanfrancisco.view.productor;

import com.gmail.cacho.backend.jpa.FilterablePageableDataProvider;
import com.gmail.cacho.slapi.view.controllers.AbstractPresenterList;
import com.gmail.sanfrancisco.entidad.Productor;
import com.gmail.sanfrancisco.serviciosModelo.ProductorService;

import javax.inject.Inject;

public class ProductorListPresenter extends AbstractPresenterList<Productor, ProductorService> {
    @Inject
    public ProductorListPresenter(ProductorService servicio, FilterablePageableDataProvider<Productor, Long, String> dataProvider) {
        super(servicio, dataProvider);
    }
}
