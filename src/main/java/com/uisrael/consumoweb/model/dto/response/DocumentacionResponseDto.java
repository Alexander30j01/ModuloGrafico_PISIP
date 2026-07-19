package com.uisrael.consumoweb.model.dto.response;

import java.sql.Date;

import lombok.Data;

@Data
public class DocumentacionResponseDto {
	
	private int idDocumentacion;
	private String tipoDocumentacion;
	private Date fechaCarga;
	private String ruta;
	private boolean estado;

}
