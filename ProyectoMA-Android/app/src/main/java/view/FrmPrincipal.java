package view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.artiguez.proyectoma.R;

import java.util.ArrayList;

import logic.AdaptadorProducto;
import logic.Datos;
import model.Productos;

public class FrmPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.axctivity_frmPrincipal);

        Datos.prod = getElements();



        // Vinculamos el objeto del controlador con el de la vista
        RecyclerView listaMain = findViewById(R.id.listaMain);

        // Impide cambiar el tamaño del RecycleView
        listaMain.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        listaMain.setLayoutManager(llm);

        adaptador = new AdaptadorProducto(this);
        listaMain.setAdapter(adaptador);

        btnGrafica = findViewById(R.id.btnGrafico);
        btnGrafica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ventanaGrafica = new Intent(getApplicationContext(), GraficaView.class);
            }
        });
    }

    protected void onStart() {
        super.onStart();
        adaptador.refrescar();
    }

    public static ArrayList<Productos> getElements() {
        ArrayList<Productos> elementos = new ArrayList<Productos>();

        for (int i=0;i<10;i++){

            elementos.add(new Productos("Nombre", 1, 1, 1, 0, false,1));
        }
        return elementos;
    }
    }
}