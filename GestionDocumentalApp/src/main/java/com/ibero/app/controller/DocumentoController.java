package com.ibero.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibero.app.model.Documento;
import com.ibero.app.model.Usuario;
import com.ibero.app.services.implement.DocumentoServiceImpl;

@RestController
@RequestMapping("/app/ibero/documento")
public class DocumentoController {
	
	@Autowired
	private DocumentoServiceImpl documentoService;
	
	@GetMapping("/usuarios")
	public List<Usuario> obtenerUsuariosActivos() {
		return documentoService.obtenerUsuariosActivos();
	}
	
	@GetMapping("/usuario/{idUsuario}")
	public List<Documento> obtenerDocumentosPorUsuario(@PathVariable int idUsuario) {
		return documentoService.obtenerDocumentosPorUsuario(idUsuario);
	}
	
	@GetMapping("/descargar/{idDocumento}")
	public String descargarDocumento(@PathVariable long idDocumento) {
		return documentoService.descargarDocumento(idDocumento);
	}
	
	@GetMapping("/rechazar/{idDocumento}/{comentario}")
	public String rechazarDocumento(@PathVariable long idDocumento, @PathVariable String comentario) {
		return documentoService.rechazarDocumento(idDocumento, comentario);
	}
	
	@PostMapping("/aprobrar")
	public String aprobrarDocumento(@RequestBody Documento documento) {
		return documentoService.aprobrarDocumento(documento);
	}
	
}
