drop database if exists cidadao;
create database cidadao;
use cidadao;
create table cidadaos(
    numero_cartao integer(5) primary key not null,
    cpf varchar(12) not null,
    nome varchar(50) not null
);

create table telefones(
    numero_cartao integer(5) not null,
    numero varchar(14)
);

