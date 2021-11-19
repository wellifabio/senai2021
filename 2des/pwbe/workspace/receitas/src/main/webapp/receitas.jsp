<%@page import="model.Receita"%>
<%@page import="dao.ReceitaDAO"%>
<%@page import="controll.Mensagem"%>
<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Receitas</title>
</head>
<body>
	<div>
		<form method="post" action="procreceitas"
			enctype="multipart/form-data">
			<input type="hidden" name="action" value="create" /> <input
				type="text" name="nome" placeholder="Nome" />
			<textarea name="ingredientes" placeholder="Ingredientes" rows="6"
				cols="50"></textarea>

			<textarea name="modo_de_fazer" placeholder="Modo de Fazer" rows="6"
				cols="50"></textarea>
			<input type="file" name="foto" /> <input type="submit"
				value="Enviar" />
		</form>
	</div>
	<div>
		<%
		if (!Mensagem.getMensagens().isEmpty()) {
			out.print(Mensagem.getMensagem());
		} else {
			out.print("Aguardando alguma ação");
		}
		%>
	</div>
	<div>
		<table>
			<thead>
				<th>Id</th>
				<th>Nome</th>
				<th>Ingredientes</th>
				<th>Modo de Fazer</th>
				<th>Foto</th>
				<th>Alterar</th>
				<th>Excluir</th>
			</thead>
			<tbody>
				<%
				ReceitaDAO rd = new ReceitaDAO();
				for (Receita l : rd.list()) {
				%>
				<tr>
					<form method="post" action="procreceitas"
						enctype="multipart/form-data">
						<input type="hidden" name="action" value="update" />
						<td><input type="number" name="id" value="<%=l.getId()%>" /></td>
						<td><input type="text" name="nome" value="<%=l.getNome()%>" /></td>
						<td><textarea name="ingredientes" rows="6"><%=l.getIngredientes()%></textarea></td>
						<td><textarea name="modo_de_fazer" rows="6"><%=l.getModoDeFazer()%></textarea></td>
						<td><img src="imagem?id=<%=l.getId()%>" width="200px"></td>
						<td><input type="file" name="foto" /></td>
						<td><input type="submit" value=" * " /></td>
					</form>
					<form method="post" action="procreceitas" enctype="multipart/form-data">
						<input type="hidden" name="action" value="delete" /> <input
							type="hidden" name="id" value="<%=l.getId()%>" />
						<td><input type="submit" value=" - " /></td>
					</form>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>