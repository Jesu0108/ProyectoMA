package logic;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.artiguez.tarea02_listadeproductos.R;

public class AdaptadorProducto extends RecyclerView.Adapter<AdaptadorProducto.HolderProducto> {

    private Context c;
    public static int cardPosition;

    public AdaptadorProducto(Context c) {
        this.c = c;
    }

    @NonNull
    @Override
    public HolderProducto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.elementos,parent,false);
        return new HolderProducto(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderProducto holder, int position) {
        holder.txtNombreProd.setText(Datos.prod.get(position).getsNombre());
        holder.txtPrecioProd.setText(Datos.prod.get(position).getfPrecio()+" €");
        holder.ratPuntuacion.setRating((Datos.prod.get(position).getEstrellas()));

        if(Datos.prod.get(position).isbFragil()){
           holder.imgFragil.setImageResource(R.drawable.fragile);
        }else{
            holder.imgFragil.setImageResource(R.drawable.bien);
        }

        holder.cardProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardPosition = position;
                Intent ventanaEdicion = new Intent(c, SegundaPantalla.class);
                c.startActivity(ventanaEdicion);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Datos.prod.size();
    }

    public void refrescar(){
        notifyDataSetChanged();
    }

    public class HolderProducto extends RecyclerView.ViewHolder{
        CardView cardProductos;
        TextView txtNombreProd;
        TextView txtPrecioProd;
        RatingBar ratPuntuacion;
        ImageView imgFragil;

        public HolderProducto(@NonNull View itemView) {
            super(itemView);

            cardProductos = itemView.findViewById(R.id.cardProductos);
            txtNombreProd = itemView.findViewById(R.id.txtNombreProd);
            txtPrecioProd = itemView.findViewById(R.id.txtPrecioProd);
            ratPuntuacion = itemView.findViewById(R.id.ratPuntuacion);
            imgFragil = itemView.findViewById(R.id.imgFragil);
        }
    }
}
