package es.aytos.hibernate.hibernate.conversores;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

import es.aytos.hibernate.hibernate.modelo.Genero;

@Convert
public class Converter implements AttributeConverter<Genero, String> {

	@Override
	public String convertToDatabaseColumn(Genero genero) {
		if (genero == null) {
			return null;
		}
		return genero.getCodigo();
	}

	@Override
	public Genero convertToEntityAttribute(String generoBBDD) {
		if (generoBBDD == null) {
			return null;
		}
		return Genero.getEnumerado(generoBBDD);
	}
}