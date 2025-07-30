package com.pericles.locadora_veiculos.interfaces.controller;

import com.pericles.locadora_veiculos.application.service.MotoService;
import com.pericles.locadora_veiculos.interfaces.dto.moto.MotoRequest;
import com.pericles.locadora_veiculos.interfaces.dto.moto.MotoResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/motos")
public class MotoController {

    private MotoService motoService;

    public MotoController(MotoService motoService) {
        this.motoService = motoService;
    }

    @PostMapping
    public ResponseEntity<MotoResponse> criar(@RequestBody @Valid MotoRequest request, UriComponentsBuilder uriBuilder) {
        MotoResponse response = motoService.salvar(request);

    }

}
