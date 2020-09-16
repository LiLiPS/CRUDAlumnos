CREATE database alumnosWeb;

USE alumnosWeb;

CREATE TABLE alumnosWeb(
id INT not null AUTO_INCREMENT PRIMARY KEY,
numeroControl varchar(10) not null,
nombre varchar(100) not null,
curso varchar(2) not null,
semestre int not null
)

CREATE TABLE usuarios(
id INT not null AUTO_INCREMENT PRIMARY KEY,
usuario varchar(40) not null,
contrasena varchar(40) not null
)