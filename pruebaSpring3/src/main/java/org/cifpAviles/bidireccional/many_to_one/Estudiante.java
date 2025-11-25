package org.cifpAviles.bidireccional.many_to_one;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name="uni_estudiante_many_to_one")
@Table(name="uni_estudiante_many_to_one")
public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="idEscuela")
	private Escuela escuela;
	
	private String nombreEsrudiante;
	private String curso;
}
