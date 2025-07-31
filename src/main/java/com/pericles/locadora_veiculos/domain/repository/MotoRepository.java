package com.pericles.locadora_veiculos.domain.repository;

import com.pericles.locadora_veiculos.domain.model.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public interface MotoRepository extends JpaRepository<Moto, Long>, JpaSpecificationExecutor<Moto> {

    @Query("SELECT m FROM Moto m WHERE m.ativo = true AND m.id = :id")
    Optional<Moto> buscarMotoAtivoPorId(@Param("id") Long id);

}
