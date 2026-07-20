package com.uisrael.consumoweb.services.impl;


import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


import com.uisrael.consumoweb.model.dto.response.PedidoResponseDto;
import com.uisrael.consumoweb.services.IPedidoService;



@Service
public class PedidoServiceImpl implements IPedidoService {



    private WebClient webClient;



    public PedidoServiceImpl(WebClient webClient) {

        this.webClient = webClient;

    }





    @Override
    public List<PedidoResponseDto> listarPedidos() {


        return this.webClient
                .get()
                .uri("/pedidos")
                .retrieve()
                .bodyToFlux(PedidoResponseDto.class)
                .collectList()
                .block();


    }





    @Override
    public PedidoResponseDto buscarPorId(int idPedido) {


        return this.webClient
                .get()
                .uri("/pedidos/" + idPedido)
                .retrieve()
                .bodyToMono(PedidoResponseDto.class)
                .block();


    }





    @Override
    public void aprobarPedido(int idPedido) {


        this.webClient
                .patch()
                .uri("/pedidos/aprobar/" + idPedido)
                .retrieve()
                .toBodilessEntity()
                .block();


    }


    @Override
    public void rechazarPedido(int idPedido, String observacion) {


        this.webClient
                .patch()
                .uri(uriBuilder -> uriBuilder
                        .path("/pedidos/rechazar/" + idPedido)
                        .queryParam("observacion", observacion)
                        .build())
                .retrieve()
                .toBodilessEntity()
                .block();


    }



}