package com.pericles.locadora_veiculos.modules.veiculo.interfaces.dto.filter;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.validation.Valid;

public record CarroFilter(
        @Valid
        @JsonUnwrapped
        VeiculoFilter veiculoFiltro,
        Integer quantidadePortas,
        Boolean arCondicionado
) {
}
