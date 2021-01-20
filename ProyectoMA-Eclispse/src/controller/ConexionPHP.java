package controller;


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
	
	public static List<Perfil> JsonToPerfilesLog(String respuesta) {

		List<Perfil> lstResultado = new ArrayList<>();

		JSONArray jsonA = new JSONArray(respuesta);

		for (int i = 0; i < jsonA.length(); i++) {

			JSONObject jsonO = jsonA.getJSONObject(i);

			Perfil c = JsonToPerfilLog(jsonO);

			lstResultado.add(c);

		}

		return lstResultado;
	}

	public static Perfil JsonToPerfilLog(JSONObject jsonO) {

		String correo = jsonO.getString("correo");
		String contrasenia = jsonO.getString("contrasenia");

		Perfil c = new Perfil(correo, contrasenia);

		return c;
	}
	
	public static Perfil JsonToPerfil(JSONObject jsonO) {

		String correo = jsonO.getString("correo");
		String usuario = jsonO.getString("usuario");
		String contrasenia = jsonO.getString("contrasenia");
		String tipo = jsonO.getString("tipo");
		String plato = jsonO.getString("plato");
		Integer estrellas = jsonO.getInt("estrellas");

		Perfil c = new Perfil(correo, usuario, contrasenia, tipo, plato, estrellas);

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
