package com.pericles.locadora_veiculos.dto.carro;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record CarroRequest(
        @NotBlank(message = "Placa é obrigatória")
        @Size(max = 10, message = "Placa deve ter no máximo 10 caracteres")
        String placa,

        @NotBlank(message = "Modelo é obrigatório")
        @Size(max = 80)
        String modelo,

        @NotBlank(message = "Marca é obrigatória")
        @Size(max = 80)
        String marca,

        @Min(value = 1886, message = "Ano inválido")
        @Max(value = 2100, message = "Ano inválido")
        int ano,

        @NotNull(message = "Valor da diária é obrigatório")
        @DecimalMin(value = "0.0", inclusive = false, message = "Valor da diária deve ser positivo")
        BigDecimal valorDiaria,

        @Min(value = 2, message = "Quantidade de portas deve ser no mínimo 2")
        @Max(value = 6, message = "Quantidade de portas deve ser no máximo 6")
        int quantidadePortas,

        boolean arCondicionado
) {
}
