package com.ibero.app.services.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ibero.app.model.Documento;
import com.ibero.app.model.Usuario;
import com.ibero.app.repo.DocumentoRepo;
import com.ibero.app.repo.UsuarioRepo;
import com.ibero.app.services.IDocumentoService;

@Service
public class DocumentoServiceImpl implements IDocumentoService {
	
	private DocumentoRepo documentoRepo;
	private UsuarioRepo usuarioRepo;
	
	public DocumentoServiceImpl(DocumentoRepo documentoRepo, UsuarioRepo usuarioRepo) {
		this.documentoRepo = documentoRepo;
		this.usuarioRepo = usuarioRepo;
	}

	@Override
	public List<Usuario> obtenerUsuariosActivos() {
		return usuarioRepo.findByEstado("ACTIVO");
	}
	
	@Override
	public List<Documento> obtenerDocumentosPorUsuario(long idUsuario) {
		return documentoRepo.findByIdUsuario(idUsuario);
	}
	
	@Override
	public String descargarDocumento(Long idDocumento) {
		Optional<Documento> documento = documentoRepo.findById(idDocumento);
		if(documento.isEmpty()) {
			return "No se encontro el documento con id: " + idDocumento;
		}
		return documento.orElseThrow().getUrl();
	}

	@Override
	public String rechazarDocumento(Long idDocumento, String comentario) {
		Optional<Documento> documento = documentoRepo.findById(idDocumento);
		if(documento.isEmpty()) {
			return "No se encontro el documento con id: " + idDocumento;
		}
		
		Documento documentoActualizar = documento.orElseThrow();
		documentoActualizar.setComentario(comentario);
		documentoActualizar.setEstadoDocumento("RECHAZADO");
		documentoRepo.save(documentoActualizar);
		
		Documento documentoValidar = documentoRepo.findById(idDocumento).orElseThrow();
		
		if(documentoValidar.getComentario() != comentario) {
			return "No se pudo rechazar el documento";
		}
		
		return "Se rechazo el documento con id " + documentoValidar.getIdDocumento();
	}

	@Override
	public String aprobrarDocumento(Documento documento) {
		Optional<Usuario> usuarioValidar = usuarioRepo.findById(documento.getIdUsuario());
		if(usuarioValidar.isEmpty()) {
			return "El usuario con id " + documento.getIdUsuario() + " no esta registrado en el sistema.";
		}
		
		Optional<Documento> documentoBD = documentoRepo.findById(documento.getIdDocumento());
		if(documentoBD.isEmpty()) {
			return "No se encontro el documento con id: " + documento.getIdDocumento();
		}
		documento.setEstadoDocumento("APROBADO");
		documentoRepo.save(documento);
		Documento documentoValidar = documentoRepo.findById(documento.getIdDocumento()).orElseThrow();
		
		if(documentoValidar.getEstadoDocumento() != documento.getEstadoDocumento()) {
			return "No se pudo aprobrar el documento";
		}
		
		return "Se aprobo el documento con id: " + documento.getIdDocumento();
	}

}
