package redVendedores.test;

import redVendedores.exception.AdministradorException;
import redVendedores.exception.ProductoException;
import redVendedores.exception.VendedorException;
import redVendedores.model.Administrador;
import redVendedores.model.Producto;
import redVendedores.model.RedV;
import redVendedores.model.TipoEstado;
import redVendedores.model.Vendedor;
import junit.framework.TestCase;

public class Test extends TestCase{

	/**
	 * Declaraciones de nuevos vendedores, administradores y productos apra hacer las pruebas
	 */
	private RedV redV = new RedV("Red de vendedores");

	Vendedor vendedor1 = new Vendedor("Julio", "Lara", "12345", "Cl 14" , null, null);
	Vendedor vendedor2 = new Vendedor("Julio", "Lara", "12345", "Cl 14", null, null);
	Vendedor vendedor3 = new Vendedor("Juan", "Galvis", "Cl 19", "12345", null, null);
	Administrador administrador = new Administrador("Julian", "Rivera", "1104544247", "Calle 09", null);
	Producto producto = new Producto("ana", "12333", "", "", TipoEstado.PUBLICADO, vendedor1);
	String  mensaje =  redV.crearVendedor(vendedor1);
	String  mensaje2 =  redV.crearVendedor(vendedor2);
	String mensaje3 = redV.crearAdministrador(administrador);
	String mensajeCrear = vendedor1.crearProducto(producto);

	//test para crear un vendedor
	public void testCrearVendedor() {
		String mensaje = ("El vendedor fue creado");
		assertEquals("El vendedor ya existe", mensaje);
	}

	//test para actualizar vendedor
	public void testActualizarVendedor() throws VendedorException {
		String mensajeActualizar = redV.actualizarVendedor("Juan", "Galvis", "12345", "CL9");
		String mensajeEsperado = "El vendedor fue actualizado";
		assertEquals(mensajeEsperado,mensajeActualizar );
	}
	//Test para saber si elimino un vendedor
	public void testEliminarVendedor() throws VendedorException{
		assertTrue(redV.eliminarVendedor("12345") == ("El vendedor fue eliminado"));
	}

	//test de crear administrador
	public void testCrearAdministrador() {
		assertEquals("El administrador fue creado", mensaje3);
	}
	//Test de actualizar un administrador
	public void testActualizarAdministrador() throws AdministradorException {
		String mensajeActualizar = redV.actualizarAdministrador("Cesar", "Rey", "1104544247", "Cl 09");
		assertEquals("El administrador fue actualizado", mensajeActualizar);
	}
	//test para eliminar un administrador
	public void testEliminarAdministrador() throws AdministradorException{
		assertTrue(redV.eliminarAdministrador("1104544247") == ("El administrador fue eliminado"));
	}
	//test para crear un producto
	public void testCrearProducto(){
		assertTrue(mensajeCrear == "El producto fue creado");
	}
	//test para actualizar un producto
	public void testActualizarProducto() throws ProductoException {
		String mensajeActualizar = vendedor1.actualizarProducto("Xiaomi POCO", "1213", "Telefono", TipoEstado.PUBLICADO);
		assertEquals("El producto fue actualizado", mensajeActualizar);
	}
	//test para eliminar un producto
	public void testEliminarProducto() throws ProductoException {
		assertTrue(vendedor1.eliminarProducto("123")== ("El producto fue eliminado"));
	}

}