package com.ibero.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibero.app.model.Rol;
import com.ibero.app.services.implement.RolServiceImpl;

@RestController
@RequestMapping("/app/ibero/rol")
public class RolController {

	@Autowired
	private RolServiceImpl rolService;
	
	@GetMapping("/listar")
	public List<Rol> listarRoles(){
		return rolService.obtenerRoles();
	}
	
	@PostMapping("/crear")
	public Rol guardarRol(@RequestBody Rol rol) {
		return rolService.crearRol(rol);
	}
	
	@PutMapping("/actualizar")
	public Rol actualizarRol(@RequestBody Rol rol) {
		return rolService.actualizarRol(rol);
	}
	
	@DeleteMapping("/eliminar/{idRol}")
	public String eliminarRol(@PathVariable int idRol) {
		return rolService.eliminarRol(idRol);
	}
	
}
