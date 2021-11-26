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
LOAD DATA INFILE 'C:/Users/Aluno.DSN5131112167/Desktop/senai2021/senai2021/2des/pwbe/aula10/BD/academia.csv'
INTO TABLE alunos
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 ROWS;

select * from alunos;