create table roles(
	idrol serial not null unique,
	nombre varchar(50) not null unique,
	primary key(idrol)
);
insert into roles(nombre) values ('SuperAdministrador');
insert into roles(nombre) values ('Administrador');
insert into roles(nombre) values ('Gerente');
insert into roles(nombre) values ('Vendedor');
select * from roles;
create table usuarios(
	iduser serial not null unique,
	username varchar(50) not null unique,
	passwords varchar(50) not null unique,
	estado int default 1,
	idrol int,
	primary key(iduser),
	foreign key (idrol) references roles(idrol)
);
insert into usuarios(username,passwords,idrol) values ('admacas','dario2592',1);
insert into usuarios(username,passwords,idrol) values ('jkleon','leon1584',2);
insert into usuarios(username,passwords,idrol) values ('hgcastro','castro1234',3);
insert into usuarios(username,passwords,idrol) values ('fgsuarez','suarez7894',4);
select * from usuarios u join roles r on u.idrol=r.idrol;
create table personas(
	cedula varchar(20) not null unique,
	nombre varchar(25) not null,
	apellido varchar(25) not null,
	telefono varchar(25),
	email varchar(25),
	edad int check(edad >= 18),
	direccion varchar(250),
	primary key(cedula)
);
insert into personas(cedula,nombre,apellido,telefono,email,edad,direccion) values ('0968197691','Alex','Macas','0954789623','admacas@hotmail',24,'Isla Trinitaria');
insert into personas(cedula,nombre,apellido,telefono,email,edad,direccion) values ('0989741230','Jhonatan','Leon','0987963010','jkleon@hotmial',20,'Guasmo sur');
insert into personas(cedula,nombre,apellido,telefono,email,edad,direccion) values ('0620365489','Hernan','Castro','0925897410','hgcastro@hotmail',26,'Ceibos norte');
insert into personas(cedula,nombre,apellido,telefono,email,edad,direccion) values ('0603589744','Fernando','Suarez','1208963256','suarez@hotmail',21,'Florida norte');
create table locales(
	idlocal serial not null,
	nombre varchar(50) not null,
	telefono varchar(25) not null,
	direccion varchar(250) not null,
	primary key(idlocal)
);
insert into locales(nombre,telefono,direccion) values ('Local Norte','042894578','Guasmo Norte');
insert into locales(nombre,telefono,direccion) values ('Local Sur','042412356','Floresta');
insert into locales(nombre,telefono,direccion) values ('Local Centro','042365241','9 de Octubre');
create table empleados(
	idempleado serial not null,
	estado boolean default false,
	idpersona varchar(20),
	iduser int,
	idlocal int,
	foreign key (idpersona) references personas(cedula),
	foreign key (iduser) references usuarios(iduser),
	foreign key (idlocal) references locales(idlocal)
);
