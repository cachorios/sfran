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

           (1,  NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.TRAN', 'Transporte',                     0, 2, FALSE, NULL,  0,  0,  'Gestion Vehiculos y Choferes', 1),

           (2,  NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.TRAN', 'Vehiculos',                      1, 2, FALSE, NULL,  1,  1,  'com.gmail.sanfrancisco.view.vehiculo.VehiculoView', 1),
           (3,  NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.TRAN', 'Conductores',                    2, 2, FALSE, NULL,  2,  1,  'com.gmail.sanfrancisco.view.conductor.ConductorView', 1),

           (4,  NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.PERS', 'Personas',                       4, 2, FALSE, NULL,  1,  0,  'Personas', 1),
           (5,  NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.PERS', 'Comisionistas',                  5, 2, FALSE, NULL,  2,  4,  'com.gmail.sanfrancisco.view.comisionista.ComisionistaView', 1),
           (6,  NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.PERS', 'Consignatarios',                 6, 2, FALSE, NULL,  3,  4,  'com.gmail.sanfrancisco.view.consignatario.ConsignatarioView', 1),
           (7,  NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.PERS', 'Productores',                    7, 2, FALSE, NULL,  4,  4,  'com.gmail.sanfrancisco.view.productor.ProductorView', 1),

           (8,  NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.PREF', 'Prefaena',                       8, 2, FALSE, NULL,  2,  0,  'Prefaena', 1),
           (9,  NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.PREF', 'DTE',                            9, 2, FALSE, NULL,  3,  8,  'com.gmail.sanfrancisco.view.dte.DteView', 1),

           (10, NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.OTRO', 'Otros',                         10, 2, FALSE, NULL,  3,  0,  'Otros', 1),
           (11, NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.OTRO', 'Insumos',                       11, 2, FALSE, NULL,  4, 10,  'com.gmail.sanfrancisco.view.insumo.InsumoView', 1),


           (90, NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.PARA', 'Parametros del Sistema',       900, 2, FALSE, NULL,  8,   0,  'Configuracion General del Sistema', 1),
           (91, NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.PARA', 'Parametros Generales',         901, 2, FALSE, NULL,  9,  90,  'com.gmail.cacho.backend.views.parametro.ParamView', 1),
           (96, NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.PARA', 'Usuarios',                     906, 2, FALSE, NULL, 11,  90, 'com.gmail.cacho.backend.views.UsuariosView', 1);


--        (93, NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.PARA', 'Roles',                        904, 2, FALSE, NULL,10, 90, 'ar.com.sciolar.siddire.view.roles.RolView', 1),
--        (95, NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.PARA', 'Tipos Afip',                   906, 2, FALSE, NULL,12, 90, 'ar.com.sciolar.siddire.view.roles.NoView', 1),

