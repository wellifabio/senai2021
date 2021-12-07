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
(default, "Juca", 75, 35),
(default, "Mariana", 100, 24),
(default, "Juca", 125.5, 16);
select * from servicos;