package com.gmail.sanfrancisco.view.productor;

import com.gmail.cacho.slapi.view.controllers.AbstractPresenterForm;
import com.gmail.sanfrancisco.entidad.Productor;
import com.gmail.sanfrancisco.serviciosModelo.ProductorService;

import javax.inject.Inject;

public class ProductorFormPresenter extends AbstractPresenterForm<Productor, ProductorService> {
    @Inject
    public ProductorFormPresenter(ProductorService servicio) { super(servicio); }
}