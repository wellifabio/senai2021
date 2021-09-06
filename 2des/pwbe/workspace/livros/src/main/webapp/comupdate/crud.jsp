<%@page import="vo.Livro"%>
<%@page import="ctr.LivroProcess"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de livros</title>
<link rel="stylesheet" href="crud.css">
</head>
<body>
	<%
	//Recebendo os dados
	Livro livro;
	String id = request.getParameter("id");
	String autor = request.getParameter("autor");
	String titulo = request.getParameter("titulo");
	String preco = request.getParameter("preco");
	String acao = request.getParameter("acao");
	//Carregando os dados do arquivo
	LivroProcess.abrir();
	%>
	<div class="topo">
		<%
		if (acao == null) {
		%>
		<form>
			<label>Id</label><input type="number" name="id" required /> <label>Autor</label><input
				type="text" name="autor" required /> <label>Título</label><input
				type="text" name="titulo" required /> <label>Preço</label><input
				type="number" step="any" name="preco" required />
			<button type="submit">Enviar</button>
		</form>
		<%
		} else {
		livro = LivroProcess.livros.get(LivroProcess.livros.indexOf(new Livro(id)));
		%>
		<form>
			<label>Id</label><input type="number" name="id"
				value="<%=livro.getId()%>" required /> <label>Autor</label><input
				type="text" name="autor" value="<%=livro.getAutor()%>" required />
			<label>Título</label><input type="text" name="titulo"
				value="<%=livro.getTitulo()%>" required /> <label>Preço</label><input
				type="number" step="any" name="preco" value="<%=livro.getPreco()%>"
				required /> <input type='hidden' name='acao' value='edit' />
			<button type="submit">Atualizar</button>
		</form>
		<%
		}
		%>
	</div>
	<div class="msg">
		<%
		//Validando se chagaram todos os dados
		if (id != null && autor != null && titulo != null && preco != null && acao != null) {
			//Update
			livro = new Livro(id, autor, titulo, preco); //Preenche um novo modelo
			LivroProcess.livros.set(LivroProcess.livros.indexOf(livro), livro);
			LivroProcess.salvar();//Salva a lista no arquivo
			response.sendRedirect("crud.jsp");//Redireciona limpando o verbo GET	

		} else if (id != null && autor != null && titulo != null && preco != null) {
			//Create
			livro = new Livro(id, autor, titulo, preco); //Preenche um novo modelo
			if (LivroProcess.livros.contains(livro)) { //Verifica se não é duplicado
				out.print("Id duplicado"); //Da uma mensagem
			} else {//Se não for duplicado
				LivroProcess.livros.add(livro); //Adicona o livro na lista
				LivroProcess.salvar();//Salva a lista no arquivo
				response.sendRedirect("crud.jsp");//Redireciona limpando o verbo GET
			}
		} else {
			//Delete
			if (id != null && acao == "del") {
				LivroProcess.livros.remove(new Livro(id)); //Remove da lista
				LivroProcess.salvar(); //Salva a lista sem o item removido
				response.sendRedirect("crud.jsp");
			}
		}
		%>
	</div>
	<table>
		<tr>
			<th>Id</th>
			<th>Autor</th>
			<th>Título</th>
			<th>Preço</th>
			<th>Edit</th>
			<th>Del</th>
		</tr>
		<%
		//Listar todos
		for (Livro l : LivroProcess.livros) {
			out.print("<tr>");
			out.print(l.toHTML());
			out.print("<td>");
			out.print("<form>");
			out.print("<input type='hidden' name='acao' value='edit'/>");
			out.print("<input type='hidden' name='id' value='" + l.getId() + "'/>");
			out.print("<button type='submit'>Edit</button>");
			out.print("</form>");
			out.print("</td>");
			out.print("<td>");
			out.print("<form>");
			out.print("<input type='hidden' name='acao' value='del'/>");
			out.print("<input type='hidden' name='id' value='" + l.getId() + "'/>");
			out.print("<button type='submit'>Del</button>");
			out.print("</form>");
			out.print("</td>");
			out.print("</tr>");
		}
		%>
	</table>
</body>
</html>