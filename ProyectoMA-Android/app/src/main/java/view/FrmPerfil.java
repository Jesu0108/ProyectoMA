package view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.artiguez.proyectoma.R;

import controller.PerfilCtrl;

public class FrmPerfil extends AppCompatActivity {
    public static TextView txtCorreoUser;
    public static TextView txtUsuarioUser;
    public static TextView txtPassUser;
    public static TextView txtPlatoUser;
    public static TextView txtLocalidadUser;
    public static TextView txtPaisUser;
    public static TextView txtTelefonoUser;
    public static TextView txtTipoUser;

    public static Button btnPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_perfil);

        txtCorreoUser = findViewById(R.id.txtCorreoUser);
        txtUsuarioUser = findViewById(R.id.txtUserUser);
        txtPassUser = findViewById(R.id.txtPassUser);
        txtPlatoUser = findViewById(R.id.txtPlatoUser);
        txtLocalidadUser = findViewById(R.id.txtLocalidadUser);
        txtPaisUser = findViewById(R.id.txtPaisUser);
        txtTelefonoUser = findViewById(R.id.txtTelefonoUser);
        txtTipoUser = findViewById(R.id.txtTipoUser);

        PerfilCtrl.getDatosUser();

        btnPerfil = findViewById(R.id.btnPerfil);
        btnPerfil.setOnClickListener(v -> {
            PerfilCtrl.updateUser(txtCorreoUser, txtUsuarioUser, txtPassUser,txtPlatoUser, txtLocalidadUser, txtPaisUser, txtTelefonoUser, txtTipoUser);
        });
    }


}