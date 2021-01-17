package controller;

import android.widget.EditText;
import android.widget.Spinner;

public class PrincipalCtrl {

    public static boolean userExist(EditText txtUser, EditText txtPass) {


        return false;
    }

    public static boolean userRegistro(EditText txtCorreo, EditText txtUser, EditText txtPass, Spinner spTipo) {
        String sCorreo,sUser,sPass,sTipo;

        sCorreo = txtCorreo.getText().toString();
        sUser = txtUser.getText().toString();
        sPass = txtPass.getText().toString();
        sTipo = spTipo.getSelectedItem().toString();

        return false;
    }
}
