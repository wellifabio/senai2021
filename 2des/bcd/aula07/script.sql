drop database if exists locadora;
create database locadora charset = UTF8 collate = utf8_general_ci;
use locadora;

create table veiculos(
    placa varchar(8) not null primary key,
    modelo varchar(20) not null,
    marca varchar(20) not null,
    cor varchar(20) not null,
    valor_diaria decimal(7,2) not null,
    ano integer(4) not null,
    tipo varchar(20) not null
);
create table locacoes(
    id integer not null primary key auto_increment,
    data_retirada date not null,
    data_devolucao date,
    obs varchar(255),
    valor_efetivo decimal(7,2)
);
create table clientes(
    cpf varchar(12) not null primary key,
    nome varchar(50) not null,
    endereco varchar(100) not null,
    email varchar(70) not null
);
create table telefones(
    cpf varchar(12) not null,
    telefone varchar(15) not null
);
show tables;
describe veiculos;
describe locacoes;
describe clientes;
describe telefones;

-- CRUD DDL (create, "show describe", alter, drop)

alter table telefones add
constraint fk_tel_cli foreign key (cpf)
references clientes(cpf)
on delete cascade
on update cascade;

alter table locacoes add
placa varchar(8) not null;

alter table locacoes add
constraint fk_locado foreign key (placa)
references veiculos(placa)
on update cascade;

alter table locacoes add
cpf varchar(12) not null;

alter table locacoes add
constraint fk_aluga foreign key (cpf)
references clientes(cpf)
on update cascade;

-- CRUD DML (Insert, Select, Delete, Update)

-- a cláusula "value" permite que possamos inserir vários valores separados por vírgula
insert into veiculos(placa, modelo, marca, cor, valor_diaria, ano, tipo) values
("AAA1111","UNO","FIAT","Amarelo","50.00","1998","popular"),
("AAA5555","GOL","VW","Prata","70.00","2015","popular"),
("BBB3333","KA","FORD","Azul","50.00","2002","popular"),
("CCC1111","CIVIC","HONDA","Prata","100.00","2020","luxo"),
("DDD3333","FUSCA","VW","Amarelo","50.00","1966","reliquia");

-- Não é obrigatório colocar os campos entre parênteses, somente se desejar inverter a ordem
insert into clientes values
("12345678999","João da Silva","Rua das Oliveiras, 45, Centro, Jaguariúna-SP","joao@silva.com"),
("45645465657","Maria da Silva","Rua das Oliveiras, 45, Centro, Jaguariúna-SP","maria@silva.com"),
("87987987998","Marcos da Silva","Rua das Oliveiras, 45, Centro, Jaguariúna-SP","marcos@silva.com"),
("48798798798","Joana da Silva","Rua das Oliveiras, 45, Centro, Jaguariúna-SP","joana@silva.com"),
("45646579879","Martha da Silva","Rua das Oliveiras, 45, Centro, Jaguariúna-SP","martha@silva.com");

-- Um cliente não possui telefone e outro possui dois telefones
insert into telefones values
("12345678999","19 99487-8798"),
("45645465657","19 99487-8798"),
("45645465657","19 99487-8798"),
("48798798798","19 99487-8798"),
("45646579879","19 99487-8798");

-- e finalmente a tabela "fraca" que liga o cliente o veículo "locacoes"
insert into locacoes values
(null,"2021-08-05","2021-08-07","",150.00,"AAA1111","12345678999"),
(default,"2021-08-10","2021-08-12",null,200.00,"CCC1111","12345678999");

select * from veiculos;
select * from clientes;
select * from telefones;
select * from locacoes;