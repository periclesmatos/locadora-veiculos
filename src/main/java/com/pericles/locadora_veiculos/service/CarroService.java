package com.pericles.locadora_veiculos.service;

import com.pericles.locadora_veiculos.dto.carro.CarroFiltro;
import com.pericles.locadora_veiculos.dto.carro.CarroRequest;
import com.pericles.locadora_veiculos.dto.carro.CarroUpdate;
import com.pericles.locadora_veiculos.model.Carro;
import com.pericles.locadora_veiculos.repository.CarroRepository;
import com.pericles.locadora_veiculos.specification.CarroSpecification;
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

    @Transactional
    public Carro salvar(CarroRequest request) {
        Carro carro = request.paraEntidade();
        return carroRepository.save(carro);
    }

    @Transactional(readOnly = true)
    public Page<Carro> buscarComFiltro(CarroFiltro filtro, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Specification<Carro> carroSpecification = CarroSpecification.comFiltro(filtro);
        return carroRepository.findAll(carroSpecification, pageable);
    }

    @Transactional(readOnly = true)
    public Carro buscarPorId(Long id) {
        return carroRepository
                .buscarCarroAtivoPorId(id)
                .orElseThrow(() -> new RuntimeException("Cliente com ID " + id + " iniativo ou não encontrado."));
    }

    @Transactional
    public Carro atualizar(CarroUpdate request, Long id) {
        Carro carro = buscarPorId(id);
        carro.atualizarCom(request);
        return carro;
    }

    @Transactional
    public void deletar(Long id) {
        Carro carro = buscarPorId(id);
        carro.desativar();
    }

}
