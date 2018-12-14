package com.gmail.cacho.backend.repositorios;

import com.gmail.cacho.backend.entidad.Usuario;
import org.apache.deltaspike.data.api.*;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Repository
public interface UsuariosRepositorio extends EntityRepository<Usuario, Long>, EntityManagerDelegate<Usuario> {
    Usuario findById(Long id);

    Usuario findByUsername(String username);

    @Query("SELECT e.password FROM Usuario e WHERE e.id = ?1")
    String getPasswordString(Long userID);

    QueryResult<Usuario> findByNombreLikeIgnoreCaseOrUsernameLikeIgnoreCaseOrEmailLikeIgnoreCase(
            String nombre, String usuario, String email);

    @Query("select e from Usuario e WHERE e.fechabaja is null")
    QueryResult<Usuario> queryAll();

    @Query("select count(e) from Usuario e WHERE LOWER( e.nombre ) like  ?1 or LOWER( e.username ) like ?2 or LOWER( e.email ) like ?3 ")
    long countByNombreLikeIgnoreCaseOrUsernameLikeIgnoreCaseOrEmailLikeIgnoreCase(String nombre,
                                                                                 String usuario,
                                                                                 String email
                                                                                 );

    @Query("select COUNT(e) FROM Usuario e WHERE e.fechabaja is null")
    long countAll();

}
