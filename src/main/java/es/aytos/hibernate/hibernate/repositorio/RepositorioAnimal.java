package es.aytos.hibernate.hibernate.repositorio;

import org.hibernate.Session;

import es.aytos.hibernate.hibernate.modelo.Animal;
import es.aytos.hibernate.hibernate.util.HibernateUtil;

public class RepositorioAnimal {

	public static Integer crearAnimal(final Animal animal) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			final Integer idAnimal = (Integer) sesion.save(animal);

			sesion.getTransaction().commit();

			return idAnimal;

		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando el animal: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}
}