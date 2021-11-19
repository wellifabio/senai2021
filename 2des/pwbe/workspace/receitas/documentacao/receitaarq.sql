drop database if exists Receitas;
create database Receitas CHARACTER SET utf8 COLLATE utf8_general_ci;
use Receitas;
create table Receitas(
	receita_id integer primary key auto_increment,
	nome varchar(30) not null,
	ingredientes varchar(500) not null,
	modo_de_fazer varchar(500) not null,
	foto mediumblob
);

insert into receitas values
(default, "Ovo cozido", "Um ovo", "Ferva a água, bote o ovo e aguarde 15 minutos", null),
(default, "Ovo frito", "Um ovo", "Derreta a manteiga, bote o ovo, aguarde 2 minutos e vire", null),
(default, "Ovo mexido", "Um ovo", "Derreta a menteiga, bote o ovo, mexa, aguarde 2 minutos e vire", null),
(default, "Ovo poche", "Um ovo, vinagre", "Ferva a água, coloque um pouco de vinagre, mexa, bote o ovo e aguarde cozinhar", null),
(default, "Ovo cru", "Um ovo", "Quebre o ovo", null);

