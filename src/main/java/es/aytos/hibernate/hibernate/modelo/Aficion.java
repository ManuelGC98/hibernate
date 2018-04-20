package es.aytos.hibernate.hibernate.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "A_AFI")
public class Aficion {

	@Id
	@GeneratedValue
	@Column(name = "AFI_ID")
	private int idAficion;

	@Column(name = "AFI_NOM", nullable = false, length = 50)
	private String nombre;

	@ManyToMany(mappedBy = "aficiones")
	private List<Persona> personas = new ArrayList<>();

	public Aficion() {
	}

	public int getIdAficion() {
		return idAficion;
	}

	public void setIdAficion(int idAficion) {
		this.idAficion = idAficion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Persona> getPersonas() {
		return personas;
	}
}
