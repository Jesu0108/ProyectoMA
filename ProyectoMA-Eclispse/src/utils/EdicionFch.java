package utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import model.Perfil;

public class EdicionFch {

	public static void genBinario(String correo, String pass) {

		try {
			ObjectOutputStream oStream = new ObjectOutputStream(new FileOutputStream(Data.fchBin));

			oStream.writeObject(new Perfil(correo, pass));

			oStream.close();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + e.getMessage(), "Generando bin",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static List<Perfil> leerBin() {

		List<Perfil> lst = new ArrayList<Perfil>();

		try {
			ObjectInputStream oStream = new ObjectInputStream(new FileInputStream(Data.fchBin));

			Perfil obj = (Perfil) oStream.readObject();

			lst.add((Perfil) obj);

			oStream.close();

		} catch (IOException | ClassNotFoundException e) {

			JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + e.getMessage(), "Leyendo bin",
					JOptionPane.ERROR_MESSAGE);
		}

		return lst;
	}

	public static String leerFichero(String FILE_NAME) {

		String contenido = "";
		FileReader fch;
		try {

			fch = new FileReader(FILE_NAME);
			BufferedReader lectura = new BufferedReader(fch);
			String lineaLeida = lectura.readLine();

			while (lineaLeida != null) {
				contenido += lineaLeida + "\n";
				lineaLeida = lectura.readLine();
			}

			lectura.close();
			fch.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + e.getMessage(), "Leyendo Fch",
					JOptionPane.ERROR_MESSAGE);
		}

		return contenido;
	}

	public static void escribirFch(String fch_Target, JTextArea textArea) {
		String sCaracter;

		try {
			FileWriter fch = new FileWriter(fch_Target);

			sCaracter = textArea.getText();

			if (sCaracter != null) {
				fch.write(sCaracter);
			} else {
				JOptionPane.showMessageDialog(null, "No hay cambios que guardar", "Sin cambios",
						JOptionPane.INFORMATION_MESSAGE);
			}

			fch.close();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + e.getMessage(), "Escribiendo Fch",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
