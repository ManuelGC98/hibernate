package es.aytos.hibernate.hibernate.pruebas;

import es.aytos.hibernate.hibernate.modelo.EstadoCivil;
import es.aytos.hibernate.hibernate.modelo.Persona;
import es.aytos.hibernate.hibernate.repositorio.RepositorioPersona;

public class Pruebas {
	public static void main(String[] args) {
		System.out.println(crearPersona());
	}

	private static Integer crearPersona() {
		final Persona persona = new Persona();
		persona.setNombre("Manuel");
		persona.setApellidos("Garcia");
		persona.setEdad(19);
		persona.setEstadoCivil(EstadoCivil.SOLTERO);
		persona.setDni("12345678X");

		return RepositorioPersona.crearPersona(persona);
	}
}
