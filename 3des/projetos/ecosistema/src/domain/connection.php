<?php

	class Connection{
		public static $instance;

		public static function getInstance(){
			$url = "mysql:host=localhost;port=3306;dbname=ecosistema;";
			//$url = "mysql:host=localhost;port=3306;dbname=id15974124_ecosistema;";

			//$user = "id15974124_user";
			$user = "root";

			//$password = "VK_}BvAxnLTu=vr9";
			$password = "";

			$config = array(PDO::ATTR_PERSISTENT => true,PDO::ATTR_CASE => PDO::CASE_LOWER);

			if (!isset(self::$instance)) {
				self::$instance = new PDO($url,$user,$password,$config);

				self::$instance->setAttribute(PDO::ATTR_ORACLE_NULLS, PDO::NULL_EMPTY_STRING);
			}

			return self::$instance;
		}
	}