package com.ibero.app.services.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ibero.app.model.Rol;
import com.ibero.app.model.Usuario;
import com.ibero.app.repo.RolRepo;
import com.ibero.app.repo.UsuarioRepo;
import com.ibero.app.services.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	private UsuarioRepo usuarioRepo;
	private RolRepo rolRepo;
	
	public UsuarioServiceImpl(UsuarioRepo usuarioRepo, RolRepo rolRepo) {
		this.usuarioRepo = usuarioRepo;
		this.rolRepo = rolRepo;
	}
	
	@Override
	public List<Usuario> obtenerUsuarios() {
		return usuarioRepo.findAll();
	}

	@Override
	public Usuario crearUsuario(Usuario usuario) {
		Optional<Rol> rol = rolRepo.findById(usuario.getIdRol());
		if(rol.isEmpty()) {
			return null;
		}
		return usuarioRepo.save(usuario);
	}

	@Override
	public Usuario editarUsuario(Usuario usuario) {
		Optional<Rol> rol = rolRepo.findById(usuario.getIdRol());
		if(rol.isEmpty()) {
			return null;
		}
		Optional<Usuario> usuarioValidar = usuarioRepo.findById(usuario.getIdUsuario());
		if(usuarioValidar.isEmpty()) {
			return null;
		}
		return usuarioRepo.save(usuario);
	}

	@Override
	public String eliminarUsuario(long idUsuario) {
		Optional<Usuario> usuarioValidar = usuarioRepo.findById(idUsuario);
		if(usuarioValidar.isEmpty()) {
			return "No se encontro el usuario con id: " + idUsuario;
		}
		usuarioRepo.deleteById(idUsuario);
		return "Se elimino el usuario";
	}

}
