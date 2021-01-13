package controller;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DataBaseCtrl {
    private class Load_1Coche_AsyncTask extends AsyncTask<String,Void,Void> {
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
            Type type = new TypeToken<List<Coche>>(){}.getType();
            List<Coche> listCoches = gson.fromJson(resultado,type);

            miCoche = listCoches.get(0);
            Log.i("ARTIGUEZ","Coche: "+miCoche);
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

        @Override
        public void onPostExecute(Void aVoid){
            super.onPostExecute(aVoid);

            Gson gson = new Gson();
            Type type = new TypeToken<List<Coche>>(){}.getType();
            List<Coche> listCoches = gson.fromJson(resultado,type);

            List<String> lsMarcas = new ArrayList<>();

            for (Coche c: listCoches){
                lsMarcas.add(c.getMarca());
            }
            spMarcas.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,lsMarcas));
        }
    }
}
