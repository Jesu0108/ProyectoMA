package utils;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.CachedRowSet;
import javax.swing.table.DefaultTableModel;

import model.Perfil;

public class GUI {

	public static DefaultTableModel generarTabla(CachedRowSet resultado) throws SQLException {
		DefaultTableModel modelo = new DefaultTableModel();

		ResultSetMetaData md = resultado.getMetaData();

		int totalColumnas = md.getColumnCount();

		// A�adir la cabecera de las columnas
		for (int col = 1; col <= totalColumnas; col++) {
			modelo.addColumn(md.getColumnName(col));
		}

		// A�adir cada fila de valores
		String[] fila = new String[totalColumnas];

		while (resultado.next()) {
			for (int col = 1; col <= totalColumnas; col++) {
				fila[col - 1] = resultado.getString(col);
			}
			modelo.addRow(fila);
		}
		return modelo;
	}

	public static DefaultTableModel generarTablaPerfiles(List<Perfil> resultado) {
		DefaultTableModel modelo = new DefaultTableModel();

		// A�adir la cabecera de las columnas
		modelo.addColumn("Correo");
		modelo.addColumn("Usuario");
		modelo.addColumn("Contrase�a");
		modelo.addColumn("Tipo");
		modelo.addColumn("Plato");
		modelo.addColumn("Telefono");
		modelo.addColumn("Localidad");
		modelo.addColumn("Pais");


		// A�adir cada fila de valores
		for (Perfil p : resultado) {
			modelo.addRow(new Object[] { p.getsCorreo(), p.getsUsuario(), p.getsContra(), p.getsTipo(), p.getsPlato(), p.getsTelefono(), p.getsLocalidad(), p.getsPais() });

		}
		
		return modelo;
	}
}
