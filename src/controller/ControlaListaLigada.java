package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import ListasLigadas.ListaLigada;

public class ControlaListaLigada {
    public static Vector lerFicheiro(String filename) {
		try {
			
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename));
			Vector<ListaLigada> vector2 = (Vector<ListaLigada>) inputStream.readObject();
			inputStream.close();
			System.out.println("Ficheiro lido");
			return vector2;
		} catch (Exception e) {
			System.out.println("Erro ao ler ficheiro");
		}
		return null;
	}
    
    public static void escreverFicherio(String fileName, Vector vector) {
		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
			outputStream.writeObject(vector);
			outputStream.close();
			System.out.println("Ficheiro escrito");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
