package controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Perfil;
import view.FrmListaPerfiles;

public class ListaPerfilesCtrl {

	public static void tableRowSelected() {
		new view.FrmListaPerfiles();
	}

	public static void loadData() {
		try {
			String url = "https://preyectoma.000webhostapp.com/getUsers.php";
			String respuesta = ConexionPHP.peticionHttp(url);

			List<Perfil> resultado = controller.ConexionPHP.JsonToPerfiles(respuesta);

			DefaultTableModel modelo = utils.GUI.generarTablaPerfiles(resultado);

			System.out.println("--- A ---");
			view.FrmListaPerfiles.tblResult.setModel(modelo);
			System.out.println("--- B ---");

		} catch (Exception e) {
			System.err.println("Fallo: " + e.getMessage());
			e.getStackTrace();
		}
	}

	public static void confirmExit() {
		if (JOptionPane.showConfirmDialog(FrmListaPerfiles.contentPane, "¿Seguro que desea salir?", "Confirmar salida",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}
