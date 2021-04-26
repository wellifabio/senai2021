drop database if exists ixsistemas;
create database ixsistemas;
show databases;

use ixsistemas;
create table usuario(
  id_usuario int not null auto_increment,
  login varchar(30) not null unique,
  senha varchar(30) not null,
  tipo varchar(30) not null,
primary key(id_usuario)
);

create table mesa(
    id_mesa int not null auto_increment,
    descricao varchar(30) not null,
    id_usuario int,
    primary key(id_mesa),
    constraint fk_m_u foreign key (id_usuario)
    references usuario(id_usuario)
    );

create table produto(
    id_produto int not null auto_increment,
    nome varchar(30) not null,
    descricao varchar(200) not null,
    valor varchar(10) not null,
    tipos varchar(20) not null,
    primary key(id_produto)
);

create table pedido(
    id_pedido int not null auto_increment,
    id_mesa int not null,
    data varchar(30) not null,
    hora varchar(30) not null,
    status varchar(30) not null,
    obs varchar(30) not null,
    primary key(id_pedido),
    constraint fk_p_p foreign key (id_mesa)
    references mesa(id_mesa)
    );

create table itens(
    id_pedido int not null,
    id_produto int not null,
    constraint fk_i_p foreign key (id_pedido)
    references pedido(id_pedido),
    constraint fk_i_pr foreign key(id_produto)
    references produto(id_produto)
);

insert into usuario values
(1,"gerente00",md5("senha@123"),"Gerente"),
(2,"Cozinha00",md5("senha@123"),"Chapeiro"),
(3,"Caixa00",md5("senha@123"),"Caixa"),
(4,"Garcom00",md5("senha@123"),"Garçom");

insert into mesa values
(1,'mesa1',4),
(2,'mesa2',4),
(3,'mesa1',4),
(4,'mesa1',4),
(5,'mesa1',4);

insert into produto values
(default,'X-tudo','Humburguer, queijo, catupiry, calabresa, bacon, milho, alface, tomate no Pão de Humburguer','25,00$','Lanches'),
(default,'X-Salada','Humburguer, queijo, alface, tomate no pão de humburguer','15,00$','Lanches'),
(default,'X-Bacon','Humburguer, queijo , bacon, alface, tomate no Pão de humburguer','20,00$','Lanches'),
(default,'X-Burguer','Humburguer, queijo no Pão de Humburguer','12,00$','Lanches');

insert into pedido values
(1,1,'22/04/2021','21:30','Em andamento','sem alface'),
(2,2,'22/04/2021','19:43','Aguardando','bem passado'),
(3,3,'22/04/2021','20:20','Feito','sem observações');

insert into itens values
(1,1),
(1,2),
(1,2),
(2,1),
(2,2),
(3,2),
(3,3);

select * from usuario;
select * from produto;
select * from pedido;
select * from itens;
select * from mesa;
show tables;