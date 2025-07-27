package com.pericles.locadora_veiculos.model;

import jakarta.persistence.Column;

import java.math.BigDecimal;

public class Moto extends Veiculo{

    @Column(nullable = false)
    private int cilidradas;

    public Moto() {
        super();
    }

    public Moto(
            Long id,
            String placa,
            String modelo,
            String marca,
            int ano,
            BigDecimal valorDiaria,
            boolean disponivel,
            boolean ativo,
            int cilidradas
    ) {
        super(id, placa, modelo, marca, ano, valorDiaria, disponivel, ativo);
        this.cilidradas = cilidradas;
    }

    public int getCilidradas() {
        return cilidradas;
    }

}
