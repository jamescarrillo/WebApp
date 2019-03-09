--NUEVOS CONTENIDOS WEB
INSERT INTO administracion.sub_modulo(
            sumo_id, sumo_nombre, sumo_url, modu_id, sumo_estado, etiq_id)
    VALUES (201, 'DESTACADOS', './WebContent?action=Destacados', 3, TRUE, 5);

INSERT INTO administracion.sub_modulo(
            sumo_id, sumo_nombre, sumo_url, modu_id, sumo_estado, etiq_id)
    VALUES (202, 'OBRAS Y PROYECTOS', './WebContent?action=Obras', 3, TRUE, 5);

INSERT INTO administracion.sub_modulo(
            sumo_id, sumo_nombre, sumo_url, modu_id, sumo_estado, etiq_id)
    VALUES (203, 'ESTUDIOS', './WebContent?action=Estudios', 3, TRUE, 5);
    
INSERT INTO administracion.sub_modulo(
            sumo_id, sumo_nombre, sumo_url, modu_id, sumo_estado, etiq_id)
    VALUES (204, 'EVENTOS', './WebContent?action=Eventos', 3, TRUE, 5);

-- DESTACADOS
CREATE TABLE web.destacado
(
   id integer NOT NULL, 
   anho character varying(4) NOT NULL, 
   titulo character varying(200) NOT NULL, 
   contenido text, 
   fecha date NOT NULL, 
   foto text NOT NULL, 
   estado boolean NOT NULL, 
   url text NOT NULL, 
   creado_por integer NOT NULL, 
   fecha_creado timestamp without time zone NOT NULL, 
   editado_por integer, 
   fecha_editado timestamp without time zone, 
   PRIMARY KEY (id)
) 
WITH (
  OIDS = FALSE
)
;


-- PENDIENTE
CREATE TABLE web.linea_accion
(
   id integer NOT NULL, 
   descripcion character varying(300) NOT NULL, 
   estado boolean NOT NULL, 
   PRIMARY KEY (id)
); 

CREATE TABLE web.evento
(
  id integer NOT NULL,
  anho character varying(4) NOT NULL,
  titulo character varying(200) NOT NULL,  
  fecha date NOT NULL,
  foto text NOT NULL,
  estado boolean NOT NULL,  
  creado_por integer NOT NULL,
  fecha_creado timestamp without time zone NOT NULL,
  editado_por integer,
  fecha_editado timestamp without time zone,
  CONSTRAINT evento_pkey PRIMARY KEY (id)
);

INSERT INTO web.linea_accion(id, descripcion, estado)    VALUES (1, 'Dirección de Infraestructura', true);
INSERT INTO web.linea_accion(id, descripcion, estado)    VALUES (2, 'Dirección de Manejo Ambiental', true);
INSERT INTO web.linea_accion(id, descripcion, estado)    VALUES (3, 'Dirección de Desarrollo Agropecuario', true);
INSERT INTO web.linea_accion(id, descripcion, estado)    VALUES (4, 'Area de Estudios', true);



CREATE TABLE web.estudio
(
   id integer NOT NULL, 
   titulo character varying(300) NOT NULL, 
   snip character varying(150), 
   objetivo text, 
   cantidad_beneficiarios integer, 
   caracteristicas_beneficiarios text, 
   foto character varying(300), 
   lugar character varying(300), 
   mapa character varying(300), 
   seguimiento character varying(150), 
   estado boolean NOT NULL, 
   creado_por integer, 
   fecha_creado timestamp without time zone, 
   editado_por integer, 
   fecha_editado timestamp without time zone, 
   anho character varying(4) NOT NULL,
   fecha date NOT NULL,
   PRIMARY KEY (id)
);

CREATE TABLE web.obra
(
   id integer NOT NULL, 
   anho character varying(4) NOT NULL, 
   mes character varying(2) NOT NULL, 
   estado boolean NOT NULL, 
   creado_por integer NOT NULL, 
   fecha_creado timestamp without time zone NOT NULL, 
   editado_por integer NOT NULL, 
   fecha_editado timestamp without time zone NOT NULL, 
   descripcion text NOT NULL, 
   monto_inversion numeric(30,10) NOT NULL, 
   monto_gastado numeric(30,10) NOT NULL, 
   tiempo_ejecucion integer NOT NULL, 
   modalidad_ejecucion character varying(150) NOT NULL, 
   fecha_inicio date NOT NULL, 
   fecha_fin date NOT NULL, 
   seguimiento character varying(50) NOT NULL, 
   ubicacion character varying(150) NOT NULL, 
   contratista character varying(300), 
   supervisor character varying(300), 
   residente character varying(300), 
   avance_fisico numeric(7,3), 
   PRIMARY KEY (id)
);
ALTER TABLE web.evento
  ADD COLUMN area integer NOT NULL;
ALTER TABLE web.evento
  ADD FOREIGN KEY (area) REFERENCES web.linea_accion (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE web.obra
  ADD COLUMN area integer NOT NULL;
ALTER TABLE web.obra
  ADD FOREIGN KEY (area) REFERENCES web.linea_accion (id) ON UPDATE NO ACTION ON DELETE NO ACTION;


ALTER TABLE web.obra
  ADD COLUMN galeria character varying(150) NOT NULL;


ALTER TABLE web.estudio
   ALTER COLUMN mapa TYPE text;


ALTER TABLE web.obra
  ADD COLUMN foto text;


