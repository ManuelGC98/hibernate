package es.aytos.hibernate.hibernate.repositorio;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import es.aytos.hibernate.hibernate.modelo.Cliente;
import es.aytos.hibernate.hibernate.modelo.Persona;
import es.aytos.hibernate.hibernate.util.HibernateUtil;

public class RepositorioCliente {

	public static Integer crearCliente(final Cliente cliente) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			final Integer idCliente = (Integer) sesion.save(cliente);

			sesion.getTransaction().commit();

			return idCliente;

		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando el cliente: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static void modificarCliente(Cliente cliente) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			sesion.saveOrUpdate(cliente);

			sesion.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Se ha producido un error modificando el cliente: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static void modificarCliente(final String nombre, final Integer idCliente) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			sesion.createQuery("Update Cliente set cli_nom = :nombre where usu_id = :identificador")
					.setParameter("nombre", nombre).setParameter("identificador", idCliente).executeUpdate();

			sesion.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Se ha producido un error modificando el ciente: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static void eliminarCliente(Integer idCliente) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			sesion.createQuery("delete Usuario where usu_id = :idCliente").setParameter("idCliente", idCliente)
					.executeUpdate();

			sesion.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Se ha producido un error eliminando el cliente: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static List<Persona> consultarCliente(Integer idCliente) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			final Query<Persona> consulta = sesion.createQuery("from Cliente where usu_id = :idCliente");
			consulta.setParameter("idCliente", idCliente);

			return consulta.list();

		} catch (Exception e) {
			System.out.println("Se ha producido un error consultando el cliente: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}
}
