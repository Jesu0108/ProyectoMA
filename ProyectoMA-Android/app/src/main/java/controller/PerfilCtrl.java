package controller;

import android.widget.TextView;

import logic.DataBaseCtrl;

public class PerfilCtrl {
    public static TextView correo;
    public static TextView usuario;
    public static TextView pass;
    public static TextView plato;
    public static TextView localidad;
    public static TextView pais;
    public static TextView telefono;
    public static TextView tipo;
    
    public static void getDatosUser(TextView txtCorreoUser, TextView txtUsuarioUser, TextView txtPassUser, TextView txtPlatoUser, TextView txtLocalidadUser, TextView txtPaisUser, TextView txtTelefonoUser, TextView txtTipoUser) {

        correo = txtCorreoUser;
        usuario = txtUsuarioUser;
        pass = txtPassUser;
        plato = txtPlatoUser;
        localidad = txtLocalidadUser;
        pais = txtPaisUser;
        telefono = txtTelefonoUser;
        tipo = txtTipoUser;

        DataBaseCtrl.get1User();
    }
}
