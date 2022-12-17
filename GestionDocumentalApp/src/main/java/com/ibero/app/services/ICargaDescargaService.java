package com.ibero.app.services;

import java.util.List;

import com.ibero.app.model.Documento;

public interface ICargaDescargaService {
	
	//Listar archivos del usuario en sesion
	List<Documento> listarArchivos(long idUsuario);
	
	//Descargar archivo
	String descargarArchivo(long idDocumento);
	
	//Cargar archivo
	Documento cargarArchivo(Documento documento);
	
}
