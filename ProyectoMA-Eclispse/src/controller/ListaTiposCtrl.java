package controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import logic.ConexionPHP;
import utils.Data;
import utils.GUI;
import view.FrmListaTipos;

public class ListaTiposCtrl {

	public static void loadData() {
		List<String> resultado;

		try {
			String url = Data.URL + "/getTipo.php";
			
			String respuesta = ConexionPHP.peticionHttp(url);

			resultado = ConexionPHP.JsonToTipo(respuesta);

			DefaultTableModel modelo = GUI.generarTablaTipos(resultado);

			FrmListaTipos.tblResult.setModel(modelo);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + e.getMessage(), "Error cargando los tipos",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
