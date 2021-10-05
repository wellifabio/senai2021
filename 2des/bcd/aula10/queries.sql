-- 1 Juntar os Clientes e telefones
select * from cliente;
select * from telefone;

select cliente.*, telefone.telefone
from cliente inner join telefone
on cliente.cliente_id = telefone.cliente_id;

-- Como criar visões (Consultas salvas)
create view vw_clientes as
select c.*, t.telefone
from cliente c inner join telefone t
on c.cliente_id = t.cliente_id;

-- Como mostrar ou filtrar uma View
select * from vw_clientes;
select * from vw_clientes limit 10,10;
select * from vw_clientes where cliente_id = 5;

-- 2 O atributo referencia da tabela cliente_id
-- está preenchido de forma incorreta em alguns registros
-- "suermercado" corriga para "supermercado"
update cliente set referencia = "supermercado"
where referencia = "suermercado";
select * from cliente;
