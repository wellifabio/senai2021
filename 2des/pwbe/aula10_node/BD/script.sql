drop database if exists academia;
create database academia;
use academia;

create table alunos(
    id integer primary key not null auto_increment,
    nome varchar(256) not null,
    peso decimal(5,2) not null,
    altura decimal(3,2) not null,
    nascimento date not null
);

-- Importando os dados de academia.csv
LOAD DATA INFILE 'C:/Users/wellington.martins/Desktop/github/senai2021/2des/pwbe/aula10_node/BD/academia.csv'
INTO TABLE alunos
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 ROWS;

select * from alunos;