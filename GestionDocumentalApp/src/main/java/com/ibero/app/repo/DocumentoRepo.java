package com.ibero.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibero.app.model.Documento;

public interface DocumentoRepo extends JpaRepository<Documento, Long> {
	
	//Incluir ver documentos por usuario
	List<Documento> findByIdUsuario(Long idUsuario);
	
}
