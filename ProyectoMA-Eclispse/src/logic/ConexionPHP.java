package logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Perfil;

public class ConexionPHP {

	public static List<Perfil> JsonToPerfiles(String respuesta) {

		List<Perfil> lstResultado = new ArrayList<>();

		JSONArray jsonA = new JSONArray(respuesta);

		for (int i = 0; i < jsonA.length(); i++) {

			JSONObject jsonO = jsonA.getJSONObject(i);

			Perfil c = JsonToPerfil(jsonO);

			lstResultado.add(c);

		}

		return lstResultado;
	}

	public static List<String> JsonToTipo(String respuesta) {

		List<String> lstResultado = new ArrayList<>();

		JSONArray jsonA = new JSONArray(respuesta);

		for (int i = 0; i < jsonA.length(); i++) {

			JSONObject jsonO = jsonA.getJSONObject(i);

			String s = jsonO.getString("tipo");

			lstResultado.add(s);

		}

		return lstResultado;
	}

	public static Perfil JsonToPerfilLog(String respuesta) {
		Perfil perfilLog;

		try {
			JSONObject jsonO = new JSONObject(respuesta);
			String correo = jsonO.getString("correo");
			String contrasenia = jsonO.getString("contrasenia");

			perfilLog = new Perfil(correo, contrasenia);
		} catch (Exception e) {
			perfilLog = null;
		}

		return perfilLog;
	}

	public static Perfil JsonToEditPerfil(String respuesta) {
		Perfil perfilLog;

		try {
			JSONObject jsonO = new JSONObject(respuesta);
			int id_Usuario = jsonO.getInt("id_Usuario");
			String correo = jsonO.getString("correo");
			String usuario = jsonO.getString("usuario");
			String contrasenia = jsonO.getString("contrasenia");
			String tipo = jsonO.getString("tipo");
			String plato = jsonO.getString("plato");
			String telefono = jsonO.getString("telefono");
			String localidad = jsonO.getString("localidad");
			String pais = jsonO.getString("pais");

			perfilLog = new Perfil(id_Usuario, correo, usuario, contrasenia, tipo, plato, telefono, localidad, pais);
		} catch (Exception e) {
			perfilLog = null;
		}

		return perfilLog;
	}

	public static Perfil JsonToPerfil(JSONObject jsonO) {

		int id_Usuario = jsonO.getInt("id_Usuario");
		String correo = jsonO.getString("correo");
		String usuario = jsonO.getString("usuario");
		String contrasenia = jsonO.getString("contrasenia");
		String tipo = jsonO.getString("tipo");
		String plato = jsonO.getString("plato");
		String telefono = jsonO.getString("telefono");
		String localidad = jsonO.getString("localidad");
		String pais = jsonO.getString("pais");

		Perfil c = new Perfil(id_Usuario, correo, usuario, contrasenia, tipo, plato, telefono, localidad, pais);

		return c;
	}

	public static String peticionHttp(String urlWebService) throws Exception {

		StringBuilder resultado = new StringBuilder();

		URL url = new URL(urlWebService);

		HttpURLConnection conexion = (HttpURLConnection) url.openConnection();

		conexion.setRequestMethod("GET");

		// Recoger los datos de respuesta
		BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));

		String linea;

		while ((linea = rd.readLine()) != null) {
			resultado.append(linea);
		}

		// cerramos el buffered
		rd.close();
		return resultado.toString();
	}

}
