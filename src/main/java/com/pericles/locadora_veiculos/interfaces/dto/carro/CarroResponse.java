package com.pericles.locadora_veiculos.interfaces.dto.carro;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.pericles.locadora_veiculos.interfaces.dto.veiculo.VeiculoResponse;

public record CarroResponse(
        @JsonUnwrapped
        VeiculoResponse veiculoResponse,
        Integer quantidadePortas,
        Boolean arCondicionado
) {
}
