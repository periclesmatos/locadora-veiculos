package com.pericles.locadora_veiculos.interfaces.specification;

import com.pericles.locadora_veiculos.domain.model.Moto;
import com.pericles.locadora_veiculos.interfaces.dto.moto.MotoFiltro;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class MotoSpecification {

    public static Specification<Moto> comFiltro(MotoFiltro filtro) {
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates =  new ArrayList<>();
            if (filtro.veiculoFiltro() != null) VeiculoSpecification.adicionarPredicados(filtro.veiculoFiltro(), root, criteriaBuilder, predicates);
            if (filtro.cilindradas() != null) predicates.add(criteriaBuilder.equal(root.get("cilindradas"), filtro.cilindradas()));
            predicates.add(criteriaBuilder.equal(root.get("ativo"), true));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }

}
