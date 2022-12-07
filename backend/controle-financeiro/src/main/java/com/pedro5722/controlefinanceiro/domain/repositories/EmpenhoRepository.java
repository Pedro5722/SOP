package com.pedro5722.controlefinanceiro.domain.repositories;

import com.pedro5722.controlefinanceiro.domain.entidade.Empenho;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpenhoRepository extends JpaRepository<Empenho, Long> {

    //List<Empenho> findDataBetween(String dataInicial, String dataFinal);

}
