package view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.artiguez.proyectoma.R;

public class FrmPrincipal extends AppCompatActivity {

    EditText txtUsuario,txtContra;
    Button btnLogin,btnRegistro;

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

            }
        });


        btnRegistro = findViewById(R.id.btnRegistro);


    }
}