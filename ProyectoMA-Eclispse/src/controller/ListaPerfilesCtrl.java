package controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Perfil;
import utils.GUI;
import view.FrmListaPerfiles;

public class ListaPerfilesCtrl {

	public static void tableRowSelected() {
		new view.FrmListaPerfiles();
	}

	public static void loadData() {		
		try {
			String url = "https://preyectoma.000webhostapp.com/getUsers.php";
			String respuesta = ConexionPHP.peticionHttp(url);

			List<Perfil> resultado = ConexionPHP.JsonToPerfiles(respuesta);

			DefaultTableModel modelo = GUI.generarTablaPerfiles(resultado);

			System.out.println("--- A ---");
			FrmListaPerfiles.tblResult.setModel(modelo);
			System.out.println("--- B ---");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+e.getMessage(), "Error cargando los datos", JOptionPane.ERROR_MESSAGE);
			
			//Eliminar al arreglar el error
			System.err.println("Fallo: "+e.getMessage());
		}
	}

	public static void confirmExit() {
		if (JOptionPane.showConfirmDialog(FrmListaPerfiles.contentPane, "¿Seguro que desea salir?", "Confirmar salida",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}
