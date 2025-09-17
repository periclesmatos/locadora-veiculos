package com.pericles.locadora_veiculos.modules.veiculo.interfaces.dto.update;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record CarroUpdate(
        @Valid
        @JsonUnwrapped
        VeiculoUpdate veiculoUpdate,

        @Min(value = 2, message = "Quantidade de portas deve ser no mínimo 2")
        @Max(value = 6, message = "Quantidade de portas deve ser no máximo 6")
        Integer quantidadePortas,

        Boolean arCondicionado
) {
}
