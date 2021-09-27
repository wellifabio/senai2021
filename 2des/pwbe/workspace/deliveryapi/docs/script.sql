drop database if exists delivery;
create database delivery;
use delivery;

create table entregadores(
    id_entregador integer not null primary key auto_increment,
    nome_completo varchar(50) not null,
    veiculo varchar(20) not null
);

create table clientes(
    id_cliente integer not null primary key auto_increment,
    nome_completo varchar(50) not null,
    endereco_completo varchar(150) not null,
    telefone varchar(15) not null,
    cpf varchar(12)
);

create table produtos(
    id_produto integer not null primary key auto_increment,
    nome varchar(30) not null,
    preco decimal(7,2) not null
);

create table pedidos(
    id_pedido integer not null primary key auto_increment,
    id_cliente integer not null,
    id_entregador integer,
    data Date not null,
    hora_pedido time not null,
    hora_entrega time,
    hora_fim time
);

create table itens(
    id_pedido integer not null,
    id_produto integer not null,
    quantidade integer not null
);

alter table pedidos add
constraint fk_faz foreign key (id_cliente)
references clientes(id_cliente);

alter table pedidos add
constraint fk_entrega foreign key (id_entregador)
references entregadores(id_entregador);

alter table itens add
constraint fk_item_pedido foreign key (id_pedido)
references pedidos(id_pedido)
on delete cascade;

alter table itens add
constraint fk_item_produto foreign key (id_produto)
references produtos(id_produto);

describe entregadores;
describe clientes;
describe produtos;
describe pedidos;
describe itens;
show tables;
