package controller;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;

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

public class DataBaseCtrl {
    private class Load_1Coche_AsyncTask extends AsyncTask<String,Void,Void> {
        String resultado;
        private Perfil user;
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
            List<Perfil> listCoches = gson.fromJson(resultado,type);

            user = listCoches.get(0);
            Log.i("ARTIGUEZ","Coche: "+user);
        }
    }

    private class LoadDataCoches_AsyncTask extends AsyncTask<String,Void,Void>{
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
    }


}
