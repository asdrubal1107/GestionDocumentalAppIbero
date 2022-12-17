package com.ibero.app.services.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibero.app.model.Rol;
import com.ibero.app.repo.RolRepo;
import com.ibero.app.services.IRolService;

@Service
public class RolServiceImpl implements IRolService{

	@Autowired
	private RolRepo rolRepo;
	
	@Override
	public List<Rol> obtenerRoles() {
		return rolRepo.findAll();
	}

	@Override
	public Rol crearRol(Rol rol) {
		return rolRepo.save(rol);
	}

	@Override
	public Rol actualizarRol(Rol rol) {
		Optional<Rol> rolActualizar = rolRepo.findById(rol.getIdRol());
		if(rolActualizar.isPresent()) {
			return rolRepo.save(rol);
		}
		return null;
	}

	@Override
	public String eliminarRol(int idRol) {
		Optional<Rol> rolEliminar = rolRepo.findById(idRol);
		if(rolEliminar.isEmpty()) {
			return "No se encontro un rol con el id " + idRol;
		}
		rolRepo.deleteById(rolEliminar.orElseThrow().getIdRol());
		return "Se elimino el rol " + rolEliminar.orElseThrow().getNombre();
	}

}
