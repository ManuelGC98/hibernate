package es.aytos.hibernate.hibernate.pruebas;

import java.util.Date;

import es.aytos.hibernate.hibernate.modelo.EstadoCivil;
import es.aytos.hibernate.hibernate.modelo.Persona;
import es.aytos.hibernate.hibernate.repositorio.RepositorioPersona;

public class PruebasPersona {
	public static void main(String[] args) {
		System.out.println(crearPersona("Usuario1", "12345678X"));
		System.out.println(crearPersona("Usuario2", "12345678C"));

		modificarPersona(1);
		RepositorioPersona.eliminarPersona(2);
		// System.out.println(RepositorioPersona.consultarPersona(1).toString());
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
}
