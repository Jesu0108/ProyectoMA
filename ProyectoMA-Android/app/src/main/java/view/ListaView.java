package view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.artiguez.proyectoma.R;

import java.util.ArrayList;

import logic.AdaptadorProducto;
import logic.DataBaseCtrl;
import model.Perfil;

public class ListaView extends AppCompatActivity {
    private AdaptadorProducto adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_view);

        //Cargamos los datos de los usuarios
        AdaptadorProducto.prod = DataBaseCtrl.listPerfiles;

        // Vinculamos el objeto del controlador con el de la vista
        RecyclerView listaMain = findViewById(R.id.listaMain);

        // Impide cambiar el tamaño del RecycleView
        listaMain.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        listaMain.setLayoutManager(llm);

        adaptador = new AdaptadorProducto(this);
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
                //startActivity(new Intent(getApplicationContext(), FrmPerfil.class));
                break;
            case R.id.mnuOpciones:
                //startActivity(new Intent(getApplicationContext(), AcercaDe.class));
                break;

            case R.id.mnuSalir:
                //startActivity(new Intent(getApplicationContext(), AcercaDe.class));
                break;
        }

        return true;
    }

    protected void onStart() {
        super.onStart();
        adaptador.refrescar();
    }
}