package com.momoca.view;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import javax.swing.ImageIcon;

public class Imagem {
	private HashMap<String, ImageIcon> imagens = new HashMap<String, ImageIcon>();
	private ImageIcon imagem;

	public void addImagem(String chave, String caminho) {
		imagem = new ImageIcon(caminho);
		carregarImagens();
		imagens.put(chave, imagem);
		gravarImagens();
	}

	public void gravarImagens() {
		try {
			FileOutputStream outPut = new FileOutputStream(
					"arquivos/imagens.data");
			ObjectOutputStream oos = new ObjectOutputStream(outPut);
			oos.writeObject(imagens);
			oos.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}

	public void carregarImagens() {
		try {
			FileInputStream fis = new FileInputStream("arquivos/imagens.data");
			ObjectInputStream ois = new ObjectInputStream(fis);
			imagens = (HashMap<String, ImageIcon>) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ImageIcon getImagem(String chave) {
		carregarImagens();
		return imagens.get(chave);
	}
}