-- SQL (--DDL --DML --DCL)

-- DDL - desenvolvimento (create, drop, alter, show)
-- Criamos o cabeçalho do script de criação
drop database if exists onibus; -- Apaga a ultima versão do BD se existir
create database onibus; -- Cria a nova versão BD
show databases; -- Mostra todos os BDs criados
use onibus; -- Acessa o BD criados

-- Criação das tabelas
create table motoristas(
    cpf varchar(12) not null primary key,
    nome varchar(50) not null,
    endereco varchar(100) not null,
    telefone varchar(14)
);
create table linhas(
    id_linha integer not null auto_increment,
    descricao varchar(40) not null,
    constraint pk_linha primary key (id_linha)
);

create table escalas(
    cpf varchar(12) not null,
    id_linha integer not null,
    data Date not null
);

create table horarios(
    id_linha integer not null,
    horario Time not null
);

create table pontos(
    id_linha integer not null,
    descricao varchar(40) not null,
    tipo varchar(15) not null,
    pos_geografica varchar(40) not null
);

-- Criação dos relacionamentos
alter table escalas
add constraint fk_dirige_linha
foreign key (id_linha) references linhas(id_linha)
on delete cascade
on update cascade;

alter table escalas
add constraint fk_dirige_motorista
foreign key (cpf) references motoristas(cpf)
on update cascade;

alter table horarios
add constraint fk_horarios_linhas
foreign key (id_linha) references linhas(id_linha) 
on delete cascade;

alter table pontos
add constraint fk_possui_linhas
foreign key (id_linha) references linhas(id_linha);

-- Visualizando os resultados 
show databases;
show tables;
describe motoristas;
describe esclalas;
describe linhas;
describe pontos;
describe horarios;
