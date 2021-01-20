package model;

public class Perfil {

    private String sNombre, sPassword, sPlato,sTipo;
    private float estrellas;

    //Constructor logueo
    public Perfil(String sNombre,String sPassword) {
        this.sNombre = sNombre;
        this.sPassword = sPassword;
    }

    //Constructor sin plato estrella
    public Perfil(String sNombre, String sTipo, String sPassword, float estrellas) {
        this.sNombre = sNombre;
        this.sTipo = sTipo;
        this.sPassword = sPassword;
        this.estrellas = estrellas;
    }

    //Constructor completo
    public Perfil(String sNombre, String sTipo, String sPassword, String sPlato, float estrellas) {
        this.sNombre = sNombre;
        this.sTipo = sTipo;
        this.sPassword = sPassword;
        this.sPlato = sPlato;
        this.estrellas = estrellas;
    }

    public String getsNombre() {
        return sNombre;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }

    public String getsPlato() {
        return sPlato;
    }

    public void setsPlato(String sPlato) {
        this.sPlato = sPlato;
    }

    public String getsTipo() {
        return sTipo;
    }

    public void setsTipo(String sTipo) {
        this.sTipo = sTipo;
    }

    public float getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(float estrellas) {
        this.estrellas = estrellas;
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "sNombre='" + sNombre + '\'' +
                ", sPassword='" + sPassword + '\'' +
                ", sPlato='" + sPlato + '\'' +
                ", sTipo='" + sTipo + '\'' +
                ", estrellas=" + estrellas +
                '}';
    }
}
