package es.aytos.hibernate.hibernate.repositorio;

import java.util.List;

import org.hibernate.Session;
import es.aytos.hibernate.hibernate.modelo.Aficion;
import es.aytos.hibernate.hibernate.util.HibernateUtil;

public class RepositorioAficion {

	public static List<Aficion> consultarAficiones() {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			List<Aficion> aficiones = (List<Aficion>) sesion.createQuery("from Aficion").setCacheable(true).list();

			return aficiones;

		} catch (Exception e) {
			System.out.println("Se ha producido un error consultando las aficiones: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}
}
