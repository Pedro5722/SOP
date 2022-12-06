package com.pedro5722.controlefinanceiro.domain.repositories;

import com.pedro5722.controlefinanceiro.domain.entidade.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {


}
