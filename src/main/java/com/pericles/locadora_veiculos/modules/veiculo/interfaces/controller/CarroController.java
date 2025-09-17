package com.pericles.locadora_veiculos.modules.veiculo.interfaces.controller;

import com.pericles.locadora_veiculos.modules.veiculo.interfaces.dto.filter.CarroFilter;
import com.pericles.locadora_veiculos.modules.veiculo.interfaces.dto.request.CarroRequest;
import com.pericles.locadora_veiculos.modules.veiculo.interfaces.dto.response.CarroResponse;
import com.pericles.locadora_veiculos.modules.veiculo.interfaces.dto.update.CarroUpdate;
import com.pericles.locadora_veiculos.modules.veiculo.application.service.CarroService;
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
            @ModelAttribute @Valid CarroFilter filtro,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<CarroResponse> responses = carroService.buscarComFiltro(filtro, page, size);
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroResponse> buscarPorId(@PathVariable Long id) {
        CarroResponse response = carroService.buscarPorId(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarroResponse> atualizar(@RequestBody @Valid CarroUpdate request, @PathVariable Long id) {
        CarroResponse response = carroService.atualizar(request, id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CarroResponse> deletar(@PathVariable Long id) {
        carroService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
