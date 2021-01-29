package controller;

import android.content.SharedPreferences;
import android.widget.ListView;

import androidx.preference.PreferenceManager;

import logic.DataBaseCtrl;
import view.FrmPrincipal;
import view.ListaView;

public class PreferenciasCtrl {
    public static void insertPreferencias(String sUsuario, String sPass) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(FrmPrincipal.context.getApplicationContext());

        //Escribir las preferencias

        //Usuario
        SharedPreferences.Editor editorPrefsUser = prefs.edit();
        editorPrefsUser.putString("user", sUsuario);
        editorPrefsUser.apply();

        //Contrasenia
        SharedPreferences.Editor editorPrefsPass = prefs.edit();
        editorPrefsPass.putString("pass", sPass);
        editorPrefsPass.apply();
    }

    public static void logueoPreferencias(String sUsuario, String sPass) {
        DataBaseCtrl.logeoUser(sUsuario, sPass);
    }

    public static void salirLogueo(){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ListaView.context.getApplicationContext());

        SharedPreferences.Editor prefsUser = prefs.edit();
        prefsUser.putString("user",null);
        prefsUser.apply();

        SharedPreferences.Editor prefsPass = prefs.edit();
        prefsPass.putString("pass",null);
        prefsPass.apply();


    }
}
