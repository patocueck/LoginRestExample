package cl.patocueck.loginrestexample.model;

public class Usuario {

	private String email;
	private String nombre;
	private String apellidos;
	private String esAdmin;
	private String password;
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getEsAdmin() {
		return esAdmin;
	}
	
	public void setEsAdmin(String esAdmin) {
		this.esAdmin = esAdmin;
	}
	
	
}
