package controller;

import javax.swing.JOptionPane;

import view.FrmEdicionPerfil;

public class EdicionPerfilCtrl {

	public static void confirmExit() {
		if (JOptionPane.showConfirmDialog(FrmEdicionPerfil.contentPane, "¿Seguro que desea salir?", "Confirmar salida",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}
