package com.ibero.app.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Documento {
	
	public Documento() {}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_documento")
	private Long idDocumento;
	
	@Column(name = "id_usuario")
	private Long idUsuario;
	
	@Column
	private String url;
	
	@Column(name = "doc_base_64")
	private String docBase64;
	
	@Column
	private String comentario;
	
	@Column(name = "fecha_vencimiento")
	private Date fechaVencimiento;
	
	@Column(name = "estado_documento")
	private String estadoDocumento;

	public Long getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(Long idDocumento) {
		this.idDocumento = idDocumento;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getDocBase64() {
		return docBase64;
	}

	public void setDocBase64(String docBase64) {
		this.docBase64 = docBase64;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getEstadoDocumento() {
		return estadoDocumento;
	}

	public void setEstadoDocumento(String estadoDocumento) {
		this.estadoDocumento = estadoDocumento;
	}

}
