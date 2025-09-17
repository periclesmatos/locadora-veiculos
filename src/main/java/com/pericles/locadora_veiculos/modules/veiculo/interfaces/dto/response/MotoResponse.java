package com.pericles.locadora_veiculos.modules.veiculo.interfaces.dto.response;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public record MotoResponse(
        @JsonUnwrapped
        VeiculoResponse veiculoResponse,
        int cilindradas
) {
}
