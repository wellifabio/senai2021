drop database if exists agencia;
create database agencia;
use agencia;

-- DDL (Data Develpoment Language)
create table vendedores(
    id_vendedor integer not null primary key auto_increment,
    nome VARCHAR(40) not null
);

create table veiculos(
    id_veiculo integer not null primary key auto_increment,
    modelo VARCHAR(40) not null,
    preco decimal(9,2) not null
);

create table agencias(
    id_agencia integer not null primary key auto_increment,
    cidade VARCHAR(40) not null,
    uf VARCHAR(2) not null
);

create table vendas(
    data Date not null,
    id_vendedor integer not null,
    id_veiculo integer not null,
    id_agencia integer not null,
    constraint fk_venda_vendedor foreign key (id_vendedor) references vendedores(id_vendedor),
    constraint fk_venda_veiculo foreign key (id_veiculo) references veiculos(id_veiculo),
    constraint fk_venda_agencia foreign key (id_agencia) references agencias(id_agencia)
);

show tables;

-- DML (Data Manipulation Language)
-- CRUD em MYSQL (INSERT INTO, SELECT, UPDATE e DELETE)

describe agencias;
insert into agencias(cidade,uf) values
("Jaguariúna","SP"),
("Pedreira","SP"),
("Holambra","SP"),
("Amparo","SP"),
("Serra Negra","SP");
select * from agencias;

describe vendedores;
insert into vendedores(nome) values ("Jair"),("Jafoi"),("Jaera"),("Javai");
select * from vendedores;
describe veiculos;
insert into veiculos(modelo,preco) values
("Palio",9000.00),
("Gol",17000.00),
("Fiesta",19000.00),
("Celta",29000.00);
select * from veiculos;
insert into veiculos(modelo,preco) values
("Palio",9000.00),
("Gol",17000.00),
("Fiesta",19000.00),
("Celta",29000.00);
select * from veiculos;
select modelo from veiculos;
select preco from veiculos;
select modelo, preco from veiculos;

-- Apaga o conteúdo da tabela inteira
delete from veiculos;
-- Aaltera o conteúdo da tabela inteira
update veiculos set modelo = "Civic";

-- WHERE (Onde) Cláusula mais importante no "CRUD"
