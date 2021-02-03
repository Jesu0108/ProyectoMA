package controller;

import java.util.List;

import javax.swing.JOptionPane;

import logic.ConexionPHP;
import model.Perfil;
import view.FrmEdicionPerfil;
import view.FrmListaPerfiles;

public class EdicionPerfilCtrl {

	private static Integer id;

	public static void confirmExit() {
		if (JOptionPane.showConfirmDialog(FrmEdicionPerfil.contentPane, "¿Seguro que desea salir?", "Confirmar salida",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public static void loadData() {
		id = Integer.parseInt(
				FrmListaPerfiles.tblResult.getValueAt(FrmListaPerfiles.tblResult.getSelectedRow(), 0).toString());

		try {
		
			String url = "https://preyectoma.000webhostapp.com/get1UserPk.php?id_Usuario=" + id;
			String respuesta = ConexionPHP.peticionHttp(url);

			List<Perfil> lstPerfil = ConexionPHP.JsonToPerfiles(respuesta);
						
			FrmEdicionPerfil.txtCorreo.setText(lstPerfil.get(0).getsCorreo());
			FrmEdicionPerfil.txtUsuario.setText(lstPerfil.get(0).getsUsuario());
			FrmEdicionPerfil.txtContra.setText(lstPerfil.get(0).getsContra());
			FrmEdicionPerfil.txtTipo.setText(lstPerfil.get(0).getsTipo());
			FrmEdicionPerfil.txtTelefono.setText(lstPerfil.get(0).getsTelefono());
			FrmEdicionPerfil.txtPlato.setText(lstPerfil.get(0).getsPlato());
			FrmEdicionPerfil.txtLocalidad.setText(lstPerfil.get(0).getsLocalidad());
			FrmEdicionPerfil.txtPais.setText(lstPerfil.get(0).getsPais());
		} catch (Exception e) {
			System.err.println("Fallo:" + e.getMessage());
			e.printStackTrace();
			
//			JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + e.getMessage(), "Error cargando en loadData (edicionPerfiles)",
//					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void saveData() {
		try {

			String sCorreo = FrmEdicionPerfil.txtCorreo.getText().toString();
			String sUsuario = FrmEdicionPerfil.txtUsuario.getText().toString();
			String sContra = FrmEdicionPerfil.txtContra.getText().toString();
			String sTipo = FrmEdicionPerfil.txtTipo.getText().toString();
			String sTelefono = FrmEdicionPerfil.txtTelefono.getText().toString();
			String sPlato = FrmEdicionPerfil.txtPlato.getText().toString();
			String sLocalidad = FrmEdicionPerfil.txtLocalidad.getText().toString();
			String sPais = FrmEdicionPerfil.txtPais.getText().toString();

			String url = "https://preyectoma.000webhostapp.com/updateUserPK.php?correo=" + sCorreo + "&user=" + sUsuario
					+ "&contrasenia=" + sContra + "&tipo=" + sTipo + "&plato=" + sPlato + "&pais=" + sPais
					+ "&localidad=" + sLocalidad + "&telefono=" + sTelefono + "&id_Usuario="+id;
			ConexionPHP.peticionHttp(url);

		} catch (Exception e) {
			System.err.println("Fallo:" + e.getMessage());
			e.printStackTrace();
			
//			JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + e.getMessage(), "Error cargando en saveData (edicionPerfiles)",
//					JOptionPane.ERROR_MESSAGE);
		}
	}
}
