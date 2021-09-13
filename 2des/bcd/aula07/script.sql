-- acessa o SGBD (Ambiente de desenvolvimento)
-- mysql -u root -p

drop database if exists locadora; -- Apaga
create database locadora
charset = UTF8 collate = utf8_general_ci; -- Cria
use locadora; -- Acessa

-- Cria as tabelas DDL
create table veiculos(
    placa varchar(8) not null primary key,
    modelo varchar(30) not null,
    marca varchar(30) not null, 
    cor varchar(20) not null,
    valor_diaria decimal(6,2) not null,
    ano integer(4) not null,
    tipo varchar(15) not null
);
create table locacoes(
    id INTEGER NOT NULL primary key AUTO_INCREMENT,
    data_retirada Date not null,
    data_devolucao Date,
    obs varchar(255),
    valor_efetivo decimal(7,2)
);
create table clientes(
    cpf varchar(12) primary key not null,
    nome varchar(50) not null,
    endereco varchar(100) not null,
    email varchar(70) not null
);
create table telefones(
    cpf varchar(12) not null,
    telefone varchar(14) not null,
    constraint fk_tel_cli foreign key (cpf)
    references clientes(cpf)
    on delete cascade
    on update cascade
);
show tables;

alter table locacoes add
placa varchar(8) not null;

alter table locacoes add
constraint fk_loc_vei foreign key (placa)
references veiculos(placa)
on update cascade;

alter table locacoes add
cpf varchar(12) not null;

alter table locacoes add
constraint fk_loc_cli foreign key (cpf)
references clientes(cpf);
