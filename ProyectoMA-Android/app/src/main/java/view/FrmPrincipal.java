package view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.artiguez.proyectoma.R;

import controller.PreferenciasCtrl;
import controller.PrincipalCtrl;

public class FrmPrincipal extends AppCompatActivity {

    public static EditText txtUsuario, txtContra;
    Button btnLogin, btnRegistro;
    public static Context context;
    public static MediaPlayer musica;
    public static SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_principal);

        context = getApplicationContext();
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        musica = MediaPlayer.create(this,R.raw.musica_fondo);

        compruebaMusica();

        if(!userLogueado()){
            txtUsuario = findViewById(R.id.txtUsuario);
            txtContra = findViewById(R.id.txtContra);

            btnLogin = findViewById(R.id.btnLogin);
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    controller.PrincipalCtrl.userLogueo(txtUsuario, txtContra);
                }
            });

            btnRegistro = findViewById(R.id.btnRegistro);
            btnRegistro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(), FrmRegistro.class));
                }
            });
        }else{
            logueoDirecto();

        }
    }

    private boolean userLogueado(){
        boolean bExito = true;

        //Leer de las preferencias
        String sUsuario = prefs.getString("user",null);
        String sPass = prefs.getString("pass",null);

        if(sUsuario != null && sPass != null){
            bExito = true;
        }else{
            bExito= false;
        }

        return bExito;
    }

    private void logueoDirecto(){
        //Leemos las preferencias y lo guardamos en variables
        String userPref = prefs.getString("user",null);
        String userPass = prefs.getString("pass",null);

        PreferenciasCtrl.logueoPreferencias(userPref,userPass);
    }

    private void compruebaMusica(){
        if(musica.isPlaying()){
            musica.stop();
            musica.reset();
            musica.setLooping(true);
        }else{
            musica.start();
            musica.setLooping(true);
        }
    }
}