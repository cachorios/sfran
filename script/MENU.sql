---------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------
-- VALORES A TENER EN CUENTA:                                                                                                        --
-- valordob: el orden en que las opciones de Menu aparecen (hay una cuenta por menu ppal y cada submenu tiene su cuenta)             --
-- valorint: aplica a os valores de submenu y apunta al id del menu ppal del que depende el submenu                                  --
-- valorstr: en menus ppal es descripcion del menu, en menus secundarios es el nombre calificado de la clase vista que lo implementa --
        ---------------------------------------------------------------------------------------------------------------------------------------
        ---------------------------------------------------------------------------------------------------------------------------------------
           INSERT INTO parametro (id, fechabaja, fechaumod, usuarioalta, usuarioumod, clase, nombre, orden, tipo, valorbol, valordat, valordob, valorint, valorstr, version)
        VALUES

           (1,  NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.TRAN', 'Transporte',                     0, 2, FALSE, NULL, 0, 0, 'Gestion Vehiculos y Choferes', 1),
           (2,  NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.TRAN', 'Moviles',                        1, 2, FALSE, NULL, 1, 1, 'com.gmail.sanfrancisco.view .vehiculo.VehiculoView', 1),
           (3,  NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.TRAN', 'Conductores',                    2, 2, FALSE, NULL, 2, 1, 'com.gmail.sanfrancisco.view.conductor.ConductorView', 1),
           (4,  NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.TRAN', 'Licencias',                      3, 2, FALSE, NULL, 3, 1, 'com.gmail.sanfrancisco.view.licencia.LicenciaView', 1),


           (90, NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.PARA', 'Parametros del Sistema',       900, 2, FALSE, NULL, 7,  0,  'Configuracion General del Sistema', 1),
           (91, NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.PARA', 'Parametros Generales',         901, 2, FALSE, NULL, 8,  90,  'com.gmail.cacho.backend.views.parametro.ParamView', 1),
           (92, NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.PARA', 'Comisionistas',                902, 2, FALSE, NULL, 9,  1,  'com.gmail.sanfrancisco.view.comisionista.ComisionistaView', 1),
           (93, NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.PARA', 'Consignatarios',               903, 2, FALSE, NULL, 10, 1,  'com.gmail.sanfrancisco.view.consignatario.ConsignatarioView', 1),
           (94, NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.PARA', 'Productores',                  904, 2, FALSE, NULL, 11, 1,  'com.gmail.sanfrancisco.view.productor.ProductorView', 1),
           (95, NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.PARA', 'Usuarios',                     905, 2, FALSE, NULL, 12, 90, 'com.gmail.cacho.backend.views.UsuariosView', 1);


--        (93, NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.PARA', 'Roles',                        904, 2, FALSE, NULL,10, 90, 'ar.com.sciolar.siddire.view.roles.RolView', 1),
--        (95, NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.PARA', 'Tipos Afip',                   906, 2, FALSE, NULL,12, 90, 'ar.com.sciolar.siddire.view.roles.NoView', 1),

