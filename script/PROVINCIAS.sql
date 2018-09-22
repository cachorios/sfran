/*
select ((ROW_NUMBER() OVER(ORDER BY ProvinciaId ASC))+400)       id,
       '"UNKNOW"'                                                usuarioalta,
       '"UNKNOW"'                                                usuarioumod,
       '"PROVINCIA"'                                             clase,
       '"'+replace(ProvinciaDesc, '.............', '')+'"'       nombre,
       ProvinciaId                                               orden,
       9                                                         tipo,
       1                                                         version
  from Provincias
 order by ProvinciaId
*/

--------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------
-- VALORES A TENER EN CUENTA:                                                                         --
-- orden: es el id origen                                                                             --
--------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------
INSERT INTO parametro (id, usuarioalta, usuarioumod, clase, nombre, orden, tipo, version)
VALUES (401, 'UNKNOW', 'UNKNOW', 'PROVINCIA', 'BUENOS AIRES', 1, 9, 1), 
       (402, 'UNKNOW', 'UNKNOW', 'PROVINCIA', 'CAPITAL FEDERAL', 2, 9, 1), 
       (403, 'UNKNOW', 'UNKNOW', 'PROVINCIA', 'MISIONES', 3, 9, 1), 
       (404, 'UNKNOW', 'UNKNOW', 'PROVINCIA', 'CORRIENTES', 4, 9, 1), 
       (405, 'UNKNOW', 'UNKNOW', 'PROVINCIA', 'ENTRE RIOS', 5, 9, 1), 
       (406, 'UNKNOW', 'UNKNOW', 'PROVINCIA', 'FORMOSA', 6, 9, 1), 
       (407, 'UNKNOW', 'UNKNOW', 'PROVINCIA', 'JUJUY', 7, 9, 1), 
       (408, 'UNKNOW', 'UNKNOW', 'PROVINCIA', 'SALTA', 8, 9, 1), 
       (409, 'UNKNOW', 'UNKNOW', 'PROVINCIA', 'SANTIAGO DEL ESTERO', 9, 9, 1), 
       (410, 'UNKNOW', 'UNKNOW', 'PROVINCIA', 'CHACO', 10, 9, 1), 
       (411, 'UNKNOW', 'UNKNOW', 'PROVINCIA', 'LA RIOJA', 11, 9, 1), 
       (412, 'UNKNOW', 'UNKNOW', 'PROVINCIA', 'CATAMARCA', 12, 9, 1), 
       (413, 'UNKNOW', 'UNKNOW', 'PROVINCIA', 'TUCUMAN', 13, 9, 1), 
       (414, 'UNKNOW', 'UNKNOW', 'PROVINCIA', 'CORDOBA', 14, 9, 1), 
       (415, 'UNKNOW', 'UNKNOW', 'PROVINCIA', 'SANTA FE', 15, 9, 1), 
       (416, 'UNKNOW', 'UNKNOW', 'PROVINCIA', 'SAN JUAN', 16, 9, 1), 
       (417, 'UNKNOW', 'UNKNOW', 'PROVINCIA', 'MENDOZA', 17, 9, 1), 
       (418, 'UNKNOW', 'UNKNOW', 'PROVINCIA', 'SAN LUIS', 18, 9, 1), 
       (419, 'UNKNOW', 'UNKNOW', 'PROVINCIA', 'LA PAMPA', 19, 9, 1), 
       (420, 'UNKNOW', 'UNKNOW', 'PROVINCIA', 'NEUQUEN', 20, 9, 1), 
       (421, 'UNKNOW', 'UNKNOW', 'PROVINCIA', 'RIO NEGRO', 21, 9, 1), 
       (422, 'UNKNOW', 'UNKNOW', 'PROVINCIA', 'CHUBUT', 22, 9, 1), 
       (423, 'UNKNOW', 'UNKNOW', 'PROVINCIA', 'SANTA CRUZ', 23, 9, 1), 
       (424, 'UNKNOW', 'UNKNOW', 'PROVINCIA', 'TIERRA DEL FUEGO', 24, 9, 1);

