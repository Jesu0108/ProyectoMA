package view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.artiguez.proyectoma.R;

import java.util.ArrayList;
import java.util.List;

import controller.PrincipalCtrl;
import model.Perfil;

public class FrmRegistro extends AppCompatActivity {
    public static EditText txtCorreo,txtUser, txtPass,txtPlato;
    Button btnCrear;
    public static Spinner spTipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_registro);

        txtCorreo = findViewById(R.id.txtEmailReg);
        txtUser = findViewById(R.id.txtNomReg);
        txtPass = findViewById(R.id.txtPassReg);
        txtPlato = findViewById(R.id.txtPlatoReg);
        spTipo = findViewById(R.id.spTipoReg);

        List<String> lstTipo = new ArrayList<>();
        lstTipo.add("Cocinero");
        lstTipo.add("Empresa");
        lstTipo.add("Catador");

        spTipo.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,lstTipo));

        btnCrear = findViewById(R.id.btnCrear);
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(PrincipalCtrl.userRegistro(txtCorreo,txtUser,txtPass,spTipo,txtPlato)){
                    Intent i = new Intent(getApplicationContext(), ListaView.class);
                    Toast.makeText(FrmRegistro.this, "Usuario registrado sin problemas", Toast.LENGTH_SHORT).show();
                    startActivity(i);
                }else{
                    Toast.makeText(FrmRegistro.this, "Este usuario ya ha sido registrado", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}