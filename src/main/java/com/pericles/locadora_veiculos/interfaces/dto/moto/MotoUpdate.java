package com.pericles.locadora_veiculos.interfaces.dto.moto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.pericles.locadora_veiculos.interfaces.dto.veiculo.VeiculoUpdate;
import jakarta.validation.Valid;

public record MotoUpdate(
        @Valid
        @JsonUnwrapped
        VeiculoUpdate veiculoUpdate,
        Integer cilindradas
) {
}
