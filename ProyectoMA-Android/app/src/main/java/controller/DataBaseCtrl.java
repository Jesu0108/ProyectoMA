package controller;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
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
import java.util.concurrent.Semaphore;

import model.Perfil;

public class DataBaseCtrl {

    private static boolean bGetUser = true;
    private static Perfil user;

    public static void cargaDatos() {
        new LoadDataUsers_AsyncTask().execute("http://jesusmedac.tk/getUsers.php");
    }

    public static boolean get1User(String user,String pass) {
        System.out.println("usuario:"+user+" -- pass:"+pass);
        new Load_1User_AsyncTask().execute("http://jesusmedac.tk/get1User.php?usuario="+user+"&contrasenia="+pass);

        System.out.print("desde la bd"+bGetUser);
        return bGetUser;
    }

    public static void insert1User(String correo,String user,String pass,String type,String plato,int stars) {
        new LoadDataUsers_AsyncTask().execute("http://jesusmedac.tk/insert1User.php?correo="+correo+"&usuario="+user+"&contrasenia="+pass
                +"&tipo="+type+"&plato="+plato+"&estrellas="+stars);
    }

    private static class Load_1User_AsyncTask extends AsyncTask<String,Void,Void> {
        String resultado;

        @Override
        protected Void doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);

                System.out.println("URL--------> "+url);

                //Abrimos el canal de comunicaciones hacia mi url
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));

                //recuperamos lo que hay en la url
                String stringBuffer;
                String str = "";
                while((stringBuffer = bufferedReader.readLine())!=null){
                    str = String.format("%s%s",str,stringBuffer);
                };
                bufferedReader.close();
                resultado = str;

                System.out.println("resultado:----------------------"+resultado);

                if(resultado != null){
                    bGetUser = true;
                    System.out.println("--Aqui entra--");
                }else{
                    bGetUser = false;
                }

            }catch (IOException e){
                resultado = e.getMessage();
            }
            return null;
        }

        @Override
        public void onPostExecute(Void aVoid){
            super.onPostExecute(aVoid);
            Gson gson = new Gson();
            Type type = new TypeToken<List<Perfil>>(){}.getType();
            List<Perfil> listCoches = gson.fromJson(resultado,type);

            user = listCoches.get(0);
            Log.i("ARTIGUEZ","Perfil: "+user);
        }
    }

    private static class LoadDataUsers_AsyncTask extends AsyncTask<String,Void,Void>{
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

                while((stringBuffer = bufferedReader.readLine())!=null){
                    str = String.format("%s%s",str,stringBuffer);
                };
                bufferedReader.close();
                resultado = str;

            }catch (IOException e){
                resultado = e.getMessage();
            }
            return null;
        }
        @Override
        public void onPostExecute(Void aVoid){
            super.onPostExecute(aVoid);

            Gson gson = new Gson();
            Type type = new TypeToken<List<Perfil>>(){}.getType();
            List<Perfil> listPerfiles = gson.fromJson(resultado,type);

            List<String> lstNombres = new ArrayList<>();

            //Esta lista debe cambiarse para que sea la que guarda los erfiles que venen de la base de datos
            for (Perfil c: listPerfiles){
                lstNombres.add(c.getsNombre());
            }
            //spMarcas.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,lsMarcas));
        }
    }


}
