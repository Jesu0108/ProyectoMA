package view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.artiguez.proyectoma.R;

public class FrmRegistro extends AppCompatActivity {
    public static EditText txtCorreo,txtUser, txtPass;
    Button btnCrear;
    Spinner spTipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_registro);

        txtCorreo = findViewById(R.id.txtEmailReg);
        txtUser = findViewById(R.id.txtNomReg);
        txtPass = findViewById(R.id.txtPassReg);
        spTipo = findViewById(R.id.spTipoReg);
    }
}