package model;

public class Perfil {

    private String sNombre, sTipo, sPassword;
    private float estrellas;

    public Perfil(String sNombre, String sTipo, String sPassword, float estrellas) {
        this.sNombre = sNombre;
        this.sTipo = sTipo;
        this.sPassword = sPassword;
        this.estrellas = estrellas;
    }

    public String getsNombre() {
        return sNombre;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getsTipo() {
        return sTipo;
    }

    public void setsTipo(String sTipo) {
        this.sTipo = sTipo;
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
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
                ", sTipo='" + sTipo + '\'' +
                ", sPassword='" + sPassword + '\'' +
                ", estrellas=" + estrellas +
                '}';
    }
}
