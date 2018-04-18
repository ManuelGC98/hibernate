package es.aytos.hibernate.hibernate.repositorio;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import es.aytos.hibernate.hibernate.modelo.Animal;
import es.aytos.hibernate.hibernate.modelo.Persona;
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

	public static void modificarAnimal(final String nombre, final Integer idAnimal) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			sesion.createQuery("Update Animal set ani_nom = :nombre where ani_id = :identificador")
					.setParameter("nombre", nombre).setParameter("identificador", idAnimal).executeUpdate();

			sesion.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando el animal: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static void eliminarAnimal(Integer idAnimal) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			sesion.createQuery("delete Animal where ani_id = :idAnimal").setParameter("idAnimal", idAnimal)
					.executeUpdate();

			sesion.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando el animal: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static List<Animal> consultarAnimal(Integer idAnimal) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			final Query<Animal> consulta = sesion.createQuery("from Animal where ani_id = :idAnimal");
			consulta.setParameter("idAnimal", idAnimal);

			return consulta.list();

		} catch (Exception e) {
			System.out.println("Se ha producido un error consultando el animal: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}
}