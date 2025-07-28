package com.pericles.locadora_veiculos.controller;

import com.pericles.locadora_veiculos.dto.carro.CarroFiltro;
import com.pericles.locadora_veiculos.dto.carro.CarroRequest;
import com.pericles.locadora_veiculos.dto.carro.CarroResponse;
import com.pericles.locadora_veiculos.dto.carro.CarroUpdate;
import com.pericles.locadora_veiculos.model.Carro;
import com.pericles.locadora_veiculos.service.CarroService;
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
        Carro carro = carroService.salvar(request);
        URI uri = uriBuilder
                .path("/carros/{id}")
                .buildAndExpand(carro.getId())
                .toUri();
        CarroResponse response = new CarroResponse(carro);
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping("/filtro")
    public ResponseEntity<Page<CarroResponse>> buscarComFiltro(
            @ModelAttribute @Valid CarroFiltro filtro,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<Carro> carros = carroService.buscarComFiltro(filtro, page, size);
        Page<CarroResponse> responses = carros.map(CarroResponse::new);
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroResponse> buscarPorId(@RequestParam Long id) {
        Carro carro = carroService.buscarPorId(id);
        CarroResponse response = new CarroResponse(carro);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarroResponse> atualizar(@RequestBody @Valid CarroUpdate request, Long id) {
        Carro carro = carroService.atualizar(request, id);
        CarroResponse response = new CarroResponse(carro);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CarroResponse> deletar(@RequestParam Long id) {
        carroService.deletar(id);
        return ResponseEntity.noContent().build();
    }


}
