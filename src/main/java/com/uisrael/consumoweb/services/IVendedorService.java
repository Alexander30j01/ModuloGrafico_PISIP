package com.uisrael.consumoweb.services;


import java.util.List;

import com.uisrael.consumoweb.model.dto.response.VendedorResponseDto;


public interface IVendedorService {


    List<VendedorResponseDto> listarVendedores();


    VendedorResponseDto buscarPorId(int idVendedor);


    void actualizarUbicacion(int idVendedor, String ubicacion);



}