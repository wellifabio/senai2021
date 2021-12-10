drop database if exists servicos;
create database servicos;

use servicos;

create table servicos(
	id_servico integer not null primary key auto_increment,
	prestador varchar(256) not null,
	valor_hora decimal(6,2) not null,
	horas_trabalhadas decimal(6,2) not null
);

insert into servicos values
(default, "Juca Silva", 75, 35),
(default, "Mariana Lima", 100, 24),
(default, "Jacinto Pena", 125.5, 16),
(default, "Mariana Pena", 115.0, 5),
(default, "Luiza Pena", 200.0, 13),
(default, "Ana Souza", 75.5, 25),
(default, "Maria Silva", 100.0, 16);
select * from servicos;