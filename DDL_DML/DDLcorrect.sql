create table USUARIO(
	USUA_cedula varchar(15) not null,
	USUA_clave varchar(128) not null,
	USUA_nombre varchar(30),
	USUA_apellido varchar(30),
	USUA_correo varchar(255) not null,
	primary key(USUA_cedula)
);

create table CIUDAD(
	CIUD_id integer not null,
	CIUD_nombre varchar(250) not null,
	CIUD_latitud varchar(20),
	CIUD_longitud varchar(20),
	primary key(CIUD_id)
);

begin transaction;
	insert into CIUDAD values
	('0','ninguna','0','0'),
	('1','Bogota','4.25','-74.1833333'),
	('2','Medellín','6.2913889','-75.5361111'),
	('3','Cali','3.4166667','-76.55'),
	('4','Barranquilla','11.0','-74.8'),
	('5','Cartagena','10.3997222','-75.5144444'),
	('6','Cúcuta','8.5','-72.6666667'),
	('7','Ibagué','4.5','-75.25'),
	('8','Soledad','10.9166667','-74.75'),
	('9','Bucaramanga','7.2166667','-73.0833333'),
	('10','Soacha','4.5833333','-74.25'),
	('11','Santa Marta','11.0833333','-73.9166667'),
	('12','Pereira','4.8333333','-75.75'),
	('13','Villavicencio','4.15','-73.6166667'),
	('14','Bello','6.5166667','-75.5863889'),
	('15','Valledupar','10.4166667','-73.5833333'),
	('16','Pasto','1.1666667','-77.1666667'),
	('17','Montería','8.6666667','-76.0'),
	('18','Manizales','5.0833333','-75.5'),
	('19','Buenaventura','3.5833333','-77.0'),
	('20','Neiva','3.0833333','-75.3333333'),
	('21','Palmira','3.5833333','-76.25'),
	('22','Armenia','4.5','-75.7'),
	('23','Popayán','2.5','-76.5833333'),
	('24','Sincelejo','9.3','-75.4166667'),
	('25','Floridablanca','7.1333333','-73.05'),
	('26','Itagüí','6.2','-75.6'),
	('27','Riohacha','11.1666667','-73.0833333'),
	('28','Envigado','6.1666667','-75.5833333'),
	('29','Tuluá','4.0833333','-76.0'),
	('30','Dosquebradas','5.73','-74.3433333'),
	('31','Barrancabermeja','7.1666667','-73.75'),
	('32','Tumaco','1.8333333','-78.5');	
	commit;


create table ORIGEN(
	ORIG_id integer not null,
	ORIG_CIUD_id integer not null references CIUDAD(CIUD_id),
	primary key(ORIG_id)
);

create table DESTINO(
	DEST_id integer not null,
	DEST_CIUD_id integer not null references CIUDAD(CIUD_id),
	primary key(DEST_id)
);



create table ESCALA(
	ESCA_id integer not null,
	ESCA_CIUD_id integer not null references CIUDAD(CIUD_id),
	primary key(ESCA_id)
);



create table RUTA(
	RUTA_id integer not null,
	RUTA_ORIG_id integer not null references ORIGEN(ORIG_id),
	RUTA_DEST_id integer not null references DESTINO(DEST_id),
	RUTA_ESCA_id integer not null references ESCALA(ESCA_id),
	primary key(RUTA_id)
);


create table HORARIO(
	HORA_id integer not null,
	HORA_horario varchar(10) not null,
	primary key(HORA_id)
);

create table AEROLINEA(
	AEROL_id integer not null,
	AEROL_nombre varchar(250),
	AEROL_direccion varchar(250),
	AEROL_telefono varchar(20),
	AEROL_tarifa real,
	primary key(AEROL_id)
);

create table AEROLINEA_HORARIO(
	/*AEHO_id integer not null,*/
	AEHO_AEROL_id integer not null references AEROLINEA(AEROL_id),
	AEHO_HORA_id integer not null references HORARIO(HORA_id),
	primary key(AEHO_AEROL_id,AEHO_HORA_id)
);

/*
create table TARIFA(
	TARI_id integer not null,
	TARI_precio real,
	TARI_dia varchar(20),	
	TARI_AEROL_id integer not null references AEROLINEA(AEROL_id),
	primary key(TARI_id)
);*/

create table VUELO(
	VUEL_id  SERIAL,
	VUEL_precio real,
	VUEL_AEROL_id integer not null references AEROLINEA(AEROL_id),
	VUEL_RUTA_id integer not null references RUTA(RUTA_id),
	VUEL_fecha date,	
	VUEL_hora time,
	primary key(VUEL_id)
);

/*ALTER TABLE VUELO ADD PRIMARY KEY (VUEL_id);*/
/*alter table vuelo add VUEL_MES_id int not null references MES(MES_id) default 'desconocido';*/
/*alter table vuelo add VUEL_ANIO_id int not null references ANIO(ANIO_id) default  '2013';*/
/*update vuelo set VUEL_MES_id='11' where VUEL_MES_id='desconocido's*/

/*alter table aerolinea add AERO_TARI_id int not null references TARIFA(TARI_id) default '0'*/
/*alter table vuelo drop column VUEL_JORN_id;*/

create table AEROPUERTO(
	AEROP_id integer not null,
	AEROP_CIUD_id integer not null references CIUDAD(CIUD_id),
	AEROP_nombre varchar(250),
	AEROP_direccion varchar(250),
	primary key(AEROP_id)
);

create table AERPUERTO_AEROLIENEA(
	APAL_AEROL_id integer not null references AEROLINEA(AEROL_id),
	APAL_AEROP_id integer not null references AEROPUERTO(AEROP_id),
	primary key(APAL_AEROL_id,APAL_AEROP_id)
);

/*un vuelo tiene muchos usuarios, un usuarios perteneces a un uchos vuelos PERO  no al mismo tiempo.*/
create table VUELO_USUARIO(
	VUUS_USUA_cedula varchar(15) not null references USUARIO(USUA_cedula),
	VUUS_VUEl_id integer not null references VUELO(VUEL_id),
	VUUS_is_reserva boolean,
	VUUS_fecha date,
	VUUS_hora time,
	primary key(VUUS_USUA_cedula,VUUS_VUEl_id)
);


