package controller;

import java.util.List;

import javax.swing.JOptionPane;

import logic.ConexionPHP;
import model.Perfil;
import utils.Data;
import view.FrmEdicionPerfil;
import view.FrmListaPerfiles;

public class EdicionPerfilCtrl {

	private static Integer id;

	public static void loadData() {
		id = Integer.parseInt(
				FrmListaPerfiles.tblResult.getValueAt(FrmListaPerfiles.tblResult.getSelectedRow(), 0).toString());

		try {

			String url = Data.URL + "/get1UserPk.php?id_Usuario=" + id;
			String respuesta = ConexionPHP.peticionHttp(url);

			List<Perfil> lstPerfil = ConexionPHP.JsonToPerfiles(respuesta);

			FrmEdicionPerfil.txtCorreo.setText(lstPerfil.get(0).getsCorreo());
			FrmEdicionPerfil.txtUsuario.setText(lstPerfil.get(0).getsUsuario());
			FrmEdicionPerfil.txtContra.setText(lstPerfil.get(0).getsContra());
			FrmEdicionPerfil.spTipo.setSelectedIndex(indexTipo(lstPerfil));
			
			FrmEdicionPerfil.txtTelefono.setText(lstPerfil.get(0).getsTelefono());
			FrmEdicionPerfil.txtPlato.setText(lstPerfil.get(0).getsPlato());
			FrmEdicionPerfil.txtLocalidad.setText(lstPerfil.get(0).getsLocalidad());
			FrmEdicionPerfil.txtPais.setText(lstPerfil.get(0).getsPais());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + e.getMessage(),
					"Error cargando en loadData (edicionPerfiles)", JOptionPane.ERROR_MESSAGE);
		}
	}

	private static int indexTipo(List<Perfil> lstPerfil) {
		int iIndex;

		if (lstPerfil.get(0).getsTipo().equals("Catador")) {
			iIndex = 0;
		} else if (lstPerfil.get(0).getsTipo().equals("Cocinero")) {
			iIndex = 1;
		} else {
			iIndex = 2;
		}
		return iIndex;
	}

	public static void saveData() {
		try {

			String sCorreo = FrmEdicionPerfil.txtCorreo.getText().toString();
			String sUsuario = FrmEdicionPerfil.txtUsuario.getText().toString();
			String sContra = FrmEdicionPerfil.txtContra.getText().toString();
			String sTipo = FrmEdicionPerfil.spTipo.getSelectedItem().toString();
			String sTelefono = FrmEdicionPerfil.txtTelefono.getText().toString();
			String sPlato = FrmEdicionPerfil.txtPlato.getText().toString();
			String sLocalidad = FrmEdicionPerfil.txtLocalidad.getText().toString();
			String sPais = FrmEdicionPerfil.txtPais.getText().toString();

			String url = Data.URL + "/updateUserPK.php?correo=" + sCorreo + "&user=" + sUsuario + "&contrasenia="
					+ sContra + "&tipo=" + sTipo + "&plato=" + sPlato + "&pais=" + sPais + "&localidad=" + sLocalidad
					+ "&telefono=" + sTelefono + "&id_Usuario=" + id;
			ConexionPHP.peticionHttp(url);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + e.getMessage(),
					"Error cargando en saveData (edicionPerfiles)", JOptionPane.ERROR_MESSAGE);
		}
	}

	@SuppressWarnings("unchecked")
	public static void addTipos() {

		try {
			String url = Data.URL + "/getTipo.php";
			String respuesta = ConexionPHP.peticionHttp(url);
			List<String> resultado = ConexionPHP.JsonToTipo(respuesta);

			for (String s : resultado) {
				FrmEdicionPerfil.spTipo.addItem(s);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static void deleteUSer() {
		try {
			String url = Data.URL + "/deleteUser.php?id_Usuario=" + id;
			ConexionPHP.peticionHttp(url);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + e.getMessage(),
					"Error eliminando el usuario", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static boolean confirmDelete() {
		boolean bExito;
		
		if (JOptionPane.showConfirmDialog(null, "¿Seguro que desea borrar este usuario?", "Confirmacion borrado",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			bExito = true;
		} else {
			bExito = false;
		}

		return bExito;
	}
}
