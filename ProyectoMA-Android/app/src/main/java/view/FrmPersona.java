package view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.artiguez.proyectoma.R;

public class FrmPersona extends AppCompatActivity {
    public static TextView txtCorreoPersona;
    public static TextView txtUsuarioPersona;
    public static TextView txtPlatoPersona;
    public static TextView txtLocalidadPersona;
    public static TextView txtPaisPersona;
    public static TextView txtTelefonoPersona;
    public static Spinner spTipoPersona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_persona);

        txtCorreoPersona = findViewById(R.id.txtCorreoPersona);
        txtUsuarioPersona = findViewById(R.id.txtUsuarioPersona);
        txtPlatoPersona = findViewById(R.id.txtPlatoPersona);
        txtLocalidadPersona = findViewById(R.id.txtLocalidadPersona);
        txtPaisPersona = findViewById(R.id.txtPaisPersona);
        txtTelefonoPersona = findViewById(R.id.txtTelefonoPersona);
        spTipoPersona = findViewById(R.id.spTipoPersona);
    }
}