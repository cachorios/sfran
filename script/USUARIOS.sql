
INSERT INTO roles (id, fechabaja, fechaumod, usuarioalta, usuarioumod, activo, descripcion, nombre, version)
VALUES
  (1, NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', TRUE, 'Rol para Administradores',     'ADMIN',     1),
  (2, NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', TRUE, 'Rol para Contadores',          'CHOFER',  1),
  (3, NULL, '2017-11-03', 'UNKNOW', 'UNKNOW', TRUE, 'Rol para Usuarios Gestores',   'USUARIO',    1);




INSERT INTO usuario
  ( id,  fechabaja,  fechaumod,    usuarioalta, usuarioumod,   email,                  nombre,             username, password,                                                                                                                        version, locked, role, photourl, salt )
VALUES
    (1,   NULL,       '2017-11-03', 'UNKNOW',   'UNKNOW',     'cacho@gmail.com.ar',  'Administrador',     'admin',  '0e9ada300f77e03d7fe9caffa17457d2f9c117032b4271f2c77283048c3499aec67539cbb7898e74033fbb79039baa2624fb93fc368944695a4d62bcceea5283', 1,      false, 'ADMIN', 'admin', '4384cd5236d2243752deee2c8395e7dc'),
    (2,   NULL,       '2017-11-03', 'UNKNOW',   'UNKNOW',     'beto@gmail.com.ar',  'Luis Antonio Rios',  'beto',   '23024b0a1c5bf4c5851931264c8a722b76797913dee4878b3f497c292c4cda09e1e72eac48b7a7ceab7f69ad078d57ef440a79c5bf75c32664d364790090a5c1', 1,      false,  'ADMIN', 'usuario', 'e746da6d0453d512aeab3f904d4e6cb5'),
    (3,   NULL,       '2017-11-03', 'UNKNOW',   'UNKNOW',     'dario@gmail.com.ar',  'Luis Antonio Rios',  'dario',  '23024b0a1c5bf4c5851931264c8a722b76797913dee4878b3f497c292c4cda09e1e72eac48b7a7ceab7f69ad078d57ef440a79c5bf75c32664d364790090a5c1', 1,      false,  'ADMIN', 'usuario', 'e746da6d0453d512aeab3f904d4e6cb5');




INSERT INTO usuario_roles (usuario, rol)
VALUES
  (1, 1),
  (2, 2),
  (3, 3);
