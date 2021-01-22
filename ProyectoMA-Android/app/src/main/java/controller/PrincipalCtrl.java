package controller;

import android.widget.EditText;
import android.widget.Spinner;

import logic.DataBaseCtrl;

public class PrincipalCtrl {

    public static void userExist(EditText txtUser, EditText txtPass) {
        String sUsuario, sPass;

        sUsuario = txtUser.getText().toString();
        sPass = txtPass.getText().toString();

        DataBaseCtrl.get1User(sUsuario, sPass);
    }

    public static boolean userRegistro(EditText txtCorreo, EditText txtUser, EditText txtPass, Spinner spTipo,EditText txtPlato) {
        String sCorreo, sUser, sPass, sTipo,sPlato;

        sCorreo = txtCorreo.getText().toString();
        sUser = txtUser.getText().toString();
        sPass = txtPass.getText().toString();
        sTipo = spTipo.getSelectedItem().toString();
        sPlato = txtPlato.getText().toString();

        return DataBaseCtrl.insert1User(sCorreo,sUser,sPass,sTipo,sPlato,1);
    }
}
