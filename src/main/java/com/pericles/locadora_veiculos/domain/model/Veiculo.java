package com.pericles.locadora_veiculos.domain.model;

import com.pericles.locadora_veiculos.interfaces.dto.veiculo.VeiculoUpdate;
import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.math.BigDecimal;

@Entity
@Table(name = "veiculos")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10, unique = true)
    private String placa;

    @Column(nullable = false, length = 80)
    private String modelo;

    @Column(nullable = false, length = 80)
    private String marca;

    @Column(nullable = false)
    private int ano;

    @Column(name = "valor_diaria", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorDiaria;

    @Column(nullable = false)
    private boolean disponivel;

    @Column(nullable = false)
    private boolean ativo;

    public Veiculo() {}

    public Veiculo(
            String placa,
            String marca,
            String modelo,
            int ano,
            BigDecimal valorDiaria
    ) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valorDiaria = valorDiaria;
        this.disponivel = true;
        this.ativo = true;
    }

    public abstract BigDecimal calcularValorDiaria();

    public Long getId() {
        return id;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public boolean isAtivo() {
        return ativo;
    }

    protected BigDecimal getValorDiaria() {
        return valorDiaria;
    }

    protected void atualizarCom(VeiculoUpdate dto) {
        if (dto.placa() != null) this.placa = dto.placa();
        if (dto.modelo() != null) this.modelo = dto.modelo();
        if (dto.marca() != null) this.marca = dto.marca();
        if (dto.ano() != null) this.ano = dto.ano();
        if (dto.valorDiaria() != null) this.valorDiaria = dto.valorDiaria();
    }

    public void desativar() {
        this.ativo = false;
    }
}
