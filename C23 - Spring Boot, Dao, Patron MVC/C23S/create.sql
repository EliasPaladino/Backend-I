DROP TABLE IF EXISTS domicilios;
CREATE TABLE domicilios (ID INT AUTO_INCREMENT PRIMARY KEY,
CALLE varchar(200) NOT NULL,
NUMERO varchar(100) NOT NULL,
LOCALIDAD varchar(100) NOT NULL,
PROVINCIA varchar(100) NOT NULL
);

DROP TABLE IF EXISTS PACIENTE;
CREATE TABLE PACIENTE (ID INT AUTO_INCREMENT PRIMARY KEY,
NOMBRE varchar(100),
APELLIDO varchar(100),
EMAIL varchar(60),
DNI varchar(100),
FECHA_INGRESO DATE ,
DOMICILIO INT);

INSERT INTO domicilios (calle, numero, localidad, provincia) VALUES ('Avenida falsa', '123', 'Virrey del Pino', 'Buenos Aires');