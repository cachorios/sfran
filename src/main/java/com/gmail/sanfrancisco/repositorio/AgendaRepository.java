package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.Agenda;
import org.apache.deltaspike.data.api.EntityManagerDelegate;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface AgendaRepository  extends EntityRepository<Agenda, Long>, EntityManagerDelegate<Agenda> {

}
