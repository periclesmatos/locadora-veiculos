package com.pericles.locadora_veiculos.domain.model;

import com.pericles.locadora_veiculos.interfaces.dto.moto.MotoUpdate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "motos")
public class Moto extends Veiculo{

    private static final BigDecimal TAXA_ALTA_CILINDRADA = BigDecimal.valueOf(30);
    private static final int LIMITE_CICLINDRADAS_PARA_ACRESCIMO = 500;

    @Column(nullable = false)
    private int cilidradas;

    public Moto() {
        super();
    }

    public Moto(
            String placa,
            String modelo,
            String marca,
            int ano,
            BigDecimal valorDiaria,
            int cilidradas
    ) {
        super(placa, modelo, marca, ano, valorDiaria);
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

    public void atualizarCom(MotoUpdate dto) {
        if (dto.veiculoUpdate() != null) super.atualizarCom(dto.veiculoUpdate());
        if (dto.cilindradas() != null) this.cilidradas = dto.cilindradas();
    }

}
