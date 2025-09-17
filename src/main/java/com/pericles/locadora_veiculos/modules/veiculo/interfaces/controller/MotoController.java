package com.pericles.locadora_veiculos.modules.veiculo.interfaces.controller;

import com.pericles.locadora_veiculos.modules.veiculo.application.service.MotoService;
import com.pericles.locadora_veiculos.modules.veiculo.interfaces.dto.filter.MotoFilter;
import com.pericles.locadora_veiculos.modules.veiculo.interfaces.dto.request.MotoRequest;
import com.pericles.locadora_veiculos.modules.veiculo.interfaces.dto.response.MotoResponse;
import com.pericles.locadora_veiculos.modules.veiculo.interfaces.dto.update.MotoUpdate;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/motos")
public class MotoController {

    private final MotoService motoService;

    public MotoController(MotoService motoService) {
        this.motoService = motoService;
    }

    @PostMapping
    public ResponseEntity<MotoResponse> criar(@RequestBody @Valid MotoRequest request, UriComponentsBuilder uriBuilder) {
        MotoResponse response = motoService.salvar(request);
        URI uri = uriBuilder
                .path("motos/{id}")
                .buildAndExpand(response.veiculoResponse().id())
                .toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<MotoResponse>> buscarComFiltro(
            @ModelAttribute MotoFilter filtro,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<MotoResponse> responses = motoService.buscarComFiltro(filtro, page, size);
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotoResponse> buscarPorId(@PathVariable Long id) {
        MotoResponse response = motoService.buscarPorId(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MotoResponse> atualizar(@RequestBody @Valid MotoUpdate request, @PathVariable Long id) {
        MotoResponse response = motoService.atualizar(request, id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MotoResponse> deletar(@PathVariable Long id) {
        motoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
