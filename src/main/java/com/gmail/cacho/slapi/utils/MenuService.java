package com.gmail.cacho.slapi.utils;


import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.github.appreciated.app.layout.component.appmenu.left.LeftNavigationComponent;
import com.github.appreciated.app.layout.component.appmenu.left.builder.LeftAppMenuBuilder;
import com.github.appreciated.app.layout.component.appmenu.left.builder.LeftSubMenuBuilder;
import com.gmail.cacho.backend.entidad.Parametro;
import com.gmail.cacho.backend.entidad.Usuario;
import com.gmail.cacho.backend.service.ParametroServicio;
import com.gmail.cacho.slapi.Sistema;
import com.gmail.cacho.slapi.comunes.C;
import com.gmail.cacho.slbase.core.Constantes;
import com.gmail.cacho.slbase.logging.L;
import com.gmail.cacho.slbase.security.enums.ETipoPermiso;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;


import javax.ejb.Stateless;
import javax.inject.Inject;
import java.lang.annotation.Annotation;
import java.util.List;

@Stateless
public class MenuService {
    private ParametroServicio servicio;

    @Inject
    public MenuService(ParametroServicio parametros) {
        this.servicio = parametros;
        L.sistema(Constantes.SYS_CAD_REMARK + C.MSJ_INF_INIT_MENUSERV + Constantes.SYS_CAD_REMARK);
    }

    /**
     * Obtiene la listaCols de opciones de menu principal como objetos del tipo PARAMETRO
     * con atributo "tipo" ETipoParametro=MENU, desde la base de datos y sin ningun
     * tipo de filtro extra.
     *
     * @param servicio, el servicio de parametro para obtener los objetos de menu principal
     * @return la listaCols de Parametros que representan las opciones de Menu Principal
     */
    private List<Parametro> getMenuConfig(ParametroServicio servicio) {
        return servicio.findByClaseLikeAndValorintOrderByOrden(C.SYS_CFG_MENU_PREFIJO, C.SYS_CFG_MENU_IDINI);
    }

    /**
     * Obtiene la listaCols de opciones de menu secundario como objetos de tipo PARAMETRO
     * con atributo "tipo" ETipoParametro=MENU, desde la base de datos y tomando como
     * filtro un valor long que se compara contra el atributo "valorint" de cada objeto
     * parametro a efectos de restringir la listaCols a las opciones de menu secundario de
     * una sola opcion de Menu Principal. Es decir que en cada parametro de atributo
     * "tipo" ETipoParametro=MENU, el atributo "valorint" representa la opcion de menu
     * principal de la que dicho parametro (dicha opcion de menu secundario) depende.
     *
     * @param menu,     el valor que representa a la opcion de menu principal a tomar como filtro
     * @param servicio, el servicio de parametro para obtener los objetos de submenu
     * @return la listaCols de Parametros que representan las opciones de Menu Principal
     */
    private List<Parametro> getSubMenuConfig(Long menu, ParametroServicio servicio) {
        return servicio.findByClaseLikeAndValorintOrderByOrden(C.SYS_CFG_MENU_PREFIJO, menu);
    }

    /**
     * Este metodo completa el menu del sistema a partir de la configuracion obtenida
     * desde la base de datos y teniendo en cuenta los permisos del usuario actualmente
     * conectado y validado.
     *
     * @param lamb,      el objeto sobre el que se construye el menu
     */
    public void completarMenuDesdeDB(LeftAppMenuBuilder lamb) {
        try {
            Usuario usuario = Sistema.getSistema().getSecurityControl().getUsuarioActivo();

            if (usuario != null) {
                for (Parametro m : getMenuConfig(servicio)) {
                    // Agrega la opcion de menu ppal solo si el usuario tiene permiso de ejeucion
                    if (usuario.poseePermiso(m, ETipoPermiso.EJECUTAR)) {
                        LeftSubMenuBuilder smb = LeftSubMenuBuilder.get(m.getNombre(), VaadinIcon.ELLIPSIS_DOTS_V.create());
                        getSubMenuConfig(m.getId(), servicio).forEach(sm -> {
                            try {
                                // Agrega la opcion de submenu solo si no es un separador
                                // (valorstr=null) y el usuario tiene permiso de ejecucion
                                if (sm.getNombre() != null
                                        && !sm.getNombre().substring(0,1).equals(C.SYS_CFG_MENU_SEPARATOR)
                                        && Sistema.getSistema()
                                        .getSecurityControl()
                                        .usuarioActivoPoseeCadenaPermiso(
                                                ETipoPermiso.EJECUTAR.name()
                                                        .concat(Constantes.SYS_CAD_REFER)
                                                        .concat(sm.getNombre()))) {
                                    Class c = Class.forName(sm.getValorstr());
                                    smb.add(new LeftNavigationComponent(sm.getNombre(), getIcono(c), c));
                                }
                            } catch (Exception ex) {
                                L.warning(C.SYS_MENU_ERR_NOEXISTS,
                                        sm.getNombre().concat(C.SYS_CFG_MENU_SEPARATOR).concat(sm.getValorstr()));
                            }
                        });
                        lamb.add(smb.build());
                    }
                }
            }
        } catch (Exception ex) {
            L.error(C.SYS_MENU_ERR_ONBUILD, ex.getMessage());
        }
    }


    /**
     * Este metodo completa el menu del sistema a partir de la configuracion obtenida
     * desde la base de datos y teniendo en cuenta los permisos del usuario actualmente
     * conectado y validado.
     *
     * @param lamb,      el objeto sobre el que se construye el menu
     */

//    public void completarHybridMenuDesdeDB(LeftMenu lamb) {
//        try {
//            Usuario usuario = Sistema.getSistema().getSecurityControl().getUsuarioActivo();
//
//            if (usuario != null) {
//                for (Parametro m : getMenuConfig(servicio)) {
//                    // Agrega la opcion de menu ppal solo si el usuario tiene permiso de ejeucion
//                    if (usuario.poseePermiso(m, ETipoPermiso.EJECUTAR)) {
//                        HMSubMenu smb = HMSubMenu.get()
//                                .withCaption(m.getNombre())
//                                .withIcon(VaadinIcon.ELLIPSIS_DOTS_V.create());
//                        getSubMenuConfig(m.getId(), servicio).forEach(sm -> {
//                            try {
//                                // Agrega la opcion de submenu solo si no es un separador
//                                // (valorstr=null) y el usuario tiene permiso de ejecucion
//                                if (sm.getNombre() != null
//                                        && !sm.getNombre().substring(0,1).equals(C.SYS_CFG_MENU_SEPARATOR)
//                                        && Sistema.getSistema()
//                                        .getSecurityControl()
//                                        .usuarioActivoPoseeCadenaPermiso(
//                                                ETipoPermiso.EJECUTAR.name()
//                                                        .concat(Constantes.SYS_CAD_REFER)
//                                                        .concat(sm.getNombre()))) {
//                                    Class c = Class.forName(sm.getValorstr());
//                                    smb.add(HMButton.get()
//                                            .withCaption(sm.getNombre())
//                                            .withIcon(getIcono(c))
//                                            .withNavigateTo(c));
//                                }
//                            } catch (Exception ex) {
//                                L.warning(C.SYS_MENU_ERR_NOEXISTS,
//                                        sm.getNombre().concat(C.SYS_CFG_MENU_SEPARATOR).concat(sm.getValorstr()));
//                            }
//                        });
//                        lamb.add(smb);
//                    }
//                }
//            }
//        } catch (Exception ex) {
//            L.error(C.SYS_MENU_ERR_ONBUILD, ex.getMessage());
//        }
//    }

    /**
     * Este metodo obtiene el icono a mostrar como parte del menu y a partir de la
     * definicion establecida en la propia clase utilizando la anotacion @MuniIcon.
     * Si no encuentra esa anontacion (o la calse es nula) se retorna el icono que
     * se genera a partir de VaadinIcon.MINUS_SQUARE_O.
     *
     * @param clase, la clase para la cual buscar el icono
     * @return el icono obtenido a partir de la anotacion de la clase argumento
     */
    private Icon getIcono(Class<?> clase) {
        if (clase != null) {
            Annotation a = clase.getAnnotation(MenuIcon.class);
            if (a != null) {
                VaadinIcon vi = ((MenuIcon)a).value();
                return vi.create();
            }
        }
        return VaadinIcon.MINUS_SQUARE_O.create();
    }
}
