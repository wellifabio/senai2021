package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	//Atributos para Conexão com o Banco de dados
	private static String dns = "jdbc:mysql://localhost:3306/receitas";
	private static String usuario = "root";
	private static String senha = "";
	private static Connection con;

	public static Connection getConnection() {
		try {
			if (con == null || con.isClosed()) {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				con = DriverManager.getConnection(dns, usuario, senha);
			}
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}