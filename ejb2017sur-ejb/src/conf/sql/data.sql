
INSERT INTO mysql.usuario (id, ciudad, `comunidadAutonoma`, email, nombre, pais, password, provincia, `recibirNotifiaciones`, rol) VALUES (0, 'Málaga', 'Andalucía', 'admin@diariosur.com', 'admin', 'España', 'admin', 'Málaga', true, 'PERIODISTA');

INSERT INTO mysql.sitio (id, ciudad, `comunidadAutonoma`, descripcion, direccion, foto, nombre, pais, provincia, url, creador_id, validador_id) VALUES (1, 'Málaga', 'Andalucía', 'Estadio en el que normalmente juega sus partidos el Unicaja Baloncesto.', 'Calle Miguel de Merida Nicolich, 2, 29004 Málaga', 'http://www.andalucia.org/media/fotos/image_181073_jpeg_800x600_q85.jpg', 'Palacio de Deportes José María Martín Carpena', 'España', 'Málaga', '', 0, 0)

INSERT INTO mysql.sitio (id, ciudad, `comunidadAutonoma`, descripcion, direccion, foto, nombre, pais, provincia, url, creador_id, validador_id) VALUES (2, 'Málaga', 'Andalucía', 'Centro cultural que realiza numerosas actividades.', 'Av. de los Guindos, 48, 29004 Málaga', 'http://sobremalaga.com/wp-content/uploads/2010/02/centro-civico-malaga.jpg', 'Centro Cívico La Térmica Málaga', 'España', 'Málaga', 'http://www.latermicamalaga.com/', 0, 0)

INSERT INTO mysql.sitio (id, ciudad, `comunidadAutonoma`, descripcion, direccion, foto, nombre, pais, provincia, url, creador_id, validador_id) VALUES (3, 'Málaga', 'Andalucía', 'Espacio para el entretenimiento.', ' Av. de los Guindos, 19, 29004 Málaga', 'http://www.plandegira.com/media/files/1/1/pictures/la_cochera_cabaret.600x338.jpg', 'La Cochera Cabaret', 'España', 'Málaga', 'https://lacocheracabaret.com/', 0, 0)

INSERT INTO mysql.sitio (id, ciudad, `comunidadAutonoma`, descripcion, direccion, foto, nombre, pais, provincia, url, creador_id, validador_id) VALUES (4, 'Málaga', 'Andalucía', 'El cine Albéniz es una sala de cine situada en la calle Alcazabilla de la ciudad española de Málaga.', 'Calle Alcazabilla, 4, 29015 Málaga', 'http://static.hellofriki.com/wp-content/uploads/images/espacio_albeniz.jpg', 'Cine Albéniz', 'España', 'Málaga', 'www.cinealbeniz.com', 0, NULL)

INSERT INTO mysql.evento (id, descripcion, foto, nombre, prioridad, tag, video, creador_id, localizacion_id, validador_id) VALUES (5, 'VIENE RAPHAEL', 'http://www.malagadeporteyeventos.com/images/stories/proximamente/2017/raphael-concierto.jpg', 'Concierto de Raphael', 8, 'Música', NULL, 0, 1, 0)

INSERT INTO mysql.evento (id, descripcion, foto, nombre, prioridad, tag, video, creador_id, localizacion_id, validador_id) VALUES (6, 'PARTIDASO', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b4/Unicaja_Real_Madrid_2011.jpg/300px-Unicaja_Real_Madrid_2011.jpg', 'Partido Unicaja vs Real Madrid', 5, 'Deporte', NULL, 0, 1, 0)

INSERT INTO mysql.evento (id, descripcion, foto, nombre, prioridad, tag, video, creador_id, localizacion_id, validador_id) VALUES (7, 'Monólogos', 'http://malaga.carpediem.cd/data/afisha/o/03/a2/03a2a43af0.jpg', 'Miguel Noguera en la Cochera', 2, 'Comedia', NULL, 0, 4, 0)

INSERT INTO mysql.sesion (id, `fechaFin`, `fechaInicio`, precio, `urlCompraEntrada`, `eventoCelebrado_id`) VALUES (8, '2017-06-16 23:30:00.0', '2017-06-16 22:00:00.0', 12.0, 'https://entradas.lacocheracabaret.com/index.php', 7)

INSERT INTO mysql.sesion (id, `fechaFin`, `fechaInicio`, precio, `urlCompraEntrada`, `eventoCelebrado_id`) VALUES (9, '2017-06-27 22:00:00.0', '2017-06-27 22:00:00.0', 12.0, 'https://entradas.lacocheracabaret.com/index.php', 7)

INSERT INTO mysql.sesion (id, `fechaFin`, `fechaInicio`, precio, `urlCompraEntrada`, `eventoCelebrado_id`) VALUES (10, '2017-06-04 22:00:00.0', '2017-06-04 18:30:00.0', 29.99, 'https://www.unicajabaloncesto.com/entradas/listado', 6)


COMMIT;