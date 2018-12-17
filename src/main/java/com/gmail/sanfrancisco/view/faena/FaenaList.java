package com.gmail.sanfrancisco.view.faena;

import com.gmail.cacho.slapi.view.AbstractList;
import com.gmail.cacho.slapi.view.interfaces.IPresenterList;
import com.gmail.cacho.slapi.view.renders.DateRenderer;
import com.gmail.cacho.slapi.view.utils.ColumnList;
import com.gmail.sanfrancisco.entidad.Faena;
import com.gmail.sanfrancisco.entidad.FaenaProductor;
import com.gmail.sanfrancisco.jpa.PersistenceCfg;
import com.gmail.sanfrancisco.repositorio.DteRepositorio;
import com.gmail.sanfrancisco.repositorio.FaenaRepositorio;
import com.gmail.sanfrancisco.repositorio.ProductorRepositorio;
import org.apache.deltaspike.jpa.api.entitymanager.EntityManagerConfig;
import org.apache.deltaspike.jpa.api.entitymanager.EntityManagerResolver;

import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import java.util.Arrays;
import java.util.Date;

public class FaenaList extends AbstractList<Faena> {
    @Inject
    public FaenaList(IPresenterList<Faena> presenter, FaenaRepositorio repositorio, ProductorRepositorio productorRepositorio, DteRepositorio dteRepositorio) {
        super(presenter);

        setListaCols(Arrays.asList(
                new ColumnList<>(new DateRenderer<>(Faena::getFecha,"dd/MM/yyyy"),"Fecha","fecha", true,"45%"),
                new ColumnList<>(Faena::getNumero,"Numero","numero", true,"45%")
        ));

//        Faena faena= new Faena();
//        faena.setNumero(1);
//        faena.setFecha(new Date());
//
//        faena.setFaenaProductor(null);
//        FaenaProductor faenaProductor = new FaenaProductor();
//                faena.getFaenaProductor();
//        faenaProductor.setProductor( productorRepositorio.findBy(4l) );
//        faenaProductor.setTropa( dteRepositorio.findBy(5l));
//
//
//        faena.setFaenaProductor(faenaProductor);
//
//        repositorio.save(faena);







    }

    @Override
    public String getTagVista() {
        return "FAENA";
    }

    @Override
    public Class<Faena> getEntityType() { return Faena.class; }

    @Override
    public String getTitulo() {
        return "Lista de Faenas";
    }
}
