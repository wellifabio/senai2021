<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="delivery.css">
<link rel="shortcut icon" href="./assets/icon.png">
<title>Altera Pedido</title>
</head>
<body>
	<div class="pedido">
		<form method="POST" action="registra.jsp" class="cadastro">
			<label>Cliente:</label><input type="text" id="cliente" name="cliente"> 
			<label>Endereço:</label><input type="text" id="endereco" name="endereco">
			<label>Produto:</label><select id="produto" name="produto">
			</select>
			<button type="submit"
				onclick="lancarPedido(), preencherForm(), obterAgora()">Gerar
				Pedido</button>
			<input type="text" id="agora" readonly="readonly">
		</form>
	</div>
</body>
</html>