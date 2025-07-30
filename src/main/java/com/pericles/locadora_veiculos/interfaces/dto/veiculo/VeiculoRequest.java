package com.pericles.locadora_veiculos.interfaces.dto.veiculo;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record VeiculoRequest(
        @NotBlank(message = "Placa é obrigatória")
        @Size(max = 10, message = "Placa deve ter no máximo 10 caracteres")
        String placa,

        @NotBlank(message = "Marca é obrigatória")
        @Size(max = 80)
        String marca,

        @NotBlank(message = "Modelo é obrigatório")
        @Size(max = 80)
        String modelo,

        @Min(value = 1886, message = "Ano inválido")
        @Max(value = 2100, message = "Ano inválido")
        Integer ano,

        @NotNull(message = "Valor da diária é obrigatório")
        @DecimalMin(value = "0.0", inclusive = false, message = "Valor da diária deve ser positivo")
        BigDecimal valorDiaria
) {
}
