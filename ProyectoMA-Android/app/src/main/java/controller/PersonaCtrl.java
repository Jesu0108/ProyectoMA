package controller;

import android.widget.TextView;

import logic.AdaptadorLista;
import logic.DataBaseCtrl;

public class PersonaCtrl {

    public static TextView correo;
    public static TextView usuario;
    public static TextView plato;
    public static TextView localidad;
    public static TextView pais;
    public static TextView telefono;
    public static TextView tipo;
    public static int posicion;

    public static void getDatosPersona(TextView lblCorreoPersona, TextView lblUsuarioPersona, TextView lblPlatoPersona, TextView lblLocalidadPersona, TextView lblPaisPersona, TextView lblTelefonoPersona, TextView lblTipoPersona) {

        posicion = AdaptadorLista.cardPosition;

        correo = lblCorreoPersona;
        usuario = lblUsuarioPersona;
        plato = lblPlatoPersona;
        localidad = lblLocalidadPersona;
        pais = lblPaisPersona;
        telefono = lblTelefonoPersona;
        tipo = lblTipoPersona;


        DataBaseCtrl.get1User();
    }
}
