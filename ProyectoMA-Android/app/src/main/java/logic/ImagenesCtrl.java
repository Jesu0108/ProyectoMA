package logic;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.ByteArrayOutputStream;
import java.util.Hashtable;
import java.util.Map;

import logic.AdaptadorLista;
import view.FrmPerfil;
import view.FrmPrincipal;

public class ImagenesCtrl {
    private ImageView imgFoto;
    private Bitmap bitmap;

    private String getStringImage(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        return Base64.encodeToString(imageBytes, Base64.DEFAULT);
    }

    private void selectFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        //startActivityForResult(Intent.createChooser(intent, "Seleccione una aplicacion"), 0);
    }
    private void upload(String imgName) {

        String strURL = "https://preyectoma.000webhostapp.com/imagen.php";

        final ProgressDialog loading = ProgressDialog.show(FrmPerfil.context, "Subiendo...", "Espere por favor", false, false);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, strURL,
                s -> {
                    loading.dismiss();
                    Toast.makeText(FrmPerfil.context, "Foto subida con exito", Toast.LENGTH_SHORT).show();
                },
                volleyError -> {
                    loading.dismiss();
                    Toast.makeText(FrmPerfil.context, volleyError.getMessage(), Toast.LENGTH_SHORT).show();
                }
        ) {
            @Override
            public Map<String, String> getParams() {
                Hashtable<String, String> params = new Hashtable<>();
                params.put("imgData", getStringImage(bitmap));
                params.put("imgName", imgName);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(FrmPerfil.context);
        requestQueue.add(stringRequest);
    }
}
