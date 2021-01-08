package model;

public class Productos {

    private String sNombre,sTipo;
    private int iFormaEnvio,iProvincia,iNomProveedor;
    private float estrellas;
    private boolean bFragil;

    public Productos(String sNombre,String sTipo, int iFormaEnvio, int iProvincia, int iNomProveedor, boolean bFragil, float estrellas) {
        this.sNombre = sNombre;
        this.iFormaEnvio = iFormaEnvio;
        this.iProvincia = iProvincia;
        this.iNomProveedor = iNomProveedor;
        this.sTipo = sTipo;
        this.bFragil = bFragil;
        this.estrellas = estrellas;
    }

    public String getsNombre() {
        return sNombre;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public int getiFormaEnvio() {
        return iFormaEnvio;
    }

    public void setiFormaEnvio(int iFormaEnvio) {
        this.iFormaEnvio = iFormaEnvio;
    }

    public int getiProvincia() {
        return iProvincia;
    }

    public void setiProvincia(int iProvincia) {
        this.iProvincia = iProvincia;
    }

    public int getiNomProveedor() {
        return iNomProveedor;
    }

    public void setiNomProveedor(int iNomProveedor) {
        this.iNomProveedor = iNomProveedor;
    }

    public String getsTipo() {
        return sTipo;
    }

    public void setsTipo(String sTipo) {
        this.sTipo = sTipo;
    }

    public boolean isbFragil() {
        return bFragil;
    }

    public void setbFragil(boolean bFragil) {
        this.bFragil = bFragil;
    }

    public float getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(float estrellas) {
        this.estrellas = estrellas;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "sNombre='" + sNombre + '\'' +
                ", sTipo='" + sTipo + '\'' +
                ", iFormaEnvio=" + iFormaEnvio +
                ", iProvincia=" + iProvincia +
                ", iNomProveedor=" + iNomProveedor +
                ", estrellas=" + estrellas +
                ", bFragil=" + bFragil +
                '}';
    }
}
