package com.uisrael.consumoweb.services.impl;


import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


import com.uisrael.consumoweb.model.dto.response.ReporteResponseDto;
import com.uisrael.consumoweb.services.IReporteService;



@Service
public class ReporteServiceImpl implements IReporteService {



    private WebClient webClient;



    public ReporteServiceImpl(WebClient webClient) {

        this.webClient = webClient;

    }

    @Override
    public ReporteResponseDto generarReporte() {


        return this.webClient
                .get()
                .uri("/reportes/generar")
                .retrieve()
                .bodyToMono(ReporteResponseDto.class)
                .block();


    }



}