package com.pericles.locadora_veiculos.interfaces.dto.moto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.pericles.locadora_veiculos.interfaces.dto.veiculo.VeiculoFiltro;
import jakarta.validation.Valid;

public record MotoFiltro(
        @Valid
        @JsonUnwrapped
        VeiculoFiltro veiculoFiltro,
        Integer cilindradas
) {
}
