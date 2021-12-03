drop database if exists irrf;
create database irrf charset = UTF8 collate utf8_general_ci;
use irrf;
create table funcionarios(
matricula integer PRIMARY key not null auto_increment,
nome_completo varchar(256) not null,
data_desligamento date not null,
ultimo_salario float(9,2) not null
);

insert into funcionarios VALUES
(201901,' Alfredo Santos',' 2020-01-13',2525),
(201902,' Amanda Alves',' 2020-05-28',3507),
(201903,' Amanda Bourn',' 2020-02-20',3902),
(201904,' Amanda de Oliveira',' 2020-02-04',4316),
(201905,' Ana Freeman',' 2020-11-14',4704),
(201906,' Ana Paula Alves',' 2020-05-14',6465),
(201907,' Ana Paula Souza',' 2020-05-11',5174),
(201908,' Ana Silva',' 2020-05-15',2108),
(201909,' Ana Souza',' 2020-09-22',2830),
(201910,' Bento Martins',' 2020-08-22',5862),
(201911,' Bento Santos',' 2020-07-26',4591),
(201912,' Carlos Bourn',' 2020-06-18',6495),
(201913,' Carlos Martins',' 2020-09-23',6384),
(201914,' Elian Belli',' 2020-07-05',3641),
(201915,' Elian Souza',' 2020-11-23',4110),
(201916,' Enso Belli',' 2020-03-09',3850),
(201917,' FabrÃ­cio da Silva',' 2020-10-03',5081),
(201918,' FabrÃ­cio Ramos',' 2020-05-21',5019),
(201919,' FabrÃ­cio Scovisk',' 2020-09-03',6153),
(201920,' Gilberto Fernandes',' 2020-11-15',1856),
(201921,' Gilberto Santos',' 2020-09-21',4611),
(201922,' Hiago Belli',' 2020-08-21',2834),
(201923,' Hiago Bourn',' 2020-08-12',3855),
(201924,' Ivo da Silva',' 2020-03-01',6847),
(201925,' Ivo Souza',' 2020-05-05',6016),
(201926,' JoÃ£o Alves',' 2020-08-02',2415),
(201927,' JoÃ£o da Silva',' 2020-01-28',3300),
(201928,' JoÃ£o Freeman',' 2020-07-28',5621),
(201929,' Juvenal Alves',' 2020-11-19',6786),
(201930,' Lucas Alves',' 2020-05-15',4970),
(201931,' Lucas Fernandes',' 2020-09-06',4774),
(201932,' Luciano Belli',' 2020-12-22',3202),
(201933,' Luciano Bourn',' 2020-02-13',4960),
(201934,' Luciano Freeman',' 2020-10-23',5765),
(201935,' Luciano Souza',' 2020-11-18',2088),
(201936,' Marcos Bourn',' 2020-11-21',1754),
(201937,' Marcos Freeman',' 2020-01-19',3977),
(201938,' Matheus Bourn',' 2020-08-10',5881),
(201939,' Nivaldo de Oliveira',' 2020-01-15',4157),
(201940,' Nivaldo Fernandes',' 2020-10-06',4801),
(201941,' Nivaldo Martins',' 2020-06-28',6465),
(201942,' OrÃ¡cio da Silva',' 2020-07-15',6317),
(201943,' OrÃ¡cio de Oliveira',' 2020-07-05',2387),
(201944,' OrÃ¡cio Souza',' 2020-05-07',4790),
(201945,' Paulo Alves',' 2020-02-07',1950),
(201946,' Paulo Falcirolli',' 2020-11-02',2643),
(201947,' Ribamar Fernandes',' 2020-12-15',5356),
(201948,' Ricardo Belli',' 2020-08-27',5649),
(201949,' Ricardo Ramos',' 2020-01-01',6169),
(201950,' Saulo Belli',' 2020-07-19',5387),
(201951,' Saulo Falcirolli',' 2020-05-20',4730),
(201952,' TimÃ³teo Bourn',' 2020-11-13',3149),
(201953,' Zilda Alves',' 2020-03-01',6343);

select * from funcionarios;