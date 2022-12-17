package com.ibero.app.services;

import java.util.List;

import com.ibero.app.model.Usuario;

public interface IUsuarioService {
	
	//Listar usuarios
	List<Usuario> obtenerUsuarios();
	
	//Crear usuario
	Usuario crearUsuario(Usuario usuario);
	
	//Editar usuario
	Usuario editarUsuario(Usuario usuario);
	
	//Eliminar usuario
	String eliminarUsuario(long idUsuario);

}
