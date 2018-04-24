package es.aytos.hibernate.hibernate.repositorio;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import es.aytos.hibernate.hibernate.modelo.Persona;
import es.aytos.hibernate.hibernate.modelo.Cliente;
import es.aytos.hibernate.hibernate.modelo.Direccion;
import es.aytos.hibernate.hibernate.modelo.EstadoCivil;
import es.aytos.hibernate.hibernate.util.HibernateUtil;

public class RepositorioPersona {

	public static Integer crearPersona(final Persona persona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			final Integer idPersona = (Integer) sesion.save(persona);

			sesion.getTransaction().commit();

			return idPersona;

		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static void modificarPersona(Persona persona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			sesion.saveOrUpdate(persona);

			sesion.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Se ha producido un error modificando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static void modificarPersona(final Integer idPersona, final String nombre) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			final Persona personaBBDD = (Persona) sesion.createQuery("from Persona where PER_ID = :idPersona")
					.setParameter("idPersona", idPersona).uniqueResult();

			personaBBDD.setNombre(nombre);
			sesion.saveOrUpdate(personaBBDD);

			sesion.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Se ha producido un error modificando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static void modificarPersona(final String nombre, final Integer idPersona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			sesion.createQuery("Update Persona set per_nom = :nombre where usu_id = :identificador")
					.setParameter("nombre", nombre).setParameter("identificador", idPersona).executeUpdate();

			sesion.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Se ha producido un error modificando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static void eliminarPersona(Integer idPersona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			sesion.createQuery("delete Usuario where usu_id = :idPersona").setParameter("idPersona", idPersona)
					.executeUpdate();

			sesion.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Se ha producido un error eliminando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static List<Persona> consultarPersona(Integer idPersona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			final Query<Persona> consulta = sesion.createQuery("from Persona p where p.idUsuario = :identificador");
			consulta.setParameter("identificador", idPersona);

			return consulta.list();

		} catch (Exception e) {
			System.out.println("Se ha producido un error consultando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static Persona consultarNombreCompleto(Integer idPersona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			Persona persona = (Persona) sesion.createQuery("from Usuario Usu where Usu.idUsuario = :idPersona")
					.setParameter("idPersona", idPersona).uniqueResult();

			// Voy a pintar los telefonos de la persona
			// persona.getTelefonos().stream().forEach(telefono ->
			// System.out.println(telefono.getTelefono()));

			return persona;

		} catch (Exception e) {
			System.out.println("Se ha producido un error creando una persona: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException(e);
		} finally {
			sesion.close();
		}
	}

	public static List<Persona> consultar(String nombre, String apellidos, String dni, EstadoCivil estadoCivil,
			String login) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			final StringBuilder sb = new StringBuilder("from Persona Where 1=1");
			if (!nombre.isEmpty()) {
				sb.append(" and PER_NOM in (select nombre from Persona where per_nom like :nombre)");
			}
			if (!apellidos.isEmpty()) {
				sb.append(" and PER_APE like :apellidos");
			}
			if (!dni.isEmpty()) {
				sb.append(" and PER_DNI = :dni");
			}
			if (estadoCivil != null) {
				sb.append(" and PER_ECV = :estadoCivil");
			}
			if (login != null && !login.isEmpty()) {
				sb.append(" and USU_LOG = :login");
			}

			final org.hibernate.query.Query<Persona> consulta = sesion.createQuery(sb.toString());

			if (!nombre.isEmpty()) {
				consulta.setParameter("nombre", nombre);
			}
			if (!apellidos.isEmpty()) {
				consulta.setParameter("apellidos", apellidos);
			}
			if (!dni.isEmpty()) {
				consulta.setParameter("dni", dni);
			}
			if (estadoCivil != null) {
				consulta.setParameter("estadoCivil", estadoCivil.ordinal());
			}
			if (login != null && !login.isEmpty()) {
				consulta.setParameter("login", login);
			}

			return consulta.list();
		} catch (Exception e) {
			System.out.println("Se ha producido un error creando una persona: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException(e);
		} finally {
			sesion.close();
		}
	}
}
