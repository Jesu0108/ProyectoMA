package view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.artiguez.proyectoma.R;

public class FrmPrincipal extends AppCompatActivity {

    public static EditText txtUsuario, txtContra;
    Button btnLogin, btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_principal);

        txtUsuario = findViewById(R.id.txtUsuario);
        txtContra = findViewById(R.id.txtContra);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (controller.PrincipalCtrl.userExist()) {
                    Intent ventanaGrafica = new Intent(getApplicationContext(), FrmPersona.class);
                } else {
                    Toast.makeText(FrmPrincipal.this, "Usuario o contraseña incorrectos", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnRegistro = findViewById(R.id.btnRegistro);
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Lleva al usuario a la pantalla de edicion de datos
            }
        });

    }
}