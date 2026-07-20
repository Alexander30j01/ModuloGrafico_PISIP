package com.uisrael.consumoweb.services.impl;


import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


import com.uisrael.consumoweb.model.dto.response.VendedorResponseDto;
import com.uisrael.consumoweb.services.IVendedorService;



@Service
public class VendedorServiceImpl implements IVendedorService {



    private WebClient webClient;



    public VendedorServiceImpl(WebClient webClient) {

        this.webClient = webClient;

    }





    @Override
    public List<VendedorResponseDto> listarVendedores() {


        return this.webClient
                .get()
                .uri("/vendedores")
                .retrieve()
                .bodyToFlux(VendedorResponseDto.class)
                .collectList()
                .block();


    }





    @Override
    public VendedorResponseDto buscarPorId(int idVendedor) {


        return this.webClient
                .get()
                .uri("/vendedores/" + idVendedor)
                .retrieve()
                .bodyToMono(VendedorResponseDto.class)
                .block();


    }



    @Override
    public void actualizarUbicacion(int idVendedor, String ubicacion) {


        this.webClient
                .patch()
                .uri(uriBuilder -> uriBuilder
                        .path("/vendedores/ubicacion")
                        .queryParam("idVendedor", idVendedor)
                        .queryParam("ubicacion", ubicacion)
                        .build())
                .retrieve()
                .toBodilessEntity()
                .block();


    }


}