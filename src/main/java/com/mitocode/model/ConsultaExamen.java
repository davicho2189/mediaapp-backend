package com.mitocode.model;

import jakarta.persistence.*;

@Entity
@Table(name = "consulta_examen")
@IdClass(ConsultaExamenPK.class) //esto determina la llave compuesta en otra clase
public class ConsultaExamen {

	//[idConsulta(FK) idExamen(FK)] PK
	
	@Id
	private Consulta consulta;
	
	@Id
	private Examen examen;

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}
	
	
	
	
	
}
