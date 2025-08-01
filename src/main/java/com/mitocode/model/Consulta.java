package com.mitocode.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "consulta") // , schema = "m01")
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConsulta;

	// JPQL | FROM Consulta c WHERE c.paciente.nombres = '';
	// private Integer idPaciente;

	@ManyToOne
	@JoinColumn(name = "id_paciente", nullable = false, foreignKey = @ForeignKey(name = "FK_consulta_paciente"))
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "id_medico", nullable = false, foreignKey = @ForeignKey(name = "FK_consulta_medico"))
	private Medico medico;

	@ManyToOne
	@JoinColumn(name = "id_especialidad", nullable = false, foreignKey = @ForeignKey(name = "fk_consulta_especialidad"))
	private Especialidad especialidad;

	@Column(name = "num_consultorio", length = 3, nullable = true)
	private String numConsultorio;

	// @Temporal(TemporalType.DATE)
	// @Column(name = "fecha")	
	@Column(name = "fecha", nullable = false)
	private LocalDateTime fecha;
	// Spring Boot 1.5 , pom.xml jsr 310, json ISODate YYYY-MM-DDTHH:MM:ss	

	//los list no se ejecutan a nivel de bd, sino a nivel de java (logico)
	// mappedby se usa para "consulta" es el atributo que enlaza en la otra tabla (en este caso Clase DetalleConsulta el atributo private Consulta "consulta;"
	// cascade se usa para
	@OneToMany(mappedBy = "consulta", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<DetalleConsulta> detalleConsulta;

	public Integer getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public String getNumConsultorio() {
		return numConsultorio;
	}

	public void setNumConsultorio(String numConsultorio) {
		this.numConsultorio = numConsultorio;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

//	public List<DetalleConsulta> getDetalleConsulta() {
//		return detalleConsulta;
//	}
//
//	public void setDetalleConsulta(List<DetalleConsulta> detalleConsulta) {
//		this.detalleConsulta = detalleConsulta;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idConsulta == null) ? 0 : idConsulta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta other = (Consulta) obj;
		if (idConsulta == null) {
			if (other.idConsulta != null)
				return false;
		} else if (!idConsulta.equals(other.idConsulta))
			return false;
		return true;
	}

	
}
