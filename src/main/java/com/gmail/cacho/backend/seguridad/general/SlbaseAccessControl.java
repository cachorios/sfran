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
public class SlbaseAccessControl { // implements IControladorSeguridad {
    private Usuario usuarioActivo;

    @Inject
    private UsuarioServicio usuarioService;

    public boolean isUserSignedIn() {
        return true ; //SecurityUtils.getSubject().isAuthenticated();
    }

//    public boolean isUserInRole(String role) {
//        return SecurityUtils.getSubject().hasRole(role);
//    }

    public Usuario getUsuarioActivo() {
//        if (!isUserSignedIn() || usuarioActivo == null) {
//            usuarioActivo = usuarioService.findByUserName(getNombreDeUsuarioActivo());
//        }

        return new Usuario(); // usuarioActivo;
    }

    public String getNombreDeUsuarioActivo() {
        //Object principal = SecurityUtils.getSubject().getPrincipal();
        return "admin"; ////(principal == null) ? null : String.valueOf(principal);
    }

    public boolean usuarioActivoPoseeCadenaPermiso(String permiso) {
//        try {
//            SecurityUtils.getSubject().checkPermission(permiso);
//            return true;
//        } catch (Exception ae) {
//            return false;
//        }
        return true;
    }
//
//    public String getPrincipalName() {
//        return getNombreDeUsuarioActivo();
//    }
//
    public void logoff() {
        usuarioActivo = null;
//        VaadinSession.getCurrent().setAttribute(Usuario.class.getName(), null);
//        SecurityUtils.getSubject().logout();
//        VaadinSession.getCurrent().close();
    }
//
//    public boolean isUserInSomeRole(String... roles) {
//        String[] var2 = roles;
//        int var3 = roles.length;
//
//        for(int var4 = 0; var4 < var3; ++var4) {
//            String role = var2[var4];
//            if (this.isUserInRole(role)) {
//                return true;
//            }
//        }
//
//        return false;
//    }
}