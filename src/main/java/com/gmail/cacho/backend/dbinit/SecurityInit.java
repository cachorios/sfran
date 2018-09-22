package com.gmail.cacho.backend.dbinit;


import com.gmail.cacho.backend.entidad.Role;
import com.gmail.cacho.backend.service.UsuarioServicio;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;


@Singleton
@Startup
public class SecurityInit {
    @Inject
    private UsuarioServicio service;

    @PostConstruct
    private void init() {
        Long adminId = service.createUser("admin", "admin","cachorios@gmail.com","admin");

        service.grant(adminId, Role.ADMIN);

        service.createUser("joe", "joe","joe@gmail.com","otro");

        for (int i = 1; i < 500; i++) {
            service.createUser(String.format("user%03d", i), "pass", String.format("user%03d", i)+"@mail.com","otro" );
        }
    }
}
