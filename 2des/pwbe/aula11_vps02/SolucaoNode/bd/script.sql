drop database if exists irrf;
create database irrf charset=UTF8 collate utf8_general_ci;
use irrf;
create table funcionarios(
    matricula integer primary key not null auto_increment,
    nome_completo varchar(256) not null,
    data_desligamento date not null,
    ultimo_salario decimal(9,2) not null
);

-- Importando os dados de academia.csv
LOAD DATA INFILE 'D:/wellington/senai2021/2des/pwbe/aula11_vps02/SolucaoNode/bd/funcionarios.csv'
INTO TABLE funcionarios
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 ROWS;

select * from funcionarios;