package es.aytos.hibernate.hibernate.pruebas;

import java.util.List;

import es.aytos.hibernate.hibernate.modelo.Aficion;
import es.aytos.hibernate.hibernate.repositorio.RepositorioAficion;

public class PruebasCache {

	public static void main(String[] args) {
		consultarAficiones();
	}

	private static void consultarAficiones() {
		final List<Aficion> aficiones = RepositorioAficion.consultarAficiones();

		aficiones.stream().map(Aficion::getNombre).forEach(System.out::println);
	}
}
