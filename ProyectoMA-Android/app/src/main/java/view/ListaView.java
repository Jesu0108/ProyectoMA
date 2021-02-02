package view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.artiguez.proyectoma.R;

import controller.PreferenciasCtrl;
import logic.AdaptadorLista;
import logic.DataBaseCtrl;

public class ListaView extends AppCompatActivity {
    private AdaptadorLista adaptador;
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_view);

        context = getApplicationContext();

        //Cargamos los datos de los usuarios
        AdaptadorLista.prod = DataBaseCtrl.listPerfiles;

        // Vinculamos el objeto del controlador con el de la vista
        RecyclerView listaMain = findViewById(R.id.listaMain);

        // Impide cambiar el tamaño del RecycleView
        listaMain.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        listaMain.setLayoutManager(llm);

        adaptador = new AdaptadorLista(this);
        listaMain.setAdapter(adaptador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_lista, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mnuPerfil:
                startActivity(new Intent(getApplicationContext(), FrmPerfil.class));
                break;
            case R.id.mnuFiltroNinguno:
                DataBaseCtrl.getAllPerfiles();
                break;

            case R.id.mnuFiltroCatadores:
                DataBaseCtrl.filtroCocineros("Catador");
                break;
            case R.id.mnuFiltroCocinero:
                DataBaseCtrl.filtroCocineros("Cocinero");
                break;
            case R.id.mnuFiltroEmpresa:
                DataBaseCtrl.filtroCocineros("Empresa");
                break;

            case R.id.mnuSalir:
                PreferenciasCtrl.salirLogueo();
                startActivity(new Intent(getApplicationContext(), FrmPrincipal.class));
                break;
            case R.id.mnuOn:
                    FrmPrincipal.musica = MediaPlayer.create(this,R.raw.musica_fondo);
                    FrmPrincipal.musica.start();
                    FrmPrincipal.musica.setLooping(true);
                break;
            case R.id.mnuOff:
                    FrmPrincipal.musica.stop();
                break;
        }

        return true;
    }

    protected void onStart() {
        super.onStart();
        adaptador.refrescar();
    }
}