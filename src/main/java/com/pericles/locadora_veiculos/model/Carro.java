package com.pericles.locadora_veiculos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "carros")
public class Carro extends Veiculo{

    @Column(name = "quantidade_portas", nullable = false)
    private int quantidadePortas;

    @Column(name = "ar_condicionado", nullable = false)
    private boolean arCondicionado;

    public Carro() {
        super();
    }

    public Carro(
            Long id,
            String placa,
            String modelo,
            String marca,
            int ano,
            BigDecimal valorDiaria,
            boolean disponivel,
            boolean ativo,
            int quantidadePortas,
            boolean arCondicionado
    ) {
        super(id, placa, modelo, marca, ano, valorDiaria, disponivel, ativo);
        this.quantidadePortas = quantidadePortas;
        this.arCondicionado = arCondicionado;
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public boolean isArCondicionado() {
        return arCondicionado;
    }

}
