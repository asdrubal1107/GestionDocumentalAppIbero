package com.ibero.app.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibero.app.model.Documento;
import com.ibero.app.repo.DocumentoRepo;
import com.ibero.app.services.ICargaDescargaService;

@Service
public class CargaDescargaServiceImpl implements ICargaDescargaService {

	@Autowired
	private DocumentoRepo documentoRepo;
	
	@Override
	public List<Documento> listarArchivos(long idUsuario) {
		return documentoRepo.findByIdUsuario(idUsuario);
	}

	@Override
	public String descargarArchivo(long idDocumento) {
		String URL = documentoRepo.findById(idDocumento).orElseThrow().getUrl();
		if(URL == null) {
			return "No se encontro el documento en el sistema";
		}
		return URL;
	}

	@Override
	public Documento cargarArchivo(Documento documento) {
		documento.setUrl("gestion/documento/cargar/");
		documento.setEstadoDocumento("PENDIENTE");
		return documentoRepo.save(documento);
	}

}
