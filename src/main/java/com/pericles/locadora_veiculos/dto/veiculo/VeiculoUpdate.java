package com.pericles.locadora_veiculos.dto.veiculo;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record VeiculoUpdate(
        Long id,

        @Size(max = 10, message = "Placa deve ter no máximo 10 caracteres")
        String placa,

        @Size(max = 80)
        String marca,

        @Size(max = 80)
        String modelo,

        @Min(value = 1886, message = "Ano inválido")
        @Max(value = 2100, message = "Ano inválido")
        Integer ano,

        @DecimalMin(value = "0.0", inclusive = false, message = "Valor da diária deve ser positivo")
        BigDecimal valorDiaria
) {
}
