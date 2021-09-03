drop database if exists agencia;
create database agencia;
use agencia;

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