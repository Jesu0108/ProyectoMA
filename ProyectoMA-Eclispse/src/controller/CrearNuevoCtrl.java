package controller;

import java.util.List;

import javax.swing.JOptionPane;

import logic.ConexionPHP;
import utils.Data;
import view.FrmCrearNuevo;

public class CrearNuevoCtrl {

	public static void addPerfil() {
		try {
			String correo = FrmCrearNuevo.txtNewCorreo.getText().toString().replace(" ", "%20");
			String usuario = FrmCrearNuevo.txtNewUsuario.getText().toString().replace(" ", "%20");
			String pass = FrmCrearNuevo.txtNewContra.getText().toString().replace(" ", "%20");
			String tipo = FrmCrearNuevo.spTipo.getSelectedItem().toString().replace(" ", "%20");
			String plato = FrmCrearNuevo.txtNewPlato.getText().toString().replace(" ", "%20");
			String pais = FrmCrearNuevo.txtNewPais.getText().toString().replace(" ", "%20");
			String localidad = FrmCrearNuevo.txtNewLocalidad.getText().toString().replace(" ", "%20");
			String telefono = FrmCrearNuevo.txtNewTelefono.getText().toString().replace(" ", "%20");
			
			String url = Data.URL + "/insert1User.php?correo=" + correo + "&usuario=" + usuario + "&contrasenia=" + pass
					+ "&tipo=" + tipo + "&plato=" + plato + "&pais=" + pais + "&localidad=" + localidad + "&telefono="
					+ telefono;

			ConexionPHP.peticionHttp(url);

			JOptionPane.showMessageDialog(null, "Perfil añadido con exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + e.getMessage(), "Error añadiendo un perfil",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void borrarCampos() {
		FrmCrearNuevo.txtNewCorreo.setText("");
		FrmCrearNuevo.txtNewUsuario.setText("");
		FrmCrearNuevo.txtNewContra.setText("");
		FrmCrearNuevo.txtNewPlato.setText("");
		FrmCrearNuevo.txtNewPais.setText("");
		FrmCrearNuevo.txtNewLocalidad.setText("");
		FrmCrearNuevo.txtNewTelefono.setText("");
	}
	
	@SuppressWarnings("unchecked")
	public static void addTipos() {

		try {
			String url = Data.URL + "/getTipo.php";
			String respuesta = ConexionPHP.peticionHttp(url);
			List<String> resultado = ConexionPHP.JsonToTipo(respuesta);
			
			for (String s : resultado) {
				FrmCrearNuevo.spTipo.addItem(s);
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
