package com.pericles.locadora_veiculos.dto.carro;

import com.pericles.locadora_veiculos.dto.veiculo.VeiculoFiltro;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;

import java.math.BigDecimal;

public record CarroFiltro(
        @Valid
        VeiculoFiltro veiculoFiltro,
        Integer quantidadePortas,
        Boolean arCondicionado
) {
}
