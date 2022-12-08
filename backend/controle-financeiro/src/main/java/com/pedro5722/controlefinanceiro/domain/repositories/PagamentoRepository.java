package com.pedro5722.controlefinanceiro.domain.repositories;

import com.pedro5722.controlefinanceiro.domain.entidade.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
