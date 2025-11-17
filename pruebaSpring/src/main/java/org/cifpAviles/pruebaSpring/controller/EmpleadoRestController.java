package org.cifpAviles.pruebaSpring.controller;

import java.util.List;
import java.util.Optional;

import org.cifpAviles.pruebaSpring.entities.Empleado;
import org.cifpAviles.pruebaSpring.repositories.EmpleadoRepository;
import org.cifpAviles.pruebaSpring.services.EmpleadoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api/empleado")
public class EmpleadoRestController {

	private final EmpleadoService empleadoService;
	
	public EmpleadoRestController(EmpleadoService empleadoService, EmpleadoRepository empleadoRepository) {
		this.empleadoService = empleadoService;
	}
	
	@GetMapping("info_empleados")
	@ResponseBody
	public List<Empleado> getEmpleados() {
		return empleadoService.finAll();				
	}
	
	@PostMapping("add_empleado")
	public void crearEmpleado(@RequestBody Empleado empleado ) {
		empleadoService.insert(empleado);
	}
	
	@GetMapping("get_empleado/{id}")
	@ResponseBody
	public Optional<Empleado> obtenerEmpleadoPorId(@PathVariable Long id){
		return empleadoService.findById(id);
	}
}
