package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import logic.ConexionPHP;
import model.Perfil;
import view.FrmPrincipal;

public class PrincipalCtrl {

	public static boolean checkLogin() {
		boolean bExito = false;
		List<Perfil> lstPerfiles = new ArrayList<Perfil>();
		String sCorreo, sContra;

		sCorreo = FrmPrincipal.user;
		sContra = FrmPrincipal.pass;
		
		try {
			String url = "https://preyectoma.000webhostapp.com/getUserCorreo.php?correo="+sCorreo+"&contrasenia="+sContra;
			String respuesta = ConexionPHP.peticionHttp(url);

			lstPerfiles = ConexionPHP.JsonToPerfilesLog(respuesta);

			if (lstPerfiles.isEmpty()) {
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
