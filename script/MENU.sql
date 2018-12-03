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

           (1, NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.OTRO', 'Otros',                           0, 2, FALSE, NULL,  0,  0,  'Otros', 1),
           (2, NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.OTRO', 'Insumos',                         1, 2, FALSE, NULL,  1,  1,  'com.gmail.sanfrancisco.view.insumo.InsumoView', 1),

           (3,  NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.TRAN', 'Transporte',                     2, 2, FALSE, NULL,  1,  0,  'Gestion Vehiculos y Choferes', 1),

           (4,  NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.TRAN', 'Vehiculos',                      3, 2, FALSE, NULL,  2,  3,  'com.gmail.sanfrancisco.view.vehiculo.VehiculoView', 1),
           (5,  NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.TRAN', 'Conductores',                    4, 2, FALSE, NULL,  3,  3,  'com.gmail.sanfrancisco.view.conductor.ConductorView', 1),

           (6,  NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.PERS', 'Personas',                       5, 2, FALSE, NULL,  3,  0,  'Personas', 1),
           (7,  NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.PERS', 'Comisionistas',                  6, 2, FALSE, NULL,  4,  6,  'com.gmail.sanfrancisco.view.comisionista.ComisionistaView', 1),
           (8,  NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.PERS', 'Consignatarios',                 7, 2, FALSE, NULL,  5,  6,  'com.gmail.sanfrancisco.view.consignatario.ConsignatarioView', 1),
           (9,  NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.PERS', 'Productores',                    8, 2, FALSE, NULL,  6,  6,  'com.gmail.sanfrancisco.view.productor.ProductorView', 1),

           (10, NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.PREF', 'Prefaena',                       9, 2, FALSE, NULL,  6,  0,  'Prefaena', 1),
           (11, NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.PREF', 'DTE',                           10, 2, FALSE, NULL,  7,  10,  'com.gmail.sanfrancisco.view.dte.DteView', 1),

           (12, NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.COSTO','Costos',                        11, 2, FALSE, NULL,  7,  0,  'Costos', 1),
           (13, NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.COSTO','Graseria',                      12, 2, FALSE, NULL,  8,  12, 'com.gmail.sanfrancisco.view.graseriaCosto.GraseriaCostoView', 1),
           (14, NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.COSTO','Vehiculo',                      13, 2, FALSE, NULL,  9,  12, 'com.gmail.sanfrancisco.view.vehiculocostoaCostoVehiculoView', 1),


           (90, NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.PARA', 'Parametros del Sistema',       900, 2, FALSE, NULL,  8,   0,  'Configuracion General del Sistema', 1),
           (91, NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.PARA', 'Parametros Generales',         901, 2, FALSE, NULL,  9,  90,  'com.gmail.cacho.backend.views.parametro.ParamView', 1),
           (96, NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.PARA', 'Usuarios',                     906, 2, FALSE, NULL, 10,  90, 'com.gmail.cacho.backend.views.UsuariosView', 1);


--        (93, NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.PARA', 'Roles',                        904, 2, FALSE, NULL,10, 90, 'ar.com.sciolar.siddire.view.roles.RolView', 1),
--        (95, NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', 'MENU.PARA', 'Tipos Afip',                   906, 2, FALSE, NULL,12, 90, 'ar.com.sciolar.siddire.view.roles.NoView', 1),

