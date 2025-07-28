package com.pericles.locadora_veiculos.dto.carro;

import com.pericles.locadora_veiculos.dto.veiculo.VeiculoResponse;
import com.pericles.locadora_veiculos.model.Carro;

import java.math.BigDecimal;

public record CarroResponse(
        VeiculoResponse veiculoResponse,
        Integer quantidadePortas,
        Boolean arCondicionado
) {
    public CarroResponse(Carro carro) {
        this(
            new VeiculoResponse(
                    carro.getId(),
                    carro.getPlaca(),
                    carro.getMarca(),
                    carro.getModelo(),
                    carro.getAno(),
                    carro.calcularValorDiaria(),
                    carro.isDisponivel()
            ),
            carro.getQuantidadePortas(),
            carro.isArCondicionado()
        );
    }
}
