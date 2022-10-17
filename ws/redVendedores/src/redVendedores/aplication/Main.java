package redVendedores.aplication;

import javax.swing.JOptionPane;

import redVendedores.model.RedV;
import redVendedores.model.Vendedor;

public class Main {
	static RedV red = new RedV("Red de vendedores");
	public static void main(String[] args) {
		Vendedor vendedor1 = new Vendedor("Juan", "Lopez", "Cl 13", "12355", null, null);
		Vendedor vendedor2 = new Vendedor("Juan", "Lopez", "Cl 13", "12355", null, null);


		String  mensaje =  red.crearVendedor(vendedor1);
		String  mensaje2 =  red.crearVendedor(vendedor2);

		JOptionPane.showMessageDialog(null, mensaje);
		JOptionPane.showMessageDialog(null, mensaje2);

	}

}

