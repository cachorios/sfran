package com.gmail.cacho.backend.dbinit;


import com.gmail.cacho.backend.entidad.Role;
import com.gmail.cacho.backend.service.UsuarioService;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;


@Singleton
@Startup
public class SecurityInit {
    @Inject
    private UsuarioService service;

    @PostConstruct
    private void init() {
        Long adminId = service.createUser("root", "root","cachorios@gmail.com");
        service.grant(adminId, Role.ADMIN);

        service.createUser("joe", "joe","joe@gmail.com");

        for (int i = 1; i < 500; i++) {
            service.createUser(String.format("user%03d", i), "pass", String.format("user%03d", i)+"@mail.com" );
        }
    }
}
