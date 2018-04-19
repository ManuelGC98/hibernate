package es.aytos.hibernate.hibernate.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "A_DIR")
public class Direccion {

	@Id
	@GeneratedValue
	@Column(name = "DIR_ID")
	private Integer idDireccion;

	@Column(name = "DIR_PRO", nullable = false, length = 50)
	private String provincia;

	@Column(name = "DIR_CIU", nullable = false, length = 50)
	private String ciudad;

	@Column(name = "DIR_COP", nullable = false, length = 10)
	private String codigoPostal;

	@Column(name = "DIR_CAL", nullable = false, length = 50)
	private String calle;

	@Column(name = "DIR_NUM", nullable = false, length = 5)
	private Integer numero;

	@Column(name = "DIR_BLO", nullable = false, length = 5)
	private Integer bloque;

	@Column(name = "DIR_PLA", nullable = false, length = 5)
	private Integer planta;

	@Column(name = "DIR_PUE", nullable = false, length = 5)
	private String puerta;

	@ManyToMany(mappedBy = "direcciones")
	private List<Persona> propietarios = new ArrayList<>();

	public Direccion() {
	}

	public Direccion(String calle, Integer numero, String codigoPostal) {
		this.calle = calle;
		this.numero = numero;
		this.codigoPostal = codigoPostal;
	}

	public Integer getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(Integer idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getBloque() {
		return bloque;
	}

	public void setBloque(Integer bloque) {
		this.bloque = bloque;
	}

	public Integer getPlanta() {
		return planta;
	}

	public void setPlanta(Integer planta) {
		this.planta = planta;
	}

	public String getPuerta() {
		return puerta;
	}

	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}

	public List<Persona> getPropietarios() {
		return propietarios;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Direccion direccion = (Direccion) o;
		return Objects.equals(calle, direccion.calle) && Objects.equals(numero, direccion.numero)
				&& Objects.equals(codigoPostal, direccion.codigoPostal);
	}

	@Override
	public int hashCode() {
		return Objects.hash(calle, numero, codigoPostal);
	}
}
