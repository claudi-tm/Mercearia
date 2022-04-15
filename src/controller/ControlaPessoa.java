package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import ListasLigadas.No;
import model.Pessoa;

public class ControlaPessoa {

    public static Vector lerFicheiro(String filename) {
		try {
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename));
			Vector<Pessoa> vector2 = (Vector<Pessoa>) inputStream.readObject();
			inputStream.close();
			return vector2;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
    
    public static void escreverFicherio(String fileName, Vector vector) {
		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
			outputStream.writeObject(vector);
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    /*public void removeCode(String id) throws Exception {
        No no = primeiro;
        Pessoa pessoa;
        for (int i = 0; i < totalElem; i++) {
            pessoa = (Pessoa) no.getElemento();
            if (pessoa.getId().equals(id)) {
                removePosicao(i);
                return;
            }
            no = no.getProximo();
        }
    }*/
}
