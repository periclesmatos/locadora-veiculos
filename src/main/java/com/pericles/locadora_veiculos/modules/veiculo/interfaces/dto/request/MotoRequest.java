package com.pericles.locadora_veiculos.modules.veiculo.interfaces.dto.request;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.validation.Valid;

public record MotoRequest(
        @Valid
        @JsonUnwrapped
        VeiculoRequest veiculoRequest,
        Integer cilindradas
) {
}
