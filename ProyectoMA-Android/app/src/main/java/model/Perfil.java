package model;

public class Perfil {

    private String correo;
    private String usuario;
    private String contrasenia;
    private String plato;
    private String tipo;
    private String localidad;
    private String pais;
    private String telefono;

    //Constructor logueo
    public Perfil(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    //Constructor sin contrasenia
    public Perfil(String correo,String usuario, String plato, String tipo, String localidad, String pais, String telefono) {
        this.correo = correo;
        this.usuario = usuario;
        this.plato = plato;
        this.tipo = tipo;
        this.localidad = localidad;
        this.pais = pais;
        this.telefono = telefono;
    }

    //Constructor completo
    public Perfil(String correo,String usuario, String contrasenia, String plato, String tipo, String localidad, String pais, String telefono) {
        this.correo = correo;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.plato = plato;
        this.tipo = tipo;
        this.localidad = localidad;
        this.pais = pais;
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getPlato() {
        return plato;
    }

    public void setPlato(String plato) {
        this.plato = plato;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "correo='" + correo + '\'' +
                ", usuario='" + usuario + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", plato='" + plato + '\'' +
                ", tipo='" + tipo + '\'' +
                ", localidad='" + localidad + '\'' +
                ", pais='" + pais + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
