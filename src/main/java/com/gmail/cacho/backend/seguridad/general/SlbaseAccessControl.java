package com.gmail.cacho.backend.seguridad.general;


import com.gmail.cacho.backend.entidad.Usuario;
import com.gmail.cacho.backend.service.UsuarioServicio;
import com.gmail.cacho.slbase.security.interfaces.IControladorSeguridad;
import com.vaadin.flow.server.VaadinSession;
import org.apache.shiro.SecurityUtils;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * A simple access control implementation using Apache Shiro.
 */
@ApplicationScoped
public class SlbaseAccessControl implements IControladorSeguridad {
    private Usuario usuarioActivo;

    @Inject
    private UsuarioServicio usuarioService;

    @Inject
    PrincipalMapper principalMapper;

    public boolean isUserSignedIn() {
        return SecurityUtils.getSubject().isAuthenticated();
    }

    public boolean isUserInRole(String role) {
        return SecurityUtils.getSubject().hasRole(role);
    }

    public Usuario getUsuarioActivo() {
        if (!isUserSignedIn() || usuarioActivo == null) {
            System.out.println("SlbaseAccessControl.getUsuarioActivo---->" + getNombreDeUsuarioActivo());
            usuarioActivo = usuarioService.findByUsername(getNombreDeUsuarioActivo());
            System.out.println("Usuario Activo -->" + usuarioActivo);
        }

        return  usuarioActivo;
    }

    public String getNombreDeUsuarioActivo() {
        return  principalMapper.getUsername( SecurityUtils.getSubject().getPrincipals());
    }

    public boolean usuarioActivoPoseeCadenaPermiso(String permiso) {
        return true;
//        try {
//            SecurityUtils.getSubject().checkPermission(permiso);
//            return true;
//        } catch (Exception ae) {
//            return false;
//        }
    }

    public String getPrincipalName() {
        return getNombreDeUsuarioActivo();
    }

    public void logoff() {
        usuarioActivo = null;
        VaadinSession.getCurrent().setAttribute(Usuario.class.getName(), null);
        SecurityUtils.getSubject().logout();
        VaadinSession.getCurrent().close();
    }

    public boolean isUserInSomeRole(String... roles) {
        String[] var2 = roles;
        int var3 = roles.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String role = var2[var4];
            if (this.isUserInRole(role)) {
                return true;
            }
        }

        return false;
    }
}