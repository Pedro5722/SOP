package com.pedro5722.controlefinanceiro.api.controller;

import com.pedro5722.controlefinanceiro.domain.entidade.Pagamento;
import com.pedro5722.controlefinanceiro.domain.services.PagamentoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {
    @Autowired
    private PagamentoServices pagamentoServices;

    @GetMapping("/pagamentos")
    public ResponseEntity<List<Pagamento>> findAll(){
        List<Pagamento> pagamentos = pagamentoServices.findAll();
        return ResponseEntity.ok().body(pagamentos);
    }

    @GetMapping("pagamentoId")
    public ResponseEntity<Pagamento> findById(Long id){
        Pagamento pagamento = pagamentoServices.findById(id);
        return ResponseEntity.ok().body(pagamento);
    }
    @DeleteMapping(value="deletePagamento")
    @ResponseBody
    public ResponseEntity<String> deleteById(@RequestParam Long id){
        pagamentoServices.deleteById(id);
        return new ResponseEntity<String>("Pagamento deletado com sucesso", HttpStatus.OK);
    }

    @PostMapping("salvarPagamento")
    public ResponseEntity<Pagamento> salvar(@RequestBody Pagamento pagamento){
        pagamento = pagamentoServices.save(pagamento);
        return ResponseEntity.ok(pagamento);
    }
}
