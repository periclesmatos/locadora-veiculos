package com.pericles.locadora_veiculos.modules.veiculo.interfaces.mapper;

import com.pericles.locadora_veiculos.modules.veiculo.domain.model.Moto;
import com.pericles.locadora_veiculos.modules.veiculo.interfaces.dto.request.MotoRequest;
import com.pericles.locadora_veiculos.modules.veiculo.interfaces.dto.response.MotoResponse;
import com.pericles.locadora_veiculos.modules.veiculo.interfaces.dto.response.VeiculoResponse;

public class MotoMapper {

    public static Moto toEntity(MotoRequest dto) {
        return new Moto(
                dto.veiculoRequest().placa(),
                dto.veiculoRequest().marca(),
                dto.veiculoRequest().modelo(),
                dto.veiculoRequest().ano(),
                dto.veiculoRequest().valorDiaria(),
                dto.cilindradas()
        );
    }

    public static MotoResponse toResponse(Moto moto) {
        return new MotoResponse(
                new VeiculoResponse(
                        moto.getId(),
                        moto.getPlaca(),
                        moto.getMarca(),
                        moto.getModelo(),
                        moto.getAno(),
                        moto.calcularValorDiaria(),
                        moto.isDisponivel()
                ),
                moto.getCilidradas()
        );
    }
}
