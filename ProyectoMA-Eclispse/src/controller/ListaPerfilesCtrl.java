package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import logic.ConexionPHP;
import model.Perfil;
import utils.Data;
import utils.GUI;
import view.FrmListaPerfiles;

public class ListaPerfilesCtrl {

	public static List<Perfil> resultado;

	public static void loadData() {
		try {
			String url = Data.URL + "/getUsers.php";
			String respuesta = ConexionPHP.peticionHttp(url);

			resultado = ConexionPHP.JsonToPerfiles(respuesta);

			DefaultTableModel modelo = GUI.generarTablaPerfiles(resultado);

			FrmListaPerfiles.tblResult.setModel(modelo);

			// Ocultar la columna 0 que contiene la pk
			FrmListaPerfiles.tblResult.getColumnModel().getColumn(0).setMinWidth(0);
			FrmListaPerfiles.tblResult.getColumnModel().getColumn(0).setMaxWidth(0);
			FrmListaPerfiles.tblResult.getColumnModel().getColumn(0).setWidth(0);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + e.getMessage(), "Error cargando los datos",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void confirmExit() {
		if (JOptionPane.showConfirmDialog(FrmListaPerfiles.contentPane, "¿Seguro que desea salir?", "Confirmar salida",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public static void textoAyuda() {

		JOptionPane.showMessageDialog(FrmListaPerfiles.contentPane, leerFichero("archivos\\Ayuda.txt"));
	}

	public static void textoAcercaDe() {

		JOptionPane.showMessageDialog(FrmListaPerfiles.contentPane, leerFichero("archivos\\AcercaDe.txt"));
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
		} catch (FileNotFoundException e) {
			System.err.println("No se encuentra el fichero " + FILE_NAME);
		} catch (IOException e) {
			System.err.println("Error accediendo al fichero " + FILE_NAME);
		}

		return contenido;
	}
}
