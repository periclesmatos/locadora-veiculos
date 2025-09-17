package com.pericles.locadora_veiculos.modules.veiculo.interfaces.dto.update;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.validation.Valid;

public record MotoUpdate(
        @Valid
        @JsonUnwrapped
        VeiculoUpdate veiculoUpdate,
        Integer cilindradas
) {
}
