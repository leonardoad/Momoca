package com.momoca.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.momoca.conexao.Conexao;
import com.momoca.model.Usuario;

public class UsuarioDao {

	private Connection con;
	private Usuario usuarios;

	public UsuarioDao() throws Exception {
		this.con = Conexao.getConexao();
	}

	/**
	 * MÉTODO DE INSERÇÃO DE CONTATO
	 * 
	 * @param cl
	 * @throws SQLException
	 */
	public void adicionaUsuario(Usuario u) throws SQLException {
		// prepara a conexão
		String sql = "Insert into usuarios(nome,senha)" + " values (?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			// seta os valores
			stmt.setString(1, u.getNome());
			stmt.setString(2, u.getSenha());

			// exucuta o codigo sql
			stmt.execute();

			System.out.println("Usuario adicionado com sucesso");
		} catch (SQLException e) {
			System.out.println("Usuario não adicionado");
		} finally {

			stmt.close();
		}
	}

	/*
	 * MÉTODO DE RECUPERAÇÃO DE UM USUÁRIO
	 */

	public Usuario getRetornaUsuario(String nome, String senha)
			throws SQLException {

		Usuario usuarioEncontrado = null;
		String sql = "SELECT * FROM usuarios WHERE ( nome = ? AND senha = ?)";

		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			// seta os valores
			stmt.setString(1, nome);
			stmt.setString(2, senha);

			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				usuarioEncontrado = new Usuario();
				usuarioEncontrado.setNome(rs.getString("nome"));
				usuarioEncontrado.setSenha(rs.getString("senha"));
				System.out.println("usuario encontrado");
			} else {
				System.out.println("usuario não encontrado");
			}

		} catch (SQLException e) {
			e.getMessage();
		} finally {

			stmt.close();
			System.out.println("desconectado");
		}
		if(usuarioEncontrado != null){
			return usuarioEncontrado;
		}else
			return null;
	
		

			

	}
}
