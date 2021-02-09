package controller;

import javax.swing.JOptionPane;

import logic.ConexionPHP;
import utils.Data;
import view.FrmCrearTipo;

public class CrearTipoCtrl {

	
	
	public static void addTipo() {
		try {
			String newTipo = FrmCrearTipo.txtNuevoTipo.getText().toString();

			String url = Data.URL + "/insert1Tipo.php?tipo=" + newTipo;

			ConexionPHP.peticionHttp(url);


		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + e.getMessage(), "Error añadiendo un perfil",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	

}
