<?php

	require("../../domain/connection.php");
	require("../../domain/agenda.php");

	class AgendaProcess {
		var $ad;

		function doGet($arr){
			$ad = new AgendaDAO();
			$result = "use to result to DAO";
			http_response_code(200);
			echo json_encode($result);
		}


		function doPost($arr){
			$ad = new AgendaDAO();
			$result = "use to result to DAO";
			http_response_code(200);
			echo json_encode($result);
		}


		function doPut($arr){
			$ad = new AgendaDAO();
			$result = "use to result to DAO";
			http_response_code(200);
			echo json_encode($result);
		}


		function doDelete($arr){
			$ad = new AgendaDAO();
			$result = "use to result to DAO";
			http_response_code(200);
			echo json_encode($result);
		}
	}