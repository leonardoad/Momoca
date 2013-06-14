package com.momoca.conexao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JOptionPane;

public class Conexao {

	private String driver;
	private static Connection conexao;
	public Statement statement;
	public ResultSet resultSet;

	public static Connection getConexao() throws Exception {

		String fileName = "databaseSettings.properties";
		File file = new File(System.getProperty("user.dir") + "/src/utilitarios/" + fileName);

		try {
			Properties settings = new Properties();
	        settings.load(new FileInputStream(file));
	        
	        String driver = settings.getProperty("driver");
	        String host = settings.getProperty("host");
	        String port = settings.getProperty("port");
	        String database = settings.getProperty("database");
	        String usuario = settings.getProperty("usuario");
	        String senha = settings.getProperty("senha");
	        
	        String url = "jdbc:mysql://" + host + ":" + port + "/" + database;

			conexao = DriverManager.getConnection(url, usuario, senha);

		} catch (Exception e) {
			throw new Exception("Problema na conexao com o banco de dados");
        }

		return conexao;
	}

	public void desconecta() {
		try {
			conexao.close();
			JOptionPane.showMessageDialog(null, "Banco fechado");
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null,
					"Não foi possivel fechar o banco de dados: " + erro);
		}
	}

	public void executarSQL(String sql) {
		try {
			statement = conexao
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
			resultSet = statement.executeQuery(sql);

		} catch (SQLException sqlex) {
			JOptionPane.showMessageDialog(null,
					"NÃ£o foi possivel executar o comando SQL: " + sqlex
							+ ", o sql passado foi " + sql);
		}
	}

}