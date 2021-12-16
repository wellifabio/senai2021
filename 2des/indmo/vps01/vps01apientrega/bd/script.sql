drop database if exists vps01entrega;
create database vps01entrega character set utf8mb4 collate utf8mb4_bin;

use vps01entrega;

create table entregadores(
    id_entregador integer not null primary key auto_increment,
    nome varchar(50) not null
);

create table entregas(
    id_entrega integer not null primary key auto_increment,
    id_entregador integer not null,
    cliente varchar(50) not null,
    endereco varchar(256) not null,
    produto varchar(256) not null,
    valor decimal(10,2) not null,
    data date not null,
    hora time,
    CONSTRAINT fk_entregador foreign key (id_entregador) references entregadores(id_entregador)
);

insert into entregadores VALUES
(default,"Roberval"),
(default,"Ricardo"),
(default,"Manuel"),
(default,"José"),
(default,"Rosângela");

insert into entregas VALUES
(default, 1, "Jacinto Pena", "Rua que sobe e desce, 25, Jaguariúna","Pão de queijo",3.50,curdate(),null),
(default, 2, "Jacinto Ódio", "Rua do Amor, 19, Jaguariúna","Pão de mel",10.50,curdate(),null),
(default, 3, "Jacinto Amor", "Rua da felicidade, 15, Jaguariúna","Pão de ló",13.50,curdate(),null),
(default, 4, "Jacinto Pena", "Rua que some, 250, Jaguariúna","Pão de forma",5.50,curdate(),null),
(default, 1, "Passos Dias aguiar", "Rua que aparece, 258, Jaguariúna","Pão de queijo",3.50,curdate(),null),
(default, 2, "Osmar Motta", "Rua do Calor, 193, Jaguariúna","Pão de mel",8.50,curdate(),null),
(default, 3, "Osmar Manjo", "Rua que vai e vem, 151, Jaguariúna","Pão de ló",7.50,curdate(),null),
(default, 4, "Tomas Quase Turbando", "Rua que só vai, 253, Jaguariúna","Pão de forma",3.50,curdate(),null),
(default, 5, "Antônio Lobo", "Rua que só vem, 253, Jaguariúna","Pão de forma",8.50,curdate(),null),
(default, 1, "Simone Silva", "Rua dos Pelados, 258, Jaguariúna","Pão de queijo",3.50,curdate(),null),
(default, 2, "Marta Motta", "Rua dos Bonitos, 193, Jaguariúna","Pão de mel",8.50,curdate(),null),
(default, 3, "Ana Maria Manjo", "Rua do trem grande, 151, Jaguariúna","Pão de ló",7.50,curdate(),null),
(default, 4, "Marcos Turbando", "Rua que vai, 253, Jaguariúna","Pão de forma",3.50,curdate(),null),
(default, 5, "Júlio Lobo", "Rua que volta, 253, Jaguariúna","Pão de batata",8.50,curdate(),null);

select * from entregadores;
select * from entregas;