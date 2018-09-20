package com.gmail.cacho.backend.repositorios;

import com.gmail.cacho.backend.entidad.Usuario;
import org.apache.deltaspike.data.api.EntityManagerDelegate;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface Usuarios  extends EntityRepository<Usuario, Long>, EntityManagerDelegate<Usuario> {
    Usuario findByUsername(String username);
    Usuario findByEmail(String email);
}
