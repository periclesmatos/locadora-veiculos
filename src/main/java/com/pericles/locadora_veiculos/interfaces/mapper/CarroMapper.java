package com.pericles.locadora_veiculos.interfaces.mapper;

import com.pericles.locadora_veiculos.interfaces.dto.carro.CarroRequest;
import com.pericles.locadora_veiculos.interfaces.dto.carro.CarroResponse;
import com.pericles.locadora_veiculos.interfaces.dto.veiculo.VeiculoResponse;
import com.pericles.locadora_veiculos.domain.model.Carro;

public class CarroMapper {

    public static Carro toEntity(CarroRequest dto) {
        return new Carro(
                dto.veiculoRequest().placa(),
                dto.veiculoRequest().marca(),
                dto.veiculoRequest().modelo(),
                dto.veiculoRequest().ano(),
                dto.veiculoRequest().valorDiaria(),
                dto.quantidadePortas(),
                dto.arCondicionado()
        );
    }

    public static CarroResponse toResponse(Carro carro) {
        return new CarroResponse(
                new VeiculoResponse(
                        carro.getId(),
                        carro.getPlaca(),
                        carro.getMarca(),
                        carro.getModelo(),
                        carro.getAno(),
                        carro.calcularValorDiaria(),
                        carro.isDisponivel()
                ),
                carro.getQuantidadePortas(),
                carro.isArCondicionado()
        );
    }

}
