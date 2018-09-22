package com.gmail.cacho.backend.service;

import com.gmail.cacho.backend.entidad.Usuario;
import com.gmail.cacho.backend.jpa.ServicioModelo;
import com.gmail.cacho.backend.repositorios.UsuariosRepositorio;
import com.gmail.cacho.backend.seguridad.shiro.HashConfig;
import com.vaadin.flow.data.provider.QuerySortOrder;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Hash;
import org.apache.shiro.util.ByteSource;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Stream;

@Stateless
public class UsuarioServicio extends ServicioModelo<Usuario> {
    @Inject
    private UsuariosRepositorio repo;
//    @Inject
//    private Role roles;
    @Inject
    private HashConfig hashConfig;


    private RandomNumberGenerator rng;

    public Long createUser(String username, String password, String email, String avatar) {
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setEmail(email);
        usuario.setPhotoUrl(avatar);
        generateSaltedHash(password, usuario);
        this.repo.persist(usuario);
        return usuario.getId();
    }

    public void grant(Long userId, String  role) {
        Usuario usuario = this.repo.findBy(userId);
        usuario.setRole(role);
    }

    public  void generateSaltedHash(String password, Usuario usuario) {
        ByteSource saltByteSrc = getRng().nextBytes();
        usuario.setSalt(saltByteSrc.toHex());
        Hash hash = hashConfig.createHash(password, saltByteSrc);
        usuario.setPassword(hash.toHex());
    }

    private RandomNumberGenerator getRng() {
        if (rng == null) {
            rng = new SecureRandomNumberGenerator();
        }
        return rng;
    }

    public Usuario findByUserName(String userName){
        return repo.findByUsername(userName);
    }

    public Usuario save(Usuario u){
        return repo.save(u);
    }

    @Override
    public long countAnyMatching(Object padre, String filtro) {
        return 0;
    }

    @Override
    public Stream<Usuario> findAnyMatching(Object padre, String filtro, int offset, int limitm, List<QuerySortOrder> sortOrders) {
        return null;
    }
}
