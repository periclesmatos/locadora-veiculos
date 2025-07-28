package com.pericles.locadora_veiculos.dto.veiculo;

import java.math.BigDecimal;

public record VeiculoResponse(
        Long id,
        String placa,
        String marca,
        String modelo,
        Integer ano,
        BigDecimal valorDiaria,
        Boolean disponivel
) {
}
