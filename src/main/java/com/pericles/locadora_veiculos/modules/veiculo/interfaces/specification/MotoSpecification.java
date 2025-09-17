package com.pericles.locadora_veiculos.modules.veiculo.interfaces.specification;

import com.pericles.locadora_veiculos.modules.veiculo.domain.model.Moto;
import com.pericles.locadora_veiculos.modules.veiculo.interfaces.dto.filter.MotoFilter;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class MotoSpecification {

    public static Specification<Moto> comFiltro(MotoFilter filtro) {
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates =  new ArrayList<>();
            if (filtro.veiculoFiltro() != null) VeiculoSpecification.adicionarPredicados(filtro.veiculoFiltro(), root, criteriaBuilder, predicates);
            if (filtro.cilindradas() != null) predicates.add(criteriaBuilder.equal(root.get("cilindradas"), filtro.cilindradas()));
            predicates.add(criteriaBuilder.equal(root.get("ativo"), true));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }

}
