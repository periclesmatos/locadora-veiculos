package com.pericles.locadora_veiculos.modules.veiculo.interfaces.dto.filter;

import jakarta.validation.constraints.DecimalMin;

import java.math.BigDecimal;

public record VeiculoFilter(
        String placa,
        String marca,
        String modelo,
        Integer ano,
        Boolean disponivel,

        @DecimalMin(value = "0.0", inclusive = true, message = "Valor mínimo inválido")
        BigDecimal valorDiariaMin,
        @DecimalMin(value = "0.0", inclusive = true, message = "Valor maximo inválido")
        BigDecimal valorDiariaMax
) {
}
