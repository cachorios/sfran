package com.gmail.cacho.backend.dbinit;


import com.gmail.cacho.backend.entidad.Role;
import com.gmail.cacho.backend.entidad.Usuario;
import com.gmail.cacho.backend.service.UsuarioServicio;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;


@Singleton
//@Startup
public class SecurityInit {
    @Inject
    private UsuarioServicio service;

    @PostConstruct
    private void init() {
//        Usuario admin = service.findByUserName("admin");
//        service.generateSaltedHash("admin",admin);
//        service.save(admin);
//        Usuario u = service.findByUserName("cacho");
//        service.generateSaltedHash("7219",u);
//        service.save(u);
//        u = service.findByUserName("beto");
//        service.generateSaltedHash("beto",u);
//        service.save(u);

        Long adminId = service.createUser("admin", "admin","cachorios@gmail.com","admin");

        service.grant(adminId, Role.ADMIN);

        service.createUser("BETO", "joe","joe@gmail.com","otro");
//
//        for (int i = 1; i < 500; i++) {
//            service.createUser(String.format("user%03d", i), "pass", String.format("user%03d", i)+"@mail.com","otro" );
//        }
    }
}
