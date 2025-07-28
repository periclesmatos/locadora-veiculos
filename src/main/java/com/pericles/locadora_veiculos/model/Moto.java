package com.pericles.locadora_veiculos.model;

import jakarta.persistence.Column;

import java.math.BigDecimal;

public class Moto extends Veiculo{

    private static final BigDecimal TAXA_ALTA_CILINDRADA = BigDecimal.valueOf(30);
    private static final int LIMITE_CICLINDRADAS_PARA_ACRESCIMO = 500;

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

    @Override
    public BigDecimal calcularValorDiaria() {
        BigDecimal valor = super.getValorDiaria();
        if (cilidradas > LIMITE_CICLINDRADAS_PARA_ACRESCIMO) {
            valor = valor.add(TAXA_ALTA_CILINDRADA);
        }
        return valor;
    }

    public int getCilidradas() {
        return cilidradas;
    }

}
