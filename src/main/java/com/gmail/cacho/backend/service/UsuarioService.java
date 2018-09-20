package com.gmail.cacho.backend.service;

import com.gmail.cacho.backend.entidad.Role;
import com.gmail.cacho.backend.entidad.Usuario;
import com.gmail.cacho.backend.repositorios.Usuarios;
import com.gmail.cacho.backend.seguridad.shiro.HashConfig;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Hash;
import org.apache.shiro.util.ByteSource;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class UsuarioService {
    @Inject
    private Usuarios repo;
//    @Inject
//    private Role roles;
    @Inject
    private HashConfig hashConfig;


    private RandomNumberGenerator rng;

    public Long createUser(String username, String password, String email) {
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setEmail(email);
        generateSaltedHash(password, usuario);
        this.repo.persist(usuario);
        return usuario.getId();
    }

    public void grant(Long userId, String  role) {
        Usuario usuario = this.repo.findBy(userId);
        usuario.setRole(role);
    }

    private void generateSaltedHash(String password, Usuario usuario) {
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
}
