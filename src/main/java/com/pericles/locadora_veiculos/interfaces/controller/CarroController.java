package com.pericles.locadora_veiculos.interfaces.controller;

import com.pericles.locadora_veiculos.interfaces.dto.carro.CarroFiltro;
import com.pericles.locadora_veiculos.interfaces.dto.carro.CarroRequest;
import com.pericles.locadora_veiculos.interfaces.dto.carro.CarroResponse;
import com.pericles.locadora_veiculos.interfaces.dto.carro.CarroUpdate;
import com.pericles.locadora_veiculos.application.service.CarroService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/carros")
public class CarroController {

    private final CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @PostMapping
    public ResponseEntity<CarroResponse> criar(@RequestBody @Valid CarroRequest request, UriComponentsBuilder uriBuilder) {
        CarroResponse response = carroService.salvar(request);
        URI uri = uriBuilder
                .path("/carros/{id}")
                .buildAndExpand(response.veiculoResponse().id())
                .toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<CarroResponse>> buscarComFiltro(
            @ModelAttribute @Valid CarroFiltro filtro,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<CarroResponse> responses = carroService.buscarComFiltro(filtro, page, size);
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id:[0-9]+}")
    public ResponseEntity<CarroResponse> buscarPorId(@PathVariable Long id) {
        CarroResponse response = carroService.buscarPorId(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarroResponse> atualizar(@RequestBody @Valid CarroUpdate request, Long id) {
        CarroResponse response = carroService.atualizar(request, id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CarroResponse> deletar(@RequestParam Long id) {
        carroService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
