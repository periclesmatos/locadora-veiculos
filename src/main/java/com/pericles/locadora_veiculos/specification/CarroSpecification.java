package com.pericles.locadora_veiculos.specification;

import com.pericles.locadora_veiculos.dto.carro.CarroFiltro;
import com.pericles.locadora_veiculos.model.Carro;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;

public class CarroSpecification {

    public static Specification<Carro> comFiltro(CarroFiltro filtro) {
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates =  new ArrayList<>();

            if (filtro.ano() != null) {
                predicates.add(criteriaBuilder.equal(root.get("ano"), filtro.ano()));
            }

            if (filtro.marca() != null) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("marca")), "%" + filtro.marca().toLowerCase() + "%"));
            }

            if (filtro.modelo() != null) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("modelo")), "%" + filtro.modelo().toLowerCase() + "%"));
            }

            if (filtro.placa() != null) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("placa")), "%" + filtro.placa().toLowerCase() + "%"));
            }

            if (filtro.quantidadePortas() != null) {
                predicates.add(criteriaBuilder.equal(root.get("quantidadePortas"), filtro.quantidadePortas()));
            }

            if (filtro.arCondicionado() != null) {
                predicates.add(criteriaBuilder.equal(root.get("arCondicionado"), filtro.arCondicionado()));
            }

            if (filtro.disponivel() != null) {
                predicates.add(criteriaBuilder.equal(root.get("disponivel"), filtro.disponivel()));
            }

            if (filtro.valorDiariaMin() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("valorDiaria"), filtro.valorDiariaMin()));
            }

            if (filtro.valorDiariaMax() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("valorDiaria"), filtro.valorDiariaMax()));
            }

            predicates.add(criteriaBuilder.equal(root.get("ativo"), true));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }

}
