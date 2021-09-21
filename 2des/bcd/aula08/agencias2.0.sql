drop database if exists agencia;
create database agencia charset=UTF8 collate utf8_general_ci;
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

-- Queries
select * from vendedores;
select * from veiculos;
select * from agencias;
select * from vendas;

-- DML
insert into vendedores(nome) values
("Alfredo Santos"),
("Amanda Alves"),
("Amanda Bourn"),
("Amanda de Oliveira"),
("Ana Freeman"),
("Ana Paula Alves"),
("Ana Paula Souza"),
("Ana Silva"),
("Ana Souza"),
("Bento Martins"),
("Bento Santos"),
("Carlos Bourn"),
("Carlos Martins"),
("Elian Belli"),
("Elian Souza"),
("Enso Belli"),
("Fabrício da Silva"),
("Fabrício Ramos"),
("Fabrício Scovisk"),
("Gilberto Fernandes"),
("Gilberto Santos"),
("Hiago Belli"),
("Hiago Bourn"),
("Ivo da Silva"),
("Ivo Souza"),
("João Alves"),
("João da Silva"),
("João Freeman"),
("Juvenal Alves"),
("Lucas Alves"),
("Lucas Fernandes"),
("Luciano Belli"),
("Luciano Bourn"),
("Luciano Freeman"),
("Luciano Souza"),
("Marcos Bourn"),
("Marcos Freeman"),
("Matheus Bourn"),
("Nivaldo de Oliveira"),
("Nivaldo Fernandes"),
("Nivaldo Martins"),
("Orácio da Silva"),
("Orácio de Oliveira"),
("Orácio Souza"),
("Paulo Alves"),
("Paulo Falcirolli"),
("Ribamar Fernandes"),
("Ricardo Belli"),
("Ricardo Ramos"),
("Saulo Belli"),
("Saulo Falcirolli"),
("Timóteo Bourn"),
("Zilda Alves");
select * from vendedores;
insert into veiculos(modelo,preco) values
("Civic",14404),
("Uno",28877),
("Polo",41835),
("Pálio",53940),
("Fiesta",18715),
("Cruze",48416),
("Corola",39496),
("Gol",35845),
("EcoSport",47753),
("Logan",39417),
("Ka",19995);
select * from veiculos;
insert into agencias(cidade,uf) values
('Jacarezinho','PR'),
('Amparo','SP'),
('Americana','SP'),
('Pedreira','SP'),
('Curitiba','PR'),
('Londrina','PR'),
('Belo Horizonte','MG'),
('Campinas','SP'),
('Pouso Alegre','MG'),
('Monte Verde','MG'),
('Jaguariúna','SP');
select * from agencias;

-- importação a partir de um arquivo CSV
LOAD DATA INFILE 'c:/bcd/vendas.csv'
INTO TABLE vendas
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

select * from vendas order by data desc limit 20;
-- exportação para arquivos csv
select * from agencias INTO OUTFILE "c:/bcd/agencias.csv"
FIELDS TERMINATED BY ';'
ENCLOSED BY '"' 
LINES TERMINATED BY '\r\n';

