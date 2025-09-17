package com.pericles.locadora_veiculos.modules.veiculo.interfaces.specification;

import com.pericles.locadora_veiculos.modules.veiculo.interfaces.dto.filter.VeiculoFilter;
import com.pericles.locadora_veiculos.modules.veiculo.domain.model.Veiculo;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class VeiculoSpecification {

    public static void adicionarPredicados(
            VeiculoFilter filtro,
            Root<? extends Veiculo> root,
            CriteriaBuilder criteriaBuilder,
            List<Predicate> predicates)
    {
        if (filtro.ano() != null) predicates.add(criteriaBuilder.equal(root.get("ano"), filtro.ano()));
        if (filtro.marca() != null) predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("marca")), "%" + filtro.marca().toLowerCase() + "%"));
        if (filtro.modelo() != null) predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("modelo")), "%" + filtro.modelo().toLowerCase() + "%"));
        if (filtro.placa() != null) predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("placa")), "%" + filtro.placa().toLowerCase() + "%"));
        if (filtro.disponivel() != null) predicates.add(criteriaBuilder.equal(root.get("disponivel"), filtro.disponivel()));
        if (filtro.valorDiariaMin() != null) predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("valorDiaria"), filtro.valorDiariaMin()));
        if (filtro.valorDiariaMax() != null) predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("valorDiaria"), filtro.valorDiariaMax()));
    }

}
