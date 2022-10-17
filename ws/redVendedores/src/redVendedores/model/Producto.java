package redVendedores.model;

public class Producto {

	private String nombre;
	private String codigo;
	private String categoria;
	private String precio;
	private TipoEstado tipoEstado;
	private Vendedor vendedor;
	public Producto(String nombre, String codigo, String categoria, String precio, TipoEstado tipoEstado,
			Vendedor vendedor) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.categoria = categoria;
		this.precio = precio;
		this.tipoEstado = tipoEstado;
		this.vendedor = vendedor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public TipoEstado getTipoEstado() {
		return tipoEstado;
	}
	public void setTipoEstado(TipoEstado tipoEstado) {
		this.tipoEstado = tipoEstado;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	@Override
	public String toString() {
		return "Producto [prodcuto=" + nombre + ", codigo=" + codigo + ", categoria=" + categoria + ", precio="
				+ precio + ", tipoEstado=" + tipoEstado + ", vendedor=" + vendedor + "]";
	}

}
