package com.pericles.locadora_veiculos.modules.veiculo.interfaces.dto.response;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public record CarroResponse(
        @JsonUnwrapped
        VeiculoResponse veiculoResponse,
        int quantidadePortas,
        boolean arCondicionado
) {
}
