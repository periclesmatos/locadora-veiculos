package com.pericles.locadora_veiculos.repository;

import com.pericles.locadora_veiculos.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Long, Carro> {
}
