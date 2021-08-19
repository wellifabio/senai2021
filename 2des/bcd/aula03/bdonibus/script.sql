-- SQL (--DDL --DML --DCL)
-- DDL - desenvolvimento (create, drop, alter, show)

drop database if exists onibus;
create database onibus;
show databases;
use onibus;

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
    data Date not null,

    constraint fk_dirige_linha
    foreign key (id_linha) references linhas(id_linha)
    on delete cascade
    on update cascade

);

alter table escalas
add constraint fk_dirige_motorista
foreign key (cpf) references motoristas(cpf)
on delete cascade
on update cascade;
