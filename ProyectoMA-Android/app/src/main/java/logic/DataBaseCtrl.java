package logic;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
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

import controller.PersonaCtrl;
import model.Perfil;
import view.FrmPerfil;
import view.FrmPersona;
import view.FrmPrincipal;
import view.FrmRegistro;
import view.ListaView;

public class DataBaseCtrl {

    public static ArrayList<Perfil> listPerfiles;

    public static void logeoUser(String user, String pass) {
        new Logueo_User_AsyncTask().execute("https://preyectoma.000webhostapp.com/get1User.php?usuario=" + user + "&contrasenia=" + pass);
    }

    public static void insert1User(String correo, String user, String pass, String type, String plato, String localidad, String pais, String telefono) {
        new Insert_User_AsyncTask().execute("https://preyectoma.000webhostapp.com/insert1User.php?correo=" + correo + "&usuario=" + user + "&contrasenia=" + pass
                + "&tipo=" + type + "&plato=" + plato  + "&pais=" + pais + "&localidad=" + localidad + "&telefono=" + telefono);
    }

    public static void get1User() {
        new Load_1User_AsyncTask().execute("https://preyectoma.000webhostapp.com/get1UserPk.php?id_Usuario=" + (AdaptadorLista.cardPosition+1));
    }

    public static void getPerfil() {
        new Load_Perfil_AsyncTask().execute("https://preyectoma.000webhostapp.com/get_Datos_1_User.php?usuario=" + FrmPrincipal.userPref + "&contrasenia="+FrmPrincipal.userPass);
    }

    public static void filtroCocineros(String tipo) {
        new LoadDataUsers_AsyncTask().execute("https://preyectoma.000webhostapp.com/filtroUsers.php?tipo=" + tipo);
    }

    public static void getAllPerfiles() {
        new LoadDataUsers_AsyncTask().execute("https://preyectoma.000webhostapp.com/getUsers.php");
    }

    public static void updateUser(String correo, String user, String contrasenia, String type, String plato, String localidad, String pais, String telefono) {
        new Update_User_AsyncTask().execute("https://preyectoma.000webhostapp.com/updateUser.php?correo=" + correo + "&user=" + user + "&contrasenia=" + contrasenia
                + "&tipo=" + type + "&plato=" + plato  + "&pais=" + pais + "&localidad=" + localidad + "&telefono=" + telefono + "&usuario="+ FrmPrincipal.userPref);
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

            //Mandamos un mensaje al usuario
            Toast.makeText(FrmRegistro.context.getApplicationContext(), "Registrado con éxito", Toast.LENGTH_SHORT).show();

            //Cargamos los datos
            new LoadDataUsers_AsyncTask().execute("https://preyectoma.000webhostapp.com/getUsers.php");

        }
    }

    private static class Update_User_AsyncTask extends AsyncTask<String, Void, Void> {

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

            //Mandamos un mensaje al usuario
            Toast.makeText(FrmRegistro.context.getApplicationContext(), "Usuario Editado", Toast.LENGTH_SHORT).show();

            //Cargamos los datos de nuevo
            getPerfil();

        }
    }

    private static class Logueo_User_AsyncTask extends AsyncTask<String, Void, Void> {
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
                    //Cargamos los datos
                    new LoadDataUsers_AsyncTask().execute("https://preyectoma.000webhostapp.com/getUsers.php");
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
                };

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
            listPerfiles = gson.fromJson(resultado, type);

            //Llamamos a la ListView
            FrmPrincipal.context.startActivity(new Intent(FrmPrincipal.context.getApplicationContext(), ListaView.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        }
    }

    private static class Load_1User_AsyncTask extends AsyncTask<String,Void,Void>{
        String resultado;
        Perfil perfil;

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

            if (listPerfiles != null) {
                if (listPerfiles.size() > 0) {
                    perfil = listPerfiles.get(0);

                    PersonaCtrl.correo.setText(perfil.getCorreo());
                    PersonaCtrl.usuario.setText(perfil.getUsuario());
                    PersonaCtrl.telefono.setText(perfil.getTelefono());
                    PersonaCtrl.tipo.setText(perfil.getTipo());
                    PersonaCtrl.plato.setText(perfil.getPlato());
                    PersonaCtrl.pais.setText(perfil.getPais());
                    PersonaCtrl.localidad.setText(perfil.getLocalidad());

                } else {
                    Toast.makeText(FrmPrincipal.context.getApplicationContext(), "Ha ocurrido un error, por favor recarge la app", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(FrmPrincipal.context.getApplicationContext(), "Ha ocurrido un error, por favor recarge la app", Toast.LENGTH_LONG).show();
            }
        }
    }

    private static class Load_Perfil_AsyncTask extends AsyncTask<String,Void,Void>{
        String resultado;
        Perfil perfil;

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

            if (listPerfiles != null) {
                if (listPerfiles.size() > 0) {
                    perfil = listPerfiles.get(0);

                    FrmPerfil.txtCorreoUser.setText(perfil.getCorreo());
                    FrmPerfil.txtUsuarioUser.setText(perfil.getUsuario());
                    FrmPerfil.txtPassUser.setText(perfil.getContrasenia());
                    FrmPerfil.txtTipoUser.setText(perfil.getTipo());
                    FrmPerfil.txtPlatoUser.setText(perfil.getPlato());
                    FrmPerfil.txtTelefonoUser.setText(perfil.getTelefono());
                    FrmPerfil.txtPaisUser.setText(perfil.getPais());
                    FrmPerfil.txtLocalidadUser.setText(perfil.getLocalidad());

                } else {
                    Toast.makeText(FrmPrincipal.context.getApplicationContext(), "Ha ocurrido un error, por favor reinicie la app", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(FrmPrincipal.context.getApplicationContext(), "Ha ocurrido un error, por favor reinicie la app", Toast.LENGTH_LONG).show();
            }
        }
    }

}
