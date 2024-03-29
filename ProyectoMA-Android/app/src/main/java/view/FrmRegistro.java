package view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.artiguez.proyectoma.R;

import controller.PrincipalCtrl;
import logic.DatosFromDB;

public class FrmRegistro extends AppCompatActivity {
    public static EditText txtCorreo;
    public static EditText txtUser;
    public static EditText txtPass;
    public static EditText txtTelefono;
    public static EditText txtPlato;
    public static EditText txtLocalidad;
    public static EditText txtPais;

    public static Spinner spTipo;

    Button btnCrear;

    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_registro);

        context = getApplicationContext();

        txtCorreo = findViewById(R.id.txtEmailReg);
        txtUser = findViewById(R.id.txtUsuarioPersona);
        txtPass = findViewById(R.id.txtPassReg);
        txtPlato = findViewById(R.id.txtPlatoReg);
        txtLocalidad = findViewById(R.id.txtLocalidadReg);
        txtPais = findViewById(R.id.txtPaisReg);
        txtTelefono = findViewById(R.id.txtTelefonoReg);

        spTipo = findViewById(R.id.spTipoReg);
        DatosFromDB.getTipos("Registro");

        btnCrear = findViewById(R.id.btnCrear);
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrincipalCtrl.userRegistro(txtCorreo, txtUser, txtPass, spTipo, txtPlato,txtLocalidad,txtPais,txtTelefono);
            }
        });
    }
}