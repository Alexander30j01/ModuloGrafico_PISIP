package com.uisrael.consumoweb.services;

import java.util.Optional;

import com.uisrael.consumoweb.model.dto.response.DocumentacionResponseDto;

public interface IDocumentacionService {

	DocumentacionResponseDto guardar(DocumentacionResponseDto documento);

	void eliminar(int idDocumentacion);

	Optional<DocumentacionResponseDto> obtenerPorId(int idDocumentacion);

}
