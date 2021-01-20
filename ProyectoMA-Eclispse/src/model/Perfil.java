package model;

public class Perfil {

	private String sCorreo, sUsuario, sContra, sTipo, sPlato;
	private Integer iEstrellas;

	public Perfil() {

	}

	public Perfil(String sCorreo, String sContra) {
		setsCorreo(sCorreo);
		setsContra(sContra);

	}
	
	public Perfil(String sCorreo, String sUsuario, String sContra, String sTipo, String sPlato, Integer iEstrellas) {
		setsCorreo(sCorreo);
		setsUsuario(sUsuario);
		setsContra(sContra);
		setsTipo(sTipo);
		setsPlato(sPlato);
		setiEstrellas(iEstrellas);
	}

	public String getsCorreo() {
		return sCorreo;
	}

	public void setsCorreo(String sCorreo) {
		this.sCorreo = sCorreo;
	}

	public String getsUsuario() {
		return sUsuario;
	}

	public void setsUsuario(String sUsuario) {
		this.sUsuario = sUsuario;
	}

	public String getsContra() {
		return sContra;
	}

	public void setsContra(String sContra) {
		this.sContra = sContra;
	}

	public String getsTipo() {
		return sTipo;
	}

	public void setsTipo(String sTipo) {
		this.sTipo = sTipo;
	}

	public String getsPlato() {
		return sPlato;
	}

	public void setsPlato(String sPlato) {
		this.sPlato = sPlato;
	}

	public Integer getiEstrellas() {
		return iEstrellas;
	}

	public void setiEstrellas(Integer iEstrellas) {
		this.iEstrellas = iEstrellas;
	}

	@Override
	public String toString() {
		return "Correo= " + sCorreo + "\nUsuario= " + sUsuario + "\n Contraseña= " + sContra + "\nTipo= " + sTipo
				+ "\nPlato= " + sPlato + "\nEstrellas= " + iEstrellas;
	}

}
