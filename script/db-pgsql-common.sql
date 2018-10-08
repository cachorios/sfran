set statement_timeout = 0;
set lock_timeout = 0;
set idle_in_transaction_session_timeout = 0;
set client_encoding = 'utf8';
set standard_conforming_strings = on;
set check_function_bodies = false;
set client_min_messages = warning;
set row_security = off;
set search_path = public, pg_catalog;
set default_tablespace = '';
set default_with_oids = false;

-------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------
-- tablas, pks, uniques, indices
-------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------

-------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------
-- comunes
-------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------

-------------------------------------------------------------------------------------
-- openjpa_sequences_table
-------------------------------------------------------------------------------------
create table openjpa_sequences_table (
    id             character varying(255) not null,
    sequence_value bigint                 not null
);
alter table openjpa_sequences_table owner to postgres;
alter table openjpa_sequences_table add constraint pk_openjpa_sequences_table primary key (id);

-------------------------------------------------------------------------------------
-- parametro
-------------------------------------------------------------------------------------
create table parametro (
    id          bigint                 not null,
    --------------- auditoria --------------------
    fechabaja   timestamp,
    fechaalta   timestamp default now(),
    fechaumod   timestamp default now(),
    usuarioalta character varying(255),
    usuarioumod character varying(255),
    version     integer                not null,
    --------------- propios ----------------------
    clase       character varying(255) not null,
    nombre      character varying(255) not null,
    orden       integer                not null,
    tipo        smallint default 0     not null,
    valorbol    boolean default false,
    valordat    timestamp,
    valordob    double precision,
    valorint    bigint,
    valorstr    character varying(255),
    valorchr    char
);
alter table parametro owner to postgres;
alter table parametro add constraint pk_parametro primary key (id);
alter table parametro add constraint uk_parametro_tipoorden unique (tipo, orden);
alter table parametro add constraint uk_parametro_clasenombre unique (clase, nombre);
create index ix_parametro_tipoorden on parametro using btree (tipo, orden);
create index ix_parametro_clasenmbre on parametro using btree (clase, nombre);

-------------------------------------------------------------------------------------
-- permisos
-------------------------------------------------------------------------------------	
create table permisos (
    id          bigint             not null,
    --------------- auditoria --------------------
    fechabaja   timestamp,
    fechaalta   timestamp default now(),
    fechaumod   timestamp default now(),
    usuarioalta character varying(255),
    usuarioumod character varying(255),
    version     integer            not null,
    --------------- propios ----------------------
    permiso     smallint default 0 not null,
    recurso     bigint             not null
);
alter table permisos owner to postgres;
alter table permisos add constraint pk_permisos primary key (id);
alter table permisos add constraint uk_permisos_recper unique (recurso, permiso);
create index ix_permisos_recurso on permisos using btree (recurso, permiso);

-------------------------------------------------------------------------------------
-- roles
-------------------------------------------------------------------------------------
create table roles (
    id          bigint                 not null,
    --------------- auditoria --------------------
    fechabaja   timestamp,
    fechaalta   timestamp default now(),
    fechaumod   timestamp default now(),
    usuarioalta character varying(255),
    usuarioumod character varying(255),
    version     integer                not null,
    --------------- propios ----------------------
    activo      boolean default true   not null,
    nombre      character varying(255) not null,
    descripcion character varying(255)
);
alter table roles owner to postgres;
alter table roles add constraint pk_roles primary key (id);
alter table roles add constraint uk_roles_nombre unique (nombre);
create index ix_roles_nombre on roles using btree (nombre);

-------------------------------------------------------------------------------------
-- roles_permisos
-------------------------------------------------------------------------------------
create table roles_permisos (
    rol     bigint,
    permiso bigint
);
alter table roles_permisos owner to postgres;
alter table roles_permisos add constraint uk_roles_permisos unique (rol, permiso);
create index ix_roles_permisos_perm on roles_permisos using btree (permiso);
create index ix_roles_permisos_rol on roles_permisos using btree (rol);

-------------------------------------------------------------------------------------
-- roles_roles
-------------------------------------------------------------------------------------
create table roles_roles (
    rol_padre bigint,
    rol_hijo  bigint
);
alter table roles_roles owner to postgres;
alter table roles_roles add constraint uk_roles_roles unique (rol_padre, rol_hijo);
create index ix_roles_roles_hijo on roles_roles using btree (rol_hijo);
create index ix_roles_roles_padre on roles_roles using btree (rol_padre);

-------------------------------------------------------------------------------------
-- usuario
-------------------------------------------------------------------------------------	
create table usuario (
    id          bigint                 not null,
    --------------- auditoria --------------------
    fechabaja   timestamp,
    fechaalta   timestamp default now(),
    fechaumod   timestamp default now(),
    usuarioalta character varying(255),
    usuarioumod character varying(255),
    version     integer                not null,
    --------------- propios ----------------------
    nombre      character varying(255) not null,
    password    character varying(1024) not null,
    username    character varying(255) not null,
    email       character varying(255),
    salt        character varying(1024),
    role        character varying(255),
    photoUrl    character varying(1024),
    locked      boolean default false not null,
    tipomenu    smallint default 0 not null

);
alter table usuario owner to postgres;
alter table usuario add constraint pk_usuario primary key (id);
alter table usuario add constraint uk_usuario_username unique (username);
alter table usuario add constraint uk_usuario_email unique (email);
create index ix_usuario_username on usuario using btree (username);

-------------------------------------------------------------------------------------
-- usuario_roles
-------------------------------------------------------------------------------------	
create table usuario_roles (
    usuario bigint,
    rol     bigint
);
alter table usuario_roles owner to postgres;
alter table usuario_roles add constraint uk_usuario_roles unique (usuario, rol);
create index ix_usuario_roles_rol on usuario_roles using btree (rol);
create index ix_usuario_roles_usr on usuario_roles using btree (usuario);


-------------------------------------------------------------------------------------
-- afip
-------------------------------------------------------------------------------------
create table afip (
    id bigint not null,
    --------------- auditoria --------------------
    fechabaja   timestamp,
    fechaalta   timestamp default now(),
    fechaumod   timestamp default now(),
    usuarioalta character varying(255),
    usuarioumod character varying(255),
    version integer not null,
    --------------- propios ----------------------
    codigo character varying(255) not null,
    nombre character varying(255) not null,
    valoriva double precision default 0.00 not null,
    aplicaiva boolean default true not null,
    discriminaiva boolean default true not null,
    --------------- migracion --------------------
    idorigen  bigint,
    tagorigen character varying(512)
);
alter table afip owner to postgres;
alter table afip add constraint pk_afip primary key (id);
alter table afip add constraint uk_afip_codigo unique (codigo);


-------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------
-- foreing keys
-------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------

-------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------
-- comunes
-------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------
alter table permisos add constraint fk_permisos_recurso foreign key (recurso) references parametro (id);

alter table roles_permisos add constraint fk_roles_permisos_permiso foreign key (permiso) references permisos (id);
alter table roles_permisos add constraint fk_roles_permisos_rol foreign key (rol) references roles (id);

alter table roles_roles add constraint fk_roles_roles_hijo foreign key (rol_hijo) references roles (id);
alter table roles_roles add constraint fk_roles_roles_padre foreign key (rol_padre) references roles (id);

alter table usuario_roles add constraint fk_usuario_roles_rol foreign key (rol) references roles (id);
alter table usuario_roles add constraint fk_usuario_roles_usuario foreign key (usuario) references usuario (id);
