<%@page import="vo.Bem"%>
<%@page import="ctr.BensProcess"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar todos os Bens (READ)</title>
</head>
<body>
	<table>
	<%
		BensProcess.abrir();
		for(Bem b: BensProcess.bens){
			out.print(b.toHTML());
		}
	%>
	</table>
</body>
</html>