package com.pericles.locadora_veiculos.modules.veiculo.application.service;

import com.pericles.locadora_veiculos.modules.veiculo.domain.model.Moto;
import com.pericles.locadora_veiculos.modules.veiculo.domain.repository.MotoRepository;
import com.pericles.locadora_veiculos.modules.veiculo.interfaces.dto.filter.MotoFilter;
import com.pericles.locadora_veiculos.modules.veiculo.interfaces.dto.request.MotoRequest;
import com.pericles.locadora_veiculos.modules.veiculo.interfaces.dto.response.MotoResponse;
import com.pericles.locadora_veiculos.modules.veiculo.interfaces.dto.update.MotoUpdate;
import com.pericles.locadora_veiculos.modules.veiculo.interfaces.mapper.MotoMapper;
import com.pericles.locadora_veiculos.modules.veiculo.interfaces.specification.MotoSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MotoService {

    private final MotoRepository motoRepository;

    public MotoService(MotoRepository motoRepository) {
        this.motoRepository = motoRepository;
    }

    public Moto buscarEntidadePorId(Long id) {
        return motoRepository
                .buscarMotoAtivoPorId(id)
                .orElseThrow(() -> new RuntimeException("Moto com ID " + id + " inativo ou não encontrado."));
    }

    @Transactional
    public MotoResponse salvar(MotoRequest request) {
        Moto moto = MotoMapper.toEntity(request);
        motoRepository.save(moto);
        return MotoMapper.toResponse(moto);
    }

    @Transactional(readOnly = true)
    public Page<MotoResponse> buscarComFiltro(MotoFilter filtro, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Specification<Moto> motoSpecification = MotoSpecification.comFiltro(filtro);
        Page<Moto> motos = motoRepository.findAll(motoSpecification, pageable);
        return motos.map(MotoMapper::toResponse);
    }

    @Transactional(readOnly = true)
    public MotoResponse buscarPorId(Long id) {
        Moto moto = buscarEntidadePorId(id);
        return MotoMapper.toResponse(moto);
    }

    @Transactional
    public MotoResponse atualizar( MotoUpdate request, Long id) {
        Moto moto = buscarEntidadePorId(id);
        moto.atualizarCom(request);
        return MotoMapper.toResponse(moto);
    }

    @Transactional
    public void deletar(Long id) {
        Moto moto = buscarEntidadePorId(id);
        moto.desativar();
    }

}
