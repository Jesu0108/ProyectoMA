package controller;

import javax.swing.JOptionPane;

import logic.ConexionPHP;
import model.Perfil;
import utils.Data;
import view.FrmPrincipal;

public class PrincipalCtrl {

	public static boolean checkLogin() {
		boolean bExito = false;
		Perfil perfilLog = new Perfil();
		String sCorreo, sContra;

		sCorreo = FrmPrincipal.correo;
		sContra = FrmPrincipal.pass;
		
		try {
			String url = Data.URL+"/getUserCorreo.php?correo="+sCorreo+"&contrasenia="+sContra;
			String respuesta = ConexionPHP.peticionHttp(url);

			perfilLog = ConexionPHP.JsonToPerfilLog(respuesta);

			if (perfilLog == null) {
				bExito = false;
			} else {
				bExito = true;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+e.getMessage(), "Error de login", JOptionPane.ERROR_MESSAGE);
		}
		return bExito;
	}

	public static void borrarCampos() {
		FrmPrincipal.txtUsuario.setText("");
		FrmPrincipal.txtContra.setText("");
	}

	public static void confirmExit() {
		if (JOptionPane.showConfirmDialog(FrmPrincipal.contentPane, "¿Seguro que desea salir?", "Confirmar salida",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}
