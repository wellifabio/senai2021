-- 1 Mostre todos os clientes;
select * from cliente;
-- 2 Mostre somente os 10 últimos clientes;
select * from cliente
order by cliente_id desc
limit 10;
-- 3 Mostre somente os clientes que possuem como referência "supermercado"
select * from cliente where referencia like "suermercado";
-- 4 corrija as referêcias "suermercado" para "supermercado"
update cliente set referencia = "supermercado"
where referencia like "suermercado";
select * from cliente where referencia like "supermercado";
-- 5 Mostre todos os telefones dos clientes
select * from telefone;
-- 6 Mostre os clientes e os telefones juntos
-- left join
-- right join
-- inner join
-- outer join

select * from cliente inner join telefone
on cliente.cliente_id = telefone.cliente_id;