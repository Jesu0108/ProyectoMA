package logic;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.artiguez.proyectoma.R;

import java.util.ArrayList;

import model.Perfil;
import view.FrmPersona;

public class AdaptadorProducto extends RecyclerView.Adapter<AdaptadorProducto.HolderProducto> {

    private Context c;
    public static int cardPosition;
    public static ArrayList<Perfil> prod;


    public AdaptadorProducto(Context c) {
        this.c = c;
    }

    @NonNull
    @Override
    public HolderProducto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.datos,parent,false);
        return new HolderProducto(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderProducto holder, int position) {
        holder.txtNombreUser.setText(prod.get(position).getUsuario());
        holder.txtTipoUsuario.setText(prod.get(position).getTipo());
        holder.txtLocalidad.setText(prod.get(position).getLocalidad());

        holder.cardProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardPosition = position;
                Intent ventanaEdicion = new Intent(c, FrmPersona.class);
                c.startActivity(ventanaEdicion);
            }
        });
    }

    @Override
    public int getItemCount() {
        return prod.size();
    }

    public void refrescar(){
        notifyDataSetChanged();
    }

    public class HolderProducto extends RecyclerView.ViewHolder{
        CardView cardProductos;

        TextView txtNombreUser;
        TextView txtTipoUsuario;
        TextView txtLocalidad;
        ImageView imgPerfil;

        public HolderProducto(@NonNull View itemView) {
            super(itemView);
            cardProductos = itemView.findViewById(R.id.cardProductos);

            txtNombreUser = itemView.findViewById(R.id.txtNombreUsuario);
            txtTipoUsuario = itemView.findViewById(R.id.txtTipoUsuario);
            txtLocalidad = itemView.findViewById(R.id.txtLocalidad);
            imgPerfil = itemView.findViewById(R.id.imgUsuario);
        }
    }
}
