INSERT INTO licencia (id, conductor_id, licenciacarga, tipolicencia_id, vencimiento, vencimientocurso, vencimientonac, fechaalta, fechabaja, fechaumod, usuarioalta, usuarioumod, version) VALUES (1, 1, '1', (SELECT id from parametro where tipo=22 and orden=1), '2019-05-02 00:00:00', '2019-04-06 00:00:00', '2019-08-11 00:00:00', '2018-08-28 11:16:17', null, '2008-01-01', 'Algo', 'Algo', 1);
INSERT INTO licencia (id, conductor_id, licenciacarga, tipolicencia_id, vencimiento, vencimientocurso, vencimientonac, fechaalta, fechabaja, fechaumod, usuarioalta, usuarioumod, version) VALUES (2, 3, '1', (SELECT id from parametro where tipo=22 and orden=1), '2019-01-17 00:00:00', '2019-01-09 00:00:00', '2019-01-11 00:00:00', '2018-08-29 08:21:26', null, '2018-08-29 08:26:55', 'Algo', 'Algo', 1);
INSERT INTO licencia (id, conductor_id, licenciacarga, tipolicencia_id, vencimiento, vencimientocurso, vencimientonac, fechaalta, fechabaja, fechaumod, usuarioalta, usuarioumod, version) VALUES (3, 2, '1', (SELECT id from parametro where tipo=22 and orden=1), '2018-11-09 00:00:00', '2019-01-12 00:00:00', '2019-10-21 00:00:00', '2018-08-29 08:55:37', null, '2018-08-29 10:16:09', 'Algo', 'Algo', 1);
INSERT INTO licencia (id, conductor_id, licenciacarga, tipolicencia_id, vencimiento, vencimientocurso, vencimientonac, fechaalta, fechabaja, fechaumod, usuarioalta, usuarioumod, version) VALUES (4, 6, '1', (SELECT id from parametro where tipo=22 and orden=1), '2023-03-21 00:00:00', '2019-04-18 00:00:00', '2020-04-09 00:00:00', '2018-08-30 07:52:06', null, '2008-01-01', 'Algo', 'Algo', 1);
