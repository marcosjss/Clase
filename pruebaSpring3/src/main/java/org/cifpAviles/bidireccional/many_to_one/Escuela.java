package org.cifpAviles.bidireccional.many_to_one;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name="uni_escuela_many_to_one")
@Table(name="uni_escuela_many_to_one")
public class Escuela {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name ="idEscuela")
	private String nombreEscuela;
	private String direccion;
}
