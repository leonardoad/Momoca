package com.momoca.view;

import java.sql.SQLException;

import com.momoca.DAO.UsuarioDao;
import com.momoca.model.Usuario;

public class Teste {

	public static void main(String[] args) throws SQLException {
		
		Usuario u = new Usuario();
		u.setNome("leonardo");
		u.setSenha("5678");
		
		Usuario u2 = new Usuario();
		u2.setNome("fernando");
		u2.setSenha("8765");
		
		UsuarioDao usuario;
		try {
			usuario = new UsuarioDao();
			
			Usuario u3 = usuario.getRetornaUsuario("sergio", "1234");
			System.out.println(u3.getNome() + " " + u3.getSenha());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		usuario.adicionaUsuario(u);
//		usuario.adicionaUsuario(u2);
		
	}
}
