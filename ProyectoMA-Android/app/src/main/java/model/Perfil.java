package model;

public class Perfil {

    private String sNombre, sPassword, sPlato;
    private boolean bTipo;
    private float estrellas;

    //Constructor sin plato estrella
    public Perfil(String sNombre, boolean bTipo, String sPassword, float estrellas) {
        this.sNombre = sNombre;
        this.bTipo = bTipo;
        this.sPassword = sPassword;
        this.estrellas = estrellas;
    }

    //Constructor completo
    public Perfil(String sNombre, boolean bTipo, String sPassword, String sPlato, float estrellas) {
        this.sNombre = sNombre;
        this.bTipo = bTipo;
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

    public boolean isbTipo() {
        return bTipo;
    }

    public void setbTipo(boolean bTipo) {
        this.bTipo = bTipo;
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
                ", bTipo='" + bTipo + '\'' +
                ", sPassword='" + sPassword + '\'' +
                ", sPlato='" + sPlato + '\'' +
                ", estrellas=" + estrellas +
                '}';
    }
}
