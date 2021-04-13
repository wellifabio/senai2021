DROP DATABASE IF EXISTS ecosistema;

CREATE DATABASE ecosistema;

USE ecosistema;

CREATE TABLE status_chamado (
  id INTEGER   NOT NULL  AUTO_INCREMENT,
  status_cha VARCHAR(16)   NOT NULL   ,
PRIMARY KEY(id));

CREATE TABLE materiais (
  id INTEGER   NOT NULL AUTO_INCREMENT ,
  nome VARCHAR(32)   NOT NULL ,
  cor VARCHAR(32)   NOT NULL   ,
PRIMARY KEY(id));




CREATE TABLE usuarios (
  id INTEGER   NOT NULL  AUTO_INCREMENT,
  nome VARCHAR(64)   NOT NULL ,
  celular VARCHAR(14)   NOT NULL ,
  rua VARCHAR(64)   NOT NULL ,
  numero VARCHAR(8)   NOT NULL ,
  bairro VARCHAR(64)   NOT NULL ,
  cidade VARCHAR(64)   NOT NULL ,
  uf VARCHAR(2)   NOT NULL ,
  cpf VARCHAR(11)   NOT NULL   ,
PRIMARY KEY(id));

CREATE TABLE tipos_logins (
  id INTEGER   NOT NULL  AUTO_INCREMENT,
  tipo VARCHAR(32)   NOT NULL   ,
PRIMARY KEY(id));

CREATE TABLE cooperativas (
  id INTEGER NOT NULL AUTO_INCREMENT,
  nome VARCHAR(130) ,
PRIMARY KEY(id));

CREATE TABLE porta_a_porta (
  id INTEGER   NOT NULL  AUTO_INCREMENT,
  cooperativas_id INTEGER   NOT NULL ,
  descricao VARCHAR(256)   NOT NULL ,
  lat DECIMAL(11,7)   NOT NULL ,
  longi DECIMAL(11,7)   NOT NULL   ,
PRIMARY KEY(id)  ,
  FOREIGN KEY(cooperativas_id)
    REFERENCES cooperativas(id));


CREATE INDEX porta_a_porta_FKIndex1 ON porta_a_porta (cooperativas_id);


CREATE INDEX IFK_Rel_16 ON porta_a_porta (cooperativas_id);


CREATE TABLE veiculos (
  id INTEGER   NOT NULL  AUTO_INCREMENT,
  cooperativas_id INTEGER   NOT NULL ,
  placa VARCHAR(8)   NOT NULL ,
  modelo VARCHAR(32)   NOT NULL ,
  marca VARCHAR(16)   NOT NULL ,
  capacidade_carga_kg INTEGER   NOT NULL   ,
PRIMARY KEY(id)  ,
  FOREIGN KEY(cooperativas_id)
    REFERENCES cooperativas(id));


CREATE INDEX veiculos_FKIndex1 ON veiculos (cooperativas_id);


CREATE INDEX IFK_Rel_20 ON veiculos (cooperativas_id);


CREATE TABLE ecopontos (
  id INTEGER   NOT NULL  AUTO_INCREMENT,
  cooperativas_id INTEGER   NOT NULL ,
  nome VARCHAR(32)   NOT NULL ,
  descricao VARCHAR(256)   NOT NULL ,
  lat DECIMAL(11,7)   NOT NULL ,
  longi DECIMAL(11,7)   NOT NULL   ,
PRIMARY KEY(id)  ,
  FOREIGN KEY(cooperativas_id)
    REFERENCES cooperativas(id));


CREATE INDEX ecopontos_FKIndex1 ON ecopontos (cooperativas_id);


CREATE INDEX IFK_Rel_15 ON ecopontos (cooperativas_id);


CREATE TABLE ecopontos_has_materiais (
  ecopontos_id INTEGER   NOT NULL ,
  materiais_id INTEGER   NOT NULL   ,
PRIMARY KEY(ecopontos_id, materiais_id)    ,
  FOREIGN KEY(ecopontos_id)
    REFERENCES ecopontos(id),
  FOREIGN KEY(materiais_id)
    REFERENCES materiais(id));


CREATE INDEX Ecopontos_has_Materiais_FKIndex1 ON ecopontos_has_materiais (ecopontos_id);
CREATE INDEX Ecopontos_has_Materiais_FKIndex2 ON ecopontos_has_materiais (materiais_id);


CREATE INDEX IFK_Rel_06 ON ecopontos_has_materiais (ecopontos_id);
CREATE INDEX IFK_Rel_07 ON ecopontos_has_materiais (materiais_id);


CREATE TABLE logins (
  id INTEGER   NOT NULL  AUTO_INCREMENT,
  usuarios_id INTEGER   NOT NULL ,
  tipos_logins_id INTEGER   NOT NULL ,
  senha VARCHAR(32)   NOT NULL   ,
PRIMARY KEY(id)    ,
  FOREIGN KEY(tipos_logins_id)
    REFERENCES tipos_logins(id),
  FOREIGN KEY(usuarios_id)
    REFERENCES usuarios(id));


CREATE INDEX logins_FKIndex1 ON logins (tipos_logins_id);
CREATE INDEX logins_FKIndex2 ON logins (usuarios_id);


CREATE INDEX IFK_Rel_01 ON logins (tipos_logins_id);
CREATE INDEX IFK_Rel_02 ON logins (usuarios_id);


CREATE TABLE ecopontos_has_veiculos (
  ecopontos_id INTEGER   NOT NULL ,
  veiculos_id INTEGER   NOT NULL ,
  dia_horario DATETIME   NOT NULL   ,
PRIMARY KEY(ecopontos_id, veiculos_id)    ,
  FOREIGN KEY(ecopontos_id)
    REFERENCES ecopontos(id),
  FOREIGN KEY(veiculos_id)
    REFERENCES veiculos(id));


CREATE INDEX Ecopontos_has_veiculos_FKIndex1 ON ecopontos_has_veiculos (ecopontos_id);
CREATE INDEX Ecopontos_has_veiculos_FKIndex2 ON ecopontos_has_veiculos (veiculos_id);


CREATE INDEX IFK_Rel_10 ON ecopontos_has_veiculos (ecopontos_id);
CREATE INDEX IFK_Rel_11 ON ecopontos_has_veiculos (veiculos_id);


CREATE TABLE chamados_autonomos (
  id INTEGER   NOT NULL  AUTO_INCREMENT,
  usuarios_autonomo_id INTEGER    ,
  usuarios_solicitante_id INTEGER    ,
  status_chamado_id INTEGER   NOT NULL ,
  lat DECIMAL(11,7)   NOT NULL ,
  longi DECIMAL(11,7)   NOT NULL ,
  dia_horario DATETIME   NOT NULL   ,
PRIMARY KEY(id)      ,
  FOREIGN KEY(usuarios_autonomo_id)
    REFERENCES usuarios(id),
  FOREIGN KEY(status_chamado_id)
    REFERENCES status_chamado(id),
  FOREIGN KEY(usuarios_solicitante_id)
    REFERENCES usuarios(id));


CREATE INDEX chamados_autonomos_FKIndex1 ON chamados_autonomos (usuarios_autonomo_id);
CREATE INDEX chamados_autonomos_FKIndex2 ON chamados_autonomos (status_chamado_id);
CREATE INDEX chamados_autonomos_FKIndex3 ON chamados_autonomos (usuarios_solicitante_id);


CREATE INDEX IFK_Rel_05 ON chamados_autonomos (usuarios_autonomo_id);
CREATE INDEX IFK_Rel_14 ON chamados_autonomos (status_chamado_id);
CREATE INDEX IFK_Rel_17 ON chamados_autonomos (usuarios_solicitante_id);


CREATE TABLE rotas (
  id INTEGER   NOT NULL  AUTO_INCREMENT,
  veiculos_id INTEGER   NOT NULL ,
  nome VARCHAR(50)   NOT NULL ,
  dia_horario DATETIME   NOT NULL   ,
PRIMARY KEY(id)  ,
  FOREIGN KEY(veiculos_id)
    REFERENCES veiculos(id));


CREATE INDEX rotas_FKIndex1 ON rotas (veiculos_id);


CREATE INDEX IFK_Rel_21 ON rotas (veiculos_id);


CREATE TABLE pontos (
  id INTEGER   NOT NULL  AUTO_INCREMENT,
  rotas_id INTEGER   NOT NULL ,
  lat DECIMAL(11,7)    ,
  longi DECIMAL(11,7)      ,
PRIMARY KEY(id)  ,
  FOREIGN KEY(rotas_id)
    REFERENCES rotas(id));


CREATE INDEX pontos_FKIndex1 ON pontos (rotas_id);


CREATE INDEX IFK_Rel_22 ON pontos (rotas_id);


CREATE TABLE chamados_autonomos_has_materiais (
  chamados_autonomos_id INTEGER   NOT NULL ,
  materiais_id INTEGER   NOT NULL   ,
PRIMARY KEY(chamados_autonomos_id, materiais_id)    ,
  FOREIGN KEY(chamados_autonomos_id)
    REFERENCES chamados_autonomos(id),
  FOREIGN KEY(materiais_id)
    REFERENCES materiais(id));


CREATE INDEX chamados_autonomos_has_Materiais_FKIndex1 ON chamados_autonomos_has_materiais (chamados_autonomos_id);
CREATE INDEX chamados_autonomos_has_Materiais_FKIndex2 ON chamados_autonomos_has_materiais (materiais_id);


CREATE INDEX IFK_Rel_08 ON chamados_autonomos_has_materiais (chamados_autonomos_id);
CREATE INDEX IFK_Rel_09 ON chamados_autonomos_has_materiais (materiais_id);



