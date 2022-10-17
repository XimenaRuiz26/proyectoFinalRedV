package redVendedores.model;

import java.util.ArrayList;

import redVendedores.exception.AdministradorException;
import redVendedores.exception.VendedorException;

public class RedV {

	private String nombre;
	private ArrayList<Usuario> listaUsuarios;


	public RedV(String nombre) {
		super();
		this.nombre = nombre;
		listaUsuarios = new ArrayList<Usuario> ();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	@Override
	public String toString() {
		return "RedV [nombre=" + nombre + ", listaUsuarios=" + listaUsuarios + "]";
	}

////////////////CRUD para vendedor

	/**
	 * Metodo para crear un vendedor
	 * @param nuevoVendedor
	 * @return
	 */
	public String crearVendedor(Vendedor nuevoVendedor) {
		String mensaje = "";
		try {
			verificarVendedor(nuevoVendedor.getCedula());
			listaUsuarios.add(nuevoVendedor);
			mensaje = "El vendedor fue creado";
		} catch (VendedorException e) {
			mensaje  = e.getMessage();
		}
		return mensaje;
	}

	/**
	* Metodo para verificar si el vendedor ya fue creado
	* @param cedula
	* @return
	* @throws VendedorException
	*/
	private Vendedor verificarVendedor(String cedula) throws VendedorException {
		Vendedor vendedorVerificado = null;

		for (Usuario vendedor : listaUsuarios) {
			if(vendedor instanceof Vendedor){
				if(vendedor.getCedula().equals(cedula)){
					vendedorVerificado =  (Vendedor) vendedor;
					throw new VendedorException ("El vendedor ya existe");
				}
			}
		}
		return vendedorVerificado;
	}

	/**
	 * Metodo para buscar un vendedor
	 * @param cedula
	 * @return
	 * @throws VendedorException
	 */
	public Vendedor buscarVendedor(String cedula) throws VendedorException {
		Vendedor vendedorEncontrado = null;

		for (Usuario vendedor : listaUsuarios){
			if(vendedor instanceof Vendedor){
				if(vendedor != null && vendedor.getCedula().equals(cedula)){
					vendedorEncontrado =  (Vendedor) vendedor;
				}
			}
		}
		if(vendedorEncontrado == null){
			throw new VendedorException ("Vendedor no encontrado");

		}
		return vendedorEncontrado;
	}

	/**
	 * Metodo para actualizar un vendedor
	 * @param cedula
	 * @param listaUsuarios
	 * @return
	 * @throws VendedorException
	 */
	public String actualizarVendedor(String nombre, String apellido, String cedula, String direccion) throws VendedorException{
		String mensaje = "El vendedor fue actualizado";
		Vendedor vendedorObtenido = buscarVendedor(cedula);

		for (int i = 0; i< listaUsuarios.size(); i++) {
			if(listaUsuarios.get(i) instanceof Vendedor) {
				if(vendedorObtenido.equals(listaUsuarios.get(i))) {
					(listaUsuarios.get(i)).setNombre(nombre);
					(listaUsuarios.get(i)).setApellido(apellido);
					(listaUsuarios.get(i)).setCedula(cedula);
					(listaUsuarios.get(i)).setDireccion(direccion);
				}
			}
		}
		if(vendedorObtenido == null) {
			throw new VendedorException("El vendedor no ha sido creado");
		}
		return mensaje;
	}

	/**
	 	* Metodo para eliminar un vendedor
	 	* @param cedula
	 	* @return
	 	* @throws VendedorException
	 	*/
	public String eliminarVendedor(String cedula) throws VendedorException{
		String mensaje = "El vendedor fue eliminado";
		Vendedor vendedorObtenido = buscarVendedor(cedula);

		for (int i = 0; i < listaUsuarios.size(); i++) {
			if(listaUsuarios.get(i) instanceof Vendedor){
				if(listaUsuarios.get(i).getCedula().equals(cedula)) {
					listaUsuarios.remove(vendedorObtenido);
					break;
				}
			}
		}
		if(vendedorObtenido == null) {
			throw new VendedorException("El vendedor no a sido creado");
		}
		return mensaje;
	}

	//////////////CRUD para el administrador

	/**
	 * Metodo para crear un administrador
	 * @param nuevoAdministrador
	 * @return
	 */
	public String crearAdministrador(Administrador nuevoAdministrador) {
		String mensaje = "";
		try {
			verificarAdiministrador(nuevoAdministrador.getCedula());
			listaUsuarios.add(nuevoAdministrador);
			mensaje = "El administrador fue creado";
		} catch (AdministradorException e) {
			mensaje  = e.getMessage();
		}
		return mensaje;
	}

	/**
	 * Metodo para verficar un administrador
	 * @param cedula
	 * @return
	 * @throws AdministradorException
	 */
	private Administrador verificarAdiministrador(String cedula) throws AdministradorException {
		Administrador administradorVerificado = null;

		for (Usuario administrador : listaUsuarios) {
			if(administrador instanceof Administrador){
				if(administrador.getCedula().equals(cedula)){
					administradorVerificado =  (Administrador) administrador;
					throw new AdministradorException ("El administrador ya existe");
				}
			}
		}
		return administradorVerificado;
	}

	/**
	 * Metodo para buscar un administrador
	 * @param cedula
	 * @return
	 * @throws AdministradorException
	 */
	public Administrador buscarAdministrador(String cedula) throws AdministradorException {
		Administrador administradorEncontrado = null;

		for (Usuario administrador : listaUsuarios) {
			if(administrador instanceof Administrador){
				if(administrador.getCedula().equals(cedula)){
					administradorEncontrado =  (Administrador) administrador;
					break;
				}
			}
		}
		if(administradorEncontrado == null){
			throw new AdministradorException ("Administrador no encontrado");
		}
		return administradorEncontrado;
	}

	/**
	 * Metodo para actualizar un administrador
	 * @param cedula
	 * @param listaUsuarios
	 * @return
	 * @throws AdministradorException
	 */
	public String actualizarAdministrador(String nombre, String apellido, String cedula, String direccion) throws AdministradorException{
		String mensaje = "El administrador fue actualizado";
		Administrador administradorObtenido = buscarAdministrador(cedula);

		for (int i = 0; i< listaUsuarios.size(); i++) {
			if(listaUsuarios.get(i) instanceof Administrador){
				if(administradorObtenido.equals(listaUsuarios.get(i))) {
					(listaUsuarios.get(i)).setNombre(nombre);
					(listaUsuarios.get(i)).setApellido(apellido);
					(listaUsuarios.get(i)).setCedula(cedula);
					(listaUsuarios.get(i)).setDireccion(direccion);
				}
			}
		}
		if(administradorObtenido == null) {
			throw new AdministradorException("El administrador no a sido creado");
		}


		return mensaje;
	}

	/**
	 * Metodo para eliminar un administrador
	 * @param cedula
	 * @return
	 * @throws AdministradorException
	 */
	public String eliminarAdministrador(String cedula) throws AdministradorException{
		String mensaje = "El administrador fue eliminado";
		Administrador administradorObtenido = buscarAdministrador(cedula);

		for (int i = 0; i < listaUsuarios.size(); i++) {
			if(listaUsuarios.get(i) instanceof Administrador){
				if(listaUsuarios.get(i).getCedula().equals(cedula)) {
					listaUsuarios.remove(administradorObtenido);
					break;
				}
			}
		}
		if(administradorObtenido == null) {
			throw new AdministradorException("El administrador no a sido creado");
		}
		return mensaje;
	}

}
