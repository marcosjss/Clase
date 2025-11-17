package org.cifpAviles.pruebaSpring.services;

import java.util.List;
import java.util.Optional;

import org.cifpAviles.pruebaSpring.entities.Empleado;

public interface EmpleadoService {

	List<Empleado> finAll();
	void insert(Empleado empleado);
	void borrar (Empleado empleado);
	public Optional<Empleado> findById(Long id);
}
