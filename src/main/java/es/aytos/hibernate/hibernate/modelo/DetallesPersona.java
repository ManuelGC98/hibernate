package es.aytos.hibernate.hibernate.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "A_DPE")
public class DetallesPersona {

	@Id
	@GeneratedValue
	@Column(name = "DPE_ID")
	private int idDetallesPersona;
	
	@Column(name = "DPE_TH")
	private boolean tieneHijos;

	@Column(name = "DPE_GD")
	private boolean gustaDeporte;

	@Column(name = "DPE_TM")
	private boolean tieneMascotas;

	 @OneToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "USU_ID")
	    private Persona persona;
	 
	public DetallesPersona() {
	}

	public boolean isTieneHijos() {
		return tieneHijos;
	}

	public void setTieneHijos(boolean tieneHijos) {
		this.tieneHijos = tieneHijos;
	}

	public boolean isGustaDeporte() {
		return gustaDeporte;
	}

	public void setGustaDeporte(boolean gustaDeporte) {
		this.gustaDeporte = gustaDeporte;
	}

	public boolean isTieneMascotas() {
		return tieneMascotas;
	}

	public void setTieneMascotas(boolean tieneMascotas) {
		this.tieneMascotas = tieneMascotas;
	}
	
	public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
