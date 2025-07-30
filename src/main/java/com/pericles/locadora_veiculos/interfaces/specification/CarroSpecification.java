package com.pericles.locadora_veiculos.interfaces.specification;

import com.pericles.locadora_veiculos.interfaces.dto.carro.CarroFiltro;
import com.pericles.locadora_veiculos.domain.model.Carro;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;

public class CarroSpecification {

    public static Specification<Carro> comFiltro(CarroFiltro filtro) {
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates =  new ArrayList<>();

            if (filtro.veiculoFiltro() != null) {
                VeiculoSpecification.adicionarPredicados(filtro.veiculoFiltro(), root, criteriaBuilder, predicates);
            }

            if (filtro.quantidadePortas() != null) {
                predicates.add(criteriaBuilder.equal(root.get("quantidadePortas"), filtro.quantidadePortas()));
            }

            if (filtro.arCondicionado() != null) {
                predicates.add(criteriaBuilder.equal(root.get("arCondicionado"), filtro.arCondicionado()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }

}
