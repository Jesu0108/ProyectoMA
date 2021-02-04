package controller;

import android.widget.Spinner;
import android.widget.TextView;

import logic.DatosFromDB;

public class PerfilCtrl {
    private static String correo;
    private static String usuario;
    private static String pass;
    private static String plato;
    private static String localidad;
    private static String pais;
    private static String telefono;
    private static String tipo;

    public static void getDatosUser() {
        DatosFromDB.getPerfil();
    }

    public static void  updateUser(TextView txtCorreoUser, TextView txtUsuarioUser, TextView txtPassUser, TextView txtPlatoUser, TextView txtLocalidadUser, TextView txtPaisUser, TextView txtTelefonoUser, Spinner spTipoUser) {
        correo = txtCorreoUser.getText().toString();
        usuario = txtUsuarioUser.getText().toString();
        pass = txtPassUser.getText().toString();
        plato = txtPlatoUser.getText().toString();
        localidad = txtLocalidadUser.getText().toString();
        pais = txtPaisUser.getText().toString();
        telefono = txtTelefonoUser.getText().toString();
        tipo = spTipoUser.getSelectedItem().toString();

        DatosFromDB.updateUser(correo, usuario, pass, tipo, plato, localidad, pais, telefono);
    }
}
