package view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.artiguez.proyectoma.R;

import java.util.ArrayList;

import logic.AdaptadorProducto;
import logic.Datos;
import model.Perfil;

public class ListaView extends AppCompatActivity {
    private AdaptadorProducto adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_view);

        Datos.prod = getElements();

        // Vinculamos el objeto del controlador con el de la vista
        RecyclerView listaMain = findViewById(R.id.listaMain);

        // Impide cambiar el tamaño del RecycleView
        listaMain.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        listaMain.setLayoutManager(llm);

        adaptador = new AdaptadorProducto(this);
        listaMain.setAdapter(adaptador);
    }

    protected void onStart() {
        super.onStart();
        adaptador.refrescar();
    }

    public static ArrayList<Perfil> getElements() {
        ArrayList<Perfil> elementos = new ArrayList<Perfil>();

        for (int i = 0; i < 10; i++) {

            elementos.add(new Perfil("Nombre", "cocinero","123",5));
        }
        return elementos;
    }
}