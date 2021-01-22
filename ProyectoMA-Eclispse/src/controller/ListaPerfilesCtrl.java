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
			String url = "http://jesusmedac.tk/getUsers.php";
			String respuesta = ConexionPHP.peticionHttp(url);
			
			List<Perfil> resultado = controller.ConexionPHP.JsonToPerfiles(respuesta);
			
			DefaultTableModel modelo = utils.GUI.generarTablaPerfiles(resultado);
			
//			for (Perfil perfil : resultado) {
//				
//				System.out.println(perfil);
//			}
			
			System.out.println("--- A ---");
			System.out.println(modelo.getColumnName(1));
			view.FrmListaPerfiles.tblResult.setModel(modelo);
			System.out.println("--- B ---");
			
		} catch (Exception e) {
			System.err.println("Fallo: " + e.getMessage());
			e.getStackTrace();
		}
	}

	public static void confirmExit() {
		if(JOptionPane.showConfirmDialog(FrmListaPerfiles.contentPane, "¿Seguro que desea salir?",null, 2) == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}
