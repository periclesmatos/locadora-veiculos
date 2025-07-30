package com.pericles.locadora_veiculos.domain.repository;

import com.pericles.locadora_veiculos.domain.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CarroRepository extends JpaRepository<Carro, Long>, JpaSpecificationExecutor<Carro> {

    @Query("SELECT c FROM Carro c WHERE c.id = :id AND c.ativo = true")
    Optional<Carro> buscarCarroAtivoPorId(@Param("id") Long id);

}