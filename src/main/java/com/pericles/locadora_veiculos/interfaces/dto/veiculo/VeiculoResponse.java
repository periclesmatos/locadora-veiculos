package com.pericles.locadora_veiculos.interfaces.dto.veiculo;

import java.math.BigDecimal;

public record VeiculoResponse(
        long id,
        String placa,
        String marca,
        String modelo,
        int ano,
        BigDecimal valorDiaria,
        boolean disponivel
) {
}
