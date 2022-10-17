package redVendedores.model;

import java.util.ArrayList;

import redVendedores.exception.ProductoException;

public class Vendedor extends Usuario{

	private ArrayList<Producto> listaProductos;
	private Muro muro;
	private ArrayList<Vendedor> listaContactos;
	public Vendedor(String nombre, String apellido, String cedula, String direccion, RedV redV, Muro muro) {
		super(nombre, apellido, cedula, direccion, redV);
		listaProductos = new ArrayList<Producto> ();
		this.muro = muro;
		listaContactos = new ArrayList<Vendedor> ();
	}
	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}
	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	public Muro getMuro() {
		return muro;
	}
	public void setMuro(Muro muro) {
		this.muro = muro;
	}
	public ArrayList<Vendedor> getListaContactos() {
		return listaContactos;
	}
	public void setListaContactos(ArrayList<Vendedor> listaContactos) {
		this.listaContactos = listaContactos;
	}
	@Override
	public String toString() {
		return "Vendedor [listaProductos=" + listaProductos + ", muro=" + muro + ", listaContactos=" + listaContactos
				+ "]";
	}


	//////////////CRUD para el producto

	/**
	 * Metodo para crear un producto
	 * @param nuevoProducto
 	* @return
 	*/
	public String crearProducto(Producto nuevoProducto) {
		String mensaje = "";
		try {
			verificarProducto(nuevoProducto.getCodigo());
			listaProductos.add(nuevoProducto);
			mensaje = "El producto fue creado";
		}	catch (ProductoException e) {
			mensaje  = e.getMessage();
		}
		return mensaje;
	}

	/**
	 * Metodo para verificar un producto
	 * @param codigo
	 * @return
	 * @throws ProductoException
	 */
	public Producto verificarProducto(String codigo) throws ProductoException {
		Producto productoVerificado = null;

		for (Producto producto : listaProductos) {
			if(producto.getCodigo().equals(codigo)){
				productoVerificado =  (Producto) producto;
				throw new ProductoException ("El producto ya existe");
			}
		}
		return productoVerificado;
	}

	/**
	 * Metodo para buscar un producto
	 * @param codigo
	 * @return
	 * @throws ProductoException
	 */
	public Producto buscarProducto(String codigo) throws ProductoException {
		Producto productoEncontrado = null;

		for (Producto producto : listaProductos) {
			if(producto.getCodigo().equals(codigo)){
				productoEncontrado = producto;
			}
		}
		if(productoEncontrado == null){
			throw new ProductoException ("Producto no encontrado");
		}
		return productoEncontrado;
	}

	/**
	 * Metodo para actualizar un producto
	 * @param codigo
	 * @param listaProductos
	 * @return
	 * @throws ProductoException
	 */
	public String actualizarProducto(String nombre, String codigo, String categoria, TipoEstado estado) throws ProductoException{
		String mensaje = "El producto fue actualizado";
		Producto productoObtenido = buscarProducto(codigo);

		for (int i = 0; i< listaProductos.size(); i++) {
			if(productoObtenido != null){
				if(productoObtenido.equals(listaProductos.get(i))) {
					(listaProductos.get(i)).setNombre(nombre);
					(listaProductos.get(i)).setCodigo(codigo);
					(listaProductos.get(i)).setCategoria(categoria);
					(listaProductos.get(i)).setTipoEstado(estado);
				}
			}
		}
		if(productoObtenido == null) {
			throw new ProductoException("El producto no ha sido creado");
		}
		return mensaje;
	}

	/**
	 * Metodo para eliminar un producto
	 * @param codigo
	 * @return
	 * @throws ProductoException
	 */
	public String eliminarProducto(String codigo) throws ProductoException{
		String mensaje = "El producto fue eliminado";
		Producto productoObtenido = buscarProducto(codigo);

		for (int i = 0; i < listaProductos.size(); i++) {
			if(productoObtenido.equals(listaProductos.get(i))) {
				listaProductos.remove(productoObtenido);
			}
		}
		if(productoObtenido == null) {
			throw new ProductoException("El vendedor no a sido creado");
		}
		return mensaje;
	}
}