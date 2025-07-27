package com.pericles.locadora_veiculos.dto.carro;

import com.pericles.locadora_veiculos.model.Carro;

import java.math.BigDecimal;

public record CarroResponse(
        Long id,
        String placa,
        String modelo,
        String marca,
        int ano,
        BigDecimal valorDiaria,
        int quantidadePortas,
        boolean arCondicionado,
        boolean disponivel
) {
    public CarroResponse(Carro carro) {
        this(
            carro.getId(),
            carro.getPlaca(),
            carro.getModelo(),
            carro.getMarca(),
            carro.getAno(),
            carro.getValorDiaria(),
            carro.getQuantidadePortas(),
            carro.isArCondicionado(),
            carro.isDisponivel()
        );
    }
}
