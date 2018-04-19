package es.aytos.hibernate.hibernate.pruebas;

import es.aytos.hibernate.hibernate.modelo.Animal;
import es.aytos.hibernate.hibernate.repositorio.RepositorioAnimal;

public class PruebasAnimal {

	public static void main(String[] args) {
		System.out.println(crearAnimal());
		// RepositorioAnimal.modificarAnimal("Yang", 1);
		// RepositorioAnimal.eliminarAnimal(1);
		// System.out.println(RepositorioAnimal.consultarAnimal(1).toString());
	}

	private static Integer crearAnimal() {
		final Animal animal = new Animal();
		animal.setNombre("Ying");
		animal.setEspecie("Oso");
		animal.setRaza("Panda");
		animal.setEdad(7);
		animal.setPaisDeOrigen("China");
		animal.setEnPeligroDeExtincion(true);

		return RepositorioAnimal.crearAnimal(animal);
	}
}
