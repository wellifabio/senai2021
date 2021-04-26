<?php

	require("../../domain/connection.php");
	require("../../domain/usuario.php");

	class UsuarioProcess {
		var $ud;

		function doGet($arr){
			$ud = new UsuarioDAO();
			$result = "use to result to DAO";
			http_response_code(200);
			echo json_encode($result);
		}


		function doPost($arr){
			$ud = new UsuarioDAO();
			$result = "use to result to DAO";
			http_response_code(200);
			echo json_encode($result);
		}


		function doPut($arr){
			$ud = new UsuarioDAO();
			$result = "use to result to DAO";
			http_response_code(200);
			echo json_encode($result);
		}


		function doDelete($arr){
			$ud = new UsuarioDAO();
			$result = "use to result to DAO";
			http_response_code(200);
			echo json_encode($result);
		}
	}