package com.pericles.locadora_veiculos.interfaces.dto.moto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.pericles.locadora_veiculos.interfaces.dto.veiculo.VeiculoResponse;

public record MotoResponse(
        @JsonUnwrapped
        VeiculoResponse veiculoResponse,
        int cilindradas
) {
}
