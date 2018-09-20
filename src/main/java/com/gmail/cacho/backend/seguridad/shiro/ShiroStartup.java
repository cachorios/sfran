package com.gmail.cacho.backend.seguridad.shiro;


import org.apache.deltaspike.core.api.config.ConfigProperty;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.web.env.DefaultWebEnvironment;
import org.apache.shiro.web.env.EnvironmentLoaderListener;
import org.apache.shiro.web.env.WebEnvironment;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.ShiroFilter;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;

@WebListener
public class ShiroStartup extends EnvironmentLoaderListener {
    @Inject
    private ShiroRealm realm;

    @Inject
    @ConfigProperty(name = "lar.rememberme.aeskey",
            defaultValue = "547055b7b47f0821c20336b066bd37e0")
    private String rememberMeKey;


    @WebFilter("/*")
    public static class FilterActivator extends ShiroFilter {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setInitParameter(
                ENVIRONMENT_CLASS_PARAM, DefaultWebEnvironment.class.getName());
        super.contextInitialized(sce);
    }

    @Override
    protected void customizeEnvironment(WebEnvironment environment) {
        DefaultWebEnvironment env = (DefaultWebEnvironment) environment;
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager(realm);
        env.setSecurityManager(securityManager);

        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
        rememberMeManager.setCipherKey(Hex.decode(rememberMeKey));
        securityManager.setRememberMeManager(rememberMeManager);
    }

}