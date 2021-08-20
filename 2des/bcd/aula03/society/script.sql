drop database if exists society; 
create database society;
use society;

create table jogadores(
    cpf varchar(12) not null primary key,
    nome varchar(50) not null,
    telefone varchar(14)
);
create table grupos(
    id varchar(10) not null primary key,
    dia_semana varchar(30) not null,
    horario varchar(10) not null
);
create table joga(
    cpf varchar(12) not null,
    id varchar(10) not null 
);
--RELACINONAMENTO ENTRE TABELAS
alter table joga
add constraint fk_cpf
foreign key (cpf) references jogadores(cpf)
on delete cascade
on update cascade;

alter table joga
add constraint fk_id
foreign key (id) references grupos(id)
on delete cascade
on update cascade;

-- DML
INSERT INTO jogadores (cpf, nome, telefone) VALUES ('11111', 'Marcos', '1945467648');
INSERT INTO jogadores (cpf, nome, telefone) VALUES ('22222', 'Ana', '1945454678');
INSERT INTO jogadores (cpf, nome, telefone) VALUES ('33333', 'Jorge', '19456544678');
INSERT INTO jogadores (cpf, nome, telefone) VALUES ('44444', 'Bruna', '1945466578');
INSERT INTO jogadores (cpf, nome, telefone) VALUES ('55555', 'Carla', '1945466578');
INSERT INTO jogadores (cpf, nome, telefone) VALUES ('66666', 'Diego', '1945465678');
INSERT INTO jogadores (cpf, nome, telefone) VALUES ('88888', 'Ronaldo', '1945466578');
INSERT INTO jogadores (cpf, nome, telefone) VALUES ('77777', 'Isabela', '1945466578');

INSERT INTO grupos (id, dia_semana, horario) VALUES ('1', 'BolaCheia', '07:00');
INSERT INTO grupos (id, dia_semana, horario) VALUES ('2', 'BolaMucha', '10:00');
INSERT INTO grupos (id, dia_semana, horario) VALUES ('3', 'BolaQuadrada', '22:00');


INSERT INTO joga (cpf, id) VALUES ('11111', '1');
INSERT INTO joga (cpf, id) VALUES ('22222', '1');
INSERT INTO joga (cpf, id) VALUES ('77777', '1');
INSERT INTO joga (cpf, id) VALUES ('44444', '1');
INSERT INTO joga (cpf, id) VALUES ('55555', '2');
INSERT INTO joga (cpf, id) VALUES ('66666', '2');
INSERT INTO joga (cpf, id) VALUES ('11111', '2');
INSERT INTO joga (cpf, id) VALUES ('11111', '3');
INSERT INTO joga (cpf, id) VALUES ('88888', '3');
INSERT INTO joga (cpf, id) VALUES ('55555', '3');
INSERT INTO joga (cpf, id) VALUES ('33333', '3');

describe jogadores;
select * from jogadores;