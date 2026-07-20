package com.uisrael.consumoweb.services;


import java.util.List;

import com.uisrael.consumoweb.model.dto.response.PedidoResponseDto;


public interface IPedidoService {


    List<PedidoResponseDto> listarPedidos();


    PedidoResponseDto buscarPorId(int idPedido);


    void aprobarPedido(int idPedido);


    void rechazarPedido(int idPedido, String observacion);



}