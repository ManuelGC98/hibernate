package es.aytos.hibernate.hibernate.pruebas;

import java.util.Date;
import java.util.List;

import es.aytos.hibernate.hibernate.modelo.DetallesPersona;
import es.aytos.hibernate.hibernate.modelo.Direccion;
import es.aytos.hibernate.hibernate.modelo.EstadoCivil;
import es.aytos.hibernate.hibernate.modelo.Persona;
import es.aytos.hibernate.hibernate.modelo.Telefono;
import es.aytos.hibernate.hibernate.repositorio.RepositorioPersona;

public class PruebasPersona {
	public static void main(String[] args) {
		System.out.println(crearPersona("Usuario1", "12345678X"));
		// System.out.println(crearPersona("Usuario2", "12345678C"));

		// modificarPersona(1);
		// RepositorioPersona.eliminarPersona(2);
		// System.out.println(RepositorioPersona.consultarPersona(1).toString());
		// System.out.println(getTelefonos("Usuario1", "12345678X"));
	}

	private static Integer crearPersona(String login, String dni) {
		final Persona persona = new Persona();
		persona.setNombre("Manuel");
		persona.setApellidos("Garcia");
		persona.setEdad(19);
		persona.setEstadoCivil(EstadoCivil.SOLTERO);
		persona.setDni(dni);
		persona.setFechaAlta(new Date());
		persona.setLogin(login);
		persona.setPassword("Contraseña");

		// Direccion direccion1 = new Direccion();
		// direccion1.setProvincia("Sevilla");
		// direccion1.setCiudad("Écija");
		// direccion1.setCalle("Calle");
		// direccion1.setNumero(1);
		// direccion1.setCodigoPostal("4005A");
		// direccion1.setBloque(1);
		// direccion1.setPlanta(2);
		// direccion1.setPuerta("A");
		//
		// Direccion direccion2 = new Direccion();
		// direccion1.setProvincia("Sevilla");
		// direccion1.setCiudad("Écija");
		// direccion1.setCalle("Calle");
		// direccion1.setNumero(18);
		// direccion1.setCodigoPostal("4007B");
		// direccion1.setBloque(1);
		// direccion1.setPlanta(2);
		// direccion1.setPuerta("A");
		//
		// persona.altaDireccion(direccion1);
		// persona.altaDireccion(direccion2);

		// persona.borrarDireccion(direccion1);

		Telefono telefono1 = new Telefono(623456789);
		Telefono telefono2 = new Telefono(621654098);

		persona.altaTelefono(telefono1);
		persona.altaTelefono(telefono2);

		// persona.borrarTelefono(telefono1);

		DetallesPersona detalles = new DetallesPersona();
		detalles.setTieneHijos(false);
		detalles.setGustaDeporte(false);
		detalles.setTieneMascotas(false);

		persona.altaDetalles(detalles);

		return RepositorioPersona.crearPersona(persona);
	}

	private static void modificarPersona(Integer idPersona) {
		final Persona persona = new Persona();
		persona.setNombre("Pepe");
		persona.setApellidos("Garcia");
		persona.setEdad(28);
		persona.setEstadoCivil(EstadoCivil.SOLTERO);
		persona.setDni("12345678X");
		persona.setFechaAlta(new Date());
		persona.setLogin("Usuario1");
		persona.setPassword("Contraseña");
		persona.setIdUsuario(idPersona);

		RepositorioPersona.modificarPersona(persona);
	}

	private static List<Telefono> getTelefonos(String login, String dni) {
		final Persona persona = new Persona();
		persona.setNombre("Manuel");
		persona.setApellidos("Garcia");
		persona.setEdad(19);
		persona.setEstadoCivil(EstadoCivil.SOLTERO);
		persona.setDni(dni);
		persona.setFechaAlta(new Date());
		persona.setLogin(login);
		persona.setPassword("Contraseña");

		Telefono telefono1 = new Telefono(623456789);
		Telefono telefono2 = new Telefono(621654098);

		persona.altaTelefono(telefono1);
		persona.altaTelefono(telefono2);

		RepositorioPersona.crearPersona(persona);
		
		return persona.getTelefonos();
	}
}
