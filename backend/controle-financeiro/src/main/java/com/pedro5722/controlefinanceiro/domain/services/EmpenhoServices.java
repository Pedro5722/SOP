package com.pedro5722.controlefinanceiro.domain.services;


import com.pedro5722.controlefinanceiro.api.dto.EmpenhoDTO;
import com.pedro5722.controlefinanceiro.domain.entidade.Despesa;
import com.pedro5722.controlefinanceiro.domain.entidade.Empenho;
import com.pedro5722.controlefinanceiro.domain.entidade.Pagamento;
import com.pedro5722.controlefinanceiro.domain.repositories.EmpenhoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpenhoServices {

    private final EmpenhoRepository empenhoRepository;
    private final DespesaServices despesaServices;

    public Empenho save(EmpenhoDTO empenhoDTO){
        Long idDespesa = despesaServices.findByNumeroProtocolo(empenhoDTO.getNumeroProtocolo()).getId();
        Empenho empenho = Empenho.builder()
                .ano(empenhoDTO.getAno())
                .numero(empenhoDTO.getNumero())
                .data(empenhoDTO.getData())
                .valor(empenhoDTO.getValor())
                .observacao(empenhoDTO.getObservacao())
                .idDespesa(idDespesa)
                .build();
        return empenhoRepository.save(empenho);
    }

    public void deleteById(Long id){
        Empenho empenho = findById(id);

        // Não deve ser permitido deletar um Empenho que tenha ao menos um Pagamento associado.
        if (empenho.getPagamentos().isEmpty()){
            empenhoRepository.deleteById(id);
        }else{
            throw new RuntimeException("Impossivel deletar: existem Pagamentos associados ao empenho.");
        }

    }

    public Empenho findById(Long id){
        return empenhoRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<Empenho> findAll(Empenho empenho){
        return empenhoRepository.findAll();
    }
    public List<Empenho> findAll(){
        return empenhoRepository.findAll();
    }

}
