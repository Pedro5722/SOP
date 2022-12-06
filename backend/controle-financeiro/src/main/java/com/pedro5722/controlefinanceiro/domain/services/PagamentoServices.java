package com.pedro5722.controlefinanceiro.domain.services;

import com.pedro5722.controlefinanceiro.domain.entidade.Pagamento;
import com.pedro5722.controlefinanceiro.domain.repositories.PagamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PagamentoServices {
    private final PagamentoRepository pagamentoRepository;

    public Pagamento save(Pagamento pagamento){
        return pagamentoRepository.save(pagamento);
    }

    public void deleteById(Long id){
        pagamentoRepository.deleteById(id);
    }


    public Pagamento findById(Long id){
        return pagamentoRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<Pagamento> findAll(Pagamento pagamento){
        return pagamentoRepository.findAll();
    }
    public List<Pagamento> findAll(){
        return pagamentoRepository.findAll();
    }

}
