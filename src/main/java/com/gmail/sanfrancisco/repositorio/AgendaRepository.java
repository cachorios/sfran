package com.gmail.sanfrancisco.repositorio;

import com.gmail.sanfrancisco.entidad.Agenda;
import org.apache.deltaspike.data.api.*;

import java.util.Date;
import java.util.List;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface AgendaRepository  extends EntityRepository<Agenda, Long>, EntityManagerDelegate<Agenda> {

    @Query("SELECT e FROM Agenda e WHERE e.start BETWEEN :desde AND :hasta ")
    List<Agenda> agendaaByRangoFecha(@QueryParam("desde") Date desde,@QueryParam("hasta") Date hasta);
}
