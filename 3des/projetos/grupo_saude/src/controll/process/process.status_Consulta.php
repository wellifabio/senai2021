<?php

	require("../../domain/connection.php");
	require("../../domain/status_consulta.php");

	class Status_ConsultaProcess {
		var $sd;

		function doGet($arr){
			$sd = new Status_ConsultaDAO();
			$result = "use to result to DAO";
			http_response_code(200);
			echo json_encode($result);
		}


		function doPost($arr){
			$sd = new Status_ConsultaDAO();
			$result = "use to result to DAO";
			http_response_code(200);
			echo json_encode($result);
		}


		function doPut($arr){
			$sd = new Status_ConsultaDAO();
			$result = "use to result to DAO";
			http_response_code(200);
			echo json_encode($result);
		}


		function doDelete($arr){
			$sd = new Status_ConsultaDAO();
			$result = "use to result to DAO";
			http_response_code(200);
			echo json_encode($result);
		}
	}