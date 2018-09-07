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
	primary key(idempleado),
	foreign key (idpersona) references personas(cedula),
	foreign key (iduser) references usuarios(iduser),
	foreign key (idlocal) references locales(idlocal)
);
insert into empleados(idpersona,iduser,idlocal) values('0968197691',1,null);
insert into empleados(idpersona,iduser,idlocal) values('0989741230',2,1);
insert into empleados(idpersona,iduser,idlocal) values('0620365489',3,1);
insert into empleados(idpersona,iduser,idlocal) values('0603589744',4,1);
create table productos(
	idproducto serial not null,
	nombre varchar(50) not null,
	marca varchar(50) not null,
	modelo varchar(50) not null,
	descripcion varchar(300) not null,
	precio float not null,
	estado int default 1,
	primary key(idproducto)
);
insert into productos(nombre,marca,modelo,descripcion,precio) values ('Cocina Induccion','Indurama','ANDALUCIA','24", 4 INDUCTORES, 4 BOOSTERS
POTENCIA TOTAL:8240 W
HORNO ELÉCTRICO RESISTENCIA SUELO: 1400 W
RESISTENCIA GRILL: 1200W
VOLTAJE: 220
CABLE: TRIPOLAR TIPO INEMA 10-50P',180.99);
insert into productos(nombre,marca,modelo,descripcion,precio) values ('Cocina Induccion','Indurama','PRAGA','24", 4 INDUCTORES, 4 BOOSTERS
POTENCIA TOTAL:8240 W
HORNO ELÉCTRICO RESISTENCIA SUELO: 1400 W
RESISTENCIA GRILL: 1200W
VOLTAJE: 220 V
CABLE: TRIPOLAR TIPO INEMA 10-50P',192.88);
insert into productos(nombre,marca,modelo,descripcion,precio) values('Refrigeradora','Durex','Grafito','1 puerta escalonada 287 litros
																	Eficiencia energética categoría "A". 
Sistema de enfriamiento Twist Air.
Dispensador de 2 litros de capacidad.',480.30);
insert into productos(nombre,marca,modelo,descripcion,precio) values('Refrigeradora','Durex','Andina','2 puertas 250 litros Blanco.
																	Eficiencia energética categoría "A". 
Sistema de enfriamiento Twist Air.
Dispensador de agua.',688.99);
insert into productos(nombre,marca,modelo,descripcion,precio) values ('Lavadora','Mabe','Semiautomatica','7.5 kg Blanca.
																	 Semiautomática 2 tinas. 
Sistema de lavado a propela. 
Filtro atrapapelusas removible.
Canasta de prolipopileno.',240.99);
insert into productos(nombre,marca,modelo,descripcion,precio) values ('Lavadora Aqua Saver Green Automática','Mabe','Diamond Gray','24 kg 
																	 Tecnología Aqua Saver Green
Sistema de lavado por agitador.
Canasta Sphere Care de acero inoxidable.
Recuperación por corte de energía.
Grado ecológico.',520.55);
insert into productos(nombre,marca,modelo,descripcion,precio) values ('Lavadora Carga Frontal','Mabe','Diamond Gray Mabe','17 Kg Ciclo steam assist que remueve manchas difíciles y protege la ropa.
																	 Centrifugado rápido que minimiza el tiempo de secado.',588.33);

create table inventario(
	idinventario serial not null,
	idlocal int,
	idproducto int,
	cantidad int not null,
	primary key(idinventario),
	foreign key (idlocal) references locales(idlocal),
	foreign key (idproducto) references productos(idproducto)
);
insert into inventario(idlocal,idproducto,cantidad) values (1,1,50);
insert into inventario(idlocal,idproducto,cantidad) values (1,2,50);
insert into inventario(idlocal,idproducto,cantidad) values (1,3,50);
insert into inventario(idlocal,idproducto,cantidad) values (1,4,50);
insert into inventario(idlocal,idproducto,cantidad) values (1,5,50);
insert into inventario(idlocal,idproducto,cantidad) values (1,6,50);
insert into inventario(idlocal,idproducto,cantidad) values (1,7,50);
insert into inventario(idlocal,idproducto,cantidad) values (2,1,50);
insert into inventario(idlocal,idproducto,cantidad) values (2,2,50);
insert into inventario(idlocal,idproducto,cantidad) values (2,3,50);
insert into inventario(idlocal,idproducto,cantidad) values (2,4,50);
insert into inventario(idlocal,idproducto,cantidad) values (2,5,50);
insert into inventario(idlocal,idproducto,cantidad) values (2,6,50);
insert into inventario(idlocal,idproducto,cantidad) values (2,7,50);
insert into inventario(idlocal,idproducto,cantidad) values (3,1,50);
insert into inventario(idlocal,idproducto,cantidad) values (3,2,50);
insert into inventario(idlocal,idproducto,cantidad) values (3,3,50);
insert into inventario(idlocal,idproducto,cantidad) values (3,4,50);
insert into inventario(idlocal,idproducto,cantidad) values (3,5,50);
insert into inventario(idlocal,idproducto,cantidad) values (3,6,50);
insert into inventario(idlocal,idproducto,cantidad) values (3,7,50);
select * from inventario;

