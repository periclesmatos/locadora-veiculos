package com.pericles.locadora_veiculos.modules.veiculo.interfaces.dto.response;

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
