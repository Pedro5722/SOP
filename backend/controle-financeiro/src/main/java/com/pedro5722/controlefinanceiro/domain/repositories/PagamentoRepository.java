package com.pedro5722.controlefinanceiro.domain.repositories;

import com.pedro5722.controlefinanceiro.domain.entidade.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
