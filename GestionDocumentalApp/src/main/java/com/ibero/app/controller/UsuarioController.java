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

import com.ibero.app.model.Usuario;
import com.ibero.app.services.implement.UsuarioServiceImpl;

@RestController
@RequestMapping("/app/ibero/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	@GetMapping("/listar")
	public List<Usuario> obtenerUsuarios(){
		return usuarioService.obtenerUsuarios();
	}
	
	@PostMapping("/crear")
	public Usuario crearUsuario(@RequestBody Usuario usuario) {
		return usuarioService.crearUsuario(usuario);
	}
	
	@PutMapping("/actualizar")
	public Usuario editarUsuario(@RequestBody Usuario usuario) {
		return usuarioService.editarUsuario(usuario);
	}
	
	@DeleteMapping("/eliminar/{idUsuario}")
	public String eliminarUsuario(@PathVariable long idUsuario) {
		return usuarioService.eliminarUsuario(idUsuario);
	}
	
}
