<%@page import="controllers.ProdutoUtil"%>
<%@page import="controllers.ProdutoProcess"%>
<%@page import="domains.Produto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./crud.css">
<link rel="shortcut icon" href="./assets/icon.png">
<title>Estoque de produtos</title>
</head>
<body>
	<%
	//Abre o arquivo CSV com todos os dados
	ProdutoProcess.abrir();
	String id, nome, descricao, valor, quantidade;
	String acao = request.getParameter("acao");
	Produto produto = ProdutoUtil.getAleatorio();
	String botao = "Novo";
	String escondido = "create";

	if (acao != null) {
		switch (acao) {
		case "create":
			//Caso a ação seja "create" recebe os dados da requisição "request"
			id = request.getParameter("id");
			nome = request.getParameter("nome");
			descricao = request.getParameter("descricao");
			valor = request.getParameter("valor");
			quantidade = request.getParameter("quantidade");
			//Adiciona o novo produto na lista
			ProdutoProcess.produtos.add(new Produto(id, nome, descricao, valor, quantidade));
			ProdutoProcess.salvar(); //Salva no arquivo CSV
			response.sendRedirect("crud.jsp"); //Recarrega a página
			break;
		case "del":
			//Caso a ação seja "del" cria um novo produto só com o id para servir de índice
			produto = new Produto(request.getParameter("id"));
			//Remove o produto da lista utilizando o índice
			ProdutoProcess.produtos.remove(ProdutoProcess.produtos.indexOf(produto));
			ProdutoProcess.salvar(); //Salva no arquivo a lista sem o produto excluído
			response.sendRedirect("crud.jsp"); //Recarrega a página
			break;
		case "up":
			//Caso a ação seja UP o que queremos é apenas preencher o formulário
			produto = new Produto(request.getParameter("id")); //Para servir de índice
			//Obtém os outros dados do produto na lista para preencher o formulário de alteração
			produto = ProdutoProcess.produtos.get(ProdutoProcess.produtos.indexOf(produto));
			//Altera o botão do formulário de "Novo" para "Alterar" e a ação escondida passa a ser alter
			botao = "Alterar";
			escondido = "alter";
			break;
		case "alter":
			//Caso a ação seja "alter" recebe os dados da requisição "request"
			id = request.getParameter("id");
			nome = request.getParameter("nome");
			descricao = request.getParameter("descricao");
			valor = request.getParameter("valor");
			quantidade = request.getParameter("quantidade");
			//Configura o produto com os novos dados
			produto = new Produto(id, nome, descricao, valor, quantidade);
			//Realiza a alteração na lista
			ProdutoProcess.produtos.set(ProdutoProcess.produtos.indexOf(produto), produto);
			ProdutoProcess.salvar();//Salva no arquivo a lista sem o produto excluído
			response.sendRedirect("crud.jsp");//Recarrega a página
			break;
		default:
			break;
		}
	}
	%>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Descrição</th>
				<th>Valor</th>
				<th>Qtd</th>
				<th rowspan="2">Subtotal</th>
				<th colspan="2">Ações</th>
			</tr>
			<tr>
				<form>
				<th><input type="number" name="id" value="<%=produto.getId()%>"	readonly /></th>
				<th><input type="text" name="nome" value="<%=produto.getNome()%>" required /></th>
				<th><input type="text"	name="descricao" value="<%=produto.getDescricao()%>" required /></th>
				<th><input type="number" step="any" name="valor" value="<%=produto.getValor()%>" required /></th>
				<th><input type="number" name="quantidade" value="<%=produto.getQuantidade()%>" required /></th>
				<input type="hidden" name="acao" value="<%=escondido%>" />
				<th colspan="2"><input type="submit" value="<%=botao%>" /></th>
				</form>
			</tr>
		</thead>
		<tbody>
			<%
			//Lista todos os dados
			for (Produto p : ProdutoProcess.produtos) {
				out.print("<tr>"); //Inicia a linha da tabela
				out.print(p.toHTML()); //Mostra os dados do produto nas primeiras colunas
				out.print("<td><form>");//Acrescenta uma columa com um formulário para excluir
				out.print("<input type='hidden' name='acao' value='del'/>");//Campo oculto com a acao del
				out.print("<input type='hidden' name='id' value='" + p.getId() + "'/>");//Campo oculto com o id
				out.print("<input type='submit' value=' - '/>");//Botão para enviar os dados deste pequeno formulário
				out.print("</form></td>");//Termina o formulário e a coluna
				out.print("<td><form>");//Acrescenta mais uma coluna com o formulário para alterar
				out.print("<input type='hidden' name='acao' value='up'/>");//Campo oculto com acao up
				out.print("<input type='hidden' name='id' value='" + p.getId() + "'/>");//Campo oculto com o id
				out.print("<input type='submit' value=' * '/>");//Botão para enviar os dados deste pequeno formulário
				out.print("</form></td>");//Termina o formulário e a coluna
				out.print("</tr>");//Termina a lina
			}
			%>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5"><p>Total geral em estoque:</p></td>
				<td colspan="3"><%=String.format("R$ %.2f",ProdutoProcess.total())%></td>
			</tr>
		</tfoot>
	</table>
</body>
</html>