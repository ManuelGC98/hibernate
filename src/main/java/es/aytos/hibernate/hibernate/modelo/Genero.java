package es.aytos.hibernate.hibernate.modelo;

public enum Genero {

	MASCULINO("M"), FEMENINO("F");

	private String codigo;

	private Genero(final String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

}
