package com.pedro5722.controlefinanceiro.domain.repositories;

import com.pedro5722.controlefinanceiro.domain.entidade.StatusDespesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusDespesaRepository extends JpaRepository<StatusDespesa, Integer> {
}
