package app;

import model.Perfil;
import utils.EdicionFch;
import view.FrmListaPerfiles;
import view.FrmPrincipal;

public class Inicio {
	public static void main(String[] args) {

		try {
			if (userPreferences()) {
				new FrmListaPerfiles();
			} else {
				FrmPrincipal frame = new FrmPrincipal();
				frame.setVisible(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean userPreferences() {
		boolean bExito;

		Perfil u = EdicionFch.leerBin().get(0);

		if (u.getsCorreo().equals("no") || u.getsContra().equals("no")) {
			bExito = false;
		} else {
			bExito = true;
		}

		return bExito;
	}
}