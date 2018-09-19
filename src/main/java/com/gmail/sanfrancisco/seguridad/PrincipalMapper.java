package com.gmail.sanfrancisco.seguridad;


import com.gmail.sanfrancisco.entidad.Usuario;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PrincipalMapper {

    public PrincipalCollection toPrincipals(Usuario usuario, String realmName) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection();
        principals.add(usuario.getId(), realmName);
        principals.add(usuario.getUsername(), realmName);
        return principals;
    }

    public Long getUserId(PrincipalCollection principals) {
        return (Long) principals.asList().get(0);
    }

    public String getUsername(PrincipalCollection principals) {
        return (String) principals.asList().get(1);
    }
}
