package com.pericles.locadora_veiculos.dto.carro;

import com.pericles.locadora_veiculos.dto.veiculo.VeiculoRequest;
import com.pericles.locadora_veiculos.model.Carro;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record CarroRequest(
        @Valid
        VeiculoRequest veiculoRequest,

        @Min(value = 2, message = "Quantidade de portas deve ser no mínimo 2")
        @Max(value = 6, message = "Quantidade de portas deve ser no máximo 6")
        Integer quantidadePortas,

        Boolean arCondicionado
) {
        public Carro paraEntidade() {
                return new Carro(
                        null,
                        this.veiculoRequest().placa(),
                        this.veiculoRequest().modelo(),
                        this.veiculoRequest().marca(),
                        this.veiculoRequest().ano(),
                        this.veiculoRequest().valorDiaria(),
                        true,
                        true,
                        this.quantidadePortas,
                        this.arCondicionado
                );
        }
}
