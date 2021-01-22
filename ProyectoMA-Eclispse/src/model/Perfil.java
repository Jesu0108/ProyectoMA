package model;

public class Perfil {

	private String sCorreo, sUsuario, sContra, sTipo, sPlato,sLocalidad,sPais,sTelefono;

	public Perfil() {

	}

	public Perfil(String sCorreo, String sContra) {
		setsCorreo(sCorreo);
		setsContra(sContra);

	}
	
	public Perfil(String sCorreo, String sUsuario, String sContra, String sTipo, String sPlato, String sTelefono, String sLocalidad,String sPais) {
		setsCorreo(sCorreo);
		setsUsuario(sUsuario);
		setsContra(sContra);
		setsTipo(sTipo);
		setsPlato(sPlato);
		setsTelefono(sTelefono);
		setsLocalidad(sLocalidad);
		setsPais(sPais);
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

	public String getsLocalidad() {
		return sLocalidad;
	}

	public void setsLocalidad(String sLocalidad) {
		this.sLocalidad = sLocalidad;
	}

	public String getsPais() {
		return sPais;
	}

	public void setsPais(String sPais) {
		this.sPais = sPais;
	}

	public String getsTelefono() {
		return sTelefono;
	}

	public void setsTelefono(String sTelefono) {
		this.sTelefono = sTelefono;
	}

	@Override
	public String toString() {
		return "Perfil [sCorreo=" + sCorreo + ", sUsuario=" + sUsuario + ", sContra=" + sContra + ", sTipo=" + sTipo
				+ ", sPlato=" + sPlato + ", sLocalidad=" + sLocalidad + ", sPais=" + sPais + ", sTelefono=" + sTelefono
				+ "]";
	}

}
