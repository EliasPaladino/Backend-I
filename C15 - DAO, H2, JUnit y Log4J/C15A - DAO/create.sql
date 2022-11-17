DROP TABLE IF EXISTS domicilios;
CREATE TABLE domicilios (ID INT AUTO_INCREMENT PRIMARY KEY,
CALLE varchar(200),
NUMERO INT,
LOCALIDAD varchar(100),
PROVINCIA varchar(100)
);
DROP TABLE IF EXISTS pacientes;
CREATE TABLE pacientes (ID INT AUTO_INCREMENT PRIMARY KEY,
NOMBRE varchar(100),
DNI INT,
FECHA_INGRESO DATE,
DOMICILIO_ID INT);
INSERT INTO domicilios(calle, numero, localidad, provincia) VALUES ('Calle B',497,'Salta Capital','Salta');
INSERT INTO domicilios(calle, numero, localidad, provincia) VALUES ('Calle C',584,'Salta Capital','Salta');
INSERT INTO pacientes(nombre, dni, fecha_ingreso, domicilio_id) VALUES ('Rodolfo',544807,'2022-03-01',1);
INSERT INTO pacientes(nombre, dni, fecha_ingreso, domicilio_id) VALUES ('Rodolfo',544807,'2022-03-01',2);