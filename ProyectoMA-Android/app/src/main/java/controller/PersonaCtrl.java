package controller;

import android.widget.TextView;

import logic.DatosFromDB;

public class PersonaCtrl {

    public static TextView correo;
    public static TextView usuario;
    public static TextView plato;
    public static TextView localidad;
    public static TextView pais;
    public static TextView telefono;
    public static TextView tipo;

    public static void getDatosPersona(TextView lblCorreoPersona, TextView lblUsuarioPersona, TextView lblPlatoPersona, TextView lblLocalidadPersona, TextView lblPaisPersona, TextView lblTelefonoPersona, TextView lblTipoPersona) {
        correo = lblCorreoPersona;
        usuario = lblUsuarioPersona;
        plato = lblPlatoPersona;
        localidad = lblLocalidadPersona;
        pais = lblPaisPersona;
        telefono = lblTelefonoPersona;
        tipo = lblTipoPersona;

        DatosFromDB.get1User();
    }
}
