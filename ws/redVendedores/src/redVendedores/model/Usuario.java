package redVendedores.model;

public class Usuario {
	private String nombre;
	private String apellido;
	private String cedula;
	private String direccion;
	private RedV redV;
	public Usuario(String nombre, String apellido, String cedula, String direccion, RedV redV) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.direccion = direccion;
		this.redV = redV;

	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public RedV getRedV() {
		return redV;
	}

	public void setRedV(RedV redV) {
		this.redV = redV;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", direccion="
				+ direccion + ", redV=" + redV + "]";
	}




}
