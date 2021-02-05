package view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.artiguez.proyectoma.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import controller.Data;
import controller.PersonaCtrl;
import logic.AdaptadorLista;
import logic.DatosFromDB;

public class FrmPersona extends AppCompatActivity {
    public static TextView lblCorreoPersona;
    public static TextView lblUsuarioPersona;
    public static TextView lblPlatoPersona;
    public static TextView lblLocalidadPersona;
    public static TextView lblPaisPersona;
    public static TextView lblTelefonoPersona;
    public static TextView lblTipoPersona;

    public static ImageView imgPerfilPersona;
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
        downloadImagenUsers();
    }

    public static void downloadImagenUsers() {
        int idImgUser = AdaptadorLista.prod.get(AdaptadorLista.cardPosition).getId_Usuario();

        String url = Data.HOSTING +"/imagen/"+idImgUser+".jpg";

        imgPerfilPersona.setImageDrawable(null);

        Glide
                .with(ListaView.context.getApplicationContext())
                .load(url)
                .apply(RequestOptions.centerCropTransform())
                .into(imgPerfilPersona);
    }
}