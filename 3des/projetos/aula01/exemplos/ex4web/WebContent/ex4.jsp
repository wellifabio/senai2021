<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exercício 4</title>
</head>
<body>
	<h3>Exercício 4</h3>
	<form method="POST" action="">
		<input type="text" name="numeros" placeholder="Digite os numeros" /><br />
		<input type="submit" value="Enviar" /><br />
	</form>
	<%
	if(request.getParameter("numeros") != null){
		String valores = request.getParameter("numeros");
		int par = 0, impar = 0;
		String result = "";
		String[] vetor = valores.split(" ");
		
		for(int i = 0; i < vetor.length; i++) {
			int saida = Integer.parseInt(vetor[i]) % 2;
			if(saida == 0) {
				par++;
			}else {
				impar++;
			}
		}
		
		if(par > 0) {
			if(par > 1) result += par+" pares ";
			else result += par+" par ";
		}
		
		if(impar > 0) {
			if(impar > 1) result += impar+" impares ";
			else result += impar+" impar ";
		}
		
		out.print(result);
	}
	%>
</body>
</html>