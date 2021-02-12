package controller;

import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import logic.DatosFromDB;
import view.FrmPrincipal;

public class PrincipalCtrl {

    public static void userLogueo(EditText txtUser, EditText txtPass) {
        String sUsuario, sPass;

        sUsuario = txtUser.getText().toString();
        sPass = txtPass.getText().toString();

        if(sUsuario.equals("") || sPass.equals("")){
            Toast.makeText(FrmPrincipal.context.getApplicationContext(), "Por favor, rellene todos los campos para continuar", Toast.LENGTH_LONG).show();
        }else{
            //Guardamos sus preferencias
            PreferenciasCtrl.insertPreferencias(sUsuario,sPass);
            //Comprobamos el login
            DatosFromDB.logeoUser(sUsuario, sPass);
        }
    }

    public static void userRegistro(EditText txtCorreo, EditText txtUser, EditText txtPass, Spinner spTipo, EditText txtPlato, EditText txtLocalidad, EditText txtPais, EditText txtTelefono) {
        String sCorreo, sUser, sPass, sTipo, sPlato,sLocalidad,sPais,sTelefono;

        sCorreo = txtCorreo.getText().toString();
        sUser = txtUser.getText().toString();
        sPass = txtPass.getText().toString();
        sTipo = spTipo.getSelectedItem().toString();
        sPlato = txtPlato.getText().toString();
        sLocalidad = txtLocalidad.getText().toString();
        sPais = txtPais.getText().toString();
        sTelefono = txtTelefono.getText().toString();

        if(sCorreo.equals("") || sUser.equals("") || sPass.equals("") || sTipo.equals("") || sPlato.equals("") || sLocalidad.equals("") || sPais.equals("") || sTelefono.equals("")){
            Toast.makeText(FrmPrincipal.context.getApplicationContext(), "Por favor, rellene todos los campos para continuar", Toast.LENGTH_LONG).show();
        }else{
            //Lo registramos en la DB
            DatosFromDB.insert1User(sCorreo, sUser, sPass, sTipo, sPlato, sLocalidad,sPais,sTelefono);
            //Guardamos sus preferencias
            PreferenciasCtrl.insertPreferencias(sUser,sPass);
        }
    }



}
