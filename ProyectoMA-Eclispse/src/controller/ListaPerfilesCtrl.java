package controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import logic.ConexionPHP;
import model.Perfil;
import utils.Data;
import utils.GUI;
import view.FrmListaPerfiles;

public class ListaPerfilesCtrl {

	public static List<Perfil> resultado;
	
	public static void loadData() {
		try {
			String url = Data.URL + "/getUsers.php";
			String respuesta = ConexionPHP.peticionHttp(url);

			resultado = ConexionPHP.JsonToPerfiles(respuesta);

			DefaultTableModel modelo = GUI.generarTablaPerfiles(resultado);

			FrmListaPerfiles.tblResult.setModel(modelo);

			// Ocultar la columna 0 que contiene la pk
			FrmListaPerfiles.tblResult.getColumnModel().getColumn(0).setMinWidth(0);
			FrmListaPerfiles.tblResult.getColumnModel().getColumn(0).setMaxWidth(0);
			FrmListaPerfiles.tblResult.getColumnModel().getColumn(0).setWidth(0);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + e.getMessage(), "Error cargando los datos",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void confirmExit() {
		if (JOptionPane.showConfirmDialog(FrmListaPerfiles.contentPane, "�Seguro que desea salir?", "Confirmar salida",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}
