package com.pericles.locadora_veiculos.interfaces.dto.moto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.pericles.locadora_veiculos.interfaces.dto.veiculo.VeiculoRequest;
import jakarta.validation.Valid;

public record MotoRequest(
        @Valid
        @JsonUnwrapped
        VeiculoRequest veiculoRequest,
        Integer cilindradas
) {
}
