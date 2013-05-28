package com.momoca.conexao;

	/**
	 * @author SLM
	 */
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class CriaConexao {

		public static Connection getConexao() throws SQLException {


				// Carregando o Driver JDBC (do RDBMS PostgreSQL)
				DriverManager.registerDriver(new org.postgresql.Driver());
				
				System.out.println("Conectando.....");
				return DriverManager.getConnection(
						"jdbc:postgresql://localhost:5432/Momoca", "postgres",
						"postgres");
			
		}
}
