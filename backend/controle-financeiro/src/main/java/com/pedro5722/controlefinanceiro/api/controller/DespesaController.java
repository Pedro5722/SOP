package com.pedro5722.controlefinanceiro.api.controller;

import com.pedro5722.controlefinanceiro.api.dto.DespesaDTO;
import com.pedro5722.controlefinanceiro.domain.entidade.Despesa;
import com.pedro5722.controlefinanceiro.domain.entidade.StatusDespesa;
import com.pedro5722.controlefinanceiro.domain.entidade.TipoDespesa;
import com.pedro5722.controlefinanceiro.domain.services.DespesaServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://127.0.0.1:5173/", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/despesa")
public class DespesaController {
    private final DespesaServices despesaServices;
    @GetMapping()
    public ResponseEntity<List<Despesa>> findAll(){
        List<Despesa> despesas = despesaServices.findAll();
        return ResponseEntity.ok().body(despesas);
    };
    @GetMapping("/{id}")
    public ResponseEntity<Despesa> findById(@PathVariable Long id){
        Despesa despesa = despesaServices.findById(id);
        return ResponseEntity.ok(despesa);
    }

    @DeleteMapping()
    @ResponseBody
    public ResponseEntity<String> deleteById(@RequestParam Long idDespesa){
        despesaServices.deleteById(idDespesa);
        return new ResponseEntity<String>("Despesa Excluida com sucesso", HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Despesa> salvar(@RequestBody DespesaDTO despesaDTO){
        Despesa despesa = Despesa.builder()
                .status(new StatusDespesa(despesaDTO.getStatus()))
                .tipo(new TipoDespesa(despesaDTO.getTipo()))
                .id(despesaDTO.getId())
                .valor(despesaDTO.getValor())
                .credor(despesaDTO.getCredor())
                .dataProtocolo(despesaDTO.getDataProtocolo())
                .descricao(despesaDTO.getDescricao())
                .dataVencimento(despesaDTO.getDataVencimento())
                .numeroProtocolo(despesaDTO.getNumeroProtocolo()).build();

        despesa = despesaServices.save(despesa);
        return ResponseEntity.ok(despesa);
    }

    @GetMapping("/lista-filtrada")
    public List<Despesa> getFilteredList(DespesaDTO despesaDTO){
        return despesaServices.findAll(despesaDTO);
    }
}
