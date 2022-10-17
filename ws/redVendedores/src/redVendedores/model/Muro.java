package redVendedores.model;

public class Muro {
	private String mensaje;
	private String comentario;
	private int meGusta;
	private Vendedor vendedor;

	public Muro(String mensaje, String comentario, int meGusta, Vendedor vendedor) {
		super();
		this.mensaje = mensaje;
		this.comentario = comentario;
		this.meGusta = meGusta;
		this.vendedor = vendedor;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public int getMeGusta() {
		return meGusta;
	}
	public void setMeGusta(int meGusta) {
		this.meGusta = meGusta;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	@Override
	public String toString() {
		return "Muro [mensaje=" + mensaje + ", comentario=" + comentario + ", meGusta=" + meGusta + ", vendedor="
				+ vendedor + "]";
	}
}
