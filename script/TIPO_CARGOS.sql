------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------
-- VALORES A TENER EN CUENTA:                                                                                         --
-- valorbol: define como se entiende el valor (valordob):  Si es true=valor fijo ; false=porcentaje                   --
-- valorint: define a que se aplica el cargo: 0=por factura ; 1=por titulo ; 2=por unidad ; 3=por dia ; 4=por entrega --
-- valordob: el valor que se entiende segun el tipo (valorbool)                                                       --
------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------
INSERT INTO parametro (id, usuarioalta, usuarioumod, clase, nombre, orden, tipo, version, valorbol, valordob, valorint)
VALUES (751, 'UNKNOW', 'UNKNOW', 'TIPO_CARGO', 'ADMINISTRATIVO', 1, 13, 1, false, .8, 1),
       (752, 'UNKNOW', 'UNKNOW', 'TIPO_CARGO', 'RECORRIDO', 2, 13, 1, true, 3.0, 4),
       (753, 'UNKNOW', 'UNKNOW', 'TIPO_CARGO', 'SINDICATO', 3, 13, 1, false, 3.0, 0),
       (754, 'UNKNOW', 'UNKNOW', 'TIPO_CARGO', 'MANIPULEO Y DISTRIBUCION', 4, 13, 1, false, 3.0, 4),
       (755, 'UNKNOW', 'UNKNOW', 'TIPO_CARGO', 'ENTREGA', 5, 13, 1, false, 3.0, 2),
       (756, 'UNKNOW', 'UNKNOW', 'TIPO_CARGO', 'COSTO FIJO POR DIA', 6, 13, 1, true, 3.0, 3),
       (757, 'UNKNOW', 'UNKNOW', 'TIPO_CARGO', 'COMISION', 7, 13, 1, false, 3.0, 0),
       (758, 'UNKNOW', 'UNKNOW', 'TIPO_CARGO', 'CARGO GENERAL', 8, 13, 1, false, 3.0, 0);

