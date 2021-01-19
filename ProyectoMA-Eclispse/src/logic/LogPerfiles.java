package logic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import model.Perfil;

public class LogPerfiles {

	public static List<Perfil> getPerfiles() throws SQLException {
		//Obtener los datos de la BBDD
		
		dbm.DataBase.openConnectionMySQL();
		String query = "SELECT * FROM Perfil ORDER BY tipo";
		CachedRowSet crs = dbm.DataBase.executeQuery(query);
		dbm.DataBase.closeConnection();	
		
		//Creamos la lista de Perfiles 
		List<Perfil> lstPerfiles = new ArrayList<Perfil>();
		
		while(crs.next()) {
			lstPerfiles.add(
					new Perfil(crs.getString("correo")
							,crs.getString("usuario")
							,crs.getString("contrasenia")
							,crs.getString("tipo")
							,crs.getString("plato")
							,crs.getInt("estrellas")
							)
					);
		}
		return lstPerfiles;
	}

	public static Perfil getPerfil(String correo) throws SQLException {
		dbm.DataBase.openConnectionMySQL();
		String query = "SELECT * FROM Perfil WHERE correo = "+correo;
		CachedRowSet crs = dbm.DataBase.executeQuery(query);
		dbm.DataBase.closeConnection();
		
		crs.next();
		
		Perfil c = new Perfil(crs.getString("correo")
				,crs.getString("usuario")
				,crs.getString("contrasenia")
				,crs.getString("tipo")
				,crs.getString("plato")
				,crs.getInt("estrellas")
		);
		
		return c;
	}

	public static void putPerfil(Perfil p) throws SQLException {
		String strSQL = "UPDATE Perfil "+"SET usuario '"
				+p.getsUsuario() + "' "
				+" ,contrasenia='"+p.getsContra() + "' "
				+" ,tipo='"+p.getsTipo() + "' "
				+" ,plato='"+p.getsPlato() + "' "
				+" ,estrellas="+p.getiEstrellas() +"WHERE correo = '"+p.getsCorreo()+"'";
		
		dbm.DataBase.openConnectionMySQL();
		dbm.DataBase.executeQuery(strSQL);
		dbm.DataBase.closeConnection();
	}

}
