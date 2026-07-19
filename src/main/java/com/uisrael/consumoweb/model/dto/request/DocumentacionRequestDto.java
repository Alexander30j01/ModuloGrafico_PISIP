package com.uisrael.consumoweb.model.dto.request;

import java.sql.Date;

import lombok.Data;

@Data
public class DocumentacionRequestDto {
	
	private int idDocumentacion;
	private String tipoDocumentacion;
	private Date fechaCarga;
	private String ruta;
	private boolean estado;

}
