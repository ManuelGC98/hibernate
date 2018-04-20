package es.aytos.hibernate.hibernate.modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import es.aytos.hibernate.hibernate.conversores.Converter;

@Entity
@Table(name = "A_PER")
public class Persona extends Usuario {

	@Column(name = "PER_NOM", nullable = false, length = 50)
	private String nombre;

	@Column(name = "PER_APE", nullable = false, length = 250)
	private String apellidos;

	@Column(name = "PER_DNI", nullable = false, length = 9, unique = true)
	private String dni;

	@Column(name = "PER_EDA", nullable = false)
	private Integer edad;

	@Column(name = "PER_ECV", nullable = false)
	@Enumerated
	private EstadoCivil estadoCivil;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Direccion> direcciones = new ArrayList<>();

	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Telefono> telefonos = new ArrayList<>();

	@OneToOne(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private DetallesPersona detalles;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	private List<Aficion> aficiones = new ArrayList<>();

	@Column(name = "PER_GEN", nullable = false, length = 1)
	@Convert(converter = Converter.class)
	private Genero genero;

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Persona() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	@Override
	public String toString() {
		return "Persona [Nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", edad=" + edad
				+ ", estado Civil=" + estadoCivil + "]";
	}

	public List<Direccion> getDirecciones() {
		return direcciones;
	}

	public void altaDireccion(Direccion direccion) {
		direcciones.add(direccion);
		direccion.getPropietarios().add(this);
	}

	public void borrarDireccion(Direccion direccion) {
		direcciones.remove(direccion);
		direccion.getPropietarios().remove(this);
	}

	public List<Telefono> getTelefonos() {
		return telefonos;
	}

	public void altaTelefono(Telefono telefono) {
		telefonos.add(telefono);
		telefono.setPersona(this);
	}

	public void borrarTelefono(Telefono telefono) {
		telefonos.remove(telefono);
		telefono.setPersona(null);
	}

	public DetallesPersona getDetalles() {
		return detalles;
	}

	public void altaDetalles(DetallesPersona detalles) {
		detalles.setPersona(this);
		this.detalles = detalles;
	}

	public void borrarDetalles() {
		if (detalles != null) {
			detalles.setPersona(null);
			this.detalles = null;
		}
	}

	public List<Aficion> getAficion() {
		return aficiones;
	}

	public void altaAficion(Aficion aficion) {
		aficiones.add(aficion);
		aficion.getPersonas().add(this);
	}

	public void borrarAficion(Aficion aficion) {
		aficiones.remove(aficion);
		aficion.getPersonas().remove(this);
	}
}
