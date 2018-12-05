package com.gmail.sanfrancisco.view.comisionista;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.ILayoutInnerList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.Comisionista;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.vaadin.flow.function.ValueProvider;

import javax.inject.Inject;
import java.util.Arrays;

public class ComisionistaList extends AbstractList<Comisionista> {
    @Inject
    public ComisionistaList(IPresenterList<Comisionista> presenter) {
        super(presenter);

    }

    @Override
    public String getTagVista(){ return "COMISIONISTA"; }

    @Override
    public Class<Comisionista> getEntityType() { return Comisionista.class; }

    @Override
    public String getTitulo() { return "Lista de Comisionistas"; }

    @Override
    protected ILayoutInnerList<Comisionista> generarLayout(AbstractList<Comisionista> padre, String titulo) {
        return new ComisionistaInnerList(padre, getTitulo());
    }



    @Override
    public void setCols(Grid<Comisionista> grilla) {
        ValueProvider<Comisionista, String> cssClassProvider;
        cssClassProvider = (comisionista) -> {
            String cssClass = "";
            if(comisionista.getSaldoInicial()<0 ) {
                cssClass = "color:red";
            }else {
                cssClass += "color.black";
            }
            return cssClass;
        };

        grilla.addColumn(Comisionista::getNombre)
                .setHeader("Nombre")
                .setWidth("40%")
                .setKey("nombre");

        grilla.addColumn(Comisionista::getCelular)
                .setHeader("Celular")
                .setWidth("15%")
                .setKey("celular");

//        grilla.addColumn(Comisionista::getSaldoInicial)
//                .setHeader("Inicio")
//                .setWidth("15%")
//                .setKey("saldoInicial");


//        grilla.addColumn(TemplateRenderer.<Comisionista> of(
//                "<div >LAR<br><small>[[item.saldoInicial]]</small></div>")
//                .withProperty("saldoInicial", Comisionista::getSaldoInicial)
//                )
//                .setHeader("Inicio")
//                .setWidth("20%")
//                ;

        grilla.addColumn(TemplateRenderer.<Comisionista>
                of("<div style$=\"[[item.class]]\">[[item.saldoInicial]]</div>")
                .withProperty("class", cssClassProvider)
                .withProperty("saldoInicial", Comisionista::getSaldoInicial));



    }


}