package controller;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Perfil;

public class CtrlListaPerfiles {

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
}
