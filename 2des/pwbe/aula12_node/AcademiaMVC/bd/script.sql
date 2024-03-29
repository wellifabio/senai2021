drop database if exists academia;
create database academia;
use academia;

create table alunos(
    id integer primary key not null auto_increment,
    nome varchar(256) not null,
    peso decimal(5,2) not null,
    altura decimal(3,2) not null,
    nascimento date not null
);

insert into alunos values
(1,'Alfredo Santos',52,1.78,'2001-01-13'),
(2,'Amanda Alves',66,1.95,'1992-05-28'),
(3,'Amanda Bourn',111,1.76,'1994-02-20'),
(4,'Amanda de Oliveira',67,1.95,'1997-04-02'),
(5,'Ana Freeman',96,1.70,'1999-11-14'),
(6,'Ana Paula Alves',107,1.56,'1989-05-14'),
(7,'Ana Paula Souza',78,1.94,'2000-11-05'),
(8,'Ana Silva',103,1.92,'1982-05-15'),
(9,'Ana Souza',48,1.63,'2003-09-22'),
(10,'Bento Martins',64,1.86,'1993-08-22'),
(11,'Bento Santos',102,1.81,'1995-07-26'),
(12,'Carlos Bourn',70,1.85,'1992-06-18'),
(13,'Carlos Martins',73,1.96,'1980-09-23'),
(14,'Elian Belli',60,1.85,'2002-07-05'),
(15,'Elian Souza',73,1.68,'1997-11-23'),
(16,'Enso Belli',100,1.82,'1991-09-03'),
(17,'Fabrício da Silva',80,1.79,'1987-03-10'),
(18,'Fabrício Ramos',64,1.81,'1990-05-21'),
(19,'Fabrício Scovisk',106,1.84,'1980-03-09'),
(20,'Gilberto Fernandes',81,1.75,'1992-11-15'),
(21,'Gilberto Santos',99,1.97,'2001-09-21'),
(22,'Hiago Belli',51,1.82,'1993-08-21'),
(23,'Hiago Bourn',99,1.74,'2005-12-08'),
(24,'Ivo da Silva',73,1.54,'1980-03-01'),
(25,'Ivo Souza',93,1.51,'1997-05-05'),
(26,'João Alves',67,1.99,'1997-02-08'),
(27,'João da Silva',90,1.82,'1988-01-28'),
(28,'João Freeman',89,1.61,'1997-07-28'),
(29,'Juvenal Alves',107,1.94,'1999-11-19'),
(30,'Lucas Alves',62,1.69,'1994-05-15'),
(31,'Lucas Fernandes',96,1.82,'1997-06-09'),
(32,'Luciano Belli',73,1.51,'1981-12-22'),
(33,'Luciano Bourn',82,1.53,'2003-02-13'),
(34,'Luciano Freeman',75,1.56,'2002-10-23'),
(35,'Luciano Souza',109,1.58,'2003-11-18'),
(36,'Marcos Bourn',63,1.98,'2001-11-21'),
(37,'Marcos Freeman',105,1.52,'1984-01-19'),
(38,'Matheus Bourn',110,1.65,'1995-10-08'),
(39,'Nivaldo de Oliveira',63,1.86,'1997-01-15'),
(40,'Nivaldo Fernandes',88,1.88,'1988-06-10'),
(41,'Nivaldo Martins',81,1.55,'1988-06-28'),
(42,'Orácio da Silva',114,1.85,'2001-07-15'),
(43,'Orácio de Oliveira',85,1.60,'2000-05-07'),
(44,'Orácio Souza',116,1.80,'2005-07-05'),
(45,'Paulo Alves',66,1.95,'1990-07-02'),
(46,'Paulo Falcirolli',81,1.77,'1997-02-11'),
(47,'Ribamar Fernandes',87,1.61,'1987-12-15'),
(48,'Ricardo Belli',75,1.75,'1980-08-27'),
(49,'Ricardo Ramos',59,1.56,'1991-01-01'),
(50,'Saulo Belli',97,1.77,'1987-07-19'),
(51,'Saulo Falcirolli',92,1.99,'2002-05-20'),
(52,'Timóteo Bourn',113,1.74,'1989-11-13'),
(53,'Zilda Alves',61,1.81,'1995-01-03');

select * from alunos;