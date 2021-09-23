<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

	JSONObject obj = new JSONObject("{'id' : 5, 'nome':'Fulano'}");

	//out.print(obj.getInt("id") + " - " + obj.getString("nome") + "\n");

	JSONObject obj2 = new JSONObject();
	
	obj2.put("endereco", "rua sem saida");
	obj2.put("numero", 13);
	obj2.put("casado", false);

	JSONObject obj3 = new JSONObject();
	
	obj3.put("endereco", "rua dos pe junto");
	obj3.put("numero", 666);
	obj3.put("casado", true);

	JSONArray arr = new JSONArray();
	
	arr.put(obj2);
	arr.put(obj3);
	
	//out.print(arr.toString());
	
	//out.print(arr.get(1));
	
	out.print(arr.getJSONObject(1).getString("endereco"));
	
	arr.getJSONObject(1).put("numero", 23);
	
	out.print(arr.getJSONObject(1).getInt("numero"));
	
	JSONObject cliente = arr.getJSONObject(0);
	
	
%>
</body>
</html>