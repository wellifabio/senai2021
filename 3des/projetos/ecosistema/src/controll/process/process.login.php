<?php

	require("../../domain/connection.php");
	require("../../domain/login.php");

	class LoginProcess {
		var $ld;

		function doGet($arr){
			$ld = new LoginDAO();
			$result = "use to result to DAO";
			http_response_code(200);
			echo json_encode($result);
		}


		function doPost($arr){
			if(
				isset($arr["document"]) &&
				isset($arr["password"])
			) {
				$l = new Login();

				$l->setUser($arr["document"]);
				$l->setPassword($arr["password"]);

				$ld = new LoginDAO();

				$result = $ld->read($l);
			}else {
				$result["status"] = "C003";
			}
			http_response_code(200);
			echo json_encode($result);
		}


		function doPut($arr){
			$ld = new LoginDAO();
			$result = "use to result to DAO";
			http_response_code(200);
			echo json_encode($result);
		}


		function doDelete($arr){
			$ld = new LoginDAO();
			$result = "use to result to DAO";
			http_response_code(200);
			echo json_encode($result);
		}
	}