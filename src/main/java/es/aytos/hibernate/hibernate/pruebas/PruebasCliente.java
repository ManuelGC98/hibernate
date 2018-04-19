package es.aytos.hibernate.hibernate.pruebas;

import java.util.Date;

import es.aytos.hibernate.hibernate.modelo.Cliente;
import es.aytos.hibernate.hibernate.modelo.EstadoCivil;
import es.aytos.hibernate.hibernate.repositorio.RepositorioCliente;

public class PruebasCliente {

	public static void main(String[] args) {
		System.out.println(crearCliente("Cliente1", "12345678Z"));
		System.out.println(crearCliente("Cliente2", "12345678V"));

		modificarCliente(1);
		RepositorioCliente.eliminarCliente(2);
		// System.out.println(RepositorioCliente.consultarCliente(2).toString());
	}

	private static Integer crearCliente(String login, String dni) {
		final Cliente cliente = new Cliente();
		cliente.setNombre("Manuel");
		cliente.setApellidos("Garcia");
		cliente.setEdad(19);
		cliente.setEstadoCivil(EstadoCivil.SOLTERO);
		cliente.setDni(dni);
		cliente.setFechaAlta(new Date());
		cliente.setLogin(login);
		cliente.setPassword("Contraseña");

		return RepositorioCliente.crearCliente(cliente);
	}

	private static void modificarCliente(Integer idCliente) {
		final Cliente cliente = new Cliente();
		cliente.setNombre("Rudolfo");
		cliente.setApellidos("Garcia");
		cliente.setEdad(34);
		cliente.setEstadoCivil(EstadoCivil.CASADO);
		cliente.setDni("12345678X");
		cliente.setFechaAlta(new Date());
		cliente.setLogin("Cliente1");
		cliente.setPassword("Contraseña");
		cliente.setIdUsuario(idCliente);

		RepositorioCliente.modificarCliente(cliente);
	}
}
