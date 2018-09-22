INSERT INTO afip (id, fechabaja, fechaalta, fechaumod, usuarioalta, usuarioumod, version, nombre, codigo, valoriva, aplicaiva, discriminaiva, idorigen)
VALUES (1,  NULL, now(), now(), 'UNKNOW', 'UNKNOW', 1, 'RESPONSABLE INSCRIPTO', 'RI', 21, true, true , 1),
       (3,  NULL, now(), now(), 'UNKNOW', 'UNKNOW', 1, 'MONOTRIBUTISTA'       , 'MO', 21, true, false, 3),
       (5,  NULL, now(), now(), 'UNKNOW', 'UNKNOW', 1, 'EXENTO'               , 'EX', 21, true, false, 5),
       (7,  NULL, now(), now(), 'UNKNOW', 'UNKNOW', 1, 'NO CATEGORIZADO'      , 'NC', 21, true, true , 7),
       (9,  NULL, now(), now(), 'UNKNOW', 'UNKNOW', 1, 'CONSUMIDOR FINAL'     , 'CF', 21, true, false, 9),
       (10, NULL, now(), now(), 'UNKNOW', 'UNKNOW', 1, 'CLIENTE INTERNO'      , 'CI', 21, true, false, 10);