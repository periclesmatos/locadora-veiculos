package com.pericles.locadora_veiculos.application.service;

import com.pericles.locadora_veiculos.interfaces.dto.carro.CarroFiltro;
import com.pericles.locadora_veiculos.interfaces.dto.carro.CarroRequest;
import com.pericles.locadora_veiculos.interfaces.dto.carro.CarroResponse;
import com.pericles.locadora_veiculos.interfaces.dto.carro.CarroUpdate;
import com.pericles.locadora_veiculos.interfaces.mapper.CarroMapper;
import com.pericles.locadora_veiculos.domain.model.Carro;
import com.pericles.locadora_veiculos.domain.repository.CarroRepository;
import com.pericles.locadora_veiculos.interfaces.specification.CarroSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarroService {

    private final CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    @Transactional(readOnly = true)
    public Carro buscarEntidadePorId(Long id) {
        return carroRepository
                .buscarCarroAtivoPorId(id)
                .orElseThrow(() -> new RuntimeException("Cliente com ID " + id + " iniativo ou não encontrado."));
    }

    @Transactional
    public CarroResponse salvar(CarroRequest request) {
        Carro carro = CarroMapper.toEntity(request);
        carroRepository.save(carro);
        return CarroMapper.toResponse(carro);
    }

    @Transactional(readOnly = true)
    public Page<CarroResponse> buscarComFiltro(CarroFiltro filtro, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Specification<Carro> carroSpecification = CarroSpecification.comFiltro(filtro);
        Page<Carro> carros = carroRepository.findAll(carroSpecification, pageable);
        return carros.map(CarroMapper::toResponse);
    }

    @Transactional(readOnly = true)
    public CarroResponse buscarPorId(Long id) {
        Carro carro = buscarEntidadePorId(id);
        return CarroMapper.toResponse(carro);
    }

    @Transactional
    public CarroResponse atualizar(CarroUpdate request, Long id) {
        Carro carro = buscarEntidadePorId(id);
        carro.atualizarCom(request);
        return CarroMapper.toResponse(carro);
    }

    @Transactional
    public void deletar(Long id) {
        Carro carro = buscarEntidadePorId(id);
        carro.desativar();
    }

}
