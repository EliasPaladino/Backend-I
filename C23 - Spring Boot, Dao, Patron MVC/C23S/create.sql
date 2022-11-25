DROP TABLE IF EXISTS domicilio;
CREATE TABLE domicilio (ID INT AUTO_INCREMENT PRIMARY KEY,
CALLE varchar(200),
NUMERO varchar(100),
LOCALIDAD varchar(100),
PROVINCIA varchar(100)
);
DROP TABLE IF EXISTS paciente;
CREATE TABLE paciente (ID INT AUTO_INCREMENT PRIMARY KEY,
APELLIDO varchar(100),
NOMBRE varchar(100),
DNI varchar(100),
DOMICILIO BIGINT);