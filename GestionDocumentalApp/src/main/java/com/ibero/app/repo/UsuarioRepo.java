package com.ibero.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibero.app.model.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Long>{

	List<Usuario> findByEstado(String estado);
	
}
