DROP TABLE IF EXISTS domicilios;
CREATE TABLE domicilios (ID INT AUTO_INCREMENT PRIMARY KEY,
CALLE varchar(100) NOT NULL,
NUMERO INT NOT NULL,
LOCALIDAD varchar(100) NOT NULL,
PROVINCIA varchar(100) NOT NULL);

DROP TABLE IF EXISTS odontologos;
CREATE TABLE odontologos (ID INT AUTO_INCREMENT PRIMARY KEY,
APELLIDO varchar(100) NOT NULL,
NOMBRE varchar(100) NOT NULL,
MATRICULA varchar(100) NOT NULL);

DROP TABLE IF EXISTS pacientes;
CREATE TABLE pacientes (ID INT AUTO_INCREMENT PRIMARY KEY,
APELLIDO varchar(100) NOT NULL,
NOMBRE varchar(100) NOT NULL,
EMAIL varchar(100) NOT NULL,
DNI INT NOT NULL,
FECHA_INGRESO DATE NOT NULL,
DOMICILIO_ID INT NOT NULL,
ODONTOLOGO_ID INT NOT NULL);



INSERT INTO domicilios(calle, numero, localidad, provincia) VALUES ('Calle A', 474, 'Cafayate', 'Salta');
INSERT INTO domicilios(calle, numero, localidad, provincia) VALUES ('Calle B', 6589, 'Virrey del Pino', 'Buenos Aires');
INSERT INTO domicilios(calle, numero, localidad, provincia) VALUES ('Calle C', 324, 'Bariloche', 'Neuquen');

INSERT INTO odontologos(apellido, nombre, matricula) VALUES ('Suarez', 'Adolfo', 'asd123');
INSERT INTO odontologos(apellido, nombre, matricula) VALUES ('Fernandez', 'Martin', 'aqw332');

INSERT INTO pacientes(apellido, nombre, email, dni, fecha_ingreso, domicilio_id) VALUES ('Paladino', 'Elias', 'elias@gmail.com', 12345, '2023-01-16',1, 1);
INSERT INTO pacientes(apellido, nombre, email, dni, fecha_ingreso, domicilio_id) VALUES ('Baspineiro', 'Rodolfo', 'rodolfo@gmail.com', 123212, '2023-01-16',2, 2);
