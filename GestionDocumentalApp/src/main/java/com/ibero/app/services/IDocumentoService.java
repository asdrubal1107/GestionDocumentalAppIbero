package com.ibero.app.services;

import java.util.List;

import com.ibero.app.model.Documento;
import com.ibero.app.model.Usuario;

public interface IDocumentoService {
	
	//Listar usuarios activos
	List<Usuario> obtenerUsuariosActivos();
	
	//Listar documentos por usuario
	List<Documento> obtenerDocumentosPorUsuario(long idUsuario);
	
	//Descargar documento
	String descargarDocumento(Long idDocumento);
	
	//Rechazar documento
	String rechazarDocumento(Long idDocumento, String comentario);
	
	//Aprobar documento
	String aprobrarDocumento(Documento documento);
	
}
