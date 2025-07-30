package com.pericles.locadora_veiculos.interfaces.dto.carro;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.pericles.locadora_veiculos.interfaces.dto.veiculo.VeiculoFiltro;
import jakarta.validation.Valid;

public record CarroFiltro(
        @Valid
        @JsonUnwrapped
        VeiculoFiltro veiculoFiltro,
        Integer quantidadePortas,
        Boolean arCondicionado
) {
}
