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
			List<Perfil> resultado = logic.LogPerfiles.getPerfiles();
			DefaultTableModel modelo = utils.GUI.generarTablaPerfiles(resultado);
			view.FrmListaPerfiles.tblResult.setModel(modelo);
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
