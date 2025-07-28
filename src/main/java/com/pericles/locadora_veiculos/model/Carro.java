package com.pericles.locadora_veiculos.model;

import com.pericles.locadora_veiculos.dto.carro.CarroUpdate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

import java.math.BigDecimal;

@Entity
@Table(name = "carros")
public class Carro extends Veiculo{

    private static final BigDecimal TAXA_AR_CONDICIONADO = BigDecimal.valueOf(50);

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
            String marca,
            String modelo,
            int ano,
            BigDecimal valorDiaria,
            boolean disponivel,
            boolean ativo,
            int quantidadePortas,
            boolean arCondicionado
    ) {
        super(id, placa, marca, modelo, ano, valorDiaria, disponivel, ativo);
        this.quantidadePortas = quantidadePortas;
        this.arCondicionado = arCondicionado;
    }

    @Override
    public BigDecimal calcularValorDiaria() {
        BigDecimal valor = super.getValorDiaria();
        if (arCondicionado) {
            valor = valor.add(TAXA_AR_CONDICIONADO);
        }
        return valor;
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public boolean isArCondicionado() {
        return arCondicionado;
    }

    public void atualizarCom(CarroUpdate dto) {
        if (dto.veiculoUpdate() != null) super.atualizarCom(dto.veiculoUpdate());
        if (dto.quantidadePortas() != null) this.quantidadePortas = dto.quantidadePortas();
        if (dto.arCondicionado() != null) this.arCondicionado = dto.arCondicionado();
    }
}
