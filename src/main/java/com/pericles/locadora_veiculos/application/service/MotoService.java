package com.pericles.locadora_veiculos.application.service;

import com.pericles.locadora_veiculos.domain.model.Moto;
import com.pericles.locadora_veiculos.domain.repository.MotoRepository;
import com.pericles.locadora_veiculos.interfaces.dto.moto.MotoRequest;
import com.pericles.locadora_veiculos.interfaces.dto.moto.MotoResponse;
import com.pericles.locadora_veiculos.interfaces.mapper.MotoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MotoService {

    private final MotoRepository motoRepository;

    public MotoService(MotoRepository motoRepository) {
        this.motoRepository = motoRepository;
    }

    @Transactional
    public MotoResponse salvar(MotoRequest request) {
        Moto moto = MotoMapper.toEntity(request);
        motoRepository.save(moto);
        return MotoMapper.toResponse(moto);
    }



}
