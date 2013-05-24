package ultilitarios;

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
	private Connection conexao;
	public Statement statement;
	public ResultSet resultSet;
	
	// connection settings
	// loaded from settings' file
	private String host;
	private String port;
	private String database;
	private String usuario;
	private String senha;
	private String fileName;

	public Conexao() {

		fileName = "databaseSettings.properties";
		File file = new File(System.getProperty("user.dir") + "/src/utilitarios/" + fileName);

		try {
			Properties settings = new Properties();
	        settings.load(new FileInputStream(file));
	        
	        driver = settings.getProperty("driver");
	        host = settings.getProperty("host");
	        port = settings.getProperty("port");
	        database = settings.getProperty("database");
	        usuario = settings.getProperty("usuario");
	        senha = settings.getProperty("senha");

		} catch (IOException ex) {
            System.out.println("N„o foi possÌvel ler o arquivo em " + file.getPath());
        }
	}

	public boolean conecta() {

		boolean resultado = true;
		String url = "jdbc:postgresql://" + host + ":" + port + "/" + database;

		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, usuario, senha);

		} catch (ClassNotFoundException driver) {
			JOptionPane.showMessageDialog(null, "Driver n√£o localizado: "
					+ driver);
			resultado = false;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Erro na conex√£o com a fonte de dados: " + e);
			resultado = false;
		}

		return resultado;
	}

	public void desconecta() {
		try {
			conexao.close();
			JOptionPane.showMessageDialog(null, "Banco fechado");
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null,
					"N„o foi possivel fechar o banco de dados: " + erro);
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
					"N√£o foi possivel executar o comando SQL: " + sqlex
							+ ", o sql passado foi " + sql);
		}
	}

}