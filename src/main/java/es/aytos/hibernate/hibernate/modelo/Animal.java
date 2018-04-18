package es.aytos.hibernate.hibernate.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "A_ANI")
public class Animal {

	@Id
	@GeneratedValue
	@Column(name = "ANI_ID")
	private int idAnimal;

	@Column(name = "ANI_ESP", nullable = false, length = 50)
	private String especie;

	@Column(name = "ANI_RZA", nullable = true, length = 50)
	private String raza;

	@Column(name = "ANI_PDO", nullable = false, length = 50)
	private String paisDeOrigen;

	@Column(name = "ANI_EDA", nullable = false)
	private Integer edad;

	@Column(name = "ANI_PDE", nullable = false)
	private boolean enPeligroDeExtincion;

	public Animal() {
	}

	public int getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getPaisDeOrigen() {
		return paisDeOrigen;
	}

	public void setPaisDeOrigen(String paisDeOrigen) {
		this.paisDeOrigen = paisDeOrigen;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public boolean isEnPeligroDeExtincion() {
		return enPeligroDeExtincion;
	}

	public void setEnPeligroDeExtincion(boolean enPeligroDeExtincion) {
		this.enPeligroDeExtincion = enPeligroDeExtincion;
	}

}