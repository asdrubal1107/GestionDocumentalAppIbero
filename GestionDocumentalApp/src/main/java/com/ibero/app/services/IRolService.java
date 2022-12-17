package com.ibero.app.services;

import java.util.List;

import com.ibero.app.model.Rol;

public interface IRolService {

	//Listar roles
	List<Rol> obtenerRoles();
	
	//Crear rol
	Rol crearRol(Rol rol);
	
	//Editar rol
	Rol actualizarRol(Rol rol);
	
	//Eliminar rol
	String eliminarRol(int idRol);
	
}
