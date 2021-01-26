package logic;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import model.Perfil;
import view.FrmPrincipal;
import view.FrmRegistro;
import view.ListaView;

public class DataBaseCtrl {

    private static boolean bInsertar = false;

    public static void cargaDatos() {
        new LoadDataUsers_AsyncTask().execute("http://jesusmedac.tk/getUsers.php");
    }

    public static void get1User(String user, String pass) {
        new Load_1User_AsyncTask().execute("http://jesusmedac.tk/get1User.php?usuario=" + user + "&contrasenia=" + pass);
    }

    public static void insert1User(String correo, String user, String pass, String type, String plato, String localidad, String pais, String telefono) {
        bInsertar = true;
        new Insert_User_AsyncTask().execute("http://jesusmedac.tk/insert1User.php?correo=" + correo + "&usuario=" + user + "&contrasenia=" + pass
                + "&tipo=" + type + "&plato=" + plato  + "&pais=" + pais + "&localidad=" + localidad + "&telefono=" + telefono);
    }


    private static class Insert_User_AsyncTask extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                //Abrimos el canal de comunicaciones hacia mi url
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));

            } catch (IOException e) {
               e.printStackTrace();
            }
            return null;
        }

        @Override
        public void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            Toast.makeText(FrmRegistro.context.getApplicationContext(), "Registrado con éxito", Toast.LENGTH_SHORT).show();
            //Llevamos al usuario dentro de la app
            FrmPrincipal.context.startActivity(new Intent(FrmPrincipal.context.getApplicationContext(), ListaView.class));
        }
    }


    private static class Load_1User_AsyncTask extends AsyncTask<String, Void, Void> {
        String resultado;

        @Override
        protected Void doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                //Abrimos el canal de comunicaciones hacia mi url
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));

                //recuperamos lo que hay en la url
                String stringBuffer;
                String str = "";
                while ((stringBuffer = bufferedReader.readLine()) != null) {
                    str = String.format("%s%s", str, stringBuffer);
                }
                ;
                bufferedReader.close();
                resultado = str;

            } catch (IOException e) {
                resultado = e.getMessage();
            }
            return null;
        }

        @Override
        public void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Gson gson = new Gson();
            Type type = new TypeToken<List<Perfil>>() {}.getType();

            List<Perfil> listPerfiles = gson.fromJson(resultado, type);

            if (listPerfiles != null) {
                if (listPerfiles.size() > 0) {
                    FrmPrincipal.context.startActivity(new Intent(FrmPrincipal.context.getApplicationContext(), ListaView.class));
                } else {
                    Toast.makeText(FrmPrincipal.context.getApplicationContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(FrmPrincipal.context.getApplicationContext(), "Ha ocurrido un error, por favor revise los campos", Toast.LENGTH_LONG).show();
            }
        }
    }

    private static class LoadDataUsers_AsyncTask extends AsyncTask<String, Void, Void> {
        String resultado;

        @Override
        protected Void doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);

                //Abrimos el canal de comunicaciones hacia mi url
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));

                //recuperamos lo que hay en la url
                String stringBuffer;
                String str = "";

                while ((stringBuffer = bufferedReader.readLine()) != null) {
                    str = String.format("%s%s", str, stringBuffer);
                }
                ;
                bufferedReader.close();
                resultado = str;


            } catch (IOException e) {
                resultado = e.getMessage();
            }
            return null;
        }

        @Override
        public void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            Gson gson = new Gson();
            Type type = new TypeToken<List<Perfil>>() {}.getType();
            ArrayList<Perfil> listPerfiles = gson.fromJson(resultado, type);

            for (Perfil c : listPerfiles) {
                AdaptadorProducto.prod.add(c);
                Log.i("MACARRONES",c.toString());
            }
        }
    }

}
