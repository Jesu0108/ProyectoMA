package view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.artiguez.proyectoma.R;

import controller.PersonaCtrl;

public class FrmPersona extends AppCompatActivity {
    public static TextView lblCorreoPersona;
    public static TextView lblUsuarioPersona;
    public static TextView lblPlatoPersona;
    public static TextView lblLocalidadPersona;
    public static TextView lblPaisPersona;
    public static TextView lblTelefonoPersona;
    public static TextView lblTipoPersona;

    public static ImageButton imgPerfilPersona;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_persona);

        lblCorreoPersona = findViewById(R.id.lblCorreoPersona);
        lblUsuarioPersona = findViewById(R.id.lblUserPersona);
        lblPlatoPersona = findViewById(R.id.lblPlatoPersona);
        lblLocalidadPersona = findViewById(R.id.lblLocalidadPersona);
        lblPaisPersona = findViewById(R.id.lblPaisPersona);
        lblTelefonoPersona = findViewById(R.id.lblTelefonoPersona);
        lblTipoPersona = findViewById(R.id.lblTipoPersona);

        PersonaCtrl.getDatosPersona(lblCorreoPersona, lblUsuarioPersona, lblPlatoPersona, lblLocalidadPersona, lblPaisPersona, lblTelefonoPersona, lblTipoPersona);

        imgPerfilPersona = findViewById(R.id.imgPerfilPersona);
        imgPerfilPersona.setOnClickListener(v -> {

        });
    }
}