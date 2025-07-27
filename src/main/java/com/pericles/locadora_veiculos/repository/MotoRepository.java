package com.pericles.locadora_veiculos.repository;

import com.pericles.locadora_veiculos.model.Moto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoRepository extends JpaRepository<Long, Moto> {
}
