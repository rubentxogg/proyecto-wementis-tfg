DROP DATABASE IF EXISTS clinica_psicologia;
CREATE DATABASE clinica_psicologia;
USE clinica_psicologia;

CREATE TABLE paciente (
	id int auto_increment,
    nombre varchar(40),
    apellidos varchar(80),
    email varchar(40),
    telefono varchar(10),
    fecha_nacimiento date,
    genero char,
    fecha_creacion date,
    activo boolean,
    primary key (id)
);

CREATE TABLE psicologo (
	id int auto_increment,
    nombre varchar(40),
    apellidos varchar(80),
    email varchar(40),
    telefono varchar(10),
    fecha_creacion date,
    activo boolean,
    primary key (id)
);

CREATE TABLE tarifa (
	id int auto_increment,
    nombre varchar(40),
    precio_hora double,
    fecha_creacion date,
    activo boolean,
    primary key (id)
);

CREATE TABLE estado (
	id int auto_increment,
    nombre varchar(40),
    primary key (id)
);

INSERT INTO estado(nombre)
VALUES ('activa'),('completada'),('cancelada');

CREATE TABLE cita (
	id int auto_increment,
    id_paciente int,
    id_psicologo int,
    id_tarifa int,
    id_estado int,
    fecha date,
    hora time,
    cantidad_horas int,
    activo boolean,
    primary key (id),
    foreign key (id_paciente) references paciente(id),
    foreign key (id_psicologo) references psicologo(id),
    foreign key (id_tarifa) references tarifa(id),
    foreign key (id_estado) references estado(id)
);

CREATE TABLE ganancia (
	id int auto_increment,
    id_cita int,
    cantidad double,
    fecha_creacion date,
    primary key (id),
    foreign key (id_cita) references cita(id)
);

create table users(
    username varchar(50) not null primary key,
    password varchar(100) not null,
    enabled boolean not null
);

create table authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    constraint fk_authorities_users foreign key(username) references users(username)
);

create unique index ix_auth_username on authorities (username,authority);