INSERT INTO
conductor (
    id,         dni,          nombre,
    celular,    telefono,     operadoraTelefonica_id,
    usuario_id, cuil,         fechaalta,
    fechabaja,  fechaIngreso, fechaNacimiento,
    fechaumod,  usuarioalta,  usuarioumod,
    version)
VALUES    (
      1, '26792036', 'LUIS ALBERTO MULLEMBACH',
      '03743414053', '03743414053', (SELECT id from parametro where tipo=16 and orden=2), 3, '20267920363', '2018-08-28 11:05:19', null, '0001-01-01', '1978-09-19', '2008-01-01', 'Algo', 'Algo', 1);
INSERT INTO conductor (id, dni, nombre, celular, telefono, operadoraTelefonica_id, usuario_id, cuil, fechaalta, fechabaja, fechaIngreso, fechaNacimiento, fechaumod, usuarioalta, usuarioumod, version) VALUES (2, '24107511', 'HUGO WARKEN', '3743597102', '3743597102', (SELECT id from parametro where tipo=16 and orden=2), 1, '20241075118', '2018-08-29 08:02:26', null, '0001-01-01', '0001-01-01', '2008-01-01', 'Algo', 'Algo', 1);
INSERT INTO conductor (id, dni, nombre, celular, telefono, operadoraTelefonica_id, usuario_id, cuil, fechaalta, fechabaja, fechaIngreso, fechaNacimiento, fechaumod, usuarioalta, usuarioumod, version) VALUES (3, '27522639', 'EVARISTO SANTIAGO VILLAR', '3743489965', '3743170119', (SELECT id from parametro where tipo=16 and orden=2), 2, '20275226395', '2018-08-29 08:06:13', null, '2008-10-01', '1979-10-26', '2008-01-01', 'Algo', 'Algo', 1);
INSERT INTO conductor (id, dni, nombre, celular, telefono, operadoraTelefonica_id, usuario_id, cuil, fechaalta, fechabaja, fechaIngreso, fechaNacimiento, fechaumod, usuarioalta, usuarioumod, version) VALUES (4, '27522639', 'EVARISTO SANTIAGO VILLAR', '3743489965', '3743170119', (SELECT id from parametro where tipo=16 and orden=2), 2, '20275226395', '2018-08-29 08:06:16', '2018-08-29 08:21:58', '2008-10-01', '1979-10-26', '2008-01-01', 'Algo', 'Algo', 1);
INSERT INTO conductor (id, dni, nombre, celular, telefono, operadoraTelefonica_id, usuario_id, cuil, fechaalta, fechabaja, fechaIngreso, fechaNacimiento, fechaumod, usuarioalta, usuarioumod, version) VALUES (5, '29689309', 'CARLOS ALBERTO YACZESEN', '3756500414', '3756500414', (SELECT id from parametro where tipo=16 and orden=2), 3, '23296893099', '2018-08-29 08:16:00', null, '0001-01-01', '0001-01-01', '2008-01-01', 'Algo', 'Algo', 1);
INSERT INTO conductor (id, dni, nombre, celular, telefono, operadoraTelefonica_id, usuario_id, cuil, fechaalta, fechabaja, fechaIngreso, fechaNacimiento, fechaumod, usuarioalta, usuarioumod, version) VALUES (6, '31787614', 'MIGUEL ANGEL LOPEZ', '3758485813', '3758485786', (SELECT id from parametro where tipo=16 and orden=2), 3, '23317876149', '2018-08-29 08:18:32', null, '2018-05-23', '1985-09-20', '2018-08-30 08:01:30', 'Algo', 'Algo', 1);
INSERT INTO conductor (id, dni, nombre, celular, telefono, operadoraTelefonica_id, usuario_id, cuil, fechaalta, fechabaja, fechaIngreso, fechaNacimiento, fechaumod, usuarioalta, usuarioumod, version) VALUES (7, '0', 'OTROS CHOFERES TERCEROS', '0', '0', (SELECT id from parametro where tipo=16 and orden=1), 1, '0', '2018-09-21 11:39:52', null, '0001-01-01', '0001-01-01', '2008-01-01', 'Algo', 'Algo', 1);
