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
import com.ibero.app.services.implement.CargaDescargaServiceImpl;

@RestController
@RequestMapping("/app/ibero/gestion/documento")
public class CargaDescargaController {
	
	@Autowired
	private CargaDescargaServiceImpl cargaDescargaService;
	
	@GetMapping("/listar/{idUsuario}")
	public List<Documento> listarArchivos(@PathVariable long idUsuario){
		return cargaDescargaService.listarArchivos(idUsuario);
	}
	
	@GetMapping("/descargar/{idDocumento}")
	public String descargarDocumento(@PathVariable long idDocumento) {
		return cargaDescargaService.descargarArchivo(idDocumento);
	}
	
	@PostMapping("/cargar")
	public Documento cargarDocumento(@RequestBody Documento documento) {
		return cargaDescargaService.cargarArchivo(documento);
	}

}
