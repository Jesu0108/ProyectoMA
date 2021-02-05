package view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.artiguez.proyectoma.R;

import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Map;

import controller.Data;
import controller.PerfilCtrl;
import logic.DatosFromDB;

public class FrmPerfil extends AppCompatActivity {

    public static Context context;

    public static TextView txtCorreoUser;
    public static TextView txtUsuarioUser;
    public static TextView txtPassUser;
    public static TextView txtPlatoUser;
    public static TextView txtLocalidadUser;
    public static TextView txtPaisUser;
    public static TextView txtTelefonoUser;
    public static Spinner spTipoUser;

    public static Button btnPerfil;
    public static ImageButton imgPersona;

    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_perfil);

        context = getApplicationContext();

        txtCorreoUser = findViewById(R.id.txtCorreoUser);
        txtUsuarioUser = findViewById(R.id.txtUserUser);
        txtPassUser = findViewById(R.id.txtPassUser);
        txtPlatoUser = findViewById(R.id.txtPlatoUser);
        txtLocalidadUser = findViewById(R.id.txtLocalidadUser);
        txtPaisUser = findViewById(R.id.txtPaisUser);
        txtTelefonoUser = findViewById(R.id.txtTelefonoUser);
        spTipoUser = findViewById(R.id.spTipoUser);
        DatosFromDB.getTipos("Perfil");
        PerfilCtrl.getDatosUser();

        btnPerfil = findViewById(R.id.btnPerfil);
        btnPerfil.setOnClickListener(v -> {
            PerfilCtrl.updateUser(txtCorreoUser, txtUsuarioUser, txtPassUser,txtPlatoUser, txtLocalidadUser, txtPaisUser, txtTelefonoUser, spTipoUser);
        });

        imgPersona = findViewById(R.id.imgPerfilUser);
        DatosFromDB.downloadImagenPerfil();

        imgPersona.setOnClickListener(v -> {
            selectFromGallery();
        });
    }
    private void selectFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(Intent.createChooser(intent, "Seleccione una aplicacion"), 0);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) try {

            Uri path = data.getData();
            bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(path), null, null);
            imgPersona.setImageBitmap(bitmap);

            upload();
        } catch (NullPointerException | FileNotFoundException ignored) {

        }
    }

    private void upload() {

        String strURL = Data.HOSTING +"/imagen.php";

        final ProgressDialog loading = ProgressDialog.show(context, "Subiendo...", "Espere por favor", false, false);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, strURL,
                s -> {
                    loading.dismiss();
                    Toast.makeText(context, "Foto subida con exito", Toast.LENGTH_SHORT).show();
                },
                volleyError -> {
                    loading.dismiss();
                    Toast.makeText(context, volleyError.getMessage(), Toast.LENGTH_SHORT).show();
                }
        ) {
            @Override
            public Map<String, String> getParams() {
                Hashtable<String, String> params = new Hashtable<>();
                params.put("imgData", DatosFromDB.getStringImage(bitmap));
                params.put("imgName", "" + DatosFromDB.listPerfilLog.get(0).getId_Usuario());

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
}