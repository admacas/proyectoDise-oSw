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
	iduser serial not null unique;
	username varchar(50) not null unique;
	
);