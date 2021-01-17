package view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.artiguez.proyectoma.R;

import controller.PrincipalCtrl;

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

        btnCrear = findViewById(R.id.btnCrear);
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(PrincipalCtrl.userRegistro(txtCorreo,txtUser,txtPass,spTipo)){
                    Intent i = new Intent(getApplicationContext(), ListaView.class);
                    Toast.makeText(FrmRegistro.this, "Usuario registrado sin problemas", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(FrmRegistro.this, "Este usuario ya ha sido registrado", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}