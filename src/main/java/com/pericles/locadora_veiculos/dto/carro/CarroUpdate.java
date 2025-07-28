package com.pericles.locadora_veiculos.dto.carro;

import com.pericles.locadora_veiculos.dto.veiculo.VeiculoUpdate;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record CarroUpdate(
        @Valid
        VeiculoUpdate veiculoUpdate,

        @Min(value = 2, message = "Quantidade de portas deve ser no mínimo 2")
        @Max(value = 6, message = "Quantidade de portas deve ser no máximo 6")
        Integer quantidadePortas,

        Boolean arCondicionado
) {
}
