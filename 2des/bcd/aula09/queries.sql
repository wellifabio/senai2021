-- 1 Na tabela de pedidos Mostre apenas os 10 primeiros
describe pedidos;
select * from pedidos where id_pedido <= 10;
select * from pedidos limit 10;
-- 2 Mostre apenas os 10 últimos
select * from pedidos where id_pedido > 19;
select * from pedidos order by id_pedido desc limit 10;
-- 3 Mostre os pedidos por ordem de entregadores
select * from pedidos order by id_entregador;
-- 4 mostre apenas (id_entregador, data e id_cliente)
-- por erdem de entregadores
select id_entregador, data, id_cliente
from pedidos order by id_entregador;
-- 5 mostre id_entregador, data e id_cliente
-- e quantidade de pedidos por entregador
select id_entregador, data, id_cliente, count(id_pedido)
from pedidos group by id_entregador;

-- OBS: Funções
-- sum(coluna), count(coluna), min(coluna), max(coluna), avg(coluna)
-- curtime() data atual, curdate() hora atual

-- 6 Mostre mostre id_entregador, data e id_cliente
-- e o nome do entregador
select * from pedidos;
select nome_completo from entregadores;
-- Completo
select
    pedidos.id_entregador,
    pedidos.data,
    pedidos.id_cliente,
    entregadores.nome_completo
from pedidos inner join entregadores
on pedidos.id_entregador = entregadores.id_entregador;
-- Com apelido (alias)
select p.id_entregador, p.data, p.id_cliente, e.nome_completo
from pedidos p inner join entregadores e
on p.id_entregador = e.id_entregador;
-- Resumido versão Jack
select pedidos.id_entregador, data, id_cliente, nome_completo
from pedidos inner join entregadores
on pedidos.id_entregador = entregadores.id_entregador;

-- Join
-- inner join
-- left join
-- right join
-- outher join




