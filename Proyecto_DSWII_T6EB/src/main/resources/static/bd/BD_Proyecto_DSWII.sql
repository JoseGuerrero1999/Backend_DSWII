DROP DATABASE IF EXISTS BD_PROYECTO_DSWII; 
CREATE DATABASE BD_PROYECTO_DSWII;
USE BD_PROYECTO_DSWII;

drop table if exists tb_proveedor;
create table tb_proveedor
(
cod_proveedor int,
des_proveedor varchar(60),
primary key (cod_proveedor)
);


drop table if exists tb_tipousuario;
create table tb_tipousuario
(
cod_tipousu int,
des_tipousu varchar(60),
primary key (cod_tipousu)
);

drop table if exists tb_especialidad;
create table tb_especialidad
(
cod_especialidad int,
des_especialidad  varchar(60),
primary key (cod_especialidad)
);


drop table if exists tb_medicos;
create table tb_medicos
(
cod_medic int auto_increment,
nombre_medic varchar(100),
apellido_medic varchar(100),
telefono_medic char(11),
correo_medic varchar(100),
fechacontrini_medic date,
fechacontrfin_medic date,
cod_especialidad int,
primary key (cod_medic),
UNIQUE KEY correo_medic (cod_medic),
constraint fk_medico_especialidad foreign key (cod_especialidad) references tb_especialidad(cod_especialidad)
);

drop table if exists tb_usuario;
create table tb_usuario
(
cod_usu int auto_increment,
nombre_susu varchar(100),
apellido_usu varchar(100),
fechanaci_usu date,
login_usu varchar(100),
password_usu varchar(100),
cod_tipousu int,
primary key (cod_usu),
UNIQUE KEY login_usu (cod_usu),
constraint fk_usuario_tipousuario foreign key (cod_tipousu) references tb_tipousuario(cod_tipousu)
);

drop table if exists tb_clientes;
create table tb_clientes
(
cod_cliente int auto_increment,
nombre_cliente varchar (100),
apellid_cliente varchar (100),
direccion_cliente varchar (100),
dni_cliente char(8),
fechaNacimiento_cliente date ,
malestar_cliente varchar(500),
cod_especialidad int,
cod_usu int,
primary key (cod_cliente),
constraint fk_cliente_especialidad foreign key (cod_especialidad) references tb_especialidad(cod_especialidad),
constraint fk_clientes_usuarios foreign key (cod_usu) references tb_usuario(cod_usu)
);

drop table if exists tb_medicamentos;
create table tb_medicamentos(
cod_medicamentos int auto_increment,
nombre_medicamento varchar (100),
fechavencimiento_medicamento date,
precio_medicamento decimal,
cod_proveedor int ,
cod_medic int,
primary key (cod_medicamentos),
constraint fk_medicamentos_proveedor foreign key (cod_proveedor) references tb_proveedor(cod_proveedor),
constraint fk_medicamentos_medico foreign key (cod_medic) references tb_medicos(cod_medic)
);

/*********************************************  INSERT ********************************************************/

/*********************************************  tb_proveedor ********************************************************/
INSERT INTO tb_proveedor VALUES (1, 'Peru Farma');
INSERT INTO tb_proveedor VALUES (2, 'Farmacias Peruanas');
INSERT INTO tb_proveedor VALUES (3, 'P & G ');
INSERT INTO tb_proveedor VALUES (4, 'Medisumi S.A.');
INSERT INTO tb_proveedor VALUES (5, 'Enferma EP');


/*********************************************  tb_tipousuario ********************************************************/
INSERT INTO tb_tipousuario VALUES (1, 'Admin');
INSERT INTO tb_tipousuario VALUES (2, 'Usuario');
/*********************************************  tb_especialidad ********************************************************/
INSERT INTO tb_especialidad VALUES (1, 'Médicina Interna');
INSERT INTO tb_especialidad VALUES (2, 'Radiología');
INSERT INTO tb_especialidad VALUES (3, 'Pediatría');
INSERT INTO tb_especialidad VALUES (4, 'Cirugía');
INSERT INTO tb_especialidad VALUES (5, 'Psiquiatría ');
INSERT INTO tb_especialidad VALUES (6, 'Dermatología ');
INSERT INTO tb_especialidad VALUES (7, 'Urología ');
INSERT INTO tb_especialidad VALUES (8, 'Gineco obstetricia ');
INSERT INTO tb_especialidad VALUES (9, 'Gastroenterología ');
INSERT INTO tb_especialidad VALUES (10, 'Cardiología ');
/*********************************************  tb_medicos ********************************************************/


INSERT INTO tb_medicos VALUES (null,"Clark","Meyers","389285655","fusce.mollis@cibermed.com.edu.pe","1998-03-14","2023-07-19",3);
INSERT INTO tb_medicos VALUES (null,"Amber","Clements","804426152","consectetuer@cibermed.com.edu.pe","1998-12-01","2023-09-25",9);
INSERT INTO tb_medicos VALUES(null,"Alexis","Holland","225143748","sagittis.lobortis.mauris@cibermed.com.edu.pe","1998-10-06","2023-09-15",10);
INSERT INTO tb_medicos VALUES (null,"Yasir","Callahan","308727253","donec.at.arcu@cibermed.com.edu.pe","2000-01-26","2023-06-05",2);
INSERT INTO tb_medicos VALUES(null,"Jaden","Pugh","524165934","felis@cibermed.com.edu.pe","1999-04-05","2023-09-17",7);
INSERT INTO tb_medicos VALUES (null,"Myles","Long","475273979","vestibulum@cibermed.com.edu.pe","2000-01-04","2023-04-29",2);
INSERT INTO tb_medicos VALUES (null,"Damian","Gordon","884382865","nisl.nulla.eu@cibermed.com.edu.pe","1998-01-17","2023-12-02",5);
INSERT INTO tb_medicos VALUES(null,"Tasha","Wagner","329686634","scelerisque.dui@cibermed.com.edu.pe","1999-11-19","2023-03-31",5);
INSERT INTO tb_medicos VALUES (null,"Imani","Lott","627524540","egestas@cibermed.com.edu.pe","2000-04-17","2023-05-06",3);
INSERT INTO tb_medicos VALUES (null,"Kieran","Gonzales","812629176","donec.feugiat@cibermed.com.edu.pe","2000-03-21","2023-09-29",4);
 
INSERT INTO tb_medicos VALUES (null, "Eleanor","Hess","731773357","vulputate.eu@cibermed.com.edu.pe","1999-08-05","2024-01-21",5);
INSERT INTO tb_medicos VALUES (null,"Kylan","Atkinson","773218465","fermentum.vel@cibermed.com.edu.pe","1999-12-04","2023-03-20",1);
INSERT INTO tb_medicos VALUES (null,"Dara","Workman","067234258","donec.nibh@cibermed.com.edu.pe","1998-07-17","2023-10-07",3);
INSERT INTO tb_medicos VALUES (null,"Perry","Santana","316292014","mauris.ut.quam@cibermed.com.edu.pe","1998-11-05","2023-12-20",8);
INSERT INTO tb_medicos VALUES (null,"Megan","Cummings","804858777","euismod@cibermed.com.edu.pe","1999-10-04","2023-10-12",4);
INSERT INTO tb_medicos VALUES (null,"Amber","Cameron","812281778","interdum.nunc@cibermed.com.edu.pe","1999-07-19","2023-01-20 ",2);
INSERT INTO tb_medicos VALUES (null,"Thomas","Gibson","471888528","libero.lacus@cibermed.com.edu.pe","1999-10-31","2023-09-08",2);
INSERT INTO tb_medicos VALUES (null,"Patience","Zimmerman","536223374","in@cibermed.com.edu.pe","2000-02-05","2023-02-27 ",7);
INSERT INTO tb_medicos VALUES (null,"Illiana","Howell","674228261","nisl.elementum@cibermed.com.edu.pe","2000-02-27","2023-03-21",2);
INSERT INTO tb_medicos VALUES (null,"Jenette","Bowman","474202143","et.malesuada@cibermed.com.edu.pe","1998-08-23","2023-08-20",5);


/*********************************************  tb_usuario ********************************************************/
INSERT INTO tb_usuario VALUES (null,'Admin','Admin',"2017-07-17",'admin','admin',1);
INSERT INTO tb_usuario VALUES (null,'Pepe','Almendra',"2021-12-1",'pepe','pepe',2);

/*********************************************  tb_clientes ********************************************************/
INSERT INTO tb_clientes VALUES (null,'Rosa','Suiz',"AV PERU 2370 SAN MARTIN DE PORRES",                 '12345612','2000-02-27','Dolor de estomago','3','2');
INSERT INTO tb_clientes VALUES (null,'Gertrudiz','Flores',"Av. La Universitaria Mza A Lt 1 - La Molina",'32145624','1999-01-14','Palpitacion en el corazon','10','2');
INSERT INTO tb_clientes VALUES (null,'Sonia','Laosca',"Jirón Luis Scavino, 150",                        '91240321','1992-03-05','Piel se pone roja ante el sol','6','2');
INSERT INTO tb_clientes VALUES (null,'Rosmery','Suni',"AV SAN JUAN 1160 INT A SAN JUAN DE MIRAFLORES",  '10528213','1997-04-19','Pensamiento oscuros','5','2');
INSERT INTO tb_clientes VALUES (null,'Alan','Potter',"Avenida San Martín, 158",                         '89437503','2001-05-13','Debo hacerme radiografias','2','2');

/*********************************************  tb_medicamentos ********************************************************/

INSERT INTO tb_medicamentos VALUES (null,'AMITRIPTILINA CLORHIDRATO, 25mg - TABLETA ','2030-01-21',10.50,1,4);
INSERT INTO tb_medicamentos VALUES (null,'AZITROMICINA, 200 mg/5 mL - SUSPENSION ','2025-01-21',36.0,2,3);
INSERT INTO tb_medicamentos VALUES (null,'CEFALEXINA , 250mg/5mL - SUSPENSION ','2023-01-21',10.0,3,2);
INSERT INTO tb_medicamentos VALUES (null,' CLORFENAMINA MALEATO, 2 mg/5 mL - SOLUCION','2039-01-21',1.50,4,1);
INSERT INTO tb_medicamentos VALUES (null,'CLORFENAMINA MALEATO, 4mg - TABLETA ','2029-01-21',0.50,5,7);


select * from tb_proveedor;
select * from tb_tipousuario;
select * from tb_especialidad;
select * from tb_medicos;
select * from tb_usuario;
select * from tb_clientes;
select * from tb_medicamentos;
