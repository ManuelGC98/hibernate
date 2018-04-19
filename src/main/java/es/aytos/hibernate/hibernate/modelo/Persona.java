package es.aytos.hibernate.hibernate.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

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

}
